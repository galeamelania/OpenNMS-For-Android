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

/**
 * <p>OnmsServerMap class.</p>
 */

public class OnmsServerMap extends OnmsEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -858347716282069343L;

    /** identifier field */
    private String m_ipAddr;

    /** identifier field */
    private String m_serverName;

    private Integer m_id;

    /**
     * full constructor
     *
     * @param ipAddr a {@link java.lang.String} object.
     * @param serverName a {@link java.lang.String} object.
     */
    public OnmsServerMap(String ipAddr, String serverName) {
        m_ipAddr = ipAddr;
        m_serverName = serverName;
    }

    /**
     * default constructor
     */
    public OnmsServerMap() {
    }

    
    /**
     * <p>getId</p>
     *
     * @return a {@link java.lang.Integer} object.
     */

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
     * <p>getIpAddress</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getIpAddress() {
        return m_ipAddr;
    }

    /**
     * <p>setIpAddress</p>
     *
     * @param ipAddr a {@link java.lang.String} object.
     */
    public void setIpAddress(String ipAddr) {
        m_ipAddr = ipAddr;
    }

    
    /**
     * <p>getServerName</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getServerName() {
        return m_serverName;
    }

    /**
     * <p>setServerName</p>
     *
     * @param serverName a {@link java.lang.String} object.
     */
    public void setServerName(String serverName) {
        m_serverName = serverName;
    }

	/** {@inheritDoc} */
	public void visit(EntityVisitor visitor) {
		// TODO Auto-generated method stub
		throw new RuntimeException("visitor method not implemented");
	}

}
