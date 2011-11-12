/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2006-2011 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2011 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

package com.zanclus.opennms.data.entities;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>OnmsIpInterface class.</p>
 */

public class OnmsIpInterface extends OnmsEntity implements Serializable {

    public static class PrimaryType implements Comparable<PrimaryType>, Serializable {
        private static final long serialVersionUID = -647348487361201657L;
        private static final char[] s_order = { 'N', 'S', 'P' };
        private char m_collType;

        private PrimaryType() {
            this('N');
        }

        private PrimaryType(char collType) {
            m_collType = collType;
        }

        public char getCharCode() {
            return m_collType;
        }

        public void setCharCode(char collType) {
            m_collType = collType;
        }

        /**
         * Hibernate objects should not have any specific hashCode() implementation
         * since it should always give the same object for the same row anyways.
         */

        public int hashCode() {
        	return super.hashCode();
        }

        public boolean equals(Object o) {
            if (o instanceof PrimaryType) {
                return this.compareTo((PrimaryType)o) == 0;
            } else return false;
        }

        public int compareTo(PrimaryType collType) {
            return getIndex(m_collType) - getIndex(collType.m_collType);
        }

        private static int getIndex(char code) {
            for (int i = 0; i < s_order.length; i++) {
                if (s_order[i] == code) {
                    return i;
                }
            }
            throw new IllegalArgumentException("illegal collType code '"+code+"'");
        }

        public String toString() {
            return String.valueOf(m_collType);
        }

        public boolean isLessThan(PrimaryType collType) {
            return compareTo(collType) < 0;
        }

        public boolean isGreaterThan(PrimaryType collType) {
            return compareTo(collType) > 0;
        }

        public PrimaryType max(PrimaryType collType) {
            return this.isLessThan(collType) ? collType : this;
        }

        public PrimaryType min(PrimaryType collType) {
            return this.isLessThan(collType) ? this : collType;
        }

        public static PrimaryType get(char code) {
            switch (code) {
            case 'P': return PRIMARY;
            case 'S': return SECONDARY;
            case 'N': return NOT_ELIGIBLE;
            default:
                throw new IllegalArgumentException("Cannot create collType from code "+code);
            }
        }

        public static PrimaryType get(String code) {
            if (code == null) {
                return NOT_ELIGIBLE;
            }
            code = code.trim();
            if (code.length() < 1) {
                return NOT_ELIGIBLE;
            } else if (code.length() > 1) {
                throw new IllegalArgumentException("Cannot convert string "+code+" to a collType");
            } else {
                return get(code.charAt(0));
            }
        }

        public static final PrimaryType PRIMARY = new PrimaryType('P');
        public static final PrimaryType SECONDARY = new PrimaryType('S');
        public static final PrimaryType NOT_ELIGIBLE = new PrimaryType('N');
    }

    private static final long serialVersionUID = 7750043250236397014L;

    private Integer m_id;

    private InetAddress m_ipAddress;

    private String m_ipHostName;

    private String m_isManaged;

    private PrimaryType m_isSnmpPrimary = PrimaryType.NOT_ELIGIBLE;

    private Date m_ipLastCapsdPoll;

    private OnmsNode m_node;

    private Set<OnmsMonitoredService> m_monitoredServices = new HashSet<OnmsMonitoredService>();

    private OnmsSnmpInterface m_snmpInterface;

    /**
     * <p>Constructor for OnmsIpInterface.</p>
     */
    public OnmsIpInterface() {
    }

    /**
     * minimal constructor
     *
     * @param ipAddr a {@link java.lang.String} object.
     * @param node a {@link org.opennms.netmgt.model.OnmsNode} object.
     */
    public OnmsIpInterface(InetAddress ipAddr, OnmsNode node) {
        m_ipAddress = ipAddr;
        m_node = node;
        if (node != null) {
            node.getIpInterfaces().add(this);
        }
    }

    /**
     * Unique identifier for ipInterface.
     *
     * @return a {@link java.lang.Integer} object.
     */

    public Integer getId() {
        return m_id;
    }
    
    /**
     * <p>getInterfaceId</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getInterfaceId() {
        return getId().toString();
    }

    /**
     * <p>setId</p>
     *
     * @param id a {@link java.lang.Integer} object.
     */
    public void setId(Integer id) {
        m_id = id;
    }

    //@Column(name="ifIndex")
    /**
     * <p>getIfIndex</p>
     *
     * @return a {@link java.lang.Integer} object.
     */

