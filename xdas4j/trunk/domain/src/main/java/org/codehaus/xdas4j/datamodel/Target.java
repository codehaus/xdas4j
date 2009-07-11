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
 *  File     : Target.java 
 *                    
 */


package org.codehaus.xdas4j.datamodel;

import java.util.ArrayList;
import java.util.List;

/**
 * The target is the resource(s) that are affected by the action caused by the initiator. Again, all
 * targets could be described generically as resource objects, but XDAS explicitly identifies certain
 * resource types that have special security significance. Several of these are identical to the list of
 * possible initiators.
 * 
 * @author J.Winteregg
 *
 */
public class Target {
    
    /**
     * Account describes a credential set that was acted upon.
     * Accounts have special significance in the security domain because accounts give users and
     * services access to potentially sensitive systems and data.
     */
    private Account account = null;
    
    /**
     * Trust describes a trust relationship that was acted upon (trusts can be embodied by groups,
     * roles, profiles, security equivalence relationships, certificates, etc). Trusts have special
     *  significance in the security domain because trust relationships give users and services access
     *  to potentially sensitive systems and data.
     */
    private Trust trust = null;
    
    /**
     * Services describes an application or service that was acted upon.
     * Services have special significance in the security domain because enabling, disabling, or modifying
     * the configuration of certain services may affect the confidentiality, integrity, or availability 
     * of enterprise data.
     */
    private List<Service> services = null;
    
    /**
     * Host describes a host that was acted upon.
     * Hosts have special significance in the security domain because they host services and data that,
     * if modified, might change the confidentiality, availability, and integrity of enterprise data.
     */
    private Host host = null;
    
    /**
     * Data Object describes a data object that was acted upon.
     * A data object covers all other resources that can be acted upon such as files, database tables,
     * rules, directory objects, and so forth.
     */
    private DataObject dataObject = null;
    
    
    /**
     * Static constructor
     * 
     * @return A new instance of Target class
     */
    public static Target getInstance(){
        return new Target();
    }
    
    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Target#account account} attribute.
     * @return The account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Target#account account} attribute.
     * @param account The account to be set
     * @return This Target instance (for chaining purpose)
     */
    public Target setAccount(Account account) {
        this.account = account;
        return this;
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Target#trust trust} attribute.
     * @return The trust
     */
    public Trust getTrust() {
        return trust;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Target#trust trust} attribute.
     * @param trust The trust to be set
     * @return This Target instance (for chaining purpose)
     */
    public Target setTrust(Trust trust) {
        this.trust = trust;
        return this;
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Target#services services} list.
     * @return The list of services
     */
    public List<Service> getServices() {
        return services;
    }

    /**
     * Add a {@link org.codehaus.xdas4j.datamodel.Target#services service}.
     * @param service The service to be added to the current list of services
     * @return This Target instance (for chaining purpose)
     */
    public Target addService(Service service) {
        /* On demand creation in order to return null (getServices) if no service are set.
         * This avoid to return an empty List which is more complicated to check by the caller than a null value */
        if(services == null)
            services = new ArrayList<Service>();
        services.add(service);
        return this;
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Target#host host} attribute.
     * @return The host
     */
    public Host getHost() {
        return host;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Target#host host} attribute.
     * @param host The host to be set
     * @return This Target instance (for chaining purpose)
     */
    public Target setHost(Host host) {
        this.host = host;
        return this;
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Target#dataObject dataObject} attribute.
     * @return The dataObject
     */
    public DataObject getDataObject() {
        return dataObject;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Target#dataObject dataObject} attribute.
     * @param dataObject The dataObject to be set
     * @return This Target instance (for chaining purpose)
     */
    public Target setDataObject(DataObject dataObject) {
        this.dataObject = dataObject;
        return this;
    }

}
