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
 *  File     : DataObject.java 
 *                    
 */

package org.codehaus.xdas4j.datamodel;

/**
 * A data object covers all other resources that can be acted upon such as files, database tables,
 * rules, directory objects, and so forth.
 * 
 * @author J.Winteregg
 *
 */
public class DataObject {
    
    /**
     * The Name field specifies the base name of the data object being modified, i.e. a file name, table
     * name, directory object name, and so forth. For most types of data objects, this is used for
     * presentation to humans. This field is required if the event affected a data object.
     */
    private String name = null;
    
    /**
     * The ID field specifies the internal machine identifier used to refer to the same data object, such
     * as the inode number on some filesystems. This field is optional, but can sometimes help
     * distinguish cases where filenames are being re-used.
     */
    private String id = null;
    
    /**
     * The Domain field specifies the namespace within which the data object exists. For filesystems
     * and directories, this will be fully-qualified path or directory structure. For tables, this will be the
     * database and perhaps the tablespace.
     */
    private String domain = null;

    
    /**
     * Static constructor
     * 
     * @return A new instance of DataObject class
     */
    public static DataObject getInstance(){
        return new DataObject();
    }
    
    /**
     * Get {@link org.codehaus.xdas4j.datamodel.DataObject#name name} attribute.
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.DataObject#name name} attribute.
     * @param name The name to be set
     * @return This DataObject instance (for chaining purpose)
     */
    public DataObject setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.DataObject#id id} attribute.
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.DataObject#id id} attribute.
     * @param id The id to be set
     * @return This DataObject instance (for chaining purpose)
     */
    public DataObject setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.DataObject#domain domain} attribute.
     * @return The domain
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.DataObject#domain domain} attribute.
     * @param domain The domain to be set
     * @return This DataObject instance (for chaining purpose)
     */
    public DataObject setDomain(String domain) {
        this.domain = domain;
        return this;
    }

}
