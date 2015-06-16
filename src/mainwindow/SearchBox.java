package mainwindow;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import twitch.TwitchStream;
import application.TwitchBrowser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class SearchBox extends VBox implements Initializable {

	private ObservableList<TwitchStream> list = FXCollections
			.observableArrayList();

	@FXML
	private ListView<TwitchStream> searchListView;

	@FXML
	private TextField searchTextField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// searchListView shall use the SearchItemCell to populate the listVIew
		searchListView
				.setCellFactory(new Callback<ListView<TwitchStream>, ListCell<TwitchStream>>() {

					@Override
					public ListCell<TwitchStream> call(
							ListView<TwitchStream> param) {
						return new SearchItemCell();
					}

				});

		searchListView.setItems(list);
	}

	public SearchBox() {
		Utility.loadFXMLasRoot("search_box.fxml", this);
	}

	/**
	 * Handles key inputs done by user in the searchTextField
	 * 
	 * @param event
	 *            key event when typing
	 */
	@FXML
	private void handleSearchFieldKeyPressed(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			TwitchBrowser twitchBrowser = new TwitchBrowser();
			ArrayList<TwitchStream> searchResult = twitchBrowser
					.searchTerm(searchTextField.getText());

			list.clear();
			if (searchResult != null) {
				list.addAll(searchResult);
			}

		}
	}
}
