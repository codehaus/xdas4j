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
 * 
 * @author J.Winteregg
 */
public class Account {
    
    private String name = null;
    private String id = null;
    private String domaine = null;
    
    /**
     * Static constructor
     * 
     * @return A new instance of Account class
     */
    public static Account getInstance(){
        return new Account();
    }
    
    public String getDomaine() {
        return domaine;
    }
    
    public Account setDomaine(String domaine) {
        this.domaine = domaine;
        return this;
    }
    
    public String getId() {
        return id;
    }
    
    public Account setId(String id) {
        this.id = id;
        return this;
    }
    
    public String getName() {
        return name;
    }
    
    public Account setName(String name) {
        this.name = name;
        return this;
    }

}
