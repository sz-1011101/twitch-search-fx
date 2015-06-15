package twitch;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StreamInfo {
	List<StreamQuality> qualities = new ArrayList<>();

	class StreamQuality {

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
}
