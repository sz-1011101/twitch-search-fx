package jsonretrieval;

import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import util.URLUtility;

public class Retriever {

	private static final String TWITCH_API_PROTOCOL = "https";
	private static final String TWITCH_API_BASE = "api.twitch.tv";
	private static final String TWITCH_API_SEARCH_CALL = "/kraken/search/streams";

	/**
	 * Call the twitch API with a search term
	 * 
	 * @param term
	 *            The term to search for
	 * @param limit
	 *            Max amount of results
	 * @return String representing a Json-Object with the results, returns null
	 *         if error occurs.
	 */
	public static String getSearchResultsJson(String term, int limit) {

		URI uri;
		URL url;

		String query = "q=" + term + "&limit=" + limit;

		try {
			uri = new URI(TWITCH_API_PROTOCOL, TWITCH_API_BASE,
					TWITCH_API_SEARCH_CALL, query, null);
			url = uri.toURL();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}

		System.out.println("Search Term URL: " + url);
		String result;

		try {
			result = URLUtility.retrieveURL(url);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
