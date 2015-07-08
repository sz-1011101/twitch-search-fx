package mainwindow;

import twitch.SavedStreams;
import twitch.SavedTwitchStream;

import application.ObservableTwitchBrowser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;

public class SavedItemCell extends ListCell<SavedTwitchStream> {

	private ObservableTwitchBrowser browser;
	
	private GridPane gridPane = new GridPane();
	private Label statusLabel = new Label();
	private Button deleteButton = new Button();
	
	public SavedItemCell() {
		super();
		this.setText(null); // Use statusLabel for displaying
		gridPane.add(statusLabel, 0, 0);
		gridPane.add(deleteButton, 1, 0);
		
		deleteButton.setText("Delete");
		deleteButton.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Saved Stream deleteButton pressed!");
				SavedStreams savedStreams = browser.getCurrentSavedStreams();
				if (savedStreams.containsSavedStream(getItem())) {
					savedStreams.removeSavedStream(getItem());
					browser.notifyInvalidated();
				}
			}
			
		});
	}

	@Override
	protected void updateItem(SavedTwitchStream item, boolean empty) {
		if (item == null || empty) {
			statusLabel.setText(null);
		} else {
			setItem(item);
			statusLabel.setText(item.getName());
			setGraphic(gridPane);
		}
	}
	
	public void setTwitchBrowser(ObservableTwitchBrowser browser) {
		this.browser = browser;
	}
}
