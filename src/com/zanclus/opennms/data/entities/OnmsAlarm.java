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
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * <p>OnmsAlarm class.</p>
 */
public class OnmsAlarm implements Acknowledgeable, Serializable {
    private static final long serialVersionUID = 7275548439687562161L;
    
    /** Constant <code>PROBLEM_TYPE=1</code> */
    public static final int PROBLEM_TYPE = 1;
    
    /** Constant <code>RESOLUTION_TYPE=2</code> */
    public static final int RESOLUTION_TYPE = 2;

    /** identifier field */
    private Integer m_id;

    /** persistent field */
    private String m_uei;

    /** persistent field */
    private OnmsDistPoller m_distPoller;

    /** nullable persistent field */
    private OnmsNode m_node;

    /** nullable persistent field */
    private InetAddress m_ipAddr;

    /** nullable persistent field */
    private OnmsServiceType m_serviceType;

    /** nullable persistent field */
    private String m_reductionKey;

    /** nullable persistent field */
    private Integer m_alarmType;

    /** nullable persistent field */
    private Integer m_ifIndex;

    /** persistent field */
    private Integer m_counter;

    /** persistent field */
    private OnmsSeverity m_severity;

    /** persistent field */
    private Date m_firstEventTime;
    
    /** persistent field */
    private Date m_lastEventTime;

    /** persistent field */
    private Date m_firstAutomationTime;
    
    /** persistent field */
    private Date m_lastAutomationTime;

    /** nullable persistent field */
    private String m_description;

    /** nullable persistent field */
    private String m_logMsg;

    /** nullable persistent field */
    private String m_operInstruct;

    /** nullable persistent field */
    private String m_tTicketId;

    /** nullable persistent field */
    private String m_mouseOverText;

    /** nullable persistent field */
    private Date m_suppressedUntil;

    /** nullable persistent field */
    private String m_suppressedUser;

    /** nullable persistent field */
    private Date m_suppressedTime;

    /** nullable persistent field */
    private String m_alarmAckUser;

    /** nullable persistent field */
    private Date m_alarmAckTime;

    /** nullable persistent field */
    private String m_clearKey;

    /** persistent field */
    private OnmsEvent m_lastEvent;
    
    /** persistent field */
    private String m_eventParms;

    /** persistent field */
    private String m_managedObjectInstance;
    
    /** persistent field */
    private String m_managedObjectType;
    
    /** persistent field */
    private String m_applicationDN;

    private String m_ossPrimaryKey;

    private String m_x733AlarmType;

    private String m_qosAlarmState;

    private int m_x733ProbableCause = 0;
    
	private Map<String, String> m_details;

    /**
     * default constructor
     */
    public OnmsAlarm() {
    }

    /**
     * minimal constructor
     *
     * @param alarmid a {@link java.lang.Integer} object.
     * @param eventuei a {@link java.lang.String} object.
     * @param distPoller a {@link org.opennms.netmgt.model.OnmsDistPoller} object.
     * @param counter a {@link java.lang.Integer} object.
     * @param severity a {@link java.lang.Integer} object.
     * @param firsteventtime a {@link java.util.Date} object.
     * @param event a {@link org.opennms.netmgt.model.OnmsEvent} object.
     */
    public OnmsAlarm(Integer alarmid, String eventuei, OnmsDistPoller distPoller, Integer counter, Integer severity, Date firsteventtime, OnmsEvent event) {
        this.m_id = alarmid;
        this.m_uei = eventuei;
        this.m_distPoller = distPoller;
        this.m_counter = counter;
        this.m_severity = OnmsSeverity.get(severity);
        this.m_firstEventTime = firsteventtime;
        this.m_lastEvent = event;
    }

    /**
     * <p>getId</p>
     *
     * @return a {@link java.lang.Integer} object.
     */

    public Integer getId() {
        return this.m_id;
    }

    /**
     * <p>setId</p>
     *
     * @param alarmid a {@link java.lang.Integer} object.
     */
    public void setId(Integer alarmid) {
        this.m_id = alarmid;
    }

