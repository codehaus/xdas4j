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
 *  Date     : June 8, 2010 
 * 
 *  Project  : xdas4j 
 *  Package  : org.codehaus.xdas4j.logger 
 *  File     : XDASJSONLayoutTest.java
 *                    
 */

package org.codehaus.xdas4j.logger;


import static org.junit.Assert.assertTrue;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.codehaus.xdas4j.datamodel.Action;
import org.codehaus.xdas4j.datamodel.ActionTax;
import org.codehaus.xdas4j.datamodel.XDASEvent;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Log4j Layout testing. For that purpose, JSON output is created using log4j Layout and
 * it is then loaded back to Java using Gson (a JSON parser).
 * 
 * @author J.Winteregg
 *
 */
public class XDASJSONLayoutTest {
	
	/* Object to be tested */
	private XDASJSONLayout xdasLayout = null;
	
	/* JSON reader */
	private static Gson reader = null;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE);
		reader = gsonBuilder.create();
	}
	
	
	@Before
	public void setUp() throws Exception {
		xdasLayout = new XDASJSONLayout();
	}


	/**
	 * Test case related to issue XDASJ-5
	 */
	@Test
	public void testEnumSerialization() {
		/* Build a dummy LoggingEvent in order to test an enum serialization */
		XDASEvent event = XDASEvent.getInstance().setAction(Action.getInstance().setMessage("message").setActionTax(ActionTax.NO_DEFINED));
		LoggingEvent log = new LoggingEvent(XDASLogger.class.getName(), Logger.getLogger(XDASJSONLayoutTest.class), Level.INFO, event, null);
		
		/* Run xdas layout formatting */
		String jsonResult = xdasLayout.format(log);
		
		/* Read the JSON output */
		XDASEvent eventFromJson = reader.fromJson(jsonResult, XDASEvent.class );
		
		/* Test the JSON output regarding our needs */
		assertTrue("The provided action message is not well rendered", eventFromJson.getAction().getMessage().equals("message"));
		assertTrue("The tested enum is not well rendered", eventFromJson.getAction().getActionTax().equals(ActionTax.NO_DEFINED));
	}

}
