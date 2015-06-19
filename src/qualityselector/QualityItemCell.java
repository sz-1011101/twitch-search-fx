package qualityselector;

import application.Player;
import twitch.StreamInfo.StreamQuality;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;

public class QualityItemCell extends ListCell<StreamQuality> {

	Button launchButton = new Button();

	public QualityItemCell() {
		super();

		this.setText(null);

		launchButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("launchButton pressed");
				Player player = new Player(mainwindow.Main.getConfig());
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
