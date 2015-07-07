package application;

import java.util.ArrayList;

import twitch.SavedStreams;
import twitch.SavedTwitchStream;
import twitch.TwitchStreamContainerJson;
import twitch.TwitchStream;
import jsonretrieval.JsonHandler;

/**
 * This class handles the interaction with the twitch API.
 * 
 * @author sebastian
 *
 */
public class TwitchBrowser {

	private JsonHandler handler = new JsonHandler();
	private ArrayList<TwitchStream> currentSearchResults;
	private SavedStreams currentSavedStreams;

	public TwitchBrowser() {
		currentSavedStreams = SavedStreams.loadStreams();
		if (currentSavedStreams == null) {
			currentSavedStreams = new SavedStreams();
		}
	}

	/**
	 * Search via the twitch API for the given term
	 * 
	 * @param term
	 *            The term to Search for
	 * @return ArrayList of TwitchStreams returned from the search
	 */
	public void searchTerm(String term) {
		TwitchStreamContainerJson container = handler
				.getSearchResultsTwitchStreamContainerJson(term);
		if (container == null) {
			return;
		}
		currentSearchResults = container.getTwitchStreamList();
	}

	public ArrayList<TwitchStream> getCurrentSearchResults() {
		return currentSearchResults;
	}

	public SavedStreams getCurrentSavedStreams() {
		return currentSavedStreams;
	}

	public void addToSavedStreams(TwitchStream stream) {
		SavedTwitchStream toAdd = new SavedTwitchStream(stream.getName());
		if (currentSavedStreams.getStreams() != null
				&& !currentSavedStreams.getStreams().contains(toAdd)) {
			currentSavedStreams.getStreams().add(toAdd);
		}

		currentSavedStreams.saveStreams();
	}

	public void refreshSavedStreams() {
		// TODO
		
	}

}
