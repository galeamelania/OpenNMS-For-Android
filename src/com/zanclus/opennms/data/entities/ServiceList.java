package com.zanclus.opennms.data.entities;

import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="services")
public class ServiceList {

	@ElementList(name="service", inline=true)
	private List<Service> service ;

	public List<Service> getService() {
		return service;
	}

	public void setService(List<Service> service) {
		this.service = service;
	}
}
