package mainwindow;

import java.net.URL;
import java.util.ResourceBundle;

import twitch.TwitchStream;
import application.ObservableTwitchBrowser;
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

	private ObservableTwitchBrowser browser;

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
						SearchItemCell cell = new SearchItemCell();
						cell.setTwitchBrowser(browser);
						return cell;
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
			browser.searchTerm(searchTextField.getText());

			list.clear();
			if (browser.getCurrentSearchResults() != null) {
				list.addAll(browser.getCurrentSearchResults());
			}

		}
	}

	public void setTwitchBrowser(ObservableTwitchBrowser browser) {
		this.browser = browser;
	}
}
