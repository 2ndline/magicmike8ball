package com.secondline.magic.client.presenter;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.media.client.Audio;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ResizeLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.secondline.magic.client.InputView;
import com.secondline.magic.shared.Quote;

public class InputPresenter {
	private InputView view;

	Audio clip;
	public InputPresenter(InputView v) {
		this.view = v;

		view.getGenerateButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				regenerate();
			}

		});
	}

	private void regenerate() {
		// Get disaster and other fields

		HTMLPanel container = view.getContainer();
		
		container.clear();
		Button cancel = new Button("Try again");

		cancel.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				clip.pause();
				regenerate();
			}
		});

		Quote quote = Quote.getRandomQuote();

		HTMLPanel ball = new HTMLPanel("");
		ball.setStyleName("eball");
		HTMLPanel grad = new HTMLPanel("");
		grad.setStyleName("egrad");
		HTMLPanel win = new HTMLPanel("");
		win.setStyleName("ewin");
		HTMLPanel triangle = new HTMLPanel("");
		triangle.setStyleName("triangle");

		ScrollPanel scrollContainer = new ScrollPanel();
		container.add(scrollContainer);
		scrollContainer.addStyleName("ballcontainer");
		HTMLPanel scriptPanel = new HTMLPanel("");
		scriptPanel.add(ball);
		ball.add(grad);
		ball.add(win);
		ball.add(triangle);

		Label script = new Label(quote.getText());
		script.setStyleName("balltext");
		ball.add(script);
		scrollContainer.add(scriptPanel);
		scriptPanel.add(cancel);
		// Todo: set script
		clip = Audio.createIfSupported();
		if (clip != null) {
			clip.addSource("/" + quote.getSource());
		}
		script.getElement().getStyle().setColor("white");
		
		clip.play();

	}

}
