package com.zanclus.opennms.data.entities;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="events")
public class EventList {

	@Attribute(name="totalCount")
	private int totalCount ;

	@Attribute(name="count")
	private int count ;

	@ElementList(name="event", inline=true, required=false)
	private List<Event> event ;

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

	public List<Event> getEvent() {
		return event;
	}

	public void setEvent(List<Event> event) {
		this.event = event;
	}
}
