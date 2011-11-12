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

public class OnmsIpRouteInterface {

    private Integer m_id;
	private OnmsNode m_node;
	private String m_routeDest;
	private String m_routeMask;
	private String m_routeNextHop;
	private Integer m_routeIfIndex;
	private Integer m_routeMetric1;
	private Integer m_routeMetric2;
	private Integer m_routeMetric3;
	private Integer m_routeMetric4;
	private Integer m_routeMetric5;
	private Integer m_routeType;
	private Integer m_routeProto;
	private Character m_status;
	private Date m_lastPollTime;

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

	public String getRouteDest() {
		return m_routeDest;
	}

	public void setRouteDest(final String routeDest) {
		m_routeDest = routeDest;
	}

	public String getRouteMask() {
		return m_routeMask;
	}

	public void setRouteMask(final String routeMask) {
		m_routeMask = routeMask;
	}

	public String getRouteNextHop() {
		return m_routeNextHop;
	}

	public void setRouteNextHop(final String routeNextHop) {
		m_routeNextHop = routeNextHop;
	}

	public Integer getRouteIfIndex() {
		return m_routeIfIndex;
	}

	public void setRouteIfIndex(final Integer routeIfIndex) {
		m_routeIfIndex = routeIfIndex;
	}

	public Integer getRouteMetric1() {
		return m_routeMetric1;
	}

	public void setRouteMetric1(final Integer routeMetric1) {
		m_routeMetric1 = routeMetric1;
	}

	public Integer getRouteMetric2() {
		return m_routeMetric2;
	}

	public void setRouteMetric2(final Integer routeMetric2) {
		m_routeMetric2 = routeMetric2;
	}

	public Integer getRouteMetric3() {
		return m_routeMetric3;
	}

	public void setRouteMetric3(final Integer routeMetric3) {
		m_routeMetric3 = routeMetric3;
	}

	public Integer getRouteMetric4() {
		return m_routeMetric4;
	}

	public void setRouteMetric4(final Integer routeMetric4) {
		m_routeMetric4 = routeMetric4;
	}

	public Integer getRouteMetric5() {
		return m_routeMetric5;
	}

	public void setRouteMetric5(final Integer routeMetric5) {
		m_routeMetric5 = routeMetric5;
	}

	public Integer getRouteType() {
		return m_routeType;
	}

	public void setRouteType(final Integer routeType) {
		m_routeType = routeType;
	}

	public Integer getRouteProto() {
		return m_routeProto;
	}

	public void setRouteProto(final Integer routeProto) {
		m_routeProto = routeProto;
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


}
