package mainwindow;

import twitch.TwitchStream;
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
		setText(null); //Set normal text null, we use the label for that
		
		//TODO make this work...
		GridPane.setHalignment(cellNameLabel, HPos.LEFT);
		GridPane.setHalignment(executeButton, HPos.RIGHT);
		GridPane.setHalignment(saveButton, HPos.RIGHT);
		
		cellGrid.add(cellNameLabel, 0, 0);

		cellGrid.add(executeButton, 1, 0);		
		executeButton.setText("open");
		executeButton.autosize();
		
		cellGrid.add(saveButton, 2, 0);
		saveButton.setText("save");
		saveButton.autosize();
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
