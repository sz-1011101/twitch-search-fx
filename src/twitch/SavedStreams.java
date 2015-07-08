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

	public synchronized ArrayList<SavedTwitchStream> getStreams() {
		return streams;
	}

	public synchronized void addSavedStream(SavedTwitchStream stream) {
		streams.add(stream);
	}

	public synchronized boolean containsSavedStream(SavedTwitchStream stream) {
		return streams.contains(stream);
	}

	public synchronized void removeSavedStream(SavedTwitchStream stream) {
		if (streams.contains(stream)) {
			streams.remove(stream);
		}
	}

	public static SavedStreams loadStreams() {
		try {
			String jsonStreams = FileUtility.loadStringFromFile(new File(SAVED_STREAMS_PATH));
			Gson gson = new Gson();
			return gson.fromJson(jsonStreams, SavedStreams.class);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public synchronized void saveStreams() {
		Gson gson = new Gson();
		String jsonStreams = gson.toJson(this);

		try {
			FileUtility.writeStringIntoFile(new File(SAVED_STREAMS_PATH), jsonStreams);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public synchronized void refreshStreams() {
		System.out.println("Refreshing status of streams...");
		for (SavedTwitchStream s : streams) {
			s.refreshStatus();
		}
	}
}
