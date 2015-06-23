package mainwindow;

import java.net.URL;
import java.util.ResourceBundle;

import twitch.SavedStreams;
import twitch.SavedTwitchStream;
import application.ObservableTwitchBrowser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class SavedBox extends VBox implements Initializable {

	private ObservableTwitchBrowser browser;

	@FXML
	private ListView<SavedTwitchStream> savedListView;

	private ObservableList<SavedTwitchStream> list = FXCollections
			.observableArrayList();

	public SavedBox() {
		Utility.loadFXMLasRoot("saved_box.fxml", this);
	}

	public void setTwitchBrowser(ObservableTwitchBrowser browser) {
		this.browser = browser;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		savedListView
				.setCellFactory(new Callback<ListView<SavedTwitchStream>, ListCell<SavedTwitchStream>>() {

					@Override
					public ListCell<SavedTwitchStream> call(
							ListView<SavedTwitchStream> param) {
						return new SavedItemCell();
					}

				});
		savedListView.setItems(list);
	}

	public void refresh() {
		list.clear();

		SavedStreams streams = browser.getCurrentSavedStreams();
		if (streams != null && streams.getStreams() != null) {
			list.addAll(streams.getStreams());
		}
	}
}
