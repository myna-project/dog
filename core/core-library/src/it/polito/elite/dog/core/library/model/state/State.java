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

package it.polito.elite.dog.core.library.model.state;


import it.polito.elite.dog.core.library.model.statevalue.StateValue;

import java.util.Arrays;
import java.io.Serializable;
import java.util.Hashtable;




/**
* State - automatically generated by it.polito.elite.domotics.ontologies.dogont.utilities.DogOnt2Dog
*
* @author it.polito.elite.domotics.ontologies.dogont.utilities.DogOnt2Dog
*
*/
public class State implements Serializable
{
	/**
	 * The unique class version for serialization
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * The current value of this State object (value of the current StateValue
	 * instance)
	 */
	@Deprecated
	protected Object valueOfTheCurrentStateValue;

	/**
	 * The map for converting old state specifications in the new format
	 */
	@Deprecated
	protected Hashtable<String, StateValue> old2NewMap;

	/**
	 * The current value of this State object
	 */
	protected StateValue currentStateValue[];

	/**
	 * Creates a state object in the Dog2.0 old way (before May 2012).
	 * 
	 * @param valueOfTheCurrentStateValue
	 */
	@Deprecated
	public State(Object valueOfTheCurrentStateValue)
	{
	//init the inner data structures...
		this.currentStateValue = new StateValue[1];
		this.old2NewMap = new Hashtable<String, StateValue>();
		this.valueOfTheCurrentStateValue = valueOfTheCurrentStateValue;

		if(valueOfTheCurrentStateValue instanceof String)
		{
			this.currentStateValue[0]=this.old2NewMap.get((String)valueOfTheCurrentStateValue);
		}
	}

	// subclasses will generate methods with the exact number of state values... 

	/**
	 * Creates a state object.
	 * 
	 * @param currentStateValue
	 */
	public State(StateValue... currentStateValue)
	{
		this.currentStateValue = currentStateValue;
		this.old2NewMap = new Hashtable<String, StateValue>();
	}

	public State()
	{
		this.currentStateValue = new StateValue[1];
		this.old2NewMap = new Hashtable<String, StateValue>();
	}
	/**
	 * Provides the current state in the Dog2.0 old way (before May 2012).
	 * 
	 * @return
	 */
	@Deprecated
	public Object getCurrentState()
	{
		return this.valueOfTheCurrentStateValue;
	}

	/**
	 * Provides the current state as an array of state values, typically
	 * contains only 1 instance of state value, unless for meter and sensor
	 * states
	 * 
	 * @return
	 */
	public StateValue[] getCurrentStateValue()
	{
		return this.currentStateValue;
	}

	/**
	 * Provides the unique name of this state class as a {@link String}.
	 * 
	 * @return
	 */
	public String getStateName()
	{
		return this.getClass().getSimpleName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0)
	{
		// the equals flag
		boolean equals = false;

		// if it is a state, do the comparison otherwise return false
		if (arg0 instanceof State)
		{
			// the state to compare
			State arg0State = (State) arg0;

			// deep comparison of the currentStateValue array, independently
			// from the array elements' order

			equals = true;

			for (int i = 0; (i < this.currentStateValue.length) && (equals); i++)
			{
				boolean found = false;

				for (int j = 0; (j < arg0State.currentStateValue.length) && (!found); j++)
				{
					if (this.currentStateValue[i].equals(arg0State.currentStateValue[j]))
					found = true;
				}

				if (!found)
				equals = false;
			}

		}

		// return the equals value
		return equals;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
@Override
	public String toString()
	{
		return Arrays.toString(currentStateValue);
	}
}
