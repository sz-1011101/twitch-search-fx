package qualityselector;

import application.Configuration;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import twitch.StreamInfo;
import mainwindow.Utility;

public class QualitySelector extends VBox {

	private Configuration config;

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
	
	public void setConfig(Configuration config) {
		this.config = config;
		box.setConfig(config);
	}
}