    /**
     * <p>getUei</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getUei() {
        return this.m_uei;
    }

    /**
     * <p>setUei</p>
     *
     * @param eventuei a {@link java.lang.String} object.
     */
    public void setUei(String eventuei) {
        this.m_uei = eventuei;
    }

	/**
	 * <p>getDistPoller</p>
	 *
	 * @return a {@link org.opennms.netmgt.model.OnmsDistPoller} object.
	 */

    public OnmsDistPoller getDistPoller() {
        return this.m_distPoller;
    }

    /**
     * <p>setDistPoller</p>
     *
     * @param distPoller a {@link org.opennms.netmgt.model.OnmsDistPoller} object.
     */
    public void setDistPoller(OnmsDistPoller distPoller) {
        this.m_distPoller = distPoller;
    }

	/**
	 * <p>getNode</p>
	 *
	 * @return a {@link org.opennms.netmgt.model.OnmsNode} object.
	 */

    public OnmsNode getNode() {
        return this.m_node;
    }

    /**
     * <p>setNode</p>
     *
     * @param node a {@link org.opennms.netmgt.model.OnmsNode} object.
     */
    public void setNode(OnmsNode node) {
        this.m_node = node;
    }

    /**
     * <p>getIpAddr</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public InetAddress getIpAddr() {
        return this.m_ipAddr;
    }

    /**
     * <p>setIpAddr</p>
     *
     * @param ipaddr a {@link java.lang.String} object.
     */
    public void setIpAddr(InetAddress ipaddr) {
        this.m_ipAddr = ipaddr;
    }

    /**
     * <p>getServiceType</p>
     *
     * @return a {@link org.opennms.netmgt.model.OnmsServiceType} object.
     */

    public OnmsServiceType getServiceType() {
        return this.m_serviceType;
    }

    /**
     * <p>setServiceType</p>
     *
     * @param service a {@link org.opennms.netmgt.model.OnmsServiceType} object.
     */
    public void setServiceType(OnmsServiceType service) {
        this.m_serviceType = service;
    }

    /**
     * <p>getReductionKey</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getReductionKey() {
        return this.m_reductionKey;
    }

    /**
     * <p>setReductionKey</p>
     *
     * @param reductionkey a {@link java.lang.String} object.
     */
    public void setReductionKey(String reductionkey) {
        this.m_reductionKey = reductionkey;
    }

    /**
     * <p>getAlarmType</p>
     *
     * @return a {@link java.lang.Integer} object.
     */

    public Integer getAlarmType() {
        return this.m_alarmType;
    }

    /**
     * <p>setAlarmType</p>
     *
     * @param alarmtype a {@link java.lang.Integer} object.
     */
    public void setAlarmType(Integer alarmtype) {
        this.m_alarmType = alarmtype;
    }

    /**
     * <p>getCounter</p>
     *
     * @return a {@link java.lang.Integer} object.
     */

    public Integer getCounter() {
        return this.m_counter;
    }

    /**
     * <p>setCounter</p>
     *
     * @param counter a {@link java.lang.Integer} object.
     */
    public void setCounter(Integer counter) {
        this.m_counter = counter;
    }

    /**
     * <p>getSeverityLabel</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getSeverityLabel() {
        return this.m_severity.name();
    }

    /**
     * <p>setSeverityLabel</p>
     *
     * @param label a {@link java.lang.String} object.
     */
    public void setSeverityLabel(String label) {
        m_severity = OnmsSeverity.get(label);
    }
    
    /**
     * <p>getSeverity</p>
     *
     * @return a {@link org.opennms.netmgt.model.OnmsSeverity} object.
     */

    public OnmsSeverity getSeverity() {
        return this.m_severity;
    }

    /**
     * <p>setSeverity</p>
     *
     * @param severity a {@link org.opennms.netmgt.model.OnmsSeverity} object.
     */

    public void setSeverity(OnmsSeverity severity) {
        m_severity = severity;
    }
    