    public Integer getIfIndex() {
        if (m_snmpInterface == null) {
            return null;
        }
        return m_snmpInterface.getIfIndex();
        //return m_ifIndex;
    }

    /**
     * <p>setIfIndex</p>
     *
     * @param ifindex a {@link java.lang.Integer} object.
     */
    public void setIfIndex(Integer ifindex) {
        if (m_snmpInterface == null) {
            throw new IllegalStateException("Cannot set ifIndex if snmpInterface relation isn't setup");
        }
        m_snmpInterface.setIfIndex(ifindex);
        //m_ifIndex = ifindex;
    }

    /**
     * <p>getIpHostName</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getIpHostName() {
        return m_ipHostName;
    }

    /**
     * <p>setIpHostName</p>
     *
     * @param iphostname a {@link java.lang.String} object.
     */
    public void setIpHostName(String iphostname) {
        m_ipHostName = iphostname;
    }

    /**
     * <p>getIsManaged</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getIsManaged() {
        return m_isManaged;
    }

    /**
     * <p>setIsManaged</p>
     *
     * @param ismanaged a {@link java.lang.String} object.
     */
    public void setIsManaged(String ismanaged) {
        m_isManaged = ismanaged;
    }

    /**
     * <p>isManaged</p>
     *
     * @return a boolean.
     */

    public boolean isManaged() {
        return "M".equals(getIsManaged());
    }

    /**
     * <p>getIpLastCapsdPoll</p>
     *
     * @return a {@link java.util.Date} object.
     */

    public Date getIpLastCapsdPoll() {
        return m_ipLastCapsdPoll;
    }

    /**
     * <p>setIpLastCapsdPoll</p>
     *
     * @param iplastcapsdpoll a {@link java.util.Date} object.
     */
    public void setIpLastCapsdPoll(Date iplastcapsdpoll) {
        m_ipLastCapsdPoll = iplastcapsdpoll;
    }

    /**
     * <p>getPrimaryString</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getPrimaryString() {
        return m_isSnmpPrimary == null? null : m_isSnmpPrimary.toString();
    }
    /**
     * <p>setPrimaryString</p>
     *
     * @param primaryType a {@link java.lang.String} object.
     */
    public void setPrimaryString(String primaryType) {
        m_isSnmpPrimary = new PrimaryType(primaryType.charAt(0));
    }
    
    /**
     * <p>getIsSnmpPrimary</p>
     *
     * @return a {@link org.opennms.netmgt.model.OnmsIpInterface.PrimaryType} object.
     */

    public PrimaryType getIsSnmpPrimary() {
        return m_isSnmpPrimary;
    }

    /**
     * <p>setIsSnmpPrimary</p>
     *
     * @param issnmpprimary a {@link org.opennms.netmgt.model.OnmsIpInterface.PrimaryType} object.
     */
    public void setIsSnmpPrimary(PrimaryType issnmpprimary) {
        m_isSnmpPrimary = issnmpprimary;
    }
    
    /**
     * <p>isPrimary</p>
     *
     * @return a boolean.
     */

    public boolean isPrimary(){
        return m_isSnmpPrimary.equals(PrimaryType.PRIMARY);
    }

    /**
     * <p>getNode</p>
     *
     * @return a {@link org.opennms.netmgt.model.OnmsNode} object.
     */

    public OnmsNode getNode() {
        return m_node;
    }

    /**
     * <p>setNode</p>
     *
     * @param node a {@link org.opennms.netmgt.model.OnmsNode} object.
     */
    public void setNode(com.zanclus.opennms.data.entities.OnmsNode node) {
        m_node = node;
    }

    /**
     * The services on this node
     *
     * @return a {@link java.util.Set} object.
     */
    public Set<OnmsMonitoredService> getMonitoredServices() {
        return m_monitoredServices ;
    }

    /**
     * <p>setMonitoredServices</p>
     *
     * @param ifServices a {@link java.util.Set} object.
     */
    public void setMonitoredServices(Set<OnmsMonitoredService> ifServices) {
        m_monitoredServices = ifServices;
    }


    /**
     * The SnmpInterface associated with this interface if any
     *
     * @return a {@link org.opennms.netmgt.model.OnmsSnmpInterface} object.
     */

    public OnmsSnmpInterface getSnmpInterface() {
        return m_snmpInterface;
    }


