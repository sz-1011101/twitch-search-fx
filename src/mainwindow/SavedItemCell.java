package mainwindow;

import twitch.SavedTwitchStream;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;

public class SavedItemCell extends ListCell<SavedTwitchStream> {

	private GridPane gridPane = new GridPane();
	private Label statusLabel = new Label();

	public SavedItemCell() {
		super();
		this.setText(null); // Use statusLabel for displaying
		gridPane.add(statusLabel, 0, 0);
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
}
