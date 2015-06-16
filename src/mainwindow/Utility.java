package mainwindow;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class Utility {
	/**
	 * Load a fxmlFile for the given Node
	 * 
	 * @param fxmlFile
	 *            Fxml file location
	 * @param node
	 *            Node to use as root
	 */
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
