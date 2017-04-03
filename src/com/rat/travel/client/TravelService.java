package com.rat.travel.client;

import java.util.List;



import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.rat.travel.shared.Country;
import com.rat.travel.shared.DictionaryCacheData;
import com.rat.travel.shared.Tour;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("travel")
public interface TravelService extends RemoteService {

	public List<Tour> getToursList();
	public Country getCountryById(int id);
	public List<Country> getCountriesList();
	public DictionaryCacheData loadDictionaryCache();
}
