package com.secondline.magic.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.secondline.magic.client.presenter.InputPresenter;

public class InputView extends Composite{

	HTMLPanel container = new HTMLPanel("");
	Button generateButton = new Button("GET IT!");
	
	
	InputPresenter presenter;
	public InputView(){
		initWidget(container);
		presenter = new InputPresenter(this);	
		container.setHeight("100%");
		container.setWidth("100%");
		container.add(generateButton);
		generateButton.addStyleName("generatebutton");
		//container.setStyleName("matt");
	}
	
	public Button getGenerateButton(){
		return generateButton;
	}
	
	public HTMLPanel getContainer(){
		return this.container;
	}
	
}
