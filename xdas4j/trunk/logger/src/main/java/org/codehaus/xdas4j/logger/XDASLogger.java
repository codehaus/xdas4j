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
 *  Date     : Feb 13, 2009 
 * 
 *  Project  : xdas4j 
 *  Package  : org.codehaus.xdas4j.logger 
 *  File     : XDASLogger.java
 *                    
 */

package org.codehaus.xdas4j.logger;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.codehaus.xdas4j.datamodel.XDASEvent;

/**
 * XDASLogger allowing xdas4j user to generate XDAS compliant audit trails. 
 * 
 * @author hatman
 *
 */
public class XDASLogger {
    
    /* FQDN = point d'entrée du logger (classe d'entrée) utilisée afin de 'calculer' la classe appelante 
     * (effectué par LocationInfo). Ainsi dans la pile d'appel, dès que FQDN est trouvé, log4j sait qu'il ne
     * s'agit plus pas de l'appelant, mais d'une classe du framework ! */
    static String FQCN = XDASLogger.class.getName();
    
    /**
     * Wrapped class
     */
    private Logger logger = null;
    
    
    public XDASLogger(String name){
        logger = Logger.getLogger(name);
    }
    
    public XDASLogger(Class clazz){
        logger = Logger.getLogger(clazz);
    }
    
    public void log(XDASEvent event){
        logger.log(Level.INFO, event);
    }
    
    public void log(Level level, XDASEvent event){
        logger.log(level, event);
    }
  
}
