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
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.codehaus.xdas4j.datamodel.Account;
import org.codehaus.xdas4j.datamodel.Action;
import org.codehaus.xdas4j.datamodel.Host;
import org.codehaus.xdas4j.datamodel.Initiator;
import org.codehaus.xdas4j.datamodel.Target;
import org.codehaus.xdas4j.datamodel.XDASEvent;
import org.junit.Test;


/**
 * Functional testing of xdas4j.
 * 
 * @author Gregory Sydler (gsydler at gmail dot com)
 *
 */
public class XDASLoggerFunctionalTest {
        
    private final static XDASLogger auditLogger = new XDASLogger(XDASLoggerFunctionalTest.class);
    
    @Test
    public void testJSONLayout(){
        DOMConfigurator.configure(XDASLoggerFunctionalTest.class.getResource("xdas4j-JSONLayout.xml"));
        auditLogger.log(
                    XDASEvent.getInstance()
                    .addInitiator(Initiator.getInstance()
                                  .setAccount(Account.getInstance()
                                              .setName("my name")
                                              .setDomain("domain"))
                                  .setHost(Host.getInstance()
                                              .setName("hostname")))
                     .addInitiator(Initiator.getInstance()
                                  .setAccount(Account.getInstance()
                                              .setName("my name2")
                                              .setDomain("domai2n"))
                                  .setHost(Host.getInstance()
                                              .setName("hostname2")))
                                              
                    .setAction(Action.getInstance()
                                  .setTime(new Date()))
                                  
                    .addTarget(Target.getInstance()
                                  .setHost(Host.getInstance()
                                               .setName("Target host name")))
                   );
    }

    @Test
    public void testKeyValueLayout(){
        DOMConfigurator.configure(XDASLoggerFunctionalTest.class.getResource("xdas4j-KeyValueLayout.xml"));
        auditLogger.log(
                    XDASEvent.getInstance()
                    .addInitiator(Initiator.getInstance()
                                  .setAccount(Account.getInstance()
                                              .setName("my name")
                                              .setDomain("domain"))
                                  .setHost(Host.getInstance()
                                              .setName("hostname")))
                     .addInitiator(Initiator.getInstance()
                                  .setAccount(Account.getInstance()
                                              .setName("my name2")
                                              .setDomain("domai2n"))
                                  .setHost(Host.getInstance()
                                              .setName("hostname2")))

                    .setAction(Action.getInstance()
                                  .setTime(new Date()))

                    .addTarget(Target.getInstance()
                                  .setHost(Host.getInstance()
                                               .setName("Target host name")))
                   );
    }
    
    /**
     * Test related to issue XDASJ-8
     * http://jira.codehaus.org/browse/XDASJ-8
     */
    @Test
    public void testMultiLogger() throws Exception {
    	DOMConfigurator.configure(XDASLoggerFunctionalTest.class.getResource("xdas4j-two-loggers.xml"));
    	
    	/* First logger usage */
    	final XDASLogger firstLogger = new XDASLogger("logger_1");
    	firstLogger.log(XDASEvent.getInstance().addInitiator(Initiator.getInstance().setAccount(Account.getInstance().setName("TOTO"))));
    	
    	/* Second logger usage */
    	final XDASLogger secondLogger = new XDASLogger("logger_2");
    	secondLogger.log(XDASEvent.getInstance().addInitiator(Initiator.getInstance().setAccount(Account.getInstance().setName("TATA"))));
    	
    	/* First logger usage */
    	firstLogger.log(XDASEvent.getInstance().addInitiator(Initiator.getInstance().setAccount(Account.getInstance().setName("HERE it is"))));
    	
    	/* Check if the three logger usage went into the right file */
    	File firstFile = new File("test1.log");
    	firstFile.deleteOnExit();
    	File secondFile = new File("test2.log");
    	secondFile.deleteOnExit();
    	List lines = FileUtils.readLines(firstFile, "UTF-8");
    	assertTrue("First logger should log 2 entry and not "+lines.size(), lines.size() == 2);
    	
    	lines = FileUtils.readLines(secondFile, "UTF-8");
    	assertTrue("Second logger should only log 1 entry and not "+lines.size(), lines.size() == 1);
    }
}
