package com.rat.travel.server.db;

import java.util.List;

import com.google.inject.Inject;
import com.rat.travel.server.db.mappers.CountryMapper;
import com.rat.travel.server.db.mappers.TourMapper;
import com.rat.travel.shared.Country;
import com.rat.travel.shared.Tour;

public class DB implements DBInterface{
    
    @Inject
    private TourMapper tourMapper;
    
    @Inject
    private CountryMapper countryMapper;
    
    
    public List<Tour> getToursList() {
    	
    	List<Tour> tours = tourMapper.getToursList();
        return tours;
    }
    
    public Country getCountryById(int id)
    {
    	return countryMapper.getCountryById(id);
    }
    
    public List<Country> getCountriesList()
    {
    	return countryMapper.getCountriesList();
    }
    
    public void updateTour(int id, String name)
    {
    	tourMapper.updateTour(id, name);
    }
    
}
