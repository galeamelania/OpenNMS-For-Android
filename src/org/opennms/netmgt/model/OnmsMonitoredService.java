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
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Transient;

@Root(name = "service")
public class OnmsMonitoredService extends OnmsEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7106081378757872886L;

    private Integer m_id;

    private Date m_lastGood;

    private Date m_lastFail;

    private String m_qualifier;

    private String m_status;

    private String m_source;

    private String m_notify;

    private OnmsServiceType m_serviceType;

    private OnmsIpInterface m_ipInterface;

    /*
     * This is a set only because we want it to be lazy
     * and we need a better query language (i.e. HQL)
     * to make this work.  In this case, the Set size
     * will always be 1 or empty because there can only
     * be one outage at a time on a service.
     * 
     * With distributed monitoring, there will probably
     * be a model change were one service can be represented
     * by more than one outage.
     */
    private Set<OnmsOutage> m_currentOutages = new LinkedHashSet<OnmsOutage>();

	private static final Map<String, String> STATUS_MAP;
	
	static {
        STATUS_MAP = new HashMap<String, String>();
        STATUS_MAP.put("A", "Managed");
        STATUS_MAP.put("U", "Unmanaged");
        STATUS_MAP.put("D", "Deleted");
        STATUS_MAP.put("F", "Forced Unmanaged");
        STATUS_MAP.put("N", "Not Monitored");
        STATUS_MAP.put("R", "Rescan to Resume");
        STATUS_MAP.put("S", "Rescan to Suspend");
        STATUS_MAP.put("X", "Remotely Monitored");
	}

    /**
     * <p>Constructor for OnmsMonitoredService.</p>
     */
    public OnmsMonitoredService() {
    }

    /**
     * Unique identifier for ifService.
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
     * <p>getIpAddress</p>
     *
     * @return a {@link java.lang.String} object.
     */
    @Transient
    public String getIpAddress() {
        return m_ipInterface.getIpAddress();
    }

    /**
     * <p>getIpAddress</p>
     *
     * @return a {@link java.lang.String} object.
     * 
     * @deprecated
     */
    @Transient
    public String getIpAddressAsString() {
        return m_ipInterface.getIpAddressAsString();
    }

    /**
     * <p>getIfIndex</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    @Transient
    public Integer getIfIndex() {
        return m_ipInterface.getIfIndex();
    }

    /**
     * <p>getLastGood</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getLastGood() {
        return m_lastGood;
    }

    /**
     * <p>setLastGood</p>
     *
     * @param lastgood a {@link java.util.Date} object.
     */
    public void setLastGood(Date lastgood) {
        m_lastGood = lastgood;
    }

    /**
     * <p>getLastFail</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getLastFail() {
        return m_lastFail;
    }

    /**
     * <p>setLastFail</p>
     *
     * @param lastfail a {@link java.util.Date} object.
     */
    public void setLastFail(Date lastfail) {
        m_lastFail = lastfail;
    }

    /**
     * <p>getQualifier</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getQualifier() {
        return m_qualifier;
    }

    /**
     * <p>setQualifier</p>
     *
     * @param qualifier a {@link java.lang.String} object.
     */
    public void setQualifier(String qualifier) {
        m_qualifier = qualifier;
    }

    /**
     * <p>getStatus</p>
     *
     * @return a {@link java.lang.String} object.
     */
    @Attribute
    public String getStatus() {
        return m_status;
    }

    /**
     * <p>setStatus</p>
     *
     * @param status a {@link java.lang.String} object.
     */
    public void setStatus(String status) {
        m_status = status;
    }
    
    @Transient
    public String getStatusLong() {
    	return STATUS_MAP.get(getStatus());
    }

    /**
     * <p>getSource</p>
     *
     * @return a {@link java.lang.String} object.
     */
    @Attribute
    public String getSource() {
        return m_source;
    }

    /**
     * <p>setSource</p>
     *
     * @param source a {@link java.lang.String} object.
     */
    public void setSource(String source) {
        m_source = source;
    }

    /**
     * <p>getNotify</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getNotify() {
        return m_notify;
    }

    /**
     * <p>setNotify</p>
     *
     * @param notify a {@link java.lang.String} object.
     */
    public void setNotify(String notify) {
        m_notify = notify;
    }

    /**
     * <p>getIpInterface</p>
     *
     * @return a {@link org.opennms.netmgt.model.OnmsIpInterface} object.
     */
    @Element(name="ipInterfaceId")
    public OnmsIpInterface getIpInterface() {
        return m_ipInterface;
    }

    /**
     * <p>setIpInterface</p>
     *
     * @param ipInterface a {@link org.opennms.netmgt.model.OnmsIpInterface} object.
     */
    public void setIpInterface(OnmsIpInterface ipInterface) {
        m_ipInterface = ipInterface;
    }

    /**
     * <p>getNodeId</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    @Transient
    public Integer getNodeId() {
        return m_ipInterface.getNode().getId();
    }

    /**
     * <p>getServiceType</p>
     *
     * @return a {@link org.opennms.netmgt.model.OnmsServiceType} object.
     */
    public OnmsServiceType getServiceType() {
        return m_serviceType;
    }

    /**
     * <p>setServiceType</p>
     *
     * @param service a {@link org.opennms.netmgt.model.OnmsServiceType} object.
     */
    public void setServiceType(OnmsServiceType service) {
        m_serviceType = service;
    }

    /**
     * <p>getServiceId</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    @Transient
    public Integer getServiceId() {
        return getServiceType().getId();
    }

    /**
     * <p>getServiceName</p>
     *
     * @return a {@link java.lang.String} object.
     */
    @Transient
    public String getServiceName() {
        return getServiceType().getName();
    }

    /**
     * <p>isDown</p>
     *
     * @return a boolean.
     */
    @Transient
    public boolean isDown() {
        boolean down = true;
        if (!"A".equals(getStatus()) || m_currentOutages.isEmpty()) {
            return !down;
        }

        return down;
    }

    /**
     * <p>getCurrentOutages</p>
     *
     * @return a {@link java.util.Set} object.
     */
    @Transient
    public Set<OnmsOutage> getCurrentOutages() {
        return m_currentOutages;
    }

    /**
     * <p>setCurrentOutages</p>
     *
     * @param currentOutages a {@link java.util.Set} object.
     */
    public void setCurrentOutages(Set<OnmsOutage> currentOutages) {
        m_currentOutages = currentOutages;
    }
}
