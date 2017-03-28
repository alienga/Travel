package com.rat.travel.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.rat.travel.shared.Tour;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("travel")
public interface TravelService extends RemoteService {

	public List<Tour> getToursList();
}
