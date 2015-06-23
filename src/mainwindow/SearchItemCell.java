package mainwindow;

import application.ObservableTwitchBrowser;
import qualityselector.QualitySelector;
import twitch.StreamInfo;
import twitch.TwitchStream;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SearchItemCell extends ListCell<TwitchStream> {

	private ObservableTwitchBrowser browser;

	private GridPane cellGrid = new GridPane();
	private Button executeButton = new Button();
	private Button saveButton = new Button();
	private Label cellNameLabel = new Label();

	public SearchItemCell() {
		super();

		setText(null); // Set normal text null, we use the label for that

		// TODO make this work...
		GridPane.setHalignment(cellNameLabel, HPos.LEFT);
		GridPane.setHalignment(executeButton, HPos.RIGHT);
		GridPane.setHalignment(saveButton, HPos.RIGHT);

		cellGrid.add(cellNameLabel, 0, 0);

		// This button opens the stream in a media player
		cellGrid.add(executeButton, 1, 0);
		executeButton.setText("open");
		executeButton.autosize();

		executeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Execute button pressed"); // Dummy action
				getItem().retrieveStreamData();
				StreamInfo info = getItem().getInfo();

				if (info != null) {
					openQualitySelector(info);
				}
			}
		});

		// This button saves the streams properties locally
		cellGrid.add(saveButton, 2, 0);
		saveButton.setText("save");
		saveButton.autosize();

		saveButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Save button pressed"); // Dummy action
				browser.addToSavedStreams(getItem());
			}

		});
	}

	@Override
	protected void updateItem(TwitchStream item, boolean empty) {
		if (empty || item == null) {
			cellNameLabel.setText(null);
			setGraphic(null);
		} else {
			String displayText = item.getName() + "\nViewers: "
					+ item.getViewers() + "\nGame: " + item.getGameName();
			cellNameLabel.setText(displayText);
			setGraphic(cellGrid);
		}
		this.setItem(item);
	}

	private void openQualitySelector(StreamInfo info) {
		Parent secondary = new QualitySelector();
		Stage selectorStage = new Stage();

		Scene scene = new Scene(secondary, 200, 200);
		selectorStage.setScene(scene);

		// give data to the QualitySelector
		((QualitySelector) secondary).passStreamInfo(info);
		selectorStage.setTitle("Select quality");
		selectorStage.show();
	}

	public void setTwitchBrowser(ObservableTwitchBrowser browser) {
		this.browser = browser;
	}

}
