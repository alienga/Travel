package com.rat.travel.server.db;

import java.util.List;

import com.rat.travel.shared.Country;
import com.rat.travel.shared.Tour;

public interface DBInterface {
    public List<Tour> getToursList();
    
    public Country getCountryById(int id);
    
    public List<Country> getCountriesList();
    
    public void updateTour(int id, String name);
}
