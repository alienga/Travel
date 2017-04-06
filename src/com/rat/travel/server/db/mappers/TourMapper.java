package com.rat.travel.server.db.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rat.travel.shared.Tour;

public interface TourMapper {
	public List<Tour> getToursList();
	//public void updateTour(int id, String name);
	//public void updateTour(@Param("id") int id, @Param("name") String name);
	public void updateTour(Tour tour);
	public Tour getTourById(int id);
	public Tour createTour(Tour tour);

}
