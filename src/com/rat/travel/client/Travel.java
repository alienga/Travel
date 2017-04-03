package com.rat.travel.client;

import java.util.HashMap;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.rat.travel.client.gui.MainPanel;
import com.rat.travel.client.gui.TourTable;
import com.rat.travel.shared.Country;
import com.rat.travel.shared.DictionaryCacheData;
import com.rat.travel.shared.Tour;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Travel implements EntryPoint {
	/**
	 * Create a remote service proxy to talk to the server-side Travel service.
	 */
	private final TravelServiceAsync travelService = GWT
			.create(TravelService.class);
	
	


	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {	
		final MainPanel mainPanel = new MainPanel();
		
	    travelService.loadDictionaryCache(new AsyncCallback<DictionaryCacheData>() {

			public void onFailure(Throwable caught) {
				   RootPanel.get().add(new Label("This is travel application. error"));
				
			}

			public void onSuccess(DictionaryCacheData result) {
				ClientDictionaryCache.init(result);
				
				 travelService.getToursList(new AsyncCallback<List<Tour>>() {
						
						public void onSuccess(List<Tour> result) {
							
							mainPanel.setData(result);
						}
						
						public void onFailure(Throwable caught) {
							 RootPanel.get().add(new Label("This is travel application. error"));
							
						}
					});
			}
		});
        
	    RootPanel.get().add(mainPanel);
	}
}
