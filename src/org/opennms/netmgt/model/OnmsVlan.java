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

package org.opennms.netmgt.model;

import java.util.Date;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Transient;

@Root(name = "vlan")
public class OnmsVlan extends OnmsEntity {
    private Integer m_id;
	private OnmsNode m_node;
	private Integer m_vlanId;
	private String m_vlanName;
	private Integer m_vlanType = -1;
	private Integer m_vlanStatus = -1;
	private Character m_status;
	private Date m_lastPollTime;	

	public OnmsVlan() {
	}
	
	public OnmsVlan(final int index, final String name, final int status, final int type) {
		m_vlanId = index;
		m_vlanName = name;
		m_vlanStatus = status;
		m_vlanType = type;
	}

	public OnmsVlan(final int index, final String name, final int status) {
		m_vlanId = index;
		m_vlanName = name;
		m_vlanStatus = status;
	}

    @Transient
    public Integer getId() {
        return m_id;
    }
    
    @Attribute(name="id")
    public String getInterfaceId() {
        return getId().toString();
    }

    public void setId(final Integer id) {
        m_id = id;
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
    public void setNode(final OnmsNode node) {
        m_node = node;
    }
    
    @Attribute
    public Integer getVlanId() {
		return m_vlanId;
	}

	public void setVlanId(final Integer vlanId) {
		m_vlanId = vlanId;
	}

	@Attribute(name="name")
	public String getVlanName() {
		return m_vlanName;
	}

	public void setVlanName(final String vlanName) {
		m_vlanName = vlanName;
	}

	@Attribute(name="type")
	public Integer getVlanType() {
		return m_vlanType;
	}

	public void setVlanType(final Integer vlanType) {
		m_vlanType = vlanType;
	}

	@Attribute
	public Integer getVlanStatus() {
		return m_vlanStatus;
	}

	public void setVlanStatus(final Integer vlanStatus) {
		m_vlanStatus = vlanStatus;
	}

	@Attribute
	public Character getStatus() {
		return m_status;
	}

	public void setStatus(final Character status) {
		m_status = status;
	}

    @Element
	public Date getLastPollTime() {
		return m_lastPollTime;
	}

	public void setLastPollTime(final Date lastPollTime) {
		m_lastPollTime = lastPollTime;
	}
}
