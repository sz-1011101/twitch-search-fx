package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLUtility {
	/**
	 * Retrieve content at url as String
	 * @param url the given url to read retrieve from
	 * @return String with content at url
	 * @throws IOException
	 */
	 
	public static String retrieveURL(URL url) throws IOException {
		
		InputStreamReader stream = new InputStreamReader(url.openStream());
		BufferedReader in = new BufferedReader(stream);
		String current;
		String result = "";
		
		while ((current = in.readLine()) != null) {
			result += current;
		}
		
		return result;
	}
}
