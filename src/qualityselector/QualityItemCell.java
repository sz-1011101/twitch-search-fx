package qualityselector;

import application.Configuration;
import application.Player;
import twitch.StreamInfo.StreamQuality;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;

public class QualityItemCell extends ListCell<StreamQuality> {

	private Configuration config;

	Button launchButton = new Button();

	public QualityItemCell(Configuration config) {
		super();
		this.config = config;

		this.setText(null);

		launchButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("launchButton pressed");
				Player player = new Player(config);
				player.openStream(getItem());
			}

		});
	}

	@Override
	protected void updateItem(StreamQuality item, boolean empty) {
		if (empty || item == null) {
			setGraphic(null);
		} else {
			launchButton.setText(item.getQuality());
			setGraphic(launchButton);
		}
		this.setItem(item);
	}
}
