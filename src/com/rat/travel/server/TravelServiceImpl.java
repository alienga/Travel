package com.rat.travel.server;

import java.util.List;

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
}
