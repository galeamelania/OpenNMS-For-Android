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
 * <p>OnmsServiceType class.</p>
 *
 * @hibernate.class table="service"
 */

public class OnmsServiceType implements Serializable {

    private static final long serialVersionUID = -459218937667452586L;

    /** identifier field */
    private Integer m_id;

    /** persistent field */
    private String m_name;

    /**
     * full constructor
     *
     * @param servicename a {@link java.lang.String} object.
     */
    public OnmsServiceType(String servicename) {
        m_name = servicename;
    }

    /**
     * default constructor
     */
    public OnmsServiceType() {
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
     * @param serviceid a {@link java.lang.Integer} object.
     */
    public void setId(Integer serviceid) {
        m_id = serviceid;
    }

    /**
     * <p>getName</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getName() {
        return m_name;
    }

    /**
     * <p>setName</p>
     *
     * @param name a {@link java.lang.String} object.
     */
    public void setName(String name) {
        m_name = name;
    }

    /** {@inheritDoc} */
    public boolean equals(Object obj) {
        if (obj instanceof OnmsServiceType) {
            OnmsServiceType t = (OnmsServiceType)obj;
            return m_id.equals(t.m_id);
        }
        return false;
    }

    /**
     * <p>hashCode</p>
     *
     * @return a int.
     */
    public int hashCode() {
        return m_id.intValue();
    }

}
