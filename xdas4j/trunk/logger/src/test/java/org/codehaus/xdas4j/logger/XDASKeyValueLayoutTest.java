/*
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
 *  Author   : Gregory Sydler
 *  Date     : Oct 11, 2010
 *
 *  Project  : xdas4j
 *  Package  : org.codehaus.xdas4j.logger
 *  File     : XDASKeyValueLayoutTest.java
 *
 */
package org.codehaus.xdas4j.logger;

import org.codehaus.xdas4j.datamodel.Target;
import org.codehaus.xdas4j.datamodel.Account;
import org.codehaus.xdas4j.datamodel.Host;
import org.codehaus.xdas4j.datamodel.Initiator;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.codehaus.xdas4j.datamodel.ActionTax;
import org.codehaus.xdas4j.datamodel.Action;
import org.codehaus.xdas4j.datamodel.XDASEvent;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Log4j Layout testing.
 *
 * @author Gregory Sydler (gsydler at gmail dot com)
 */
public class XDASKeyValueLayoutTest {

    // Object to be tested
    private XDASKeyValueLayout xdasLayout = null;

    @Before
    public void setUp() {
        xdasLayout = new XDASKeyValueLayout();
    }

    /**
     * Test of format method, of class XDASKeyValueLayout.
     */
    @Test
    public void testValidEvent() {
        System.out.println("testValidEvent");

        // Key-Values mapping result
        Map<String, String> keyValueMap = new HashMap<String, String>();
        keyValueMap.put("Version", "http://www.opengroup.com/xdas/2008");
        keyValueMap.put("Initiator.Account.Name", "Initiator.Account.Name");
        keyValueMap.put("Initiator.Account.Domain", "Initiator.Account.Domain");
        keyValueMap.put("Initiator.Host.Name", "Initiator.Host.Name");
        keyValueMap.put("Target.Host.Name", "Target.Host.Name");

        // Build a dummy LoggingEvent in order to test an enum serialization
        XDASEvent event = XDASEvent.getInstance()
                .addInitiator(Initiator.getInstance()
                    .setAccount(Account.getInstance()
                        .setName("Initiator.Account.Name")
                        .setDomain("Initiator.Account.Domain"))
                    .setHost(Host.getInstance()
                        .setName("Initiator.Host.Name")))
                .addInitiator(Initiator.getInstance()
                    .setAccount(Account.getInstance()
                        .setName("Initiator.Account.Name")
                        .setDomain("Initiator.Account.Domain"))
                    .setHost(Host.getInstance()
                        .setName("Initiator.Host.Name")))
                .addTarget(Target.getInstance()
                    .setHost(Host.getInstance()
                        .setName("Target.Host.Name")));
        LoggingEvent log = new LoggingEvent(XDASLogger.class.getName(), Logger.getLogger(XDASKeyValueLayoutTest.class), Level.INFO, event, null);

        // Run xdas layout formatting
        String keyValuesResult = xdasLayout.format(log);

        // Test the KeyValue output regarding our needs
        StringTokenizer sTokenizer = new StringTokenizer(keyValuesResult, xdasLayout.getSeparator());
        assertEquals("Invalid items count", 8, sTokenizer.countTokens());
        while (sTokenizer.hasMoreTokens()) {
            String[] keyValue = sTokenizer.nextToken().split(XDASKeyValueLayout.DEFAULT_KEYVALUE_SEPARATOR);
            assertEquals("An item is not well rendered", keyValueMap.get(keyValue[0]), keyValue[1]);
        }
    }

    /**
     * Test case related to issue XDASJ-5
     */
    @Test
    public void testEnumSerialization() {
        System.out.println("testEnumSerialization");

        // Key-Values mapping result
        Map<String, String> keyValueMap = new HashMap<String, String>();
        keyValueMap.put("Version", "http://www.opengroup.com/xdas/2008");
        keyValueMap.put("Action.Message", "message");
        keyValueMap.put("Action.ActionTax", ActionTax.NO_DEFINED.toString());

        // Build a dummy LoggingEvent in order to test an enum serialization
        XDASEvent event = XDASEvent.getInstance().setAction(Action.getInstance().setMessage("message").setActionTax(ActionTax.NO_DEFINED));
        LoggingEvent log = new LoggingEvent(XDASLogger.class.getName(), Logger.getLogger(XDASJSONLayoutTest.class), Level.INFO, event, null);

        // Run xdas layout formatting
        String keyValuesResult = xdasLayout.format(log);

        // Test the KeyValue output regarding our needs
        StringTokenizer sTokenizer = new StringTokenizer(keyValuesResult, xdasLayout.getSeparator());
        while (sTokenizer.hasMoreTokens()) {
            String[] keyValue = sTokenizer.nextToken().split(XDASKeyValueLayout.DEFAULT_KEYVALUE_SEPARATOR);
            assertEquals("An action item is not well rendered", keyValueMap.get(keyValue[0]), keyValue[1]);
        }
    }

    /**
     * Test of ignoresThrowable method, of class XDASKeyValueLayout.
     */
    @Test
    public void testIgnoresThrowable() {
        System.out.println("ignoresThrowable");
        assertTrue("The ignoresThrowable must always return true", xdasLayout.ignoresThrowable());
    }
}
