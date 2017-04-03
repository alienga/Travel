package com.rat.travel.shared;

import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class DictionaryCacheData implements IsSerializable {

	private  List<Country> countriesList;
	

	public  List<Country> getCountriesList() {
		return countriesList;
	}


	public void setCountriesList(List<Country> countriesList) {
		this.countriesList = countriesList;
	}
	
	

}
