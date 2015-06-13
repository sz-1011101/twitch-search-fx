package jsonretrieval;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import twitch.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import util.URLUtility;

public class Retriever {

	private static final String TWITCH_API_PROTOCOL = "https";
	private static final String TWITCH_API_BASE = "api.twitch.tv";
	private static final String TWITCH_API_SEARCH_CALL = "/kraken/search/streams";

	public static String getSearchResultsJson(String term, int limit) {

		URI uri;
		URL url;

		String query = "q="+term + "&limit=" + limit;

		try {
			uri = new URI(TWITCH_API_PROTOCOL, TWITCH_API_BASE
					,TWITCH_API_SEARCH_CALL, query, null);
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
