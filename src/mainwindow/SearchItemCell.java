package mainwindow;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;

public class SearchItemCell extends ListCell<String> {

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
		executeButton.setText(">");

		cellGrid.add(saveButton, 2, 0);
		executeButton.setText("s");
	}

	@Override
	protected void updateItem(String item, boolean empty) {
		if (empty || item == null) {
			cellNameLabel.setText(null);
			setGraphic(null);
		} else {
			cellNameLabel.setText(item);
			setGraphic(cellGrid);
		}
	}
}
