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
 * <p>
 * Unlike the other toplevel data model components, the Action section is not strictly
 * objectoriented; it provides a set of metainformation to describe the activity. Vendors
 * can choose to include codes and strings in this structure to maintain a level of backwards
 * compatibility with previous event implementations.
 * 
 * @author J.Winteregg
 */
public class Action {
    
    /**
     * The Name field contains a string that describes the abstract event that occurred, in terms of the
     * observer. It should not include any event-specific information, and should be the same for all
     * instances of this same type of event. Examples would include "User logged in", "File modified",
     * and so forth. This field is required for all events.
     */
    private String name = null;
    
    /**
     * The ID field contains a code referring to the event that occurred, in terms of the observer. Not all
     * vendors define such codes, but some do to support references and for other purposes. In general
     * there should be a one-to-one mapping between any defined Names and IDs. This field is
     * optional.
     */
    private String id = null;
    
    /**
     * The Message field contains a longer, descriptive message that describes the specific event that
     * occurred, with reference to specific event data that will help users understand the event.
     * Examples include "User 'jdoe' logged in to system 'host1.'". In general it is recommended that a
     * description be a fixed string with replacement values to contain event data, and should have a
     * one-to-one relationship with a given event Name. This field is optional.
     */
    private String message = null;
    
    /**
     * The ActionTax object presents a hierarchical classification of the event. This hierarchy is 
     * designed to categorize the event records for cross-platform, simplified queries and reporting.
     * In general it classifies two components of the XDAS data model: the Action, and the Target.
     * This field is required for all events.
     */
    private ActionTax actionTax = null;
    
    /**
     * The OutcomeTax object presents a hierarchical classification of the outcome of the event, 
     * meaning the result or status of the attempted operation. In general the top level of the hierarchy 
     * describes the success, failure (system failure), or denial (by policy) of the attempted operation,
     * and the detail level describes the reason for the outcome. This field is required for all events.
     */
    private OutcomeTax outcomeTax = null;
    
    /**
     * The time the event occurred
     */
    private Date time = null;
    
    /**
     * The number of times this event occurred, if it has been repeated. Note that using this field 
     * decreases the resolution and utility of the Time field, but may conserve processing resources.
     */
    private Integer count = null;
    
    /**
     * Static constructor
     * @return A new instance of Action class
     */
    public static Action getInstance(){
        return new Action();
    }
    
    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Action#actionTax actionTax} attribute.
     * @return The actionTax
     */
    public ActionTax getActionTax() {
        return actionTax;
    }
    
    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Action#actionTax actionTax} attribute.
     * @param actionTax The actionTax to be set
     * @return This action instance (for chaining purpose)
     */
    public Action setActionTax(ActionTax actionTax) {
        this.actionTax = actionTax;
        return this;
    }
    
    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Action#id id} attribute.
     * @return The id
     */
    public String getId() {
        return id;
    }
    
    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Action#id id} attribute.
     * @param id The id to be set
     * @return This action instance (for chaining purpose)
     */
    public Action setId(String id) {
        this.id = id;
        return this;
    }
    
    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Action#message message} attribute.
     * @return The message
     */
    public String getMessage() {
        return message;
    }
    
    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Action#message message} attribute.
     * @param message The message to be set
     * @return This action instance (for chaining purpose)
     */
    public Action setMessage(String message) {
        this.message = message;
        return this;
    }
    
    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Action#name name} attribute.
     * @return The name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Action#name name} attribute.
     * @param name The name to be set
     * @return This action instance (for chaining purpose)
     */
    public Action setName(String name) {
        this.name = name;
        return this;
    }
    
    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Action#outcomeTax outcomeTax} attribute.
     * @return The outcomeTax
     */
    public OutcomeTax getOutcomeTax() {
        return outcomeTax;
    }
    
    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Action#outcomeTax outcomeTax} attribute.
     * @param outcomeTax The outcomeTax to be set
     * @return This action instance (for chaining purpose)
     */
    public Action setOutcomeTax(OutcomeTax outcomeTax) {
        this.outcomeTax = outcomeTax;
        return this;
    }
    
    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Action#time time} attribute.
     * @return The time
     */
    public Date getTime() {
        return time;
    }
    
    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Action#time time} attribute.
     * @param time The time to be set
     * @return This action instance (for chaining purpose)
     */
    public Action setTime(Date time) {
        this.time = time;
        return this;
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Action#count count} attribute.
     * @return The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Action#count count} attribute.
     * @param count The count to be set
     * @return This action instance (for chaining purpose)
     */
    public Action setCount(Integer count) {
        this.count = count;
        return this;
    }

}
