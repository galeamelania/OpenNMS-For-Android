/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2011 The OpenNMS Group, Inc.
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

/*
 * Created on 9-mar-2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.zanclus.opennms.data.entities;

import java.util.Date;
/**
 * <p>BridgeStpInterface class.</p>
 *
 * @author antonio
 */

public class OnmsStpInterface {

    private Integer m_id;
	private OnmsNode m_node;
	private Integer m_bridgePort;
	private Integer m_ifIndex = -1;
	private Integer m_stpPortState;
	private Integer m_stpPortPathCost;
	private String m_stpPortDesignatedRoot;
	private Integer m_stpPortDesignatedCost;
	private String m_stpPortDesignatedBridge;
	private String m_stpPortDesignatedPort;
	private Character m_status;
	private Date m_lastPollTime;
	private Integer m_vlan;

	public OnmsStpInterface() {
	}

	public OnmsStpInterface(final Integer bridgePort, final Integer vlanIndex) {
		m_bridgePort = bridgePort;
		m_vlan = vlanIndex;
	}

    public OnmsStpInterface(final OnmsNode node, final Integer bridgePort, final Integer vlanIndex) {
        m_node = node;
        m_bridgePort = bridgePort;
        m_vlan = vlanIndex;
    }

    public Integer getId() {
        return m_id;
    }

    public String getInterfaceId() {
        return getId().toString();
    }

    public void setId(final Integer id) {
        m_id = id;
    }

    public OnmsNode getNode() {
        return m_node;
    }

    public void setNode(final OnmsNode node) {
        m_node = node;
    }

	public Integer getIfIndex() {
		return m_ifIndex;
	}

	public void setIfIndex(final Integer ifIndex) {
		m_ifIndex = ifIndex;
	}

	public Integer getStpPortState() {
		return m_stpPortState;
	}

	public void setStpPortState(final Integer stpPortState) {
		m_stpPortState = stpPortState;
	}

	public Integer getStpPortPathCost() {
		return m_stpPortPathCost;
	}

	public void setStpPortPathCost(final Integer stpPortPathCost) {
		m_stpPortPathCost = stpPortPathCost;
	}

	public String getStpPortDesignatedRoot() {
		return m_stpPortDesignatedRoot;
	}

	public void setStpPortDesignatedRoot(final String stpPortDesignatedRoot) {
		m_stpPortDesignatedRoot = stpPortDesignatedRoot;
	}

	public Integer getStpPortDesignatedCost() {
		return m_stpPortDesignatedCost;
	}

	public void setStpPortDesignatedCost(final Integer stpPortDesignatedCost) {
		m_stpPortDesignatedCost = stpPortDesignatedCost;
	}

	public Character getStatus() {
		return m_status;
	}

	public void setStatus(final Character status) {
		m_status = status;
	}

	public Date getLastPollTime() {
		return m_lastPollTime;
	}

	public void setLastPollTime(final Date lastPollTime) {
		m_lastPollTime = lastPollTime;
	}

	public Integer getBridgePort() {
		return m_bridgePort;
	}

	public void setBridgePort(final Integer bridgePort) {
		m_bridgePort = bridgePort;
	}

	public String getStpPortDesignatedBridge() {
		return m_stpPortDesignatedBridge;
	}

	public void setStpPortDesignatedBridge(final String stpPortDesignatedBridge) {
		m_stpPortDesignatedBridge = stpPortDesignatedBridge;
	}

	public String getStpPortDesignatedPort() {
		return m_stpPortDesignatedPort;
	}

	public void setStpPortDesignatedPort(final String stpPortDesignatedPort) {
		m_stpPortDesignatedPort = stpPortDesignatedPort;
	}

	public Integer getVlan() {
		return m_vlan;
	}
	
	public void setVlan(final Integer vlan) {
		m_vlan = vlan;
	}
}

