package com.zanclus.opennms.data.entities;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="alarms")
public class AlarmList {

	@Attribute(name="totalCount")
	private int totalCount ;

	@Attribute(name="count")
	private int count ;

	@ElementList(name="alarm")
	private List<Alarm> alarms = new ArrayList<Alarm>() ;

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

	public List<Alarm> getAlarms() {
		return alarms;
	}

	public void setAlarms(List<Alarm> alarms) {
		this.alarms = alarms;
	}
}
