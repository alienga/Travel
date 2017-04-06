package com.rat.travel.server;

import java.util.List;

import com.rat.travel.shared.DictionaryCacheData;
import com.rat.travel.client.TravelService;
import com.rat.travel.shared.Country;
import com.rat.travel.shared.Tour;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class TravelServiceImpl extends RemoteServiceServlet implements
		TravelService{


	public List<Tour> getToursList() {
		return Server.getDb().getToursList();
	}
	
	public Country getCountryById(int id){
		return Server.getDb().getCountryById(id);
	}
	
	public List<Country> getCountriesList()
	{
		return Server.getDb().getCountriesList();
	}

	public DictionaryCacheData loadDictionaryCache() {
		DictionaryCacheData dictionaryCacheData  = new DictionaryCacheData();
		dictionaryCacheData.setCountriesList(Server.getDb().getCountriesList());
		return dictionaryCacheData;
	}

	public void updateTour(Tour tour) {
		Server.getDb().updateTour(tour);
	}
	
	public Tour getTourById(int id)
	{
		return Server.getDb().getTourById(id);
	}
}
