package com.rat.travel.client.gui;

import java.util.List;

import org.eclipse.jetty.io.nio.SelectorManager.SelectSet;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.view.client.CellPreviewEvent;
import com.rat.travel.client.ClientDictionaryCache;
import com.rat.travel.client.Travel;
import com.rat.travel.client.TravelService;
import com.rat.travel.client.TravelServiceAsync;
import com.rat.travel.shared.Tour;

public class TourTable extends Composite{
	
	private final TravelServiceAsync travelService = GWT
			.create(TravelService.class);
	
	private CellTable<Tour> dataTable = new CellTable<Tour>();
     Integer selectedTourId = -1;
	
	public TourTable()
	{     
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
	    
	   
	    TextColumn<Tour> countryColumn = new TextColumn<Tour>() {
			
			@Override
			public String getValue(Tour object) {
				if (ClientDictionaryCache.getCountriesHashMap().containsKey(object.getCountryId()))
				{
					return ClientDictionaryCache.getCountriesHashMap().get(object.getCountryId()).getName();
				}
					
				else
					return"";
			}
	    };
	    
	    
	    
	    dataTable.addCellPreviewHandler(new CellPreviewEvent.Handler<Tour>() {
	    // this is to handle row id
	            public void onCellPreview(final CellPreviewEvent<Tour> event) {

	                if (BrowserEvents.CLICK.equalsIgnoreCase(event.getNativeEvent().getType())) {
	                    selectedTourId = event.getValue().getId();
	                }
	            }
	        });

	    // because Doubleclick handler doesn't give row index or column index we will use addCellPreviewHandler to return row index or column index.
	    dataTable.addDomHandler(new DoubleClickHandler() {

	            public void onDoubleClick(final DoubleClickEvent event) {
	            	final PopupPanel tourDetailsPopup = new PopupPanel(true);
	            	travelService.getTourById(selectedTourId, new AsyncCallback<Tour>() {

						public void onFailure(Throwable caught) {
							 RootPanel.get().add(new Label("This is travel application. error"));
							
						}

						public void onSuccess(Tour result) {
							TourDetails tourDetails = new TourDetails(result);
			            	tourDetailsPopup.add(tourDetails);
			            	tourDetailsPopup.center();
							
						}
					});
	            	
	            }
	        }, DoubleClickEvent.getType());
	    
	    dataTable.addColumn(idColumn);
	    dataTable.addColumn(nameColumn);
	    dataTable.addColumn(countryColumn);
	   
	    
	    initWidget(dataTable);

	}
	
	public void setData(List<Tour> toursList){
		dataTable.setRowData(0, toursList);
	}

}
