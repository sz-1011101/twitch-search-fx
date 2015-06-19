package application;

import java.io.IOException;

import twitch.StreamInfo.StreamQuality;

public class Player {

	private Configuration config;

	public Player(Configuration config) {
		this.config = config;
	}

	/**
	 * Opens the stream in the preferred player (Set in config)
	 * 
	 * @param streamInfo
	 */
	public void openStream(StreamQuality quality) {
		ProcessBuilder pb = new ProcessBuilder(config.getPlayerPath(), quality
				.getStreamURL().toExternalForm());

		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
