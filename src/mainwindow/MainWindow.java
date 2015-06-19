package mainwindow;

import application.CurrentSavedListener;
import application.ObservableTwitchBrowser;
import configwindow.ConfigWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainWindow extends GridPane {

	private ObservableTwitchBrowser browser;
	private CurrentSavedListener savedBoxListener;
	
	@FXML
	SearchBox searchBox;

	@FXML
	SavedBox savedBox;

	public MainWindow() {
		Utility.loadFXMLasRoot("main_window.fxml", this);
	}

	@FXML
	protected void handleConfigureButtonAction(ActionEvent event) {
		System.out.println("ConfigureButton pressed");
		Parent secondary = new ConfigWindow();

		Stage configStage = new Stage();
		Scene scene = new Scene(secondary, 400, 100);

		configStage.setTitle("Configuration");
		configStage.setScene(scene);
		configStage.show();
	}

	public void setTwitchBrowser(ObservableTwitchBrowser browser) {
		this.browser = browser;
		searchBox.setTwitchBrowser(browser);
		savedBox.setTwitchBrowser(browser);
	}
	
	public void setUpListeners() {
		savedBoxListener = new CurrentSavedListener(savedBox);
		browser.addListener(savedBoxListener);
	}

}
