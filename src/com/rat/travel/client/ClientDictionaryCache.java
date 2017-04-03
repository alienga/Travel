package com.rat.travel.client;

import java.util.HashMap;

import com.rat.travel.shared.Country;
import com.rat.travel.shared.DictionaryCacheData;

public class ClientDictionaryCache {
	private static HashMap<Integer, Country> countriesHashMap;

	public static HashMap<Integer, Country> getCountriesHashMap() {
		return countriesHashMap;
	}

	public static void init(DictionaryCacheData dictionaryCacheData) {
		countriesHashMap = new HashMap<Integer, Country>();
		for (Country country : dictionaryCacheData.getCountriesList()) {
			countriesHashMap.put(country.getId(), country);
		}
	}
}
