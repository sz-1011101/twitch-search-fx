package mainwindow;

import application.Configuration;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {

			Configuration config = Configuration.loadConfiguration();

			// No config available, use default config
			if (config == null) {
				config = new Configuration();
			}
			Parent root = new MainWindow(config);

			Scene scene = new Scene(root, 600, 400);
			stage.setTitle("Twitch Browser 0.01");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
