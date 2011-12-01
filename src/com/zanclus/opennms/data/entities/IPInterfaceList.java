package com.zanclus.opennms.data.entities;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="ipInterfaces")
public class IPInterfaceList {

	@ElementList(name="ipInterfaces", inline=true, required=false)
	private List<IPInterface> ipInterfaces = new ArrayList<IPInterface>() ;

	@SuppressWarnings("unused")
	@Attribute(name="totalCount")
	private int totalCount ;

	@SuppressWarnings("unused")
	@Attribute(name="count")
	private int count ;

	public IPInterfaceList() {
		super() ;
	}

	public int getTotalCount() {
		return ipInterfaces.size() ;
	}

	public int getCount() {
		return ipInterfaces.size() ;
	}

	public List<IPInterface> getIPInterfaces() {
		return ipInterfaces;
	}

	public void setIPInterfaces(List<IPInterface> ipInterfaces) {
		this.ipInterfaces = ipInterfaces;
	}

	public void addIPInterface(IPInterface ipInterface) {
		this.ipInterfaces.add(ipInterface) ;
	}
}
