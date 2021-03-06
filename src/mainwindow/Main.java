package mainwindow;

import application.Configuration;
import application.ObservableTwitchBrowser;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {

	private static Configuration config = Configuration.loadConfiguration();;

	@Override
	public void start(Stage stage) {
		try {
			// No config available, use default config
			if (config == null) {
				config = new Configuration();
			}
			ObservableTwitchBrowser browser = new ObservableTwitchBrowser();
			Parent root = new MainWindow();
			((MainWindow)root).setTwitchBrowser(browser);
			((MainWindow)root).setUpListeners();
			
			Scene scene = new Scene(root, 800, 400);
			stage.setTitle("Twitch Browser 0.1");
			stage.setScene(scene);

			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Configuration getConfig() {
		return config;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
