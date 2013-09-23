/*
 * Dog - Core
 * 
 * Copyright (c) 2009-2013 Dario Bonino and Luigi De Russis
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
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.09.13 at 02:38:48 PM CEST 
//


package it.polito.elite.dog.core.library.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.polito.elite.doghomeconfiguration package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Dhc_QNAME = new QName("http://elite.polito.it/dogHomeConfiguration", "dhc");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.polito.elite.doghomeconfiguration
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DogHomeConfiguration }
     * 
     */
    public DogHomeConfiguration createDogHomeConfiguration() {
        return new DogHomeConfiguration();
    }

    /**
     * Create an instance of {@link Statevalue }
     * 
     */
    public Statevalue createStatevalue() {
        return new Statevalue();
    }

    /**
     * Create an instance of {@link NotificationFunctionality }
     * 
     */
    public NotificationFunctionality createNotificationFunctionality() {
        return new NotificationFunctionality();
    }

    /**
     * Create an instance of {@link Building }
     * 
     */
    public Building createBuilding() {
        return new Building();
    }

    /**
     * Create an instance of {@link Commands }
     * 
     */
    public Commands createCommands() {
        return new Commands();
    }

    /**
     * Create an instance of {@link Flat }
     * 
     */
    public Flat createFlat() {
        return new Flat();
    }

    /**
     * Create an instance of {@link Garage }
     * 
     */
    public Garage createGarage() {
        return new Garage();
    }

    /**
     * Create an instance of {@link Configparam }
     * 
     */
    public Configparam createConfigparam() {
        return new Configparam();
    }

    /**
     * Create an instance of {@link ControlFunctionality }
     * 
     */
    public ControlFunctionality createControlFunctionality() {
        return new ControlFunctionality();
    }

    /**
     * Create an instance of {@link Floor }
     * 
     */
    public Floor createFloor() {
        return new Floor();
    }

    /**
     * Create an instance of {@link Notifications }
     * 
     */
    public Notifications createNotifications() {
        return new Notifications();
    }

    /**
     * Create an instance of {@link Ceiling }
     * 
     */
    public Ceiling createCeiling() {
        return new Ceiling();
    }

    /**
     * Create an instance of {@link Configcommand }
     * 
     */
    public Configcommand createConfigcommand() {
        return new Configcommand();
    }

    /**
     * Create an instance of {@link Storey }
     * 
     */
    public Storey createStorey() {
        return new Storey();
    }

    /**
     * Create an instance of {@link Device }
     * 
     */
    public Device createDevice() {
        return new Device();
    }

    /**
     * Create an instance of {@link WallOpening }
     * 
     */
    public WallOpening createWallOpening() {
        return new WallOpening();
    }

    /**
     * Create an instance of {@link Controllables }
     * 
     */
    public Controllables createControllables() {
        return new Controllables();
    }

    /**
     * Create an instance of {@link Statevalues }
     * 
     */
    public Statevalues createStatevalues() {
        return new Statevalues();
    }

    /**
     * Create an instance of {@link BuildingEnvironment }
     * 
     */
    public BuildingEnvironment createBuildingEnvironment() {
        return new BuildingEnvironment();
    }

    /**
     * Create an instance of {@link Confignotification }
     * 
     */
    public Confignotification createConfignotification() {
        return new Confignotification();
    }

    /**
     * Create an instance of {@link Configstate }
     * 
     */
    public Configstate createConfigstate() {
        return new Configstate();
    }

    /**
     * Create an instance of {@link Garden }
     * 
     */
    public Garden createGarden() {
        return new Garden();
    }

    /**
     * Create an instance of {@link Wall }
     * 
     */
    public Wall createWall() {
        return new Wall();
    }

    /**
     * Create an instance of {@link Room }
     * 
     */
    public Room createRoom() {
        return new Room();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DogHomeConfiguration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://elite.polito.it/dogHomeConfiguration", name = "dhc")
    public JAXBElement<DogHomeConfiguration> createDhc(DogHomeConfiguration value) {
        return new JAXBElement<DogHomeConfiguration>(_Dhc_QNAME, DogHomeConfiguration.class, null, value);
    }

}
