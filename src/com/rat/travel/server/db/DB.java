package com.rat.travel.server.db;

import java.util.List;

import com.google.inject.Inject;
import com.rat.travel.server.db.mappers.TourMapper;
import com.rat.travel.shared.Tour;

public class DB implements DBInterface{
    
    @Inject
    private TourMapper tourMapper;
    
    
    public List<Tour> getToursList() {
        return tourMapper.getToursList();
    }
    
}
