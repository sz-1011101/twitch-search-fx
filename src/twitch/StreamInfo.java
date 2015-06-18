package twitch;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * This class wraps info (stream URLs, quality options, etc.) that can be
 * retrieved from the m3u response of twitch
 * 
 * @author sebastian
 *
 */
public class StreamInfo {

	List<StreamQuality> qualities = new ArrayList<>();
	
	public List<StreamQuality> getQualities() {
		return qualities;
	}

	/**
	 * Represents a stream quality (low, medium, high) and the URL to open
	 * stream with that quality.
	 * 
	 * @author sebastian
	 *
	 */
	public class StreamQuality {

		private String quality;
		private URL streamURL;

		public StreamQuality(String quality, URL streamURL) {
			this.quality = quality;
			this.streamURL = streamURL;
		}

		public String getQuality() {
			return quality;
		}

		public URL getStreamURL() {
			return streamURL;
		}
	}

	@Override
	public String toString() {
		return "StreamInfo [qualities=" + qualities + "]";
	}
}
