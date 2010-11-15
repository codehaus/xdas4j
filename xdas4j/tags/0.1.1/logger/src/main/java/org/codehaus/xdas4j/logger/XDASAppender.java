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
 *  Date     : Feb 11, 2009 
 * 
 *  Project  : xdas4j 
 *  Package  : org.codehaus.xdas4j.logger 
 *  File     : XDASAppender.java
 *                    
 */

package org.codehaus.xdas4j.logger;

import java.util.Enumeration;

import org.apache.log4j.Appender;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.helpers.AppenderAttachableImpl;
import org.apache.log4j.spi.AppenderAttachable;
import org.apache.log4j.spi.LoggingEvent;
import org.codehaus.xdas4j.datamodel.Host;
import org.codehaus.xdas4j.datamodel.Observer;
import org.codehaus.xdas4j.datamodel.XDASEvent;

/**
 * XDAS Appender which allows to statically (from log4j configuration file) set different
 * XDAS values.
 * 
 * @author J.Winteregg
 *
 */
public class XDASAppender extends AppenderSkeleton implements AppenderAttachable {
    
    private String observerHostName = null;

    /**
     * Nested appenders.
     */
    private final AppenderAttachableImpl appenders;
    
    /**
     * 
     */
    public XDASAppender(){
        appenders = new AppenderAttachableImpl();
    }
    
    public void setObserverHostName(String hostname){
        observerHostName = hostname;
    }
    
    /*
     * (non-Javadoc)
     * @see org.apache.log4j.AppenderSkeleton#append(org.apache.log4j.spi.LoggingEvent)
     */
    protected void append(LoggingEvent event) {
        /*
         * Add the needed parameters on the event.
         * */
        XDASEvent evt  = (XDASEvent) event.getMessage();
        evt.setObserver(Observer.getInstance().setHost(Host.getInstance().setName(observerHostName)));
        
        appenders.appendLoopOnAppenders(event);
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.apache.log4j.AppenderSkeleton#close()
     */
    public void close() {
        if(this.closed) // closed is defined in AppenderSkeleton
            return;
        this.closed = true;
    }

    /*
     * (non-Javadoc)
     * @see org.apache.log4j.AppenderSkeleton#requiresLayout()
     */
    public boolean requiresLayout() {
        /* An xdas4j layout is needed */
        return true;
    }

    public void addAppender(Appender newAppender) {
        appenders.addAppender(newAppender);
    }

    public Enumeration getAllAppenders() {
        return appenders.getAllAppenders();
    }

    public Appender getAppender(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean isAttached(Appender appender) {
        return appenders.isAttached(appender);
    }

    public void removeAllAppenders() {
        appenders.removeAllAppenders();        
    }

    public void removeAppender(Appender appender) {
        appenders.removeAppender(appender);
    }

    public void removeAppender(String name) {
        appenders.removeAppender(name);
    }

}
