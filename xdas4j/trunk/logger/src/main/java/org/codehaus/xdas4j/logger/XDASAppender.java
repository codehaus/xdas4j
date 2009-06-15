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

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.codehaus.xdas4j.datamodel.XDASEvent;


public class XDASAppender extends AppenderSkeleton {
    
    private String separator = "-";

    /*
     * (non-Javadoc)
     * @see org.apache.log4j.AppenderSkeleton#append(org.apache.log4j.spi.LoggingEvent)
     */
    protected void append(LoggingEvent event) {
        XDASEvent evt  = (XDASEvent) event.getMessage();
        System.err.println(subAppend(evt));
    }
    

    /**
     * 
     * @param o
     */
    private String subAppend(Object o){
        String log = null;
        Method eventMethods[] = o.getClass().getMethods();
        for(Method m : eventMethods){
            /* Avoid data extraction (for printing purpose) of getInstance and getClass methods */
            if(m.getName().startsWith("get") && ! m.getName().contains("Instance") && ! m.getName().contains("Class")){
                Object data = null;
                try {
                    data = m.invoke(o);
                }
                catch (Throwable e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if(data != null){
                    if(! data.getClass().getName().startsWith("org.xdas.datamodel"))
                        /* Object separator is only set if we do not work on the first log content (to avoid to start with a separator) */
                        if(log == null)
                            /* Remove 'get' from the methode name in order to avoid it into the output */
                            log = (m.getName().substring(3)+" = "+data);
                        else
                            /* Remove 'get' from the methode name in order to avoid it into the output */
                            log = log +" "+separator+" "+m.getName().substring(3)+" = "+data;
                    else
                        /* Object separator is only set if we do not work on the first log content (to avoid to start with a separator) */
                        if(log == null)
                            log = data.getClass().getSimpleName()+"("+subAppend(data)+")";
                        else
                            log = log +" "+separator+" "+data.getClass().getSimpleName()+"("+subAppend(data)+")";
                }
            }
        }
        return log;
    }
    
    public void setSeparator(String separator){
        this.separator = separator;
    }

    public void close() {
        // TODO Auto-generated method stub
        
    }

    public boolean requiresLayout() {
        // TODO Auto-generated method stub
        return false;
    }

}
