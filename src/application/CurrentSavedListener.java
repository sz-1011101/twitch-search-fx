package application;

import mainwindow.SavedBox;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class CurrentSavedListener implements InvalidationListener {

	private SavedBox savedBox;
	
	public CurrentSavedListener(SavedBox savedBox) {
		this.savedBox = savedBox;
		savedBox.refresh();
	}
	
	@Override
	public void invalidated(Observable observable) {
		savedBox.refresh();
	}

	public SavedBox getSavedBox() {
		return savedBox;
	}
}