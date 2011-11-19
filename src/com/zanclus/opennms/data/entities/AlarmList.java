package com.zanclus.opennms.data.entities;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="alarms")
public class AlarmList {

	@ElementList(name="alarm", inline=true)
	private List<Alarm> alarms = new ArrayList<Alarm>() ;

	@SuppressWarnings("unused")
	@Attribute(name="totalCount")
	private int totalCount ;

	@SuppressWarnings("unused")
	@Attribute(name="count")
	private int count ;

	public AlarmList() {
		super() ;
	}

	public int getTotalCount() {
		return alarms.size() ;
	}

	public int getCount() {
		return alarms.size() ;
	}

	public List<Alarm> getAlarms() {
		return alarms;
	}

	public void setAlarms(List<Alarm> alarms) {
		this.alarms = alarms;
	}

	public void addAlarm(Alarm alarm) {
		this.alarms.add(alarm) ;
	}
}
