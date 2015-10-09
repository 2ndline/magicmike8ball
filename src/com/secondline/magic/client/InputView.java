package com.secondline.magic.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.secondline.magic.client.presenter.InputPresenter;

public class InputView extends Composite{

	VerticalPanel container = new VerticalPanel();
	List<TextBox> inputs = new ArrayList<TextBox>();
	Button generateButton = new Button("Generate excuse!");
	
	
	InputPresenter presenter;
	public InputView(){
		initWidget(container);
		presenter = new InputPresenter(this);
		Label title = new Label("I WAS THERE!");
		Label instruction = new Label("Select a major historical event that you were totally there for. We'll come up with your story.");
		
		container.add(title);
		container.add(instruction);
	
		
		container.add(generateButton);
	}
	
	public Button getGenerateButton(){
		return generateButton;
	}
	
}
