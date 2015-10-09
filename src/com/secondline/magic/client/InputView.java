package com.secondline.magic.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.secondline.magic.client.presenter.InputPresenter;

public class InputView extends Composite{

	VerticalPanel container = new VerticalPanel();
	Button generateButton = new Button("GET IT!");
	
	
	InputPresenter presenter;
	public InputView(){
		initWidget(container);
		presenter = new InputPresenter(this);	
		
		container.add(generateButton);
	}
	
	public Button getGenerateButton(){
		return generateButton;
	}
	
}
