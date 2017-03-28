package com.rat.travel.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.rat.travel.shared.Tour;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Travel implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Travel service.
	 */
	private final TravelServiceAsync travelService = GWT
			.create(TravelService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {	
	    final CellTable<Tour> dataTable = new CellTable<Tour>();
	      
	    TextColumn<Tour> idColumn = new TextColumn<Tour>() {
			
			@Override
			public String getValue(Tour object) {
				return String.valueOf(object.getId());
			}
	    };
	      
	    TextColumn<Tour> nameColumn = new TextColumn<Tour>() {
			
			@Override
			public String getValue(Tour object) {
				return object.getName();
			}
	    };
	    dataTable.addColumn(idColumn);
	    dataTable.addColumn(nameColumn);
	    
	    travelService.getToursList(new AsyncCallback<List<Tour>>() {
			
			public void onSuccess(List<Tour> result) {
				dataTable.setRowData(0, result);
				
			}
			
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
      
	    HorizontalPanel mainPanel = new HorizontalPanel();
	    mainPanel.add(dataTable);
	    
	    RootPanel.get().add(mainPanel);
	}
}
