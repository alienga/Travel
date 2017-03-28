package com.rat.travel.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.rat.travel.shared.Tour;

/**
 * The async counterpart of <code>TravelService</code>.
 */
public interface TravelServiceAsync {

	void getToursList(AsyncCallback< List<Tour>> callback);
}