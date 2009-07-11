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
 *  Date     : Jul 11, 2009 
 * 
 *  Project  : xdas4j 
 *  Package  : org.codehaus.xdas4j.datamodel 
 *  File     : Service.java 
 *                    
 */

package org.codehaus.xdas4j.datamodel;

/**
 * The application or service. Services have special significance in the security domain because 
 * enabling, disabling, or modifying the configuration of certain services may affect the confidentiality,
 * integrity, or availability of enterprise data.
 * 
 * @author J.Winteregg
 *
 */
public class Service {
    
    /**
     * The Name field indicates the relevant application or service. This should be a commonly
     * recognized name for the application, such as 'sshd,' 'openldap,' or 'apache.' This field is required
     * for events where the Component field describes a specific component within the application.
     */
    private String name = null;

    /**
     * The Component field describes a specific component within the application. In general this
     * should be to help the user determine which part of the application was involved and should be
     * human-readable, such as: 'authentication service,' 'session creation,' or 'archive service.'
     */
    private String component = null;
    
    /**
     * The ServiceTax classifies the type of application or service that is involved. This is an 
     * enumerated field that is used to help event consumers understand how and why the event was generated.
     */
    private ServiceTax serviceTax = null;
    
    /**
     * The Account represents an account under which the service is operating. This is provided 
     * to describe the access permissions that the service should have been granted.
     */
    private Account account = null;
    
    /**
     * The port field define the port number of the given service (networked service). 
     */
    private Integer port = null;
    
    
    /**
     * Static constructor
     * 
     * @return A new instance of Service class
     */
    public static Service getInstance(){
        return new Service();
    }
    
    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Service#name name} attribute.
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Service#name name} attribute.
     * @param name The name to be set
     * @return This Service instance (for chaining purpose)
     */
    public Service setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Service#component component} attribute.
     * @return The component
     */
    public String getComponent() {
        return component;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Service#component component} attribute.
     * @param component The component to be set
     * @return This Service instance (for chaining purpose)
     */
    public Service setComponent(String component) {
        this.component = component;
        return this;
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Service#serviceTax serviceTax} attribute.
     * @return The serviceTax
     */
    public ServiceTax getServiceTax() {
        return serviceTax;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Service#serviceTax serviceTax} attribute.
     * @param serviceTax The serviceTax to be set
     * @return This Service instance (for chaining purpose)
     */
    public Service setServiceTax(ServiceTax serviceTax) {
        this.serviceTax = serviceTax;
        return this;
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Service#account account} attribute.
     * @return The account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Service#account account} attribute.
     * @param account The account to be set
     * @return This Service instance (for chaining purpose)
     */
    public Service setAccount(Account account) {
        this.account = account;
        return this;
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Service#port port} attribute.
     * @return The port
     */
    public Integer getPort() {
        return port;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Service#port port} attribute.
     * @param port The port to be set
     * @return This Service instance (for chaining purpose)
     */
    public Service setPort(Integer port) {
        this.port = port;
        return this;
    }

}
