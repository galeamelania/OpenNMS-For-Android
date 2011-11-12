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
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Contains information on nodes discovered and potentially managed by OpenNMS.
 * sys* properties map to SNMP MIB 2 system table information.
 *
 * @hibernate.class table="node"
 */

public class OnmsNode extends OnmsEntity implements Serializable,
        Comparable<OnmsNode> {

    private static final long serialVersionUID = -5736397583719151493L;

    /** identifier field */
    private Integer m_id;

    /** persistent field */
    private Date m_createTime = new Date();

    /** nullable persistent field */
    private OnmsNode m_parent;

    /** nullable persistent field */
    private String m_type;

    /** nullable persistent field */
    private String m_sysObjectId;

    /** nullable persistent field */
    private String m_sysName;

    /** nullable persistent field */
    private String m_sysDescription;

    /** nullable persistent field */
    private String m_sysLocation;

    /** nullable persistent field */
    private String m_sysContact;

    /** nullable persistent field */
    private String m_label;

    /** nullable persistent field */
    private String m_labelSource;

    /** nullable persistent field */
    private String m_netBiosName;

    /** nullable persistent field */
    private String m_netBiosDomain;

    /** nullable persistent field */
    private String m_operatingSystem;

    /** nullable persistent field */
    private Date m_lastCapsdPoll;
    
    private String m_foreignSource;
    
    private String m_foreignId;

    /** persistent field */
    private OnmsDistPoller m_distPoller;

    /** persistent field */
    private OnmsAssetRecord m_assetRecord;

    /** persistent field */
    private Set<OnmsIpInterface> m_ipInterfaces = new LinkedHashSet<OnmsIpInterface>();

    /** persistent field */
    private Set<OnmsSnmpInterface> m_snmpInterfaces = new LinkedHashSet<OnmsSnmpInterface>();

    /** persistent field */
    private Set<OnmsArpInterface> m_arpInterfaces = new LinkedHashSet<OnmsArpInterface>();

    /** persistent field */
    private Set<OnmsArpInterface> m_arpInterfacesBySource = new LinkedHashSet<OnmsArpInterface>();

    private Set<OnmsCategory> m_categories = new LinkedHashSet<OnmsCategory>();

	private PathElement m_pathElement;
	
    /**
     * <p>Constructor for OnmsNode.</p>
     */
    public OnmsNode() {
        this(null);
    }

    /**
     * <p>Constructor for OnmsNode.</p>
     *
     * @param distPoller a {@link com.zanclus.opennms.data.entities.OnmsDistPoller} object.
     */
    public OnmsNode(final OnmsDistPoller distPoller) {
        m_distPoller = distPoller;
        m_assetRecord = new OnmsAssetRecord();
        m_assetRecord.setNode(this);
    }

    public OnmsNode(final OnmsDistPoller distPoller, final String label) {
    	this(distPoller);
    	setLabel(label);
    }
    
    /**
     * Unique identifier for node.
     *
     * @return a {@link java.lang.Integer} object.
     */

    public Integer getId() {
        return m_id;
    }
    
    /**
     * <p>getNodeId</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getNodeId() {
    	if (getId() != null) {
    		return getId().toString();
    	}
    	return null;
    }

    /**
     * <p>setId</p>
     *
     * @param nodeid a {@link java.lang.Integer} object.
     */
    public void setId(Integer nodeid) {
        m_id = nodeid;
    }

    /**
     * <p>setNodeId</p>
     *
     * @param nodeid a {@link java.lang.String} object.
     */
    public void setNodeId(String nodeid) {
        setId(Integer.valueOf(nodeid));
    }

    /**
     * Time node was added to the database.
     *
     * @hibernate.property column="nodecreatetime" length="8" not-null="true"
     * @return a {@link java.util.Date} object.
     */

    public Date getCreateTime() {
        return m_createTime;
    }

    /**
     * <p>setCreateTime</p>
     *
     * @param nodecreatetime a {@link java.util.Date} object.
     */
    public void setCreateTime(Date nodecreatetime) {
        m_createTime = nodecreatetime;
    }

    /**
     * In the case that the node is virtual or an independent device in a chassis
     * that should be reflected as a subcomponent or "child", this field reflects
     * the nodeID of the chassis/physical node/"parent" device.
     *
     * @return a {@link com.zanclus.opennms.data.entities.OnmsNode} object.
     */

    public OnmsNode getParent() {
        return m_parent;
    }

    /**
     * <p>setParent</p>
     *
     * @param parent a {@link com.zanclus.opennms.data.entities.OnmsNode} object.
     */
    public void setParent(OnmsNode parent) {
        m_parent = parent;
    }

    /**
     * Flag indicating status of node
     * - 'A' - active
     * - 'D' - deleted
     *
     * TODO: Eventually this will be deprecated and deleted nodes will actually be deleted.
     *
     * @return a {@link java.lang.String} object.
     */

    public String getType() {
        return m_type;
    }

    /**
     * <p>setType</p>
     *
     * @param nodetype a {@link java.lang.String} object.
     */
    public void setType(String nodetype) {
        m_type = nodetype;
    }

    /**
     * SNMP MIB-2 system.sysObjectID.0
     *
     * @return a {@link java.lang.String} object.
     */

    public String getSysObjectId() {
        return m_sysObjectId;
    }

    /**
     * <p>setSysObjectId</p>
     *
     * @param nodesysoid a {@link java.lang.String} object.
     */
    public void setSysObjectId(String nodesysoid) {
        m_sysObjectId = nodesysoid;
    }

    /**
     * SNMP MIB-2 system.sysName.0
     *
     * @return a {@link java.lang.String} object.
     */

    public String getSysName() {
        return m_sysName;
    }

    /**
     * <p>setSysName</p>
     *
     * @param nodesysname a {@link java.lang.String} object.
     */
    public void setSysName(String nodesysname) {
        m_sysName = nodesysname;
    }

    /**
     * SNMP MIB-2 system.sysDescr.0
     *
     * @return a {@link java.lang.String} object.
     */

    public String getSysDescription() {
        return m_sysDescription;
    }

    /**
     * <p>setSysDescription</p>
     *
     * @param nodesysdescription a {@link java.lang.String} object.
     */
    public void setSysDescription(String nodesysdescription) {
        m_sysDescription = nodesysdescription;
    }

    /**
     * SNMP MIB-2 system.sysLocation.0
     *
     * @return a {@link java.lang.String} object.
     */

    public String getSysLocation() {
        return m_sysLocation;
    }

    /**
     * <p>setSysLocation</p>
     *
     * @param nodesyslocation a {@link java.lang.String} object.
     */
    public void setSysLocation(String nodesyslocation) {
        m_sysLocation = nodesyslocation;
    }

    /**
     * SNMP MIB-2 system.sysContact.0
     *
     * @return a {@link java.lang.String} object.
     */

    public String getSysContact() {
        return m_sysContact;
    }

    /**
     * <p>setSysContact</p>
     *
     * @param nodesyscontact a {@link java.lang.String} object.
     */
    public void setSysContact(String nodesyscontact) {
        m_sysContact = nodesyscontact;
    }

    /**
     * User-friendly name associated with the node.
     *
     * @return a {@link java.lang.String} object.
     */

    public String getLabel() {
        return m_label;
    }

    /**
     * <p>setLabel</p>
     *
     * @param nodelabel a {@link java.lang.String} object.
     */
    public void setLabel(String nodelabel) {
        m_label = nodelabel;
    }

    /**
     * Flag indicating source of nodeLabel
     * - 'U' = user defined
     * - 'H' = IP hostname
     * - 'S' = sysName
     * - 'A' = IP address
     *
     * TODO: change this to an enum
     *
     * @return a {@link java.lang.String} object.
     */

    public String getLabelSource() {
        return m_labelSource;
    }

    /**
     * <p>setLabelSource</p>
     *
     * @param nodelabelsource a {@link java.lang.String} object.
     */
    public void setLabelSource(String nodelabelsource) {
        m_labelSource = nodelabelsource;
    }

    /**
     * NetBIOS workstation name associated with the node.
     *
     * @return a {@link java.lang.String} object.
     */

    public String getNetBiosName() {
        return m_netBiosName;
    }

    /**
     * <p>setNetBiosName</p>
     *
     * @param nodenetbiosname a {@link java.lang.String} object.
     */
    public void setNetBiosName(String nodenetbiosname) {
        m_netBiosName = nodenetbiosname;
    }

    /**
     * NetBIOS domain name associated with the node.
     *
     * @return a {@link java.lang.String} object.
     */

    public String getNetBiosDomain() {
        return m_netBiosDomain;
    }

    /**
     * <p>setNetBiosDomain</p>
     *
     * @param nodedomainname a {@link java.lang.String} object.
     */
    public void setNetBiosDomain(String nodedomainname) {
        m_netBiosDomain = nodedomainname;
    }

    /**
     * Operating system running on the node.
     *
     * @return a {@link java.lang.String} object.
     */

    public String getOperatingSystem() {
        return m_operatingSystem;
    }

    /**
     * <p>setOperatingSystem</p>
     *
     * @param operatingsystem a {@link java.lang.String} object.
     */
    public void setOperatingSystem(String operatingsystem) {
        m_operatingSystem = operatingsystem;
    }

    /**
     * Date and time of last Capsd scan.
     *
     * @return a {@link java.util.Date} object.
     */

    public Date getLastCapsdPoll() {
        return m_lastCapsdPoll;
    }

    /**
     * <p>setLastCapsdPoll</p>
     *
     * @param lastcapsdpoll a {@link java.util.Date} object.
     */
    public void setLastCapsdPoll(Date lastcapsdpoll) {
        m_lastCapsdPoll = lastcapsdpoll;
    }
    
    /**
     * <p>getForeignId</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getForeignId() {
        return m_foreignId;
    }

    /**
     * <p>setForeignId</p>
     *
     * @param foreignId a {@link java.lang.String} object.
     */
    public void setForeignId(String foreignId) {
        m_foreignId = foreignId;
    }

    /**
     * <p>getForeignSource</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getForeignSource() {
        return m_foreignSource;
    }

    /**
     * <p>setForeignSource</p>
     *
     * @param foreignSource a {@link java.lang.String} object.
     */
    public void setForeignSource(String foreignSource) {
        m_foreignSource = foreignSource;
    }
    
    /**
     * Distributed Poller responsible for this node
     *
     * @return a {@link com.zanclus.opennms.data.entities.OnmsDistPoller} object.
     */

    public OnmsDistPoller getDistPoller() {
        return m_distPoller;
    }

    /**
     * <p>setDistPoller</p>
     *
     * @param distpoller a {@link com.zanclus.opennms.data.entities.OnmsDistPoller} object.
     */
    public void setDistPoller(com.zanclus.opennms.data.entities.OnmsDistPoller distpoller) {
        m_distPoller = distpoller;
    }
    
    /**
     * The assert record associated with this node
     *
     * @return a {@link com.zanclus.opennms.data.entities.OnmsAssetRecord} object.
     */

    public OnmsAssetRecord getAssetRecord() {
        return m_assetRecord;
    }

    /**
     * <p>setAssetRecord</p>
     *
     * @param asset a {@link com.zanclus.opennms.data.entities.OnmsAssetRecord} object.
     */
    public void setAssetRecord(OnmsAssetRecord asset) {
        m_assetRecord = asset;
    }
    
    /**
     * <p>getPathElement</p>
     *
     * @return a {@link com.zanclus.opennms.data.entities.PathElement} object.
     */
    public PathElement getPathElement() {
    	return m_pathElement;
    }
    
    /**
     * <p>setPathElement</p>
     *
     * @param pathElement a {@link com.zanclus.opennms.data.entities.PathElement} object.
     */
    public void setPathElement(PathElement pathElement) {
    	m_pathElement = pathElement;
    }


    /**
     * The interfaces on this node
     *
     * @return a {@link java.util.Set} object.
     */
    public Set<OnmsIpInterface> getIpInterfaces() {
        return m_ipInterfaces;
    }

    /**
     * <p>setIpInterfaces</p>
     *
     * @param ipinterfaces a {@link java.util.Set} object.
     */
    public void setIpInterfaces(Set<OnmsIpInterface> ipinterfaces) {
        m_ipInterfaces = ipinterfaces;
    }
    
    /**
     * <p>addIpInterface</p>
     *
     * @param iface a {@link com.zanclus.opennms.data.entities.OnmsIpInterface} object.
     */
    public void addIpInterface(OnmsIpInterface iface) {
    	iface.setNode(this);
    	getIpInterfaces().add(iface);
    }

    /**
     * The information from the SNMP interfaces/ipAddrTables for the node
     *
     * @return a {@link java.util.Set} object.
     */
    public Set<OnmsSnmpInterface> getSnmpInterfaces() {
        return m_snmpInterfaces;
    }

    /**
     * <p>setSnmpInterfaces</p>
     *
     * @param snmpinterfaces a {@link java.util.Set} object.
     */
    public void setSnmpInterfaces(Set<OnmsSnmpInterface> snmpinterfaces) {
        m_snmpInterfaces = snmpinterfaces;
    }
    
    /**
     * The ARP interfaces with this node as a source
     *
     * @return a {@link java.util.Set} object.
     */
    public Set<OnmsArpInterface> getArpInterfacesBySource() {
        return m_arpInterfacesBySource;
    }

    /**
     * @param arpInterfaces a {@link java.util.Set} object.
     */
    public void setArpInterfacesBySource(Set<OnmsArpInterface> arpInterfaces) {
        m_arpInterfacesBySource = arpInterfaces;
    }
    
    /**
     * @param iface a {@link com.zanclus.opennms.data.entities.OnmsArpInterface} object.
     */
    public void addArpInterfaceBySource(OnmsArpInterface iface) {
        iface.setNode(this);
        getArpInterfacesBySource().add(iface);
    }

    /**
     * The ARP interfaces on this node
     *
     * @return a {@link java.util.Set} object.
     */

    public Set<OnmsArpInterface> getArpInterfaces() {
        return m_arpInterfaces;
    }

    /**
     * <p>setArpInterfaces</p>
     *
     * @param arpInterfaces a {@link java.util.Set} object.
     */
    public void setArpInterfaces(Set<OnmsArpInterface> arpInterfaces) {
        m_arpInterfaces = arpInterfaces;
    }
    
    /**
     * <p>addArpInterface</p>
     *
     * @param iface a {@link com.zanclus.opennms.data.entities.OnmsArpInterface} object.
     */
    public void addArpInterface(OnmsArpInterface iface) {
        iface.setNode(this);
        getArpInterfaces().add(iface);
    }

    /**
     * <p>getCategories</p>
     *
     * @return a {@link java.util.Set} object.
     */
    public Set<OnmsCategory> getCategories() {
        return m_categories;
    }
    
    /**
     * <p>setCategories</p>
     *
     * @param categories a {@link java.util.Set} object.
     */
    public void setCategories(Set<OnmsCategory> categories) {
        m_categories = categories;
    }
    
    /**
     * <p>addCategory</p>
     *
     * @param category a {@link com.zanclus.opennms.data.entities.OnmsCategory} object.
     * @return a boolean.
     */
    public boolean addCategory(OnmsCategory category) {
        return getCategories().add(category);
    }
    
    /**
     * <p>removeCategory</p>
     *
     * @param category a {@link com.zanclus.opennms.data.entities.OnmsCategory} object.
     * @return a boolean.
     */
    public boolean removeCategory(OnmsCategory category) {
        return getCategories().remove(category);
    }
    
    /**
     * <p>hasCategory</p>
     *
     * @param categoryName a {@link java.lang.String} object.
     * @return a boolean.
     */
    public boolean hasCategory(String categoryName) {
        for(OnmsCategory category : getCategories()) {
            if (category.getName().equals(categoryName)) {
                return true;
            }
        }
        return false;
    }

	/** {@inheritDoc} */
	public void visit(EntityVisitor visitor) {
		visitor.visitNode(this);
		
		for (OnmsIpInterface iface : getIpInterfaces()) {
			iface.visit(visitor);
		}
		
		for (OnmsSnmpInterface snmpIface : getSnmpInterfaces()) {
			snmpIface.visit(visitor);
		}
		
		visitor.visitNodeComplete(this);
	}

	/**
	 * <p>addSnmpInterface</p>
	 *
	 * @param snmpIface a {@link com.zanclus.opennms.data.entities.OnmsSnmpInterface} object.
	 */
	public void addSnmpInterface(OnmsSnmpInterface snmpIface) {
    	snmpIface.setNode(this);
    	getSnmpInterfaces().add(snmpIface);
	}

	/**
	 * <p>isDown</p>
	 *
	 * @return a boolean.
	 */

    public boolean isDown() {
        boolean down = true;
        for (OnmsIpInterface ipIf : m_ipInterfaces) {
            if (!ipIf.isDown()) {
                return !down;
            }
        }
        return down;
    }

    /**
     * <p>getSnmpInterfaceWithIfIndex</p>
     *
     * @param ifIndex a int.
     * @return a {@link com.zanclus.opennms.data.entities.OnmsSnmpInterface} object.
     */

    public OnmsSnmpInterface getSnmpInterfaceWithIfIndex(int ifIndex) {
        for (OnmsSnmpInterface dbSnmpIface : getSnmpInterfaces()) {
            if (dbSnmpIface.getIfIndex().equals(ifIndex)) {
                return dbSnmpIface;
            }
        }
        return null;
    }

    /**
     * <p>getIpInterfaceByIpAddress</p>
     *
     * @param ipAddress a {@link java.lang.String} object.
     * @return a {@link com.zanclus.opennms.data.entities.OnmsIpInterface} object.
     */
    public OnmsIpInterface getIpInterfaceByIpAddress(InetAddress ipAddress) {
        for (OnmsIpInterface iface : getIpInterfaces()) {
            if (ipAddress.equals(iface.getIpAddress())) {
                return iface;
            }
        }
        return null;
    }

    /**
     * <p>compareTo</p>
     *
     * @param o a {@link com.zanclus.opennms.data.entities.OnmsNode} object.
     * @return a int.
     */
    public int compareTo(OnmsNode o) {
        String compareLabel = "";
        Integer compareId = 0;

        if (o != null) {
            compareLabel = o.getLabel();
            compareId = o.getId();
        }

        int returnval = this.getLabel().compareToIgnoreCase(compareLabel);
        if (returnval == 0) {
            return this.getId().compareTo(compareId);
        } else {
            return returnval;
        }
    }
    
    /**
     * <p>getInterfaceWithService</p>
     *
     * @param svcName a {@link java.lang.String} object.
     * @return a {@link com.zanclus.opennms.data.entities.OnmsIpInterface} object.
     */

	public OnmsIpInterface getInterfaceWithService(String svcName) {
		for(OnmsIpInterface iface : getIpInterfaces()) {
			if (iface.getMonitoredServiceByServiceType(svcName) != null) {
				return iface;
			}	
		}
		return null;
	}
    
    /**
     * Simply replaces the current asset record with the new record
     *
     * @param scannedNode a {@link com.zanclus.opennms.data.entities.OnmsNode} object.
     */
    public void replaceCurrentAssetRecord(OnmsNode scannedNode) {
        scannedNode.getAssetRecord().setId(this.getAssetRecord().getId());
        scannedNode.setId(this.m_id);  //just in case
        this.setAssetRecord(scannedNode.getAssetRecord());
    }

}