    /**
     * <p>setSnmpInterface</p>
     *
     * @param snmpInterface a {@link org.opennms.netmgt.model.OnmsSnmpInterface} object.
     */
    public void setSnmpInterface(OnmsSnmpInterface snmpInterface) {
        m_snmpInterface = snmpInterface;
    }

    /** {@inheritDoc} */
    public void visit(EntityVisitor visitor) {
        visitor.visitIpInterface(this);

        for (OnmsMonitoredService monSvc : getMonitoredServices()) {
            monSvc.visit(visitor);
        }

        visitor.visitIpInterfaceComplete(this);
    }

    /**
     * <p>getInetAddress</p>
     *
     * @return a {@link java.net.InetAddress} object.
     */

    public InetAddress getIpAddress() {
        return m_ipAddress;
    }

    /**
     * <p>setInetAddress</p>
     *
     * @param ipaddr a {@link java.lang.String} object.
     */
    public void setIpAddress(InetAddress ipaddr) {
        m_ipAddress = ipaddr;
    }

    /**
     * <p>isDown</p>
     *
     * @return a boolean.
     */

    public boolean isDown() {
        boolean down = true;
        for (OnmsMonitoredService svc : m_monitoredServices) {
            if (!svc.isDown()) {
                return !down;
            }
        }
        return down;
    }

    public int getMonitoredServiceCount () {
    	return m_monitoredServices.size();
    }
    
    /**
     * <p>getMonitoredServiceByServiceType</p>
     *
     * @param svcName a {@link java.lang.String} object.
     * @return a {@link org.opennms.netmgt.model.OnmsMonitoredService} object.
     */
    public OnmsMonitoredService getMonitoredServiceByServiceType(String svcName) {
        for (OnmsMonitoredService monSvc : getMonitoredServices()) {
            if (monSvc.getServiceType().getName().equals(svcName)) {
                return monSvc;
            }
        }
        return null;
    }

    /**
     * <p>mergeInterfaceAttributes</p>
     *
     * @param scannedIface a {@link org.opennms.netmgt.model.OnmsIpInterface} object.
     */
    public void mergeInterfaceAttributes(OnmsIpInterface scannedIface) {
        
        if (hasNewValue(scannedIface.getIsManaged(), getIsManaged())) {
            setIsManaged(scannedIface.getIsManaged());
        }
    
        if (hasNewCollectionTypeValue(scannedIface.getIsSnmpPrimary(), getIsSnmpPrimary())) {
            setIsSnmpPrimary(scannedIface.getIsSnmpPrimary());
        }
    
        if (hasNewValue(scannedIface.getIpHostName(), getIpHostName())) {
            setIpHostName(scannedIface.getIpHostName());
        }
        
        if (hasNewValue(scannedIface.getIpLastCapsdPoll(), getIpLastCapsdPoll())) {
            setIpLastCapsdPoll(scannedIface.getIpLastCapsdPoll());
        }
        
    }
    
    /**
     * <p>hasNewCollectionTypeValue</p>
     *
     * @param newVal a {@link org.opennms.netmgt.model.OnmsIpInterface.PrimaryType} object.
     * @param existingVal a {@link org.opennms.netmgt.model.OnmsIpInterface.PrimaryType} object.
     * @return a boolean.
     */
    protected static boolean hasNewCollectionTypeValue(PrimaryType newVal, PrimaryType existingVal) {
        return newVal != null && !newVal.equals(existingVal) && newVal != PrimaryType.NOT_ELIGIBLE;
    }

    /**
     * <p>updateSnmpInterface</p>
     *
     * @param scannedIface a {@link org.opennms.netmgt.model.OnmsIpInterface} object.
     */
    public void updateSnmpInterface(OnmsIpInterface scannedIface) {
        
        if (!hasNewValue(scannedIface.getIfIndex(), getIfIndex())) {
            /* no ifIndex in currently scanned interface so don't bother
             * we must have failed to collect data
             */ 
            return;
        }
        
        if (scannedIface.getSnmpInterface() == null) {
            // there is no longer an snmpInterface associated with the ipInterface
            setSnmpInterface(null);
        } else {
            // locate the snmpInterface on this node that has the new ifIndex and set it
            // into the interface
            OnmsSnmpInterface snmpIface = getNode().getSnmpInterfaceWithIfIndex(scannedIface.getIfIndex());
            setSnmpInterface(snmpIface);
        }
    }

}
