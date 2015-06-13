package mainwindow;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class Utility {
	public static void loadFXMLasRoot(String fxmlFile, Node node) {
		FXMLLoader fxmlLoader = new FXMLLoader(node.getClass().getResource(
				fxmlFile));
		fxmlLoader.setRoot(node);
		fxmlLoader.setController(node);

		try {
			fxmlLoader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
