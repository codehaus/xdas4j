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
 *  Date     : Jul 11, 2009 
 * 
 *  Project  : xdas4j 
 *  Package  : org.codehaus.xdas4j.datamodel 
 *  File     : Address.java
 *                    
 */

package org.codehaus.xdas4j.datamodel;

/**
 * Describes the network settings for a particular host.
 * 
 * @author J.Winteregg
 *
 */
public class Address {
    
    /**
     * The DNSName specifies the DNS-assigned hostname and fully qualified domain for the host to
     * which this Address object is attached.
     */
    private String dnsName = null;
    
    /**
     * The MSName specifies the Microsoft Windows host name assigned to the associated Host.
     */
    private String msName = null;
    
    /**
     * The MSDomain specifies the Microsoft Windows domain within which the associated host
     * exists.
     */
    private String msDomain = null;
    
    /**
     * The IPv4 specify the network addresses in the Internet Protocol version 4.
     */
    private String ipv4 = null;
    
    /**
     * The IPv6 specify the network addresses in the Internet Protocol version 6.
     */
    private String ipv6 = null;
    
    /**
     * The MAC field specifies the hardware Media Access Control address for the interface used by
     * the associated host.
     */
    private String mac = null;
    
    
    /**
     * Static constructor
     * 
     * @return A new instance of Address class
     */
    public static Address getInstance(){
        return new Address();
    }
    
    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Address#dnsName dnsName} attribute.
     * @return The dnsName
     */
    public String getDnsName() {
        return dnsName;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Address#dnsName dnsName} attribute.
     * @param dnsName The dnsName to be set
     * @return This Address instance (for chaining purpose)
     */
    public Address setDnsName(String dnsName) {
        this.dnsName = dnsName;
        return this;
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Address#msName msName} attribute.
     * @return The msName
     */
    public String getMsName() {
        return msName;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Address#msName msName} attribute.
     * @param msName The msName to be set
     * @return This Address instance (for chaining purpose)
     */
    public Address setMsName(String msName) {
        this.msName = msName;
        return this;
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Address#msDomain msDomain} attribute.
     * @return The msDomain
     */
    public String getMsDomain() {
        return msDomain;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Address#msDomain msDomain} attribute.
     * @param msDomain The msDomain to be set
     * @return This Address instance (for chaining purpose)
     */
    public Address setMsDomain(String msDomain) {
        this.msDomain = msDomain;
        return this;
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Address#ipv4 ipv4} attribute.
     * @return The ipv4
     */
    public String getIpv4() {
        return ipv4;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Address#ipv4 ipv4} attribute.
     * @param ipv4 The ipv4 to be set
     * @return This Address instance (for chaining purpose)
     */
    public Address setIpv4(String ipv4) {
        this.ipv4 = ipv4;
        return this;
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Address#ipv6 ipv6} attribute.
     * @return The ipv6
     */
    public String getIpv6() {
        return ipv6;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Address#ipv6 ipv6} attribute.
     * @param ipv6 The ipv6 to be set
     * @return This Address instance (for chaining purpose)
     */
    public Address setIpv6(String ipv6) {
        this.ipv6 = ipv6;
        return this;
    }

    /**
     * Get {@link org.codehaus.xdas4j.datamodel.Address#mac mac} attribute.
     * @return The mac
     */
    public String getMac() {
        return mac;
    }

    /**
     * Set {@link org.codehaus.xdas4j.datamodel.Address#mac mac} attribute.
     * @param mac The mac to be set
     * @return This Address instance (for chaining purpose)
     */
    public Address setMac(String mac) {
        this.mac = mac;
        return this;
    }

}
