package com.rat.travel.server.db.mappers;

import java.util.List;

import com.rat.travel.shared.Tour;

public interface TourMapper {
	public List<Tour> getToursList();
	public void updateTour(int id, String name);
	public Tour getTourById(int id);

}
