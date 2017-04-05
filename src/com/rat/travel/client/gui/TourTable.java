package com.rat.travel.client.gui;

import java.util.List;

import org.eclipse.jetty.io.nio.SelectorManager.SelectSet;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.view.client.CellPreviewEvent;
import com.rat.travel.client.ClientDictionaryCache;
import com.rat.travel.client.Travel;
import com.rat.travel.shared.Tour;

public class TourTable extends Composite{
	
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
	            	PopupPanel tourDetailsPopup = new PopupPanel(true);
	            	Tour t = new Tour(100, "Berlin", 4);
	            	TourDetails tourDetails = new TourDetails(t);
	            	tourDetailsPopup.add(tourDetails);
	            	tourDetailsPopup.center();
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
