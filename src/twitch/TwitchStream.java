package twitch;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import com.google.gson.Gson;

import twitch.StreamInfo.StreamQuality;
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
			try {
				info = parseStreams(usherCallResponse);
				return true;
			} catch (MalformedURLException e) {
				e.printStackTrace();
				return false;
			}

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

	private StreamInfo parseStreams(String twitchM3u)
			throws MalformedURLException {

		StreamInfo result = new StreamInfo();

		if (twitchM3u == null || twitchM3u == "") {
			return null;
		}

		String[] splitLines = twitchM3u.split("#EXT-X-MEDIA:TYPE=VIDEO,");

		for (String s : splitLines) {
			String quality = subStringToGivenDelimiter(s, "GROUP-ID=\"", "\",");
			String videoURL = subStringToGivenDelimiter(s, "VIDEO=\"" + quality
					+ "\"", null);
			if (videoURL != null) {
				result.qualities.add(result.new StreamQuality(quality, new URL(
						videoURL)));
			}
		}

		if (!result.qualities.isEmpty()) {
			return null;
		}

		return result;
	}

	private String subStringToGivenDelimiter(String input, String lookfor,
			String delimiter) {

		int lookforIndex = input.indexOf(lookfor);
		String cutString = null;

		if (lookforIndex >= 0) {
			cutString = input.substring(lookforIndex + lookfor.length());
			if (delimiter != null) {
				cutString = cutString
						.substring(0, cutString.indexOf(delimiter));
			}
		}

		return cutString;
	}

	class TokenResponseContainer {
		String token;
		String sig;
		boolean mobile_restricted;
	}
}
