package com.rat.travel.client.gui;

import java.util.List;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.rat.travel.client.ClientDictionaryCache;
import com.rat.travel.client.Travel;
import com.rat.travel.shared.Tour;

public class TourTable extends Composite{
	
	private CellTable<Tour> dataTable = new CellTable<Tour>();
	
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
	    dataTable.addColumn(idColumn);
	    dataTable.addColumn(nameColumn);
	    dataTable.addColumn(countryColumn);
	    
	    initWidget(dataTable);

	}
	
	public void setData(List<Tour> toursList){
		dataTable.setRowData(0, toursList);
	}

}
