package com.secondline.magic.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Magicmike implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		InputView mainView = new InputView();
		RootPanel.get("container").add(mainView);
	}
}