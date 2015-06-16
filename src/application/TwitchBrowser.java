package application;

import java.util.ArrayList;

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

	JsonHandler handler = new JsonHandler();

	public TwitchBrowser() {

	}

	/**
	 * Search via the twitch API for the given term
	 * 
	 * @param term
	 *            The term to Search for
	 * @return ArrayList of TwitchStreams returned from the search
	 */
	public ArrayList<TwitchStream> searchTerm(String term) {
		TwitchStreamContainerJson container = handler
				.getSearchResultsTwitchStreamContainerJson(term);
		if (container == null) {
			return null;
		}
		return container.getTwitchStreamList();
	}

}
