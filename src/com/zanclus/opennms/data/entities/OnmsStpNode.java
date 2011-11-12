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


package com.zanclus.opennms.data.entities;

import java.util.Date;

/**
 * <p>AtInterface class.</p>
 *
 * @author <a href="mailto:antonio@opennms.it">Antonio Russo</a>
 * @version $Id: $
 */

public class OnmsStpNode {
    private Integer m_id;
	private OnmsNode m_node;
	private String m_baseBridgeAddress;
	private Integer m_baseNumPorts;
	private Integer m_baseType;
	private Integer m_stpProtocolSpecification;
	private Integer m_stpPriority;
	private String m_stpDesignatedRoot;
	private Integer m_stpRootCost;
	private Integer m_stpRootPort;
	private Character m_status;
	private Date m_lastPollTime;
	private Integer m_baseVlan;
	private String m_baseVlanName;

	public OnmsStpNode() {}

    public OnmsStpNode(final OnmsNode node, final Integer vlanIndex) {
    	m_node = node;
    	m_baseVlan = vlanIndex;
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

	public String getBaseBridgeAddress() {
		return m_baseBridgeAddress;
	}

	public void setBaseBridgeAddress(final String baseBridgeAddress) {
		m_baseBridgeAddress = baseBridgeAddress;
	}

	public Integer getBaseNumPorts() {
		return m_baseNumPorts;
	}

	public void setBaseNumPorts(final Integer baseNumPorts) {
		m_baseNumPorts = baseNumPorts;
	}

	public Integer getBaseType() {
		return m_baseType;
	}

	public void setBaseType(final Integer baseType) {
		m_baseType = baseType;
	}

	public Integer getStpProtocolSpecification() {
		return m_stpProtocolSpecification;
	}

	public void setStpProtocolSpecification(final Integer stpProtocolSpecification) {
		m_stpProtocolSpecification = stpProtocolSpecification;
	}

	public Integer getStpPriority() {
		return m_stpPriority;
	}

	public void setStpPriority(final Integer stpPriority) {
		m_stpPriority = stpPriority;
	}

	public String getStpDesignatedRoot() {
		return m_stpDesignatedRoot;
	}

	public void setStpDesignatedRoot(final String stpDesignatedRoot) {
		m_stpDesignatedRoot = stpDesignatedRoot;
	}

	public Integer getStpRootCost() {
		return m_stpRootCost;
	}

	public void setStpRootCost(final Integer stpRootCost) {
		m_stpRootCost = stpRootCost;
	}

	public Integer getStpRootPort() {
		return m_stpRootPort;
	}

	public void setStpRootPort(final Integer stpRootPort) {
		m_stpRootPort = stpRootPort;
	}

	public Character getStatus() {
		return m_status;
	}

	public void setStatus(final Character statusActive) {
		m_status = statusActive;
	}

	public Date getLastPollTime() {
		return m_lastPollTime;
	}

	public void setLastPollTime(final Date lastPollTime) {
		m_lastPollTime = lastPollTime;
	}

	public Integer getBaseVlan() {
		return m_baseVlan;
	}

	public void setBaseVlan(final Integer baseVlan) {
		m_baseVlan = baseVlan;
	}

	public String getBaseVlanName() {
		return m_baseVlanName;
	}

	public void setBaseVlanName(final String baseVlanName) {
		m_baseVlanName = baseVlanName;
	}
}
