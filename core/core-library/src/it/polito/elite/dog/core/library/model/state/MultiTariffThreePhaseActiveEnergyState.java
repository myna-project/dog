/*
    _/_/_/                              _/_/          _/          _/_/                _/      
   _/    _/    _/_/      _/_/_/      _/    _/      _/  _/      _/    _/  _/_/_/    _/_/_/_/   
  _/    _/  _/    _/  _/    _/          _/        _/  _/      _/    _/  _/    _/    _/        
 _/    _/  _/    _/  _/    _/        _/          _/  _/      _/    _/  _/    _/    _/      
_/_/_/      _/_/      _/_/_/      _/_/_/_/  _/    _/          _/_/    _/    _/      _/_/
                         _/
                    _/_/

WEBSITE: http://elite.polito.it/dogont-tools-80
Copyright (c) [2013] [Dario Bonino, Luigi De Russis, Emiliano Castellina (dario.bonino, luigi.derussis, emiliano.castellina{@polito.it}), Politecnico di Torino]
Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and limitations under the License.
*//*Automatically generated byit.polito.elite.domotics.ontologies.dogont.utilities.DogOnt2Dog */

package it.polito.elite.dog.core.library.model.state;


import it.polito.elite.dog.core.library.model.statevalue.MultiTariffActiveEnergyStateValue;



/**
* MultiTariffThreePhaseActiveEnergyState - automatically generated by it.polito.elite.domotics.ontologies.dogont.utilities.DogOnt2Dog
*
* @author it.polito.elite.domotics.ontologies.dogont.utilities.DogOnt2Dog
*
*/
public class MultiTariffThreePhaseActiveEnergyState extends EnergyMeasurementState
{
	/**
	 * The unique class version for serialization
	 */

	private static final long serialVersionUID = 1L;



	/**
	 * Class constructor for states inheriting from ContinuousState.
	 */
	public MultiTariffThreePhaseActiveEnergyState(MultiTariffActiveEnergyStateValue multitariffactiveenergystatevalue,MultiTariffActiveEnergyStateValue multitariffactiveenergystatevalue1,MultiTariffActiveEnergyStateValue multitariffactiveenergystatevalue2,MultiTariffActiveEnergyStateValue multitariffactiveenergystatevalue3,MultiTariffActiveEnergyStateValue multitariffactiveenergystatevalue4,MultiTariffActiveEnergyStateValue multitariffactiveenergystatevalue5)
	{
		//call the super class constructor
		super(multitariffactiveenergystatevalue,multitariffactiveenergystatevalue1,multitariffactiveenergystatevalue2,multitariffactiveenergystatevalue3,multitariffactiveenergystatevalue4,multitariffactiveenergystatevalue5);
	}
	/**
	 * Creates a state object in the Dog2.0 old way (before May 2012).
	 * 
	 * @param valueOfTheCurrentStateValue
	 */
	@Deprecated
	public MultiTariffThreePhaseActiveEnergyState(Object valueOfTheCurrentStateValue)
	{
		this.valueOfTheCurrentStateValue = valueOfTheCurrentStateValue;

		if(!(valueOfTheCurrentStateValue instanceof String))
		{
			MultiTariffActiveEnergyStateValue sValue = new MultiTariffActiveEnergyStateValue();
			sValue.setValue(valueOfTheCurrentStateValue);
			this.currentStateValue[0]=sValue;

		}
	}

	/**
	 * Default constructor.
	 */
	public MultiTariffThreePhaseActiveEnergyState()
	{
		super();
	}
}