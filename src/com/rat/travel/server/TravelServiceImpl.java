package com.rat.travel.server;

import java.util.ArrayList;
import java.util.List;

import com.rat.travel.client.TravelService;
import com.rat.travel.shared.FieldVerifier;
import com.rat.travel.shared.Tour;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class TravelServiceImpl extends RemoteServiceServlet implements
		TravelService{


	public List<Tour> getToursList() {
		
//		List<Tour> data = new ArrayList<Tour>();
//		data.add(new Tour(10, "Murmansk"));
//		data.add(new Tour(20, "Kalmykiya"));
//		data.add(new Tour(30, "Hosta"));
		
		//return data;
		return Server.getDb().getToursList();
	}
}
