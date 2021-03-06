/*
 * Dog - Core
 *
 * Copyright (c) 2011-2016 Dario Bonino and Luigi De Russis
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

package it.polito.elite.dog.core.library.model.state;


import it.polito.elite.dog.core.library.model.statevalue.StandByStateValue;
import it.polito.elite.dog.core.library.model.statevalue.OffStateValue;
import it.polito.elite.dog.core.library.model.statevalue.OnStateValue;
import it.polito.elite.dog.core.library.model.statevalue.StateValue;





/**
* StandByOnOffState - automatically generated by it.polito.elite.domotics.ontologies.dogont.utilities.DogOnt2Dog
*
* @author it.polito.elite.domotics.ontologies.dogont.utilities.DogOnt2Dog
*
*/
public class StandByOnOffState extends TripleValuedState
{
	/**
	 * The unique class version for serialization
	 */

	private static final long serialVersionUID = 1L;

	public static final String ON = "on";
	public static final String OFF = "off";
	public static final String STANDBY = "standBy";


	/**
	 * Class constructor for states inheriting from DiscreteState.
	 */
	public StandByOnOffState(OnStateValue onstatevalue)
	{
		//call the super class constructor
		super(new StateValue[]{onstatevalue});
	}


	/**
	 * Class constructor for states inheriting from DiscreteState.
	 */
	public StandByOnOffState(OffStateValue offstatevalue)
	{
		//call the super class constructor
		super(new StateValue[]{offstatevalue});
	}


	/**
	 * Class constructor for states inheriting from DiscreteState.
	 */
	public StandByOnOffState(StandByStateValue standbystatevalue)
	{
		//call the super class constructor
		super(new StateValue[]{standbystatevalue});
	}

	@Deprecated
	private void initCommon()
	{
		this.old2NewMap.put(StandByOnOffState.ON, new OnStateValue());
		this.old2NewMap.put(StandByOnOffState.OFF, new OffStateValue());
		this.old2NewMap.put(StandByOnOffState.STANDBY, new StandByStateValue());
	}
	/**
	 * Creates a state object in the Dog2.0 old way (before May 2012).
	 * 
	 * @param valueOfTheCurrentStateValue
	 */
	@Deprecated
	public StandByOnOffState(Object valueOfTheCurrentStateValue)
	{
		this.initCommon();
		this.valueOfTheCurrentStateValue = valueOfTheCurrentStateValue;
		if(valueOfTheCurrentStateValue instanceof String)
		{
			this.currentStateValue[0]=this.old2NewMap.get((String)valueOfTheCurrentStateValue);
		}
	}
	/**
	 * Class constructor.
	 */
	public StandByOnOffState(StateValue... currentStateValue)
	{
		super(currentStateValue);
	}

	/**
	 * Default constructor.
	 */
	public StandByOnOffState()
	{
		super();
	}
}
