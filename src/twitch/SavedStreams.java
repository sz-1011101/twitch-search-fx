package twitch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import util.FileUtility;

public class SavedStreams {

	public static final String SAVED_STREAMS_PATH = "saved.json";
	private ArrayList<SavedTwitchStream> streams;

	public SavedStreams() {
		streams = new ArrayList<>();
	}

	public ArrayList<SavedTwitchStream> getStreams() {
		return streams;
	}

	public static SavedStreams loadStreams() {
		try {
			String jsonStreams = FileUtility.loadStringFromFile(new File(
					SAVED_STREAMS_PATH));
			Gson gson = new Gson();
			return gson.fromJson(jsonStreams, SavedStreams.class);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void saveStreams() {
		Gson gson = new Gson();
		String jsonStreams = gson.toJson(this);

		try {
			FileUtility.writeStringIntoFile(new File(SAVED_STREAMS_PATH),
					jsonStreams);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
