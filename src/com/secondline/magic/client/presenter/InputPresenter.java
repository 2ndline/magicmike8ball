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
import com.secondline.magic.client.InputView;
import com.secondline.magic.shared.Quote;

public class InputPresenter {
	private InputView view;
	PopupPanel popup;
	ResizeLayoutPanel popupContainer = new ResizeLayoutPanel();

	public InputPresenter(InputView v) {
		this.view = v;

		view.getGenerateButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// Get disaster and other fields

				popup = new PopupPanel(false, false);
				popup.setWidget(popupContainer);

				HTMLPanel container = new HTMLPanel("");
				Button cancel = new Button("Try again");
				container.add(cancel);

				cancel.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						popup.hide();
					}
				});

				popupContainer.clear();
				popupContainer.add(container);
				Quote quote = Quote.getRandomQuote();

				ScrollPanel scrollContainer = new ScrollPanel();
				container.add(scrollContainer);
				HTMLPanel scriptPanel = new HTMLPanel("");
				Label script = new Label(quote.getText());
				scriptPanel.add(script);
				scrollContainer.add(scriptPanel);
				// Todo: set script
				Audio clip = Audio.createIfSupported();
				if(clip != null){
					clip.addSource("/"+quote.getSource());
				}
				script.getElement().getStyle().setColor("white");
				Window.addResizeHandler(new ResizeHandler() {

					@Override
					public void onResize(ResizeEvent event) {
						resize();
					}
				});
				resize();
				clip.play();
			}

		});
	}

	protected void resize() {
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				int windowWidth = Window.getClientWidth();
				int windowHeight = Window.getClientHeight();

				int width = (windowWidth - 25);
				int height = (windowHeight - 25);
				popupContainer.setWidth("" + width + "px");
				popupContainer.setHeight("" + height + "px");

				popup.center();

			}
		});
	}
}
