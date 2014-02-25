/*
 * Dog - Core
 * 
 * Copyright (c) 2011-2013 Dario Bonino and Luigi De Russis
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
//
//Automatically generated by it.polito.elite.domotics.ontologies.dogont.utilities.DogOnt2Dog
//

package it.polito.elite.dog.core.library.model.devicemodel;


 
 /**
* DogEnergyAndPowerMeterModel - automatically generated by DogOnt2Dog
*/

import it.polito.elite.dog.core.library.model.DeviceStatus;
import it.polito.elite.dog.core.library.model.AbstractDevice;
import it.polito.elite.dog.core.library.model.DeviceDescriptor;
import it.polito.elite.dog.core.library.model.devicecategory.EnergyAndPowerMeter;
import it.polito.elite.dog.core.library.model.notification.*;
import it.polito.elite.dog.core.library.model.state.*;

import org.osgi.framework.BundleContext;
import org.osgi.service.device.Device;

import javax.measure.Measure;
public class DogEnergyAndPowerMeter extends AbstractDevice implements EnergyAndPowerMeter
{

	public DogEnergyAndPowerMeter(BundleContext context, DeviceDescriptor dogDeviceDescriptor)
	{
		super(context);


		this.setDeviceProperties(dogDeviceDescriptor);


		this.registerDevice(Device.class.getName());
	}


	public Measure<?,?>  getReactiveEnergyValue()
	{
		if(this.driver!=null){
		return ((EnergyAndPowerMeter) this.driver).getReactiveEnergyValue();
		}
		 return null;
	}

	public DeviceStatus getState()
	{
		if(this.driver!=null){
		return ((EnergyAndPowerMeter) this.driver).getState();
		}
		 return null;
	}

	public Measure<?,?>  getActiveEnergyValue()
	{
		if(this.driver!=null){
		return ((EnergyAndPowerMeter) this.driver).getActiveEnergyValue();
		}
		 return null;
	}

	public Measure<?,?>  getActivePower()
	{
		if(this.driver!=null){
		return ((EnergyAndPowerMeter) this.driver).getActivePower();
		}
		 return null;
	}



	/*Generated Notifications*/

	/*Notification: SinglePhaseActivePowerMeasurementNotification*/
	public void notifyNewActivePowerValue(Measure<?,?>  powerValue){
		SinglePhaseActivePowerMeasurementNotification notificationEvent=new SinglePhaseActivePowerMeasurementNotification(powerValue );
		notificationEvent.setDeviceUri(this.deviceId);
		// Send the notification through the EventAdmin
		notifyEventAdmin(notificationEvent);
	}
	/**
	/* Implements the DeviceCategory interface requirement 
	**/
	@Override
	public void notifyStateChanged(State newState)
	{
		super.notifyStateChanged(newState);
	}
	/*Notification: SinglePhaseReactiveEnergyMeasurementNotification*/
	public void notifyNewReactiveEnergyValue(Measure<?,?>  value){
		SinglePhaseReactiveEnergyMeasurementNotification notificationEvent=new SinglePhaseReactiveEnergyMeasurementNotification(value );
		notificationEvent.setDeviceUri(this.deviceId);
		// Send the notification through the EventAdmin
		notifyEventAdmin(notificationEvent);
	}
	/*Notification: SinglePhaseActiveEnergyMeasurementNotification*/
	public void notifyNewActiveEnergyValue(Measure<?,?>  value){
		SinglePhaseActiveEnergyMeasurementNotification notificationEvent=new SinglePhaseActiveEnergyMeasurementNotification(value );
		notificationEvent.setDeviceUri(this.deviceId);
		// Send the notification through the EventAdmin
		notifyEventAdmin(notificationEvent);
	}
}
