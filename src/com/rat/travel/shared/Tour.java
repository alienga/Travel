package com.rat.travel.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Tour implements IsSerializable{
	
	private Integer id;
	private String name;
	private Integer countryId;
	private Country country;
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Tour() {
		super();
	}
	
	public Tour(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Tour(Integer id, String name, Integer countryId) {
		super();
		this.id = id;
		this.name = name;
		this.countryId = countryId;
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
	
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		s.append("id=");
		if (id!=null) s.append(id +"; ");
		else  s.append("null; ");
		s.append("name=" + name + "; ");
		return s.toString();
	}
	
}
