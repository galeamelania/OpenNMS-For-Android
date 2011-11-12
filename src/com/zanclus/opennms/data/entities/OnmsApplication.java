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

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <p>OnmsApplication class.</p>
 */

public class OnmsApplication implements Comparable<OnmsApplication> {

    private Integer m_id;

    private String m_name;

    private Set<OnmsMonitoredService> m_monitoredServices = new LinkedHashSet<OnmsMonitoredService>();

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

    /**
     * <p>getMonitoredServices</p>
     *
     * @return a {@link java.util.Set} object.
     * @since 1.8.1
     */
    public Set<OnmsMonitoredService> getMonitoredServices() {
        return m_monitoredServices;
    }

    /**
     * <p>setMonitoredServices</p>
     *
     * @param services a {@link java.util.Set} object.
     * @since 1.8.1
     */
    public void setMonitoredServices(Set<OnmsMonitoredService> services) {
        m_monitoredServices = services;
    }

    /**
     * <p>addMonitoredService</p>
     *
     * @param service a {@link org.opennms.netmgt.model.OnmsMonitoredService} object.
     * @since 1.8.1
     */
    public void addMonitoredService(OnmsMonitoredService service) {
        getMonitoredServices().add(service);
    }

    /**
     * <p>compareTo</p>
     *
     * @param o a {@link org.opennms.netmgt.model.OnmsApplication} object.
     * @return a int.
     */
    public int compareTo(OnmsApplication o) {
        return getName().compareToIgnoreCase(o.getName());
    }

    /** {@inheritDoc} */

    public boolean equals(Object obj) {
        if (obj instanceof OnmsApplication) {
            OnmsApplication app = (OnmsApplication)obj;
            return getName().equals(app.getName());
        }
        return false;
    }

    /** {@inheritDoc} */

    public int hashCode() {
        return getName().hashCode();
    }
    


}
