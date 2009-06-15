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
 *  File     : XDASEvent.java 
 *                    
 */

package org.codehaus.xdas4j.datamodel;

import java.net.MalformedURLException;
import java.net.URL;


public class XDASEvent {
    
    /**
     * XDAS header
     */
    private String id = null;
    private URL version = null;
    
    /**
     * XDAS data model
     */
    private Initiator initiator = null;
    private Action action = null;
    private Target target = null;
    private Observer observer = null;
    
    
    public XDASEvent(){
        try {
            version = new URL("http://www.opengroup.com/xdas/2008");
        }
        catch (MalformedURLException e) {
            //not possible (hard-coded)
        }
    }
    
    public static XDASEvent getInstance(){
        return new XDASEvent();
    }
    
    public String getId(){
        return id;
    }
    
    public URL getVersion(){
        return version;
    }
    
    public Action getAction() {
        return action;
    }
    
    public XDASEvent setAction(Action action) {
        this.action = action;
        return this;
    }
    
    public Initiator getInitiator() {
        return initiator;
    }
    
    public XDASEvent setInitiator(Initiator initiator) {
        this.initiator = initiator;
        return this;
    }
    
    public Observer getObserver() {
        return observer;
    }
    
    public XDASEvent setObserver(Observer observer) {
        this.observer = observer;
        return this;
    }
    
    public Target getTarget() {
        return target;
    }
    
    public XDASEvent setTarget(Target target) {
        this.target = target;
        return this;
    }

}
