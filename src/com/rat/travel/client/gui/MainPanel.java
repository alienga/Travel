package com.rat.travel.client.gui;

import java.util.List;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.rat.travel.client.Travel;
import com.rat.travel.shared.Tour;

public class MainPanel extends Composite {

	private VerticalPanel mainWidget = new VerticalPanel();
	private TourTable tourTable;

	public MainPanel() {
		Command refreshCommand = new Command() {
			
			public void execute() {
				loadData();
				
			}
		};
		tourTable = new TourTable(refreshCommand);
		
		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.add(new Button("Добавить"));
		buttonPanel.add(new Button("Удалить"));

		mainWidget.add(tourTable);
		mainWidget.add(buttonPanel);

		initWidget(mainWidget);
	}

	public void loadData() {
		Travel.getTravelservice().getToursList(new AsyncCallback<List<Tour>>() {

			public void onSuccess(List<Tour> result) {

				setData(result);
			}

			public void onFailure(Throwable caught) {
				RootPanel.get().add(
						new Label("This is travel application. error"));

			}
		});
	}

	public void setData(List<Tour> toursList) {
		tourTable.setData(toursList);
	}

}
