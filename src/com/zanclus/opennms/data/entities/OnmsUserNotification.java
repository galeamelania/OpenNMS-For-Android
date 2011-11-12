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
import java.util.Date;

/**
 * <p>OnmsUserNotification class.</p>
 */

public class OnmsUserNotification implements Serializable {

    private static final long serialVersionUID = -1750912427062821742L;
    
    private Integer m_id;
    
    /** identifier field */
    private String m_userId;

    /** identifier field */
    private Date m_notifyTime;

    /** identifier field */
    private String m_media;

    /** identifier field */
    private String m_contactInfo;

    /** identifier field */
    private String m_autoNotify;

    /** persistent field */
    private OnmsNotification m_notification;

    /**
     * full constructor
     *
     * @param userId a {@link java.lang.String} object.
     * @param notifyTime a {@link java.util.Date} object.
     * @param media a {@link java.lang.String} object.
     * @param contactInfo a {@link java.lang.String} object.
     * @param autoNotify a {@link java.lang.String} object.
     * @param notification a {@link org.opennms.netmgt.model.OnmsNotification} object.
     * @param id a {@link java.lang.Integer} object.
     */
    public OnmsUserNotification(String userId, Date notifyTime, String media, String contactInfo, String autoNotify, OnmsNotification notification, Integer id) {
        m_userId = userId;
        m_notifyTime = notifyTime;
        m_media = media;
        m_contactInfo = contactInfo;
        m_autoNotify = autoNotify;
        m_notification = notification;
        m_id = id;
    }

    /**
     * default constructor
     */
    public OnmsUserNotification() {
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
     * <p>getUserId</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getUserId() {
        return m_userId;
    }

    /**
     * <p>setUserId</p>
     *
     * @param userId a {@link java.lang.String} object.
     */
    public void setUserId(String userId) {
        m_userId = userId;
    }

    /**
     * <p>getNotifyTime</p>
     *
     * @return a {@link java.util.Date} object.
     */

    public Date getNotifyTime() {
        return m_notifyTime;
    }

    /**
     * <p>setNotifyTime</p>
     *
     * @param notifyTime a {@link java.util.Date} object.
     */
    public void setNotifyTime(Date notifyTime) {
        m_notifyTime = notifyTime;
    }

    /**
     * <p>getMedia</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getMedia() {
        return m_media;
    }

    /**
     * <p>setMedia</p>
     *
     * @param media a {@link java.lang.String} object.
     */
    public void setMedia(String media) {
        m_media = media;
    }

    /**
     * <p>getContactInfo</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getContactInfo() {
        return m_contactInfo;
    }

    /**
     * <p>setContactInfo</p>
     *
     * @param contactInfo a {@link java.lang.String} object.
     */
    public void setContactInfo(String contactInfo) {
        m_contactInfo = contactInfo;
    }

    /**
     * <p>getAutoNotify</p>
     *
     * @return a {@link java.lang.String} object.
     */

    public String getAutoNotify() {
        return m_autoNotify;
    }

    /**
     * <p>setAutoNotify</p>
     *
     * @param autoNotify a {@link java.lang.String} object.
     */
    public void setAutoNotify(String autoNotify) {
        m_autoNotify = autoNotify;
    }

    /**
     * <p>getNotification</p>
     *
     * @return a {@link org.opennms.netmgt.model.OnmsNotification} object.
     */

    public OnmsNotification getNotification() {
        return m_notification;
    }

    /**
     * <p>setNotification</p>
     *
     * @param notification a {@link org.opennms.netmgt.model.OnmsNotification} object.
     */
    public void setNotification(OnmsNotification notification) {
        m_notification = notification;
    }
}
