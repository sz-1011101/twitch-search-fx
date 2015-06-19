package configwindow;

import java.io.File;

import mainwindow.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class ConfigWindow extends GridPane {

	@FXML
	private TextField playerPath;

	public ConfigWindow() {
		Utility.loadFXMLasRoot("config_window.fxml", this);
		playerPath.setText(mainwindow.Main.getConfig().getPlayerPath());
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
		mainwindow.Main.getConfig().setPlayerPath(playerPath.getText());
		mainwindow.Main.getConfig().saveConfiguration();
		Stage window = (Stage)this.getScene().getWindow();
		window.close();
	}
}
