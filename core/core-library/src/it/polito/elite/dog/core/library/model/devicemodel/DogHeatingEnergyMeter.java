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
* DogHeatingEnergyMeterModel - automatically generated by DogOnt2Dog
*/

import it.polito.elite.dog.core.library.model.DeviceStatus;
import it.polito.elite.dog.core.library.model.AbstractDevice;
import it.polito.elite.dog.core.library.model.DeviceDescriptor;
import it.polito.elite.dog.core.library.model.devicecategory.HeatingEnergyMeter;
import it.polito.elite.dog.core.library.model.notification.*;
import it.polito.elite.dog.core.library.model.state.*;

import org.osgi.framework.BundleContext;
import org.osgi.service.device.Device;

import javax.measure.Measure;
public class DogHeatingEnergyMeter extends AbstractDevice implements HeatingEnergyMeter
{

	public DogHeatingEnergyMeter(BundleContext context, DeviceDescriptor dogDeviceDescriptor)
	{
		super(context);


		this.setDeviceProperties(dogDeviceDescriptor);


		this.registerDevice(Device.class.getName());
	}


	public DeviceStatus getState()
	{
		if(this.driver!=null){
		return ((HeatingEnergyMeter) this.driver).getState();
		}
		 return null;
	}

	public Measure<?,?>  getHeatingEnergy()
	{
		if(this.driver!=null){
		return ((HeatingEnergyMeter) this.driver).getHeatingEnergy();
		}
		 return null;
	}



	/*Generated Notifications*/

	/**
	/* Implements the DeviceCategory interface requirement 
	**/
	@Override
	public void notifyStateChanged(State newState)
	{
		super.notifyStateChanged(newState);
	}
	/*Notification: HeatingEnergyMeasurementNotification*/
	public void notifyNewHeatingEnergyValue(Measure<?,?>  heatingEnergy){
		HeatingEnergyMeasurementNotification notificationEvent=new HeatingEnergyMeasurementNotification(heatingEnergy );
		notificationEvent.setDeviceUri(this.deviceId);
		// Send the notification through the EventAdmin
		notifyEventAdmin(notificationEvent);
	}
}
