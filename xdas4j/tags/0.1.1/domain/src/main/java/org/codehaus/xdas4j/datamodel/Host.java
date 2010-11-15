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
 *  Date     : Jul 06, 2009 
 * 
 *  Project  : xdas4j 
 *  Package  : org.codehaus.xdas4j.datamodel 
 *  File     : Host.java
 *                    
 */

package org.codehaus.xdas4j.datamodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Describes a host that was acted upon. Hosts have special significance in the security 
 * domain because they host services and data that, if modified, might change the 
 * confidentiality, availability, and integrity of enterprise data.
 * 
 * @author J.Winteregg
 *
 */
public class Host {

    /**
     * The Name field describes the human-readable name for the host. No domain information is included here.
     */
    private String name = null;
    
    /**
     * The Address describes the network settings for a particular host.
     */
    private List<Address> addresses = null;
    
    
    /**
     * Static constructor
     * 
     * @return A new instance of Host class
     */
    public static Host getInstance(){
        return new Host();
    }
    
    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Host#name name} attribute.
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Host#name name} attribute.
     * @param name The name to be set
     * @return This Host instance (for chaining purpose)
     */
    public Host setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Host#addresses addresses} list.
     * @return The list of addresses
     */
    public List<Address> getAddresses() {
        return addresses;
    }

    /**
     * Add an {@link org.codehaus.xdas4j.datamodel.Host#addresses address}.
     * @param address The address to be added to the current list of addresses
     * @return This Host instance (for chaining purpose)
     */
    public Host addAddress(Address address) {
        /* On demand creation in order to return null (getAddresses) if no service are set.
         * This avoid to return an empty List which is more complicated to check by the caller than a null value */
        if(addresses == null)
            addresses = new ArrayList<Address>();
        addresses.add(address);
        return this;
    }


}
