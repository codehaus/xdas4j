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
 *  File     : ActionTax.java
 *                    
 */

package org.codehaus.xdas4j.datamodel;

/**
 * The Action Taxonomy is yet to be determined. The current proposal involves a hierarchical
 * standard with four levels:
 * <ul>
 *  <li>Registry: the controlling organization which hosts the registry of standardized taxonomy
 *      elements, namely the Open Group
 *  <li>Provider: a namespace provider for a defined taxonomy; this is assigned by the Open
 *      Group, and the current provider is XDAS
 *  <li>Class: event classification, which is a group of similar events (example: User
 *      Management, Data Management, ...)
 *  <li>Identifier: the specific activity that took place (example: Create, Delete, Rename, ...)
 * </ul>
 *  This proposal as well as others is in the process of being evaluated.
 * 
 * @author J.Winteregg
 *
 */
public enum ActionTax {

    NO_DEFINED;
    
}
