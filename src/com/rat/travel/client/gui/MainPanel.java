package com.rat.travel.client.gui;

import java.util.List;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.rat.travel.shared.Tour;

public class MainPanel extends Composite {

	private VerticalPanel mainWidget = new VerticalPanel();
	TourTable tourTable = new TourTable();

	public MainPanel() {
		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.add(new Button("Добавить"));
		buttonPanel.add(new Button("Удалить"));

		mainWidget.add(tourTable);
		mainWidget.add(buttonPanel);

		initWidget(mainWidget);
	}

	public void setData(List<Tour> toursList) {
		tourTable.setData(toursList);
	}

}
