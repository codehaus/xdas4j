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
 *  File     : Action.java
 *                    
 */

package org.codehaus.xdas4j.datamodel;

import java.util.Date;

/**
 * The action indicates what type of activity took place, along with metainformation
 * about when and how it happened. This includes time and date information, the taxonomy
 * fields describing the type of action and its outcome, and additional information provided
 * by the developer in the event, such as humanreadable descriptions of the activity.
 * 
 * Unlike the other toplevel data model components, the Action section is not strictly
 * objectoriented; it provides a set of metainformation to describe the activity. Vendors
 * can choose to include codes and strings in this structure to maintain a level of backwards
 * compatibility with previous event implementations.
 * 
 * @author J.Winteregg
 *
 */
public class Action {
    
    private String name = null;
    private String id = null;
    private String message = null;
    private ActionTax actionTax = null;
    private OutcomeTax outcomeTax = null;
    private Date time = null;
    private Integer count = null;
    
    /**
     * Static constructor
     * 
     * @return A new instance of Action class
     */
    public static Action getInstance(){
        return new Action();
    }
    
    public ActionTax getActionTax() {
        return actionTax;
    }
    
    public Action setActionTax(ActionTax actionTax) {
        this.actionTax = actionTax;
        return this;
    }
    
    public String getId() {
        return id;
    }
    
    public Action setId(String id) {
        this.id = id;
        return this;
    }
    
    public String getMessage() {
        return message;
    }
    
    public Action setMessage(String message) {
        this.message = message;
        return this;
    }
    
    public String getName() {
        return name;
    }
    
    public Action setName(String name) {
        this.name = name;
        return this;
    }
    
    public OutcomeTax getOutcomeTax() {
        return outcomeTax;
    }
    
    public Action setOutcomeTax(OutcomeTax outcomeTax) {
        this.outcomeTax = outcomeTax;
        return this;
    }
    
    public Date getTime() {
        return time;
    }
    
    public Action setTime(Date time) {
        this.time = time;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public Action setCount(Integer count) {
        this.count = count;
        return this;
    }

}
