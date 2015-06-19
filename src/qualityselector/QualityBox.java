package qualityselector;

import java.net.URL;
import java.util.ResourceBundle;

import mainwindow.Utility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import twitch.StreamInfo;
import twitch.StreamInfo.StreamQuality;

public class QualityBox extends VBox implements Initializable {

	private ObservableList<StreamQuality> list = FXCollections
			.observableArrayList();

	@FXML
	private ListView<StreamQuality> qualityListView;

	public QualityBox() {
		Utility.loadFXMLasRoot("quality_box.fxml", this);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		qualityListView
				.setCellFactory(new Callback<ListView<StreamQuality>, ListCell<StreamQuality>>() {

					@Override
					public ListCell<StreamQuality> call(
							ListView<StreamQuality> param) {
						return new QualityItemCell();
					}

				});

		qualityListView.setItems(list);
	}

	public void populateList(StreamInfo info) {
		list.clear();
		for (StreamQuality q : info.getQualities()) {
			list.add(q);
		}
	}
}