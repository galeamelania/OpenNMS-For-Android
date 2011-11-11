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

package org.opennms.netmgt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Transient;

/**
 * <p>OnmsSnmpInterface class.</p>
 */
@Root(name = "snmpInterface")
public class OnmsSnmpInterface extends OnmsEntity implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5396189389666285305L;

    private Integer m_id;

    /** identifier field */
    private String m_netMask;

    /** identifier field */
    private String m_physAddr;

    /** identifier field */
    private Integer m_ifIndex;

    /** identifier field */
    private String m_ifDescr;

    /** identifier field */
    private Integer m_ifType;

    /** identifier field */
    private String m_ifName;

    /** identifier field */
    private Long m_ifSpeed;

    /** identifier field */
    private Integer m_ifAdminStatus;

    /** identifier field */
    private Integer m_ifOperStatus;

    /** identifier field */
    private String m_ifAlias;
    
    private Date m_lastCapsdPoll;

    private String m_collect = "N";
    
    private String m_poll = "N";

    private Date m_lastSnmpPoll;

    private OnmsNode m_node;

    private Set<OnmsIpInterface> m_ipInterfaces = new HashSet<OnmsIpInterface>();

    /**
     * <p>Constructor for OnmsSnmpInterface.</p>
     * @param node a {@link org.opennms.netmgt.model.OnmsNode} object.
     * @param ifIndex a int.
     */
    public OnmsSnmpInterface(OnmsNode node, int ifIndex) {
        this(node, new Integer(ifIndex));
    }

    /**
     * <p>Constructor for OnmsSnmpInterface.</p>
     * @param node a {@link org.opennms.netmgt.model.OnmsNode} object.
     * @param ifIndex a {@link java.lang.Integer} object.
     */
    public OnmsSnmpInterface(OnmsNode node, Integer ifIndex) {
        m_ifIndex = ifIndex;
        m_node = node;
        if (node != null) {
            node.getSnmpInterfaces().add(this);
        }
    }

    /**
     * default constructor
     */
    public OnmsSnmpInterface() {
    }

    /**
     * Unique identifier for snmpInterface.
     *
     * @return a {@link java.lang.Integer} object.
     */
    @Attribute(name="id")
    public Integer getId() {
        return m_id;
    }

    /**
     * <p>setId</p>
     *
     * @param id a {@link java.lang.Integer} object.
     */
    public void setId(Integer id) {
        m_id = id;
    }

    /**
     * <p>getNetMask</p>
     * 
     * @return a {@link java.lang.String} object.
     */
    public String getNetMask() {
        return m_netMask;
    }

    /**
     * <p>setNetMask</p>
     * 
     * @param snmpipadentnetmask a {@link java.lang.String} object.
     */
    public void setNetMask(String snmpipadentnetmask) {
        m_netMask = snmpipadentnetmask;
    }
    
    /**
     * <p>getPhysAddr</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPhysAddr() {
        return m_physAddr;
    }

    /**
     * <p>setPhysAddr</p>
     *
     * @param snmpphysaddr a {@link java.lang.String} object.
     */
    public void setPhysAddr(String snmpphysaddr) {
        m_physAddr = snmpphysaddr;
    }

    /**
     * <p>getIfIndex</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    @Attribute(name="ifIndex")
    public Integer getIfIndex() {
        return m_ifIndex;
    }

    /**
     * <p>setIfIndex</p>
     *
     * @param snmpifindex a {@link java.lang.Integer} object.
     */
    public void setIfIndex(Integer snmpifindex) {
        m_ifIndex = snmpifindex;
    }

    /**
     * <p>getIfDescr</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getIfDescr() {
        return m_ifDescr;
    }

    /**
     * <p>setIfDescr</p>
     *
     * @param snmpifdescr a {@link java.lang.String} object.
     */
    public void setIfDescr(String snmpifdescr) {
        m_ifDescr = snmpifdescr;
    }

    /**
     * <p>getIfType</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getIfType() {
        return m_ifType;
    }

    /**
     * <p>setIfType</p>
     *
     * @param snmpiftype a {@link java.lang.Integer} object.
     */
    public void setIfType(Integer snmpiftype) {
        m_ifType = snmpiftype;
    }

    /**
     * <p>getIfName</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getIfName() {
        return m_ifName;
    }

    /**
     * <p>setIfName</p>
     *
     * @param snmpifname a {@link java.lang.String} object.
     */
    public void setIfName(String snmpifname) {
        m_ifName = snmpifname;
    }

    /**
     * <p>getIfSpeed</p>
     *
     * @return a {@link java.lang.Long} object.
     */
    public Long getIfSpeed() {
        return m_ifSpeed;
    }

    /**
     * <p>setIfSpeed</p>
     *
     * @param snmpifspeed a {@link java.lang.Long} object.
     */
    public void setIfSpeed(Long snmpifspeed) {
        m_ifSpeed = snmpifspeed;
    }

    /**
     * <p>getIfAdminStatus</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getIfAdminStatus() {
        return m_ifAdminStatus;
    }

    /**
     * <p>setIfAdminStatus</p>
     *
     * @param snmpifadminstatus a {@link java.lang.Integer} object.
     */
    public void setIfAdminStatus(Integer snmpifadminstatus) {
        m_ifAdminStatus = snmpifadminstatus;
    }

    /**
     * <p>getIfOperStatus</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getIfOperStatus() {
        return m_ifOperStatus;
    }

    /**
     * <p>setIfOperStatus</p>
     *
     * @param snmpifoperstatus a {@link java.lang.Integer} object.
     */
    public void setIfOperStatus(Integer snmpifoperstatus) {
        m_ifOperStatus = snmpifoperstatus;
    }

    /**
     * <p>getIfAlias</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getIfAlias() {
        return m_ifAlias;
    }

    /**
     * <p>setIfAlias</p>
     *
     * @param snmpifalias a {@link java.lang.String} object.
     */
    public void setIfAlias(String snmpifalias) {
        m_ifAlias = snmpifalias;
    }
    
    /**
     * <p>getLastCapsdPoll</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getLastCapsdPoll() {
        return m_lastCapsdPoll;
    }
    
    /**
     * <p>setLastCapsdPoll</p>
     *
     * @param lastCapsdPoll a {@link java.util.Date} object.
     */
    public void setLastCapsdPoll(Date lastCapsdPoll) {
        m_lastCapsdPoll = lastCapsdPoll;
    }
    
    /**
     * <p>getCollect</p>
     *
     * @return a {@link java.lang.String} object.
     */
    @Attribute(name="collectFlag")
    public String getCollect() {
        return m_collect;
    }
    
    /**
     * <p>setCollect</p>
     *
     * @param collect a {@link java.lang.String} object.
     */
    public void setCollect(String collect) {
        m_collect = collect;
    }

    /**
     * <p>getPoll</p>
     *
     * @return a {@link java.lang.String} object.
     */
    @Attribute(name="pollFlag")
    public String getPoll() {
        return m_poll;
    }
    
    /**
     * <p>setPoll</p>
     *
     * @param poll a {@link java.lang.String} object.
     */
    public void setPoll(String poll) {
        m_poll = poll;
    }

    /**
     * <p>getLastSnmpPoll</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getLastSnmpPoll() {
        return m_lastSnmpPoll;
    }
    
    /**
     * <p>setLastSnmpPoll</p>
     *
     * @param lastSnmpPoll a {@link java.util.Date} object.
     */
    public void setLastSnmpPoll(Date lastSnmpPoll) {
        m_lastSnmpPoll = lastSnmpPoll;
    }

    /**
     * <p>isCollectionUserSpecified</p>
     *
     * @return a boolean.
     */
    public boolean isCollectionUserSpecified(){
        return m_collect.startsWith("U");
    }
    
    /**
     * <p>isCollectionEnabled</p>
     *
     * @return a boolean.
     */
    @Attribute(name="collect")
    public boolean isCollectionEnabled() {
        return "C".equals(m_collect) || "UC".equals(m_collect);
    }
    
    /**
     * <p>setCollectionEnabled</p>
     *
     * @param shouldCollect a boolean.
     */
    public void setCollectionEnabled(boolean shouldCollect) {
        setCollectionEnabled(shouldCollect, false);
    }
    
    /**
     * <p>setCollectionEnabled</p>
     *
     * @param shouldCollect a boolean.
     * @param userSpecified a boolean.
     */
    public void setCollectionEnabled(boolean shouldCollect, boolean userSpecified){
       if(userSpecified){
           m_collect = shouldCollect ? "UC":"UN";
       }else if(!m_collect.startsWith("U")){
           m_collect = shouldCollect ? "C" : "N";
       }
    }

    /**
     * <p>isPollEnabled</p>
     *
     * @return a boolean.
     */
    @Attribute(name="poll")
    public boolean isPollEnabled() {
        return "P".equals(m_poll);
    }

    /**
     * <p>getNode</p>
     *
     * @return a {@link org.opennms.netmgt.model.OnmsNode} object.
     */
    @Element(name="nodeId")
    public OnmsNode getNode() {
        return m_node;
    }

    /**
     * <p>setNode</p>
     *
     * @param node a {@link org.opennms.netmgt.model.OnmsNode} object.
     */
    public void setNode(OnmsNode node) {
        m_node = node;
    }

    /**
     * <p>getIpInterfaces</p>
     *
     * @return a {@link java.util.Set} object.
     */
    public Set<OnmsIpInterface> getIpInterfaces() {
        return m_ipInterfaces;
    }

    /**
     * <p>setIpInterfaces</p>
     *
     * @param ipInterfaces a {@link java.util.Set} object.
     */
    public void setIpInterfaces(Set<OnmsIpInterface> ipInterfaces) {
        m_ipInterfaces = ipInterfaces;
    }

    // @Transient
    // public Set getIpInterfaces() {
    //		
    // Set ifsForSnmpIface = new LinkedHashSet();
    // for (Iterator it = getNode().getIpInterfaces().iterator();
    // it.hasNext();) {
    // OnmsIpInterface iface = (OnmsIpInterface) it.next();
    // if (getIfIndex().equals(iface.getIfIndex()))
    // ifsForSnmpIface.add(iface);
    // }
    // return ifsForSnmpIface;
    // }

    /**
     * <p>getPrimaryIpInterface</p>
     *
     * @return an {@link OnmsIpInterface} object.
     */
    @Transient
    public OnmsIpInterface getPrimaryIpInterface() {
        return getNode().getPrimaryInterface();
    }

    /**
     * <p>addIpInterface</p>
     *
     * @param iface a {@link org.opennms.netmgt.model.OnmsIpInterface} object.
     */
    public void addIpInterface(OnmsIpInterface iface) {
        m_ipInterfaces.add(iface);
    }
}
