package mainwindow;

import twitch.SavedTwitchStream;
import javafx.scene.control.ListCell;

public class SavedItemCell extends ListCell<SavedTwitchStream> {
	
	public SavedItemCell() {
		super();
	}
	
	@Override
	protected void updateItem(SavedTwitchStream item, boolean empty) {
		if (item==null || empty) {
			this.setText(null);
		} else {
			setItem(item);
			setText(item.getName());
		}
	}
}
