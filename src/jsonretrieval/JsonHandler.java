package jsonretrieval;

import java.io.IOException;

import twitch.TwitchStreamContainerJson;

import com.google.gson.Gson;

public class JsonHandler {
	Gson gson = new Gson();
	private final int LIMIT = 100;

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
