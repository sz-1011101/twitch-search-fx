package qualityselector;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import twitch.StreamInfo;
import mainwindow.Utility;

public class QualitySelector extends VBox {

	@FXML
	private QualityBox box;

	public QualitySelector() {
		Utility.loadFXMLasRoot("quality_selector.fxml", this);
	}

	/**
	 * give this Object the data to display in the box
	 * 
	 * @param info
	 *            the data to display
	 */
	public void passStreamInfo(StreamInfo info) {
		box.populateList(info);
	}
}
