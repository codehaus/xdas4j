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
 *  File     : XDASKeyValueLayout.java
 *
 */
package org.codehaus.xdas4j.logger;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.Layout;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;
import org.codehaus.xdas4j.datamodel.XDASEvent;

/**
 * XDAS Key-Value Layout which allows to print XDAS message into a key-value format.
 *
 * Example: Initiator.account=admin|Observer.host=myhost|
 *
 * @author Gregory Sydler (gsydler at gmail dot com)
 */
public class XDASKeyValueLayout extends Layout {

    private final static int DEFAULT_SIZE = 256;
    public final static String DEFAULT_KEYVALUE_SEPARATOR = "=";
    private final static String DEFAULT_KEY_SEPARATOR = ".";
    private final static String DEFAULT_PAIRS_SEPARATOR = ";";

    private StringBuffer sBuffer = new StringBuffer(DEFAULT_SIZE);

    private String pairsSeparator = DEFAULT_PAIRS_SEPARATOR;
    private String logHeader = null;

    public XDASKeyValueLayout() {
    }

    /**
     * Retrieve the current pairs(key-value) separator
     * @return The separator
     */
    public String getSeparator() {
        return pairsSeparator;
    }

    /**
     * Set the pairs(key-value) separator.
     * @param separator The pairs separator
     */
    public void setSeparator(final String separator) {
        this.pairsSeparator = separator;
    }

    /**
     * Set the log header (the log header is before the log)
     * @param logHeader to set
     */
    public void setLogHeader(String logHeader) {
        this.logHeader = logHeader;
    }

    /**
     * Retrieve the log header (or null if no log header)
     * @return The log header
     */
    public String getLogHeader() {
        return logHeader;
    }

    /**
     * Method used to format the logging event.
     * @param event The logging event to format
     * @return a formated string
     */
    @Override
    public String format(LoggingEvent event) {
        XDASEvent evt = (XDASEvent) event.getMessage();

        // Clear the string buffer
        sBuffer.setLength(0);

        // If a Log header is set, append it
        if(logHeader != null) {
            sBuffer.append(logHeader);
        }

        // Append the key value list
        keyValueFormat(null, evt);

        // Remove the last separator
        if (sBuffer.length() > pairsSeparator.length()) {
            sBuffer.delete(sBuffer.length() - pairsSeparator.length(), sBuffer.length());
        }

        return sBuffer.toString();
    }

    /**
     * Method used to build a key-value string.
     * @param parentKey The parent key used to build the full key
     * @param key The last element key
     * @param value The value
     */
    private void buildKeyValue(String parentKey, String key, String value) {
        // If a parent key exist, build the full key
        if (parentKey != null) {
            sBuffer.append(parentKey);
            sBuffer.append(DEFAULT_KEY_SEPARATOR);
        }
        sBuffer.append(key);
        sBuffer.append(DEFAULT_KEYVALUE_SEPARATOR);
        sBuffer.append(value);
        sBuffer.append(pairsSeparator);
        // default example : parent.key=value|
    }

    private void keyValueFormat(String parentKey, Object o) {
        Method eventMethods[] = o.getClass().getMethods();
        // Check all data model attributes (getters)
        for (Method m : eventMethods) {
            // Avoid data extraction (for printing purpose) of getInstance and getClass methods
            if (m.getName().startsWith("get") && !m.getName().contains("Instance") && !m.getName().contains("Class")) {
                Object attributeData = null;
                try {
                    attributeData = m.invoke(o);
                } catch (Throwable e) {
                    LogLog.error("Unable to extract XDAS " + m.getName() + "attribute from " + o.getClass(), e);
                }
                if (attributeData != null) {
                    // If we do not work on an xdas4j attribute object (which should be further analyzed), process this simple data structure (xdas4j enum included, related to issue XDASJ-5)
                    if (!attributeData.getClass().getName().startsWith("org.codehaus.xdas4j.datamodel") || attributeData instanceof Enum) {
                        // Do we have a collection of something ?
                        if (attributeData instanceof Collection) {
                            Collection<?> attributeCollection = (Collection<?>) attributeData;
                            // Build collection String representation
                            for (Object collectionItem : attributeCollection) {
                                keyValueFormat((parentKey == null ? "" : (parentKey + DEFAULT_KEY_SEPARATOR)) + collectionItem.getClass().getSimpleName(), collectionItem);
                            }
                        } // We work on an unstructured Java data (String, Integer, etc.)
                        else {
                            buildKeyValue(parentKey, m.getName().substring(3), attributeData.toString());
                        }
                    } // We work on an xdas4j attribute. It should be further processed
                    else {
                        keyValueFormat((parentKey == null ? "" : (parentKey + DEFAULT_KEY_SEPARATOR)) + attributeData.getClass().getSimpleName(), attributeData);
                    }
                }
            }
        }
    }

    /**
     * The XDASKeyValueLayout does not handle the throwable contained within
     * {@link LoggingEvent LoggingEvents}. It returns <code>true</code>.
     * 
     * @return always true
     */
    @Override
    public boolean ignoresThrowable() {
        return true;
    }

    /**
     * No options to activate.
     */
    @Override
    public void activateOptions() {
    }
}
