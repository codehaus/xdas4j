/*
 * Copyright (c) 2009 NetGuardians SA
 * 
 *  This file is part of xdas4j.
 *  Xdas4j is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Xdas4j is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with Xdas4j.  If not, see <http://www.gnu.org/licenses/>.
 *  
 *  Author   : J.Winteregg 
 *  Date     : Feb 14, 2009 
 * 
 *  Project  : xdas4j 
 *  Package  : org.codehaus.xdas4j.datamodel 
 *  File     : Initiator.java
 *                    
 */

package org.codehaus.xdas4j.datamodel;

import java.util.ArrayList;
import java.util.List;

/**
 * The initiator is the resource or resources that caused the event to occur. Theoretically
 * this is almost always a person (since in virtually all cases there is an ultimate actor 
 * which set a chain of events in motion), but in reality the observer often has
 * a limited view into the root cause of any particular event.
 * The XDAS standard considers only two types of possible actors that could actually cause
 * an action to occur: people, and applications/services that perform automated activities.
 * Each of these can be represented by information that describes how to uniquely identify
 * the who, what, and where of the resource(s) that initiated the described activity.
 * 
 * @author J.Winteregg
 *
 */
public class Initiator {
    
    /**
     * Credentials used by the user or service to gain access to a computing system.
     */
    private Account account = null;
    
    /**
     * In some cases, users and services may be able to perform actions under the aegis 
     * of some other account other than the one with which they first authenticated, which
     *  effectively becomes the account in use at the time the activity occurs.
     */
    private Account effectiveAccount = null;
    
    /**
     * In other cases, users and services may be allowed to perform actions on computing 
     * systems, sometimes anonymously, by virtue of a trust relationship that has been established.
     */
    private Trust trust = null;
    
    /**
     * Describes the application or service that caused the activity to take place.
     */
    private List<Service> services = null;
    
    /**
     * Describes the host environment in which the user and service was acting.
     */
    private Host host = null;
    

    /**
     * Static constructor
     * 
     * @return A new instance of Initiator class
     */
    public static Initiator getInstance(){
        return new Initiator();
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Initiatort#account account} attribute.
     * @return The account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Initiatort#account account} attribute.
     * @param account The action to be set
     * @return This Initiator instance (for chaining purpose)
     */
    public Initiator setAccount(Account account) {
        this.account = account;
        return this;
    }
    
    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Initiatort#effectiveAccount effectiveAccount} attribute.
     * @return The effective account
     */
    public Account getEffectiveAccount() {
        return effectiveAccount;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Initiatort#effectiveAccount effectiveAccount} attribute.
     * @param effectiveAccount The effective account to be set
     * @return This Initiator instance (for chaining purpose)
     */
    public Initiator setEffectiveAccount(Account effectiveAccount) {
        this.effectiveAccount = effectiveAccount;
        return this;
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Initiatort#trust trust} attribute.
     * @return The trust
     */
    public Trust getTrust() {
        return trust;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Initiatort#trust trust} attribute.
     * @param trust The trust to be set
     * @return This Initiator instance (for chaining purpose)
     */
    public Initiator setTrust(Trust trust) {
        this.trust = trust;
        return this;
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Initiatort#services services} list.
     * @return The list of services
     */
    public List<Service> getServices() {
        return services;
    }

    /**
     * Add a {@link org.codehaus.xdas4j.datamodel.Initiatort#services service}.
     * @param service The service to be added to the current list of services
     * @return This Initiator instance (for chaining purpose)
     */
    public Initiator addService(Service service) {
        /* On demand creation in order to return null (getServices) if no service are set.
         * This avoid to return an empty List which is more complicated to check by the caller than a null value */
        if(services == null)
            services = new ArrayList<Service>();
        services.add(service);
        return this;
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Initiatort#host host} attribute.
     * @return The Host
     */
    public Host getHost() {
        return host;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Initiatort#host host} attribute.
     * @param host The host to be set
     * @return This Initiator instance (for chaining purpose)
     */
    public Initiator setHost(Host host) {
        this.host = host;
        return this;
    }

}
