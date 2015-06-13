package twitch;

import java.net.URL;

public class TwitchStream {
	private String name;
	private URL url;
	private String gameName;
	private int viewers;
	
	public TwitchStream(String name, URL url, String gameName, int viewers) {
		this.name = name;
		this.url = url;
		this.gameName = gameName;
		this.viewers = viewers;
	}
	
	public String getName() {
		return name;
	}

	public URL getUrl() {
		return url;
	}

	public String getGameName() {
		return gameName;
	}
	
	public int getViewers() {
		return viewers;
	}
	
	
}
