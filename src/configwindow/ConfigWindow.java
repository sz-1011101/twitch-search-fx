package configwindow;

import java.io.File;

import application.Configuration;
import mainwindow.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ConfigWindow extends GridPane {

	@FXML
	private TextField playerPath;
	private Configuration config;

	public ConfigWindow(Configuration config) {
		this.config = config;
		Utility.loadFXMLasRoot("config_window.fxml", this);
		playerPath.setText(config.getPlayerPath());
	}

	@FXML
	protected void handleSetPlayerButtonAction(ActionEvent event) {

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open player executable");
		File file = fileChooser.showOpenDialog(this.getScene().getWindow());

		if (file != null) {
			playerPath.setText(file.getAbsolutePath());
		}

	}

	@FXML
	protected void handleSaveButtonAction(ActionEvent event) {
		config.setPlayerPath(playerPath.getText());
		config.saveConfiguration();
		Stage window = (Stage)this.getScene().getWindow();
		window.close();
	}
}