    /**
     * <p>getSeverityId</p>
     *
     * @return a {@link java.lang.Integer} object.
     */

    public Integer getSeverityId() {
        return this.m_severity.getId();
    }

    /**
     * <p>setSeverityId</p>
     *
     * @param severity a {@link java.lang.Integer} object.
     */
    public void setSeverityId(Integer severity) {
        this.m_severity = OnmsSeverity.get(severity);
    }
    
    /**
     * <p>getFirstEventTime</p>
     *
     * @return a {@link java.util.Date} object.
     */

    public Date getFirstEventTime() {
        return this.m_firstEventTime;
    }

    /**
     * <p>setFirstEventTime</p>
     *
     * @param firsteventtime a {@link java.util.Date} object.
     */
    public void setFirstEventTime(Date firsteventtime) {
        this.m_firstEventTime = firsteventtime;
    }

    /**
     * <p>getDescription</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getDescription() {
        return this.m_description;
    }

    /**
     * <p>setDescription</p>
     *
     * @param description a {@link java.lang.String} object.
     */
    public void setDescription(String description) {
        this.m_description = description;
    }

    /**
     * <p>getLogMsg</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getLogMsg() {
        return this.m_logMsg;
    }

    /**
     * <p>setLogMsg</p>
     *
     * @param logmsg a {@link java.lang.String} object.
     */
    public void setLogMsg(String logmsg) {
        this.m_logMsg = logmsg;
    }

    /**
     * <p>getOperInstruct</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getOperInstruct() {
        return this.m_operInstruct;
    }

    /**
     * <p>setOperInstruct</p>
     *
     * @param operinstruct a {@link java.lang.String} object.
     */
    public void setOperInstruct(String operinstruct) {
        this.m_operInstruct = operinstruct;
    }

    /**
     * <p>getTTicketId</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getTTicketId() {
        return this.m_tTicketId;
    }

    /**
     * <p>setTTicketId</p>
     *
     * @param tticketid a {@link java.lang.String} object.
     */
    public void setTTicketId(String tticketid) {
        this.m_tTicketId = tticketid;
    }

    /**
     * <p>getMouseOverText</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getMouseOverText() {
        return this.m_mouseOverText;
    }

    /**
     * <p>setMouseOverText</p>
     *
     * @param mouseovertext a {@link java.lang.String} object.
     */
    public void setMouseOverText(String mouseovertext) {
        this.m_mouseOverText = mouseovertext;
    }

    /**
     * <p>getSuppressedUntil</p>
     *
     * @return a {@link java.util.Date} object.
     */

    public Date getSuppressedUntil() {
        return this.m_suppressedUntil;
    }

    /**
     * <p>setSuppressedUntil</p>
     *
     * @param suppresseduntil a {@link java.util.Date} object.
     */
    public void setSuppressedUntil(Date suppresseduntil) {
        this.m_suppressedUntil = suppresseduntil;
    }

    /**
     * <p>getSuppressedUser</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getSuppressedUser() {
        return this.m_suppressedUser;
    }

    /**
     * <p>setSuppressedUser</p>
     *
     * @param suppresseduser a {@link java.lang.String} object.
     */
    public void setSuppressedUser(String suppresseduser) {
        this.m_suppressedUser = suppresseduser;
    }

    /**
     * <p>getSuppressedTime</p>
     *
     * @return a {@link java.util.Date} object.
     */

    public Date getSuppressedTime() {
        return this.m_suppressedTime;
    }

    /**
     * <p>setSuppressedTime</p>
     *
     * @param suppressedtime a {@link java.util.Date} object.
     */
    public void setSuppressedTime(Date suppressedtime) {
        this.m_suppressedTime = suppressedtime;
    }

    /**
     * <p>getAlarmAckUser</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getAlarmAckUser() {
        return this.m_alarmAckUser;
    }

    /**
     * <p>setAlarmAckUser</p>
     *
     * @param alarmackuser a {@link java.lang.String} object.
     */
    public void setAlarmAckUser(String alarmackuser) {
        this.m_alarmAckUser = alarmackuser;
    }

