package com.zanclus.opennms.data.entities;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="outages")
public class OutageList {

	@Attribute(name="totalCount")
	private int totalCount ;

	@Attribute(name="count")
	private int count ;

	@ElementList(name="outages")
	private List<Outage> outages = new ArrayList<Outage>() ;

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

	public List<Outage> getOutages() {
		return outages;
	}

	public void setOutages(List<Outage> outages) {
		this.outages = outages;
	}
}
