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
 *  File     : AppenderFunctionalTest.java
 *                    
 */

package org.codehaus.xdas4j.logger;
import java.util.Date;

import org.apache.log4j.xml.DOMConfigurator;
import org.codehaus.xdas4j.datamodel.Account;
import org.codehaus.xdas4j.datamodel.Action;
import org.codehaus.xdas4j.datamodel.Initiator;
import org.codehaus.xdas4j.datamodel.XDASEvent;
import org.codehaus.xdas4j.logger.XDASLogger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * 
 * @author hatman
 *
 */
public class XDASLoggerFunctionalTest {
    
    
    private final static XDASLogger LOGGER = new XDASLogger(XDASLoggerFunctionalTest.class);
    
    @BeforeClass
    public static void setUp() throws Exception {
        
        DOMConfigurator.configure(XDASLoggerFunctionalTest.class.getResource("log4j.xml"));
    }
    

    @AfterClass
    public static void tearDown() throws Exception {

    }
    
    
    @Test
    public void simpleLoggerTest(){
        LOGGER.info(
                    XDASEvent.getInstance()
                    .setInitiator(Initiator.getInstance()
                                  .setAccount(Account.getInstance()
                                              .setName("my name")
                                              .setDomaine("domain")))
                    .setAction(Action.getInstance()
                                  .setTime(new Date()))
                   );
    }

}
