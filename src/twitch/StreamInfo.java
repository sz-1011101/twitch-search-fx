package twitch;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StreamInfo {
	List<StreamQuality> qualities = new ArrayList<>();
	
	class StreamQuality {
		String quality;
		URL streamURL;
	}
}
