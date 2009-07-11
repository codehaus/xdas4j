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
 *  File     : Account.java 
 *                    
 */

package org.codehaus.xdas4j.datamodel;

/**
 * Describes a credential set that was acted upon. Accounts have special significance in 
 * the security domain because accounts give users and services access to potentially sensitive 
 * systems and data.
 * 
 * @author J.Winteregg
 */
public class Account {
    
    /**
     * The Name field presents a user-readable name for a given account object. This is commonly the
     * string that the user presents in order to authenticate.
     */
    private String name = null;
    
    /**
     * The ID field represents the machine-readable account ID, GUID, or other identifier that is 
     * assigned to represent this user account. This field is optional. 
     */
    private String id = null;
    
    /**
     * The Domain field represents the namespace within which the Account is stored. This could be
     * an LDAP container, an Active Directory domain, or a specific Linux host (where the account is
     * stored in the /etc/passwd file). In general a user should be able to uniquely identify a specific
     * account by combining this Domain with the Account Name. This field is required if the Name
     * field is set.
     */
    private String domain = null;
    
    
    /**
     * Static constructor
     * 
     * @return A new instance of Account class
     */
    public static Account getInstance(){
        return new Account();
    }
    
    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Account#domain domain} attribute.
     * @return The domain
     */
    public String getDomain() {
        return domain;
    }
    
    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Account#domain domain} attribute.
     * @param domain The domain to be set
     * @return This account instance (for chaining purpose)
     */
    public Account setDomain(String domain) {
        this.domain = domain;
        return this;
    }
    
    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Account#id id} attribute.
     * @return The id
     */
    public String getId() {
        return id;
    }
    
    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Account#id id} attribute.
     * @param id The id to be set
     * @return This account instance (for chaining purpose)
     */
    public Account setId(String id) {
        this.id = id;
        return this;
    }
    
    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Account#name name} attribute.
     * @return The name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Account#name name} attribute.
     * @param name The name to be set
     * @return This account instance (for chaining purpose)
     */
    public Account setName(String name) {
        this.name = name;
        return this;
    }

}
