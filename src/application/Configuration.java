package application;

import java.io.File;
import java.io.IOException;

import util.FileUtility;

import com.google.gson.Gson;

public class Configuration {

	public static final String CONFIG_PATH = "configuration.json";
	private String playerPath;
	private boolean debug;
	
	public String getPlayerPath() {
		return playerPath;
	}

	public void setPlayerPath(String playerPath) {
		this.playerPath = playerPath;
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	/**
	 * Default Ctor sets playerPath null, debug false
	 */
	public Configuration() {
		playerPath = null;
		debug = false;
	}

	public static Configuration loadConfiguration() {

		String jsonConfig;
		try {
			jsonConfig = FileUtility.loadStringFromFile(new File(CONFIG_PATH));
			Gson gson = new Gson();
			return gson.fromJson(jsonConfig, Configuration.class);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	public void saveConfiguration() {

		Gson gson = new Gson();
		String jsonConfig = gson.toJson(this);

		try {
			FileUtility.writeStringIntoFile(new File(CONFIG_PATH), jsonConfig);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
