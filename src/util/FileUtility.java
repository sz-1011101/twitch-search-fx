package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Utility for reading and writing files
 * 
 * @author sebastian
 *
 */
public class FileUtility {

	/**
	 * Loads a File and returns a String with the file's content
	 * 
	 * @param file
	 *            File to read
	 * @return file's content as String, null if file not existing
	 * @throws IOException
	 */
	public static String loadStringFromFile(File file) throws IOException {
		if (!file.exists()) {
			return null;
		}

		BufferedReader in = new BufferedReader(new FileReader(file));

		String currentLine;
		String result = "";
		while ((currentLine = in.readLine()) != null) {
			result += currentLine;
		}
		in.close();
		System.out.println("File loaded: "+file.getAbsolutePath());
		return result;
	}

	/**
	 * Writes a String to the given file
	 * 
	 * @param file
	 *            file to write to
	 * @param content
	 *            content to write into the file
	 * @throws IOException
	 */
	public static void writeStringIntoFile(File file, String content)
			throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
		out.write(content);
		out.close();
		System.out.println("File written "+file.getAbsolutePath());
	}
}
