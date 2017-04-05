package com.rat.travel.server.db.mappers;

import java.util.List;

import com.rat.travel.shared.Country;
import com.rat.travel.shared.Tour;

public interface CountryMapper {
	public Country getCountryById(int id);
	public List<Country> getCountriesList();
}
