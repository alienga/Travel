package com.rat.travel.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.rat.travel.client.Travel;
import com.rat.travel.client.TravelService;
import com.rat.travel.client.TravelServiceAsync;
import com.rat.travel.shared.Tour;

public class TourDetails extends Composite{
	private VerticalPanel mainWidget = new VerticalPanel();
	private TextBox nameTextBox = new TextBox();
	
	public TourDetails(final Tour tour, final Command closeCommand)
	{
		mainWidget.add(new Label(String.valueOf(tour.getId())));
		
		nameTextBox.setText(tour.getName());
		mainWidget.add(nameTextBox);
		Button saveBtn = new Button("Save");
		saveBtn.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				String newName = nameTextBox.getText();
				tour.setName(newName);
				Travel.getTravelservice().updateTour(tour, new AsyncCallback<Void>() {
					
					public void onSuccess(Void result) {
							
						 if (closeCommand != null)
						 {
							 closeCommand.execute();
						 }
					}
					
					public void onFailure(Throwable caught) {
						 RootPanel.get().add(new Label("This is travel application. error"));						
					}
				});
				
			}
		});
		mainWidget.add(saveBtn);
		initWidget(mainWidget);
		
	}
}
