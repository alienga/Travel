package com.rat.travel.client.gui;

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
import com.rat.travel.shared.Tour;

public class TourDetails extends Composite {
	private VerticalPanel mainWidget = new VerticalPanel();
	private TextBox nameTextBox = new TextBox();
	private Label idLabel = new Label();
	private Tour tour = null;

	private void setData(Tour tour) {
		idLabel.setText(String.valueOf(tour.getId()));
		nameTextBox.setText(tour.getName());
	}

	private Tour getData() {
		Tour newTour = new Tour();
		newTour.setName(nameTextBox.getText());
		return newTour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	public TourDetails(final Tour t, final Command closeCommand) {
		setTour(t);
		
		mainWidget.add(idLabel);
		mainWidget.add(nameTextBox);
		
		Button saveBtn = new Button("Save");

		if (tour == null) {
			saveBtn.addClickHandler(new ClickHandler() {

				public void onClick(ClickEvent event) {

					tour = getData();
					Travel.getTravelservice().createTour(tour,
							new AsyncCallback<Tour>() {

								public void onFailure(Throwable caught) {
									RootPanel
											.get()
											.add(new Label(
													"This is travel application. error"));

								}

								public void onSuccess(Tour result) {

									if (closeCommand != null) {
										closeCommand.execute();
									}

								}
							});

				}
			});

		} else {
			saveBtn.addClickHandler(new ClickHandler() {

				public void onClick(ClickEvent event) {
					tour = getData();
					tour.setId(t.getId());
					Travel.getTravelservice().updateTour(tour,
							new AsyncCallback<Void>() {

								public void onSuccess(Void result) {

									if (closeCommand != null) {
										closeCommand.execute();
									}
								}

								public void onFailure(Throwable caught) {
									RootPanel
											.get()
											.add(new Label(
													"This is travel application. error"));
								}
							});
				}
			});
			
			Button deleteButton = new Button("Delete", new ClickHandler() {
				
				public void onClick(ClickEvent event) {
					Travel.getTravelservice().deleteTour(t.getId(), new AsyncCallback<Void>() {

						public void onFailure(Throwable caught) {
							
							RootPanel
							.get()
							.add(new Label(
									"This is travel application. error"));
							
						}

						public void onSuccess(Void result) {
							RootPanel
							.get()
							.add(new Label(
									"onSuccess"));
							if (closeCommand != null) {
								
								closeCommand.execute();
							}
							
						}
					});
					
				}
			});
			mainWidget.add(deleteButton);
			setData(tour);
		}

		Button closeBtn = new Button("Close", new ClickHandler() {

			public void onClick(ClickEvent event) {

				if (closeCommand != null) {
					closeCommand.execute();
				}
			}
		});
		mainWidget.add(saveBtn);
		mainWidget.add(closeBtn);
		initWidget(mainWidget);
	}
}
