package twitch;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import com.google.gson.Gson;

import util.URLUtility;

public class TwitchStream {
	private String name;
	private URL url;
	private String gameName;
	private int viewers;
	private StreamInfo info = null;

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

	public StreamInfo getInfo() {
		return info;
	}

	/**
	 * Sets the StreamInfo Object of this Object. Thanks to
	 * http://www.johannesbader
	 * .ch/2014/01/find-video-url-of-twitch-tv-live-streams-or-past-broadcasts/
	 * for showing how to retrieve twitch stream info.
	 * 
	 * @return true if operation successful, false otherwise
	 */
	public boolean retrieveStreamData() {

		String tokenCallResponse;

		try {
			tokenCallResponse = URLUtility.retrieveURL(getTokenCall(name));
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		Gson gson = new Gson();
		TokenResponseContainer token = gson.fromJson(tokenCallResponse,
				TokenResponseContainer.class);

		String usherCallResponse;

		try {
			usherCallResponse = URLUtility.retrieveURL(getUsherCall(name,
					token.token, token.sig));
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		// check if stream is online and we got a m3u playlist of streams
		// TODO parsing and setting the object
		if (usherCallResponse.startsWith("#EXTM3U")) {
			System.out.println(usherCallResponse);
			return true;
		}

		System.out.println("Stream url's could not be retrieved");
		return false;
	}

	private URL getTokenCall(String channel) throws MalformedURLException {
		return new URL("http://api.twitch.tv/api/channels/" + channel
				+ "/access_token");
	}

	private URL getUsherCall(String channel, String token, String signature)
			throws MalformedURLException {
		Random random = new Random(System.currentTimeMillis());
		int rNumber = random.nextInt(1000000); // 6 Digits random
												// integer
		String usherCall = "http://usher.twitch.tv/api/channel/hls/" + channel
				+ ".m3u8?player=twitchweb&token=" + token + "&sig=" + signature
				+ "&$allow_audio_only=true&allow_source=true&type=any&p="
				+ rNumber;

		return new URL(usherCall);
	}

	class TokenResponseContainer {
		String token;
		String sig;
		boolean mobile_restricted;
	}
}
