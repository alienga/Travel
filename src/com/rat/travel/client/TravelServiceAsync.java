package com.rat.travel.client;

import java.util.List;



import com.google.gwt.user.client.rpc.AsyncCallback;
import com.rat.travel.shared.Country;
import com.rat.travel.shared.DictionaryCacheData;
import com.rat.travel.shared.Tour;

/**
 * The async counterpart of <code>TravelService</code>.
 */
public interface TravelServiceAsync {

	void getToursList(AsyncCallback< List<Tour>> callback);
	void getCountryById(int id, AsyncCallback< Country> callback);
	void getCountriesList(AsyncCallback<List<Country>>callback);
	void loadDictionaryCache(AsyncCallback<DictionaryCacheData> callback);
	void updateTour(Tour tour, AsyncCallback<Void> callback);
	void getTourById(int id, AsyncCallback<Tour> callback);
	void createTour(Tour tour, AsyncCallback<Tour> callback);
	void deleteTour(int id, AsyncCallback<Void> callback);
}
