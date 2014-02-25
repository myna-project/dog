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

package it.polito.elite.dog.core.library.model.devicecategory;


 
 /**
* PumpControllerCategory - automatically generated by DogOnt2Dog
*/


import it.polito.elite.dog.core.library.model.DeviceStatus;
import it.polito.elite.dog.core.library.model.state.*;

import javax.measure.Measure;

public interface PumpController extends HVACSystem, Control
{
	public static int MATCH_TYPE=100;
	public static int MATCH_SUB_TYPE=50;
	public static int MATCH_MANUFACTURER=0;

	public DeviceStatus getState();


	/*Generated Notifications*/

	/*Notification: StoreSceneNotification*/
	public void notifyStoredScene(Integer sceneNumber);
	/*Notification: StateChangeNotification*/
	public void notifyStateChanged(State newState);
	/*Notification: DeleteSceneNotification*/
	public void notifyDeletedScene(Measure<?,?>  sceneNumber);
	/*Notification: TemperatureMeasurementNotification*/
	public void notifyNewTemperatureValue(Measure<?,?>  temperatureValue);
	/*Notification: LevelStepUpNotification*/
	public void notifyStepUp();
	/*Notification: IdentifyNotification*/
	public void notifyIdentifyMe();
	/*Notification: FlowRateMeasurementNotification*/
	public void notifyChangedFlowRateValue(Measure<?,?>  flowRateValue);
	/*Notification: JoinGroupNotification*/
	public void notifyJoinedGroup(Integer groupNumber);
	/*Notification: OnNotification*/
	public void notifyOn();
	/*Notification: LevelControlNotification*/
	public void notifyChangedLevel(Measure<?,?>  newLevel);
	/*Notification: LevelStepDownNotification*/
	public void notifyStepDown();
	/*Notification: GroupNotification*/
	public void notifyBelongToGroup(Integer groupNumber);
	/*Notification: PressureMeasurementNotification*/
	public void notifyNewPressureValue(Measure<?,?>  pressureValue);
	/*Notification: OffNotification*/
	public void notifyOff();
	/*Notification: LeaveGroupNotification*/
	public void notifyLeftGroup(Integer groupNumber);
}
