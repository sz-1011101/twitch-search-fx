package mainwindow;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class MainWindow extends GridPane {
	@FXML
	SearchBox searchBox;

	@FXML
	SavedBox savedBox;

	public MainWindow() {
		Utility.loadFXMLasRoot("main_window.fxml", this);
	}
}