    /**
     * <p>getAlarmAckTime</p>
     *
     * @return a {@link java.util.Date} object.
     */

    public Date getAlarmAckTime() {
        return this.m_alarmAckTime;
    }

    /**
     * <p>setAlarmAckTime</p>
     *
     * @param alarmacktime a {@link java.util.Date} object.
     */
    public void setAlarmAckTime(Date alarmacktime) {
        this.m_alarmAckTime = alarmacktime;
    }

    /**
     * <p>getClearKey</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getClearKey() {
        return this.m_clearKey;
    }

    /**
     * <p>setClearKey</p>
     *
     * @param clearKey a {@link java.lang.String} object.
     */
    public void setClearKey(String clearKey) {
        this.m_clearKey = clearKey;
    }

    /**
     * <p>getLastEvent</p>
     *
     * @return a {@link org.opennms.netmgt.model.OnmsEvent} object.
     */

    public OnmsEvent getLastEvent() {
        return this.m_lastEvent;
    }

    /**
     * <p>setLastEvent</p>
     *
     * @param event a {@link org.opennms.netmgt.model.OnmsEvent} object.
     */
    public void setLastEvent(OnmsEvent event) {
        this.m_lastEvent = event;
        if (event!=null) this.m_lastEventTime = event.getEventTime(); // alarm can be saved with no associated event
    }

    /**
     * <p>getEventParms</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getEventParms() {
        return this.m_eventParms;
    }

    /**
     * <p>setEventParms</p>
     *
     * @param eventparms a {@link java.lang.String} object.
     */
    public void setEventParms(String eventparms) {
        this.m_eventParms = eventparms;
    }

    /**
     * <p>getLastEventTime</p>
     *
     * @return a {@link java.util.Date} object.
     */

    public Date getLastEventTime() {
        return m_lastEventTime;
    }

    /**
     * <p>setLastEventTime</p>
     *
     * @param lastEventTime a {@link java.util.Date} object.
     */
    public void setLastEventTime(Date lastEventTime) {
        m_lastEventTime = lastEventTime;
    }
    
    /**
     * <p>getApplicationDN</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getApplicationDN() {
        return m_applicationDN;
    }

    /**
     * <p>setApplicationDN</p>
     *
     * @param applicationDN a {@link java.lang.String} object.
     */
    public void setApplicationDN(String applicationDN) {
        m_applicationDN = applicationDN;
    }

    /**
     * <p>getManagedObjectInstance</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getManagedObjectInstance() {
        return m_managedObjectInstance;
    }

    /**
     * <p>setManagedObjectInstance</p>
     *
     * @param managedObjectInstance a {@link java.lang.String} object.
     */
    public void setManagedObjectInstance(String managedObjectInstance) {
        m_managedObjectInstance = managedObjectInstance;
    }

    /**
     * <p>getManagedObjectType</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getManagedObjectType() {
        return m_managedObjectType;
    }

    /**
     * <p>setManagedObjectType</p>
     *
     * @param managedObjectType a {@link java.lang.String} object.
     */
    public void setManagedObjectType(String managedObjectType) {
        m_managedObjectType = managedObjectType;
    }

    /**
     * <p>getOssPrimaryKey</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getOssPrimaryKey() {
        return m_ossPrimaryKey;
    }
    
    /**
     * <p>setOssPrimaryKey</p>
     *
     * @param key a {@link java.lang.String} object.
     */
    public void setOssPrimaryKey(String key) {
        m_ossPrimaryKey = key;
    }
    
    /**
     * <p>getX733AlarmType</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getX733AlarmType() {
        return m_x733AlarmType;
    }
    
    /**
     * <p>setX733AlarmType</p>
     *
     * @param alarmType a {@link java.lang.String} object.
     */
    public void setX733AlarmType(String alarmType) {
        m_x733AlarmType = alarmType;
    }
    
