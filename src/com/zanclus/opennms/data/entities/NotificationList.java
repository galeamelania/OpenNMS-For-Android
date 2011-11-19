package com.zanclus.opennms.data.entities;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="notifications")
public class NotificationList {

	@Attribute(name="totalCount")
	private int totalCount ;

	@Attribute(name="count")
	private int count ;

	@ElementList(name="notification", inline=true)
	private List<Notification> notification ;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Notification> getNotifications() {
		return notification;
	}

	public void setNotifications(List<Notification> event) {
		this.notification = event;
	}
}
