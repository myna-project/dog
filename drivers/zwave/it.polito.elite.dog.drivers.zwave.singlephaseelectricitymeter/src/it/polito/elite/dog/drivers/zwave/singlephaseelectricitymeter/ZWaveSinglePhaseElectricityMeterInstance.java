/*
 * Dog  - Z-Wave
 * 
 * Copyright 2013 Davide Aimone  and Dario Bonino 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
package it.polito.elite.dog.drivers.zwave.singlephaseelectricitymeter;

import it.polito.elite.dog.drivers.zwave.ZWaveAPI;
import it.polito.elite.dog.drivers.zwave.model.zway.json.CommandClasses;
import it.polito.elite.dog.drivers.zwave.model.zway.json.Controller;
import it.polito.elite.dog.drivers.zwave.model.zway.json.Device;
import it.polito.elite.dog.drivers.zwave.model.zway.json.Instance;
import it.polito.elite.dog.drivers.zwave.network.ZWaveDriverInstance;
import it.polito.elite.dog.drivers.zwave.network.info.ZWaveNodeInfo;
import it.polito.elite.dog.drivers.zwave.network.interfaces.ZWaveNetwork;
import it.polito.elite.dog.core.library.model.ControllableDevice;
import it.polito.elite.dog.core.library.util.LogHelper;
import it.polito.elite.dog.core.library.model.DeviceStatus;
import it.polito.elite.dog.core.library.model.devicecategory.ElectricalSystem;
import it.polito.elite.dog.core.library.model.devicecategory.SinglePhaseActivePowerMeter;
import it.polito.elite.dog.core.library.model.devicecategory.SinglePhaseElectricityMeter;
import it.polito.elite.dog.core.library.model.devicecategory.SinglePhaseEnergyMeter;
import it.polito.elite.dog.core.library.model.state.SinglePhaseActiveEnergyState;
import it.polito.elite.dog.core.library.model.state.SinglePhaseActivePowerMeasurementState;
import it.polito.elite.dog.core.library.model.state.State;
import it.polito.elite.dog.core.library.model.statevalue.ActiveEnergyStateValue;
import it.polito.elite.dog.core.library.model.statevalue.ActivePowerStateValue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.measure.DecimalMeasure;
import javax.measure.Measure;
import javax.measure.quantity.Power;
import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;
import javax.measure.unit.UnitFormat;

import org.osgi.framework.BundleContext;
import org.osgi.service.log.LogService;

public class ZWaveSinglePhaseElectricityMeterInstance extends
		ZWaveDriverInstance implements SinglePhaseElectricityMeter
{
	// the class logger
	private LogHelper logger;

	public ZWaveSinglePhaseElectricityMeterInstance(ZWaveNetwork network,
			ControllableDevice device, int deviceId, Set<Integer> instancesId,
			int gatewayNodeId, int updateTimeMillis, BundleContext context)
	{
		super(network, device, deviceId, instancesId, gatewayNodeId,
				updateTimeMillis, context);

		// create a logger
		logger = new LogHelper(context);

		// initialize states
		this.initializeStates();
	}

	/**
	 * Initializes the state asynchronously as required by OSGi
	 */
	private void initializeStates()
	{
		// create the var and va units
		Unit<Power> VAR = SI.WATT.alternate("var");

		// add unit of measure aliases (to fix notation problems...)
		UnitFormat uf = UnitFormat.getInstance();
		uf.alias(SI.WATT.times(NonSI.HOUR), "Wh");
		uf.label(SI.KILO(SI.WATT.times(NonSI.HOUR)), "kWh");
		uf.alias(VAR.times(NonSI.HOUR), "Varh");
		uf.label(SI.KILO(VAR.times(NonSI.HOUR)), "kVarh");

		// initialize the state
		this.currentState.setState(
				SinglePhaseActiveEnergyState.class.getSimpleName(),
				new SinglePhaseActiveEnergyState(new ActiveEnergyStateValue()));
		this.currentState.setState(SinglePhaseActivePowerMeasurementState.class
				.getSimpleName(), new SinglePhaseActivePowerMeasurementState(
				new ActivePowerStateValue()));

		// get the initial state of the device
		Runnable worker = new Runnable()
		{
			public void run()
			{
				network.read(nodeInfo, true);
			}
		};

		Thread workerThread = new Thread(worker);
		workerThread.start();

	}

	@Override
	public DeviceStatus getState()
	{
		return currentState;
	}

	@Override
	public void notifyStateChanged(State newState)
	{
		((ElectricalSystem) device).notifyStateChanged(newState);
	}

	@Override
	public void newMessageFromHouse(Device deviceNode, Instance instanceNode,
			Controller controllerNode, String sValue)
	{
		this.deviceNode = deviceNode;

		// Read the value associated with the right CommandClass
		// instance 0 doesn't contains sensor data
		if (instanceNode.getInstanceId() != 0)
		{
			// meter values are in
			// devices.X.instances.1.commandClasses.50.data.0 (KwH) and
			// devices.X.instances.1.commandClasses.50.data.2 (W)
			CommandClasses ccElectricityEntry = instanceNode
					.getCommandClasses().get(ZWaveAPI.COMMAND_CLASS_METER);

			// Check if it is a real new value or if it is an old one
			long updateTime = ccElectricityEntry.get("0").getDataElem("val")
					.getUpdateTime();

			// first time we only save update time, no more
			if (lastUpdateTime == 0)
				lastUpdateTime = updateTime;
			else if (lastUpdateTime < updateTime)
			{
				// update last update time
				lastUpdateTime = updateTime;
				nFailedUpdate = 0;
				double activeEnergy = Double.valueOf(ccElectricityEntry
						.get("0").getDataElemValue("val").toString());
				notifyNewActiveEnergyValue(DecimalMeasure.valueOf(activeEnergy
						+ " " + SI.KILO(SI.WATT.times(NonSI.HOUR))));

				double activePower = Double.valueOf(ccElectricityEntry.get("2")
						.getDataElemValue("val").toString());
				notifyNewActivePowerValue(DecimalMeasure.valueOf(activePower
						+ " " + SI.WATT));
			}
			
			this.notifyStateChanged(null);
		}
	}

	@Override
	protected void specificConfiguration()
	{
		// prepare the device state map
		currentState = new DeviceStatus(device.getDeviceId());
	}

	@Override
	protected void addToNetworkDriver(ZWaveNodeInfo nodeInfo)
	{
		network.addDriver(nodeInfo, updateTimeMillis, this);
	}

	@Override
	protected boolean isController()
	{
		return false;
	}

	@Override
	public Measure<?, ?> getActiveEnergyValue()
	{
		return (Measure<?, ?>) currentState.getState(
				SinglePhaseActiveEnergyState.class.getSimpleName())
				.getCurrentStateValue()[0].getValue();
	}

	@Override
	public Measure<?, ?> getActivePower()
	{
		return (Measure<?, ?>) currentState.getState(
				SinglePhaseActivePowerMeasurementState.class.getSimpleName())
				.getCurrentStateValue()[0].getValue();
	}

	@Override
	public void notifyNewActiveEnergyValue(Measure<?, ?> value)
	{
		// update the state
		ActiveEnergyStateValue pValue = new ActiveEnergyStateValue();
		pValue.setValue(value);
		currentState.setState(
				SinglePhaseActiveEnergyState.class.getSimpleName(),
				new SinglePhaseActiveEnergyState(pValue));

		// debug
		logger.log(LogService.LOG_DEBUG, "Device " + device.getDeviceId()
				+ " active energy " + value.toString());

		// notify the new measure
		((SinglePhaseEnergyMeter) device).notifyNewActiveEnergyValue(value);
	}

	@Override
	public void notifyNewActivePowerValue(Measure<?, ?> powerValue)
	{
		// update the state
		ActivePowerStateValue pValue = new ActivePowerStateValue();
		pValue.setValue(powerValue);
		currentState.setState(
				SinglePhaseActivePowerMeasurementState.class.getSimpleName(),
				new SinglePhaseActivePowerMeasurementState(pValue));

		// debug
		logger.log(LogService.LOG_DEBUG, "Device " + device.getDeviceId()
				+ " active power " + powerValue.toString());

		// notify the new measure
		((SinglePhaseActivePowerMeter) device)
				.notifyNewActivePowerValue(powerValue);
	}

	@Override
	protected ZWaveNodeInfo createNodeInfo(int deviceId,
			Set<Integer> instancesId, boolean isController)
	{
		HashMap<Integer, Set<Integer>> instanceCommand = new HashMap<Integer, Set<Integer>>();

		// meter information are in instance 1 with commandclasses =
		// COMMAND_CLASS_METER (kwH) and COMMAND_CLASS_SENSOR_MULTILEVEL (W)

		for (Integer instanceId : instancesId)
		{
			// only trigger instance 1
			if (instanceId == 1)
			{
				HashSet<Integer> ccSet = new HashSet<Integer>();
				ccSet.add(ZWaveAPI.COMMAND_CLASS_METER);
				ccSet.add(ZWaveAPI.COMMAND_CLASS_SENSOR_MULTILEVEL);
				instanceCommand.put(instanceId, ccSet);
			}
		}
		ZWaveNodeInfo nodeInfo = new ZWaveNodeInfo(deviceId, instanceCommand,
				isController);

		return nodeInfo;
	}

	@Override
	public void notifyNewPowerFactorValue(Measure<?, ?> powerFactor)
	{
		// Nothing to do: not supported by device...
	}

	@Override
	public void notifyNewReactiveEnergyValue(Measure<?, ?> value)
	{
		// Nothing to do: not supported by device...
	}

	@Override
	public Measure<?, ?> getReactiveEnergyValue()
	{
		// Nothing to do: not supported by device...
		return null;
	}

	@Override
	public Measure<?, ?> getPowerFactor()
	{
		// Nothing to do: not supported by device...
		return null;
	}

	@Override
	public Measure<?, ?> getReactivePower()
	{
		// Nothing to do: not supported by device...
		return null;
	}

	@Override
	public Measure<?, ?> getFrequency()
	{
		// Nothing to do: not supported by device...
		return null;
	}

	@Override
	public Measure<?, ?> getPhaseNeutralVoltageValue()
	{
		// Nothing to do: not supported by device...
		return null;
	}

	@Override
	public Measure<?, ?> getElectricCurrentValue()
	{
		// Nothing to do: not supported by device...
		return null;
	}

	@Override
	public Measure<?, ?> getApparentPower()
	{
		// Nothing to do: not supported by device...
		return null;
	}

	@Override
	public void notifyNewFrequencyValue(Measure<?, ?> frequency)
	{
		// Nothing to do: not supported by device...

	}

	@Override
	public void notifyNewReactivePowerValue(Measure<?, ?> powerValue)
	{
		// Nothing to do: not supported by device...
	}

	@Override
	public void notifyNewApparentPowerValue(Measure<?, ?> powerValue)
	{
		// Nothing to do: not supported by device...
	}

	@Override
	public void notifyNewPhaseNeutralVoltageValue(Measure<?, ?> lnVoltage)
	{
		// Nothing to do: not supported by device...
	}

	@Override
	public void notifyNewCurrentValue(Measure<?, ?> value)
	{
		// Nothing to do: not supported by device...
	}
}