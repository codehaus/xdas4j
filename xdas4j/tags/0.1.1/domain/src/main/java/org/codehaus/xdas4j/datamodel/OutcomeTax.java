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
 *  File     : OutcomeTax.java 
 *                    
 */

package org.codehaus.xdas4j.datamodel;

/**
 * A classification of the outcome or result of the attempted activity, defined by the XDAS 
 * standard, to the extent that the observer can determine it.
 * 
 * @author hatman
 *
 */
public enum OutcomeTax {
    
    /*
     * The Outcome Taxonomy is yet to be determined. Example are provided
     * in order to allow xdas4j testing.
     */
    SUCCESS,
    FAILED,
    IN_PROGRESS,
    OTHER;

}
