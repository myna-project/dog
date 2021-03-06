/*
 * Dog - Device Rest Endpoint
 * 
 * Copyright (c) 2013 Dario Bonino
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
package it.polito.elite.dog.communication.rest.device.command;

import javax.measure.DecimalMeasure;
import javax.measure.Measure;

/**
 * 
 * @author <a href="mailto:dario.bonino@polito.it">Dario Bonino</a>
 * @see <a href="http://elite.polito.it">http://elite.polito.it</a>
 * 
 */
public class MeasurePayload extends CommandPayload<Measure<?,?>>
{

	public MeasurePayload()
	{
		// TODO Auto-generated constructor stub
	}

	public Measure<?, ?> getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = DecimalMeasure.valueOf(value);
	}
	
	
}
