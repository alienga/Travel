package com.rat.travel.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Country implements IsSerializable{
	private Integer id;
	private String name;
	
	public Country() {
		super();
	}
	
	public Country(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
