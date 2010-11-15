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
 *  Date     : Jul 6, 2009 
 * 
 *  Project  : xdas4j 
 *  Package  : org.codehaus.xdas4j.datamodel
 *  File     : Trust.java 
 *                    
 */

package org.codehaus.xdas4j.datamodel;

/**
 * The format is the same as for Account, except that the object referenced represents a group,
 * account, role, profile, or other object that has as trust relationship with the initiator or target and
 * therefore confers additional access permissions to the initiator/target.
 * 
 * @author J.Winteregg
 *
 */
public class Trust extends Account {
    
    /**
     * Static constructor
     * 
     * @return A new instance of Account class
     */
    public static Trust getInstance(){
        return new Trust();
    }
    
    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Account#domain domain} attribute.
     * @param domain The domain to be set
     * @return This trust instance (for chaining purpose)
     */
    public Trust setDomain(String domain) {
        super.setDomain(domain);
        return this;
    }
    
    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Account#id id} attribute.
     * @param id The id to be set
     * @return This trust instance (for chaining purpose)
     */
    public Trust setId(String id) {
        super.setId(id);
        return this;
    }
    
    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Account#name name} attribute.
     * @param name The name to be set
     * @return This trust instance (for chaining purpose)
     */
    public Trust setName(String name) {
        super.setName(name);
        return this;
    }

}
