package jsonretrieval;

import twitch.TwitchStreamContainerJson;

import com.google.gson.Gson;

/**
 * Handles all things Json related of the twitch API.
 * 
 * @author sebastian
 *
 */
public class JsonHandler {

	Gson gson = new Gson();
	private final int LIMIT = 20;

	/**
	 * Returns TwitchStreamContainer with retrieved data from the searchterm
	 * term via twitch API. Returns null if IOException occurs.
	 * 
	 * @param term
	 * @return TwitchStreamContainer with data from searchterm
	 */
	public TwitchStreamContainerJson getSearchResultsTwitchStreamContainerJson(
			String term) {
		String resultJson;

		resultJson = Retriever.getSearchResultsJson(term, LIMIT);
		if (resultJson == null) {
			return null;
		}

		return gson.fromJson(resultJson, TwitchStreamContainerJson.class);
	}
}
