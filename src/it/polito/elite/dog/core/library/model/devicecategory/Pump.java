/*
 * Dog - Core
 *
 * Copyright (c) 2011-2014 Dario Bonino and Luigi De Russis
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
// Automatically generated by the DogOnt2Dog utility
//

package it.polito.elite.dog.core.library.model.devicecategory;


 
 /**
* PumpCategory - automatically generated by DogOnt2Dog
*/


import it.polito.elite.dog.core.library.model.DeviceStatus;
import javax.measure.Measure;

public interface Pump extends Actuator, HVACSystem
{
	public static int MATCH_TYPE=100;
	public static int MATCH_SUB_TYPE=50;
	public static int MATCH_MANUFACTURER=0;

	public void stepDown();
	public DeviceStatus getState();
	public void on();
	public void deleteGroup(Integer groupID);
	public void storeGroup(Integer groupID);
	public void off();
	public Measure<?,?>  getFlowRate();
	public void stepUp();
	public Measure<?,?>  getTemperature();
	public void storeScene(Integer sceneNumber);
	public void deleteScene(Integer sceneNumber);
	public void set(Object value);
	public Measure<?,?>  getPressure();


	/*Generated Notifications*/

	/*Notification: StoreSceneNotification*/
	public void notifyStoredScene(Integer sceneNumber);
	/*Notification: DeleteSceneNotification*/
	public void notifyDeletedScene(Integer sceneNumber);
	/*Notification: TemperatureMeasurementNotification*/
	public void notifyNewTemperatureValue(Measure<?,?>  temperatureValue);
	/*Notification: FlowRateMeasurementNotification*/
	public void notifyChangedFlowRateValue(Measure<?,?>  flowRateValue);
	/*Notification: JoinGroupNotification*/
	public void notifyJoinedGroup(Integer groupNumber);
	/*Notification: OnNotification*/
	public void notifyOn();
	/*Notification: LevelControlNotification*/
	public void notifyChangedLevel(Measure<?,?>  newLevel);
	/*Notification: OffNotification*/
	public void notifyOff();
	/*Notification: PressureMeasurementNotification*/
	public void notifyNewPressureValue(Measure<?,?>  pressureValue);
	/*Notification: LeaveGroupNotification*/
	public void notifyLeftGroup(Integer groupNumber);
	public void updateStatus();
}
