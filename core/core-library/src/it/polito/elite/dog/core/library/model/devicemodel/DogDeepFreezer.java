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
* DogDeepFreezerModel - automatically generated by DogOnt2Dog
*/

import it.polito.elite.dog.core.library.model.DeviceStatus;
import it.polito.elite.dog.core.library.model.AbstractDevice;
import it.polito.elite.dog.core.library.model.DeviceDescriptor;
import it.polito.elite.dog.core.library.model.devicecategory.DeepFreezer;
import it.polito.elite.dog.core.library.model.notification.*;
import it.polito.elite.dog.core.library.model.state.*;

import org.osgi.framework.BundleContext;
import org.osgi.service.device.Device;

import javax.measure.Measure;
public class DogDeepFreezer extends AbstractDevice implements DeepFreezer
{

	public DogDeepFreezer(BundleContext context, DeviceDescriptor dogDeviceDescriptor)
	{
		super(context);


		this.setDeviceProperties(dogDeviceDescriptor);


		this.registerDevice(Device.class.getName());
	}


	public Measure<?,?>  getRemainingTime()
	{
		if(this.driver!=null){
		return ((DeepFreezer) this.driver).getRemainingTime();
		}
		 return null;
	}

	public DeviceStatus getState()
	{
		if(this.driver!=null){
		return ((DeepFreezer) this.driver).getState();
		}
		 return null;
	}

	public void stopSuperFreezing()
	{
		if(this.driver!=null){
((DeepFreezer) this.driver).stopSuperFreezing();
		}
	}

	public Measure<?,?>  getEndTime()
	{
		if(this.driver!=null){
		return ((DeepFreezer) this.driver).getEndTime();
		}
		 return null;
	}

	public void on()
	{
		if(this.driver!=null){
((DeepFreezer) this.driver).on();
		}
	}

	public Object[] getEventsAndAlerts()
	{
		if(this.driver!=null){
		return ((DeepFreezer) this.driver).getEventsAndAlerts();
		}
		 return null;
	}

	public void setStartTime(Measure<?,?>  endTime, Measure<?,?>  remainingTime, Measure<?,?>  startTime)
	{
		if(this.driver!=null){
((DeepFreezer) this.driver).setStartTime(endTime, remainingTime, startTime);
		}
	}

	public void startSuperFreezing()
	{
		if(this.driver!=null){
((DeepFreezer) this.driver).startSuperFreezing();
		}
	}

	public void off()
	{
		if(this.driver!=null){
((DeepFreezer) this.driver).off();
		}
	}

	public Measure<?,?>  getStartTime()
	{
		if(this.driver!=null){
		return ((DeepFreezer) this.driver).getStartTime();
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
	/*Notification: MultipleEventNotification*/
	public void notifyNewEventSet(Object[] events){
		MultipleEventNotification notificationEvent=new MultipleEventNotification(events );
		notificationEvent.setDeviceUri(this.deviceId);
		// Send the notification through the EventAdmin
		notifyEventAdmin(notificationEvent);
	}
	/*Notification: EventNotification*/
	public void notifyNewEvent(Object event){
		EventNotification notificationEvent=new EventNotification(event );
		notificationEvent.setDeviceUri(this.deviceId);
		// Send the notification through the EventAdmin
		notifyEventAdmin(notificationEvent);
	}
	/*Notification: MultipleAlertNotification*/
	public void notifyNewAlertSet(Object[] alerts){
		MultipleAlertNotification notificationEvent=new MultipleAlertNotification(alerts );
		notificationEvent.setDeviceUri(this.deviceId);
		// Send the notification through the EventAdmin
		notifyEventAdmin(notificationEvent);
	}
	/*Notification: AlertNotification*/
	public void notifyNewAlert(Object alert){
		AlertNotification notificationEvent=new AlertNotification(alert );
		notificationEvent.setDeviceUri(this.deviceId);
		// Send the notification through the EventAdmin
		notifyEventAdmin(notificationEvent);
	}
}