package mainwindow;

import twitch.TwitchStream;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;

public class SearchItemCell extends ListCell<TwitchStream> {

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
				System.out.println("Execute button pressed"); //Dummy action
			}

		});

		// This button saves the streams properties locally
		cellGrid.add(saveButton, 2, 0);
		saveButton.setText("save");
		saveButton.autosize();
		
		saveButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Save button pressed"); //Dummy action
			}

		});
	}

	@Override
	protected void updateItem(TwitchStream item, boolean empty) {
		if (empty || item == null) {
			cellNameLabel.setText(null);
			setGraphic(null);
		} else {
			cellNameLabel.setText(item.getName());
			setGraphic(cellGrid);
		}
	}
}
