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

import java.lang.reflect.Method;
import java.util.Collection;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;
import org.codehaus.xdas4j.datamodel.XDASEvent;

/**
 * XDAS JSON appender which allows to print XDAS message into JSON format (http://www.json.org/).
 * A user friendly JSON file viewer is available as a Firefox plugin: https://addons.mozilla.org/en-US/firefox/addon/10869/
 * 
 * @author J.Winteregg
 *
 */
public class XDASAppender extends AppenderSkeleton {

    /*
     * (non-Javadoc)
     * @see org.apache.log4j.AppenderSkeleton#append(org.apache.log4j.spi.LoggingEvent)
     */
    protected void append(LoggingEvent event) {
        XDASEvent evt  = (XDASEvent) event.getMessage();
        /* For now, this JSON appender is just printing messages to the console */
        System.out.println("{"+subAppend(evt)+"}");
    }
    
    /**
     * String appender allowing to check if end string should be appended to 
     * start string with a comma.
     * 
     * @param start The first part of the string
     * @param end The string which should be appended to start
     * @return The appended String
     */
    private String append(String start, String end){
        /* Object separator is only set if we do not work on the first log content (to avoid to start with a separator) */
        if(start == null)
            return end;
        else
            return start+" ,"+end;
    }
    
    /**
     * Recursive analysis of xdas4j data model using reflexion. This method returns
     * a JSON String representing the given xdas4j data model object.
     * 
     * @param o The xdas4j data model object
     * 
     * @return The JSON representation of the given object
     */
    private String subAppend(Object o){
        String log = null;
        Method eventMethods[] = o.getClass().getMethods();
        /* Check all data model attributes (getters) */
        for(Method m : eventMethods){
            /* Avoid data extraction (for printing purpose) of getInstance and getClass methods */
            if(m.getName().startsWith("get") && ! m.getName().contains("Instance") && ! m.getName().contains("Class")){
                Object attributeData = null;
                try {
                    attributeData = m.invoke(o);
                }
                catch (Throwable e) {
                   LogLog.error("Unable to extract XDAS "+m.getName()+"attribute from "+o.getClass(), e);
                }
                if(attributeData != null){
                    /* If we do not work on an xdas4j attribute object (which should be further analyzed), process this simple data structure */
                    if(! attributeData.getClass().getName().startsWith("org.codehaus.xdas4j.datamodel")){
                        /* Do we have a collection of something ? */
                        if(attributeData instanceof Collection){
                            Collection<?> attributeCollection = (Collection<?>) attributeData;
                            /* Build collection String representation */
                            String collectionString = null;
                            for(Object collectionItem : attributeCollection){
                                collectionString = append(collectionString, "{"+subAppend(collectionItem)+"}");
                            }
                            log = append(log, "\""+m.getName().substring(3)+"\": ["+collectionString+"]");
                        }
                        /* We work on an unstructured Java data (String, Integer, etc.) */
                        else{
                            log = append(log, "\""+m.getName().substring(3)+"\": \""+attributeData+"\"");
                        }
                    }
                    /* We work on an xdas4j attribute. It should be further processed */
                    else{
                        log = append(log, "\""+attributeData.getClass().getSimpleName()+"\": {"+subAppend(attributeData)+"}");
                    }
                }
            }
        }
        return log;
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
        return false;
    }

}
