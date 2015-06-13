package application;

import java.util.ArrayList;

import twitch.TwitchStreamContainerJson;
import twitch.TwitchStream;
import jsonretrieval.JsonHandler;

public class TwitchBrowser {

	JsonHandler handler = new JsonHandler();

	public TwitchBrowser() {

	}

	public ArrayList<TwitchStream> searchTerm(String term) {
		TwitchStreamContainerJson container = handler
				.getSearchResultsTwitchStreamContainerJson(term);
		if (container == null) {
			return null;
		}
		return container.getTwitchStreamList();
	}

}
