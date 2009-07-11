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
 *  File     : Observer.java
 *                    
 */

package org.codehaus.xdas4j.datamodel;

import java.util.ArrayList;
import java.util.List;

/**
 * The observer detects and reports the observed activity.
 * 
 * To help clarify the difference between initiator and observer, note that there are four possible
 * combinations of initiator, target, and observer that can be reported to represent a specific type of
 * activity:
 * 
 * <ol>
 *  <li>Initiator, target, and observer are all different: for example, an Intrusion Detection
 *  System may detect an attempted attack from one remote host against another remote
 *  host. In this case the source IP is the initiator, the destination IP the target, and the IDS
 *  device itself is the observer.
 *  
 *  <li>Observer is target: for example, a service may report inbound SSH attempts from
 *  remote systems. In this case the target host/service is also the observer (is generating the
 *  event record).
 *  
 *  <li>Observer is initiator: for example, a service may report outbound connections to
 *  remote hosts. In this case the initiator is also the observer (is generating the event
 *  record).
 *  
 *  <li>Observer, target, and initiator are all the same: if, for example, the entire transaction
 *  takes place within a single application, then all three objects will report the same
 *  information.
 * </ol>
 * 
 * @author J.Winteregg
 *
 */
public class Observer {
    
    /**
     * the application or server which detects the activity and generates an event
     * record to describe the activity.
     */
    private List<Service> services = null;

    /**
     * The host environment on which that service is running.
     */
    private Host host = null;
    
    
    /**
     * Static constructor
     * 
     * @return A new instance of Observer class
     */
    public static Observer getInstance(){
        return new Observer();
    }
    
    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Observer#services services} list.
     * @return The list of services
     */
    public List<Service> getServices() {
        return services;
    }

    /**
     * Add a {@link org.codehaus.xdas4j.datamodel.Observer#services service}.
     * @param service The service to be added to the current list of services
     * @return This Observer instance (for chaining purpose)
     */
    public Observer addService(Service service) {
        /* On demand creation in order to return null (getServices) if no service are set.
         * This avoid to return an empty List which is more complicated to check by the caller than a null value */
        if(services == null)
            services = new ArrayList<Service>();
        services.add(service);
        return this;
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Observer#host host} attribute.
     * @return The host
     */
    public Host getHost() {
        return host;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Observer#host host} attribute.
     * @param host The host to be set
     * @return This Observer instance (for chaining purpose)
     */
    public Observer setHost(Host host) {
        this.host = host;
        return this;
    }
 
}