    /**
     * <p>getX733ProbableCause</p>
     *
     * @return a int.
     */

    public int getX733ProbableCause() {
        return m_x733ProbableCause;
    }
    
    /**
     * <p>setX733ProbableCause</p>
     *
     * @param cause a int.
     */
    public void setX733ProbableCause(int cause) {
        m_x733ProbableCause = cause;
    }
    
    /**
     * <p>getQosAlarmState</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getQosAlarmState() {
        return m_qosAlarmState;
        
    }
    /**
     * <p>setQosAlarmState</p>
     *
     * @param alarmState a {@link java.lang.String} object.
     */
    public void setQosAlarmState(String alarmState) {
        m_qosAlarmState = alarmState;
    }

    /**
     * <p>getFirstAutomationTime</p>
     *
     * @return a {@link java.util.Date} object.
     */

    public Date getFirstAutomationTime() {
        return m_firstAutomationTime;
    }

    /**
     * <p>setFirstAutomationTime</p>
     *
     * @param firstAutomationTime a {@link java.util.Date} object.
     */
    public void setFirstAutomationTime(Date firstAutomationTime) {
        m_firstAutomationTime = firstAutomationTime;
    }

    /**
     * <p>getLastAutomationTime</p>
     *
     * @return a {@link java.util.Date} object.
     */

    public Date getLastAutomationTime() {
        return m_lastAutomationTime;
    }

    /**
     * <p>setLastAutomationTime</p>
     *
     * @param lastAutomationTime a {@link java.util.Date} object.
     */
    public void setLastAutomationTime(Date lastAutomationTime) {
        m_lastAutomationTime = lastAutomationTime;
    }
    
    /**
     * <p>getDetails</p>
     *
     * @return a {@link java.util.Map} object.
     */

    public Map<String, String> getDetails() {
        return m_details;
    }
    
    /**
     * <p>setDetails</p>
     *
     * @param alarmDetails a {@link java.util.Map} object.
     */
    public void setDetails(Map<String, String> alarmDetails) {
        m_details = alarmDetails;
    }

    /**
     * <p>getIfIndex</p>
     *
     * @return a {@link java.lang.Integer} object.
     */

    public Integer getIfIndex() {
        return m_ifIndex;
    }

    /**
     * <p>setIfIndex</p>
     *
     * @param ifIndex a {@link java.lang.Integer} object.
     */
    public void setIfIndex(Integer ifIndex) {
        m_ifIndex = ifIndex;
    }

    /** {@inheritDoc} */
    public void acknowledge(String user) {
        if (m_alarmAckTime == null || m_alarmAckUser == null) {
            m_alarmAckTime = Calendar.getInstance().getTime();
            m_alarmAckUser = user;
        }
    }
    
    /** {@inheritDoc} */
    public void unacknowledge(String ackUser) {
        m_alarmAckTime = null;
        m_alarmAckUser = null;
    }
    
    /** {@inheritDoc} */
    public void clear(String ackUser) {
        m_severity = OnmsSeverity.CLEARED;
    }
    
    /** {@inheritDoc} */
    public void escalate(String ackUser) {
        m_severity = OnmsSeverity.escalate(m_severity);
//        m_alarmAckUser = ackUser;
//        m_alarmAckTime = Calendar.getInstance().getTime();
    }

    /**
     * <p>getType</p>
     *
     * @return a {@link org.opennms.netmgt.model.AckType} object.
     */

    public AckType getType() {
        return AckType.ALARM;
    }
    
    /**
     * <p>getAckId</p>
     *
     * @return a {@link java.lang.Integer} object.
     */

    public Integer getAckId() {
        return m_id;
    }
    
    /**
     * <p>getAckUser</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getAckUser() {
        return m_alarmAckUser;
    }
    
    /**
     * <p>getAckTime</p>
     *
     * @return a {@link java.util.Date} object.
     */

    public Date getAckTime() {
        return m_alarmAckTime;
    }
    
}
