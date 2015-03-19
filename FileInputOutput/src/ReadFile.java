import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

/**
 * This class will read the words.txt file and display each line back backwards
 * It also display the size of the file and number of words contain in the file
 * And the absolute path to the data file
 * 
 * @author Padma Dangal
 * @version 1.0.0
 */
public class ReadFile {

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		InputStream input = null;

		try {

			// opening the root file
			Path file = Paths.get("words.txt");
			input = Files.newInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					input));
			String line = null;

			// reading the each line
			line = reader.readLine();

			int count = 0;

			// if line is not empty read next line
			while (line != null) {

				// splitting the line in putting into the array
				String[] words = line.split(" ");

				String backwards = "";

				// Printing the each word of the backwards
				for (int i = words.length - 1; i >= 0; i--) {
					backwards += words[i] + " ";
                                  
                  // counting the words
					count++;
				}

				// printing on backwards lines on console
				System.out.println(backwards);


				// reading the next line
				line = reader.readLine();
			}

			// creating the object of the BasicFileAttributes to fine the size
			// of it.
			BasicFileAttributes attribute = Files.readAttributes(
					file.toAbsolutePath(), BasicFileAttributes.class);

			// new line
			System.out.println();

			// size of the file
			System.out.println("File size: -> " + attribute.size());

			// Number of words in the file
			System.out.println("Number of words: -> " + count);

			// Absolute path to the file
			System.out.println("Absolute path: -> " + file.toAbsolutePath());

			// closing input and reader
			input.close();
			reader.close();

			// catching all the possible exception
		} catch (InvalidPathException ipe) {
			System.out.println("The path string cannot be converted to a path");
		} catch (IllegalArgumentException iae) {
			System.out.println("A invalid combination of options is specified");
		} catch (UnsupportedOperationException uoe) {
			System.out.println("An unsupported option is specified");
		} catch (SecurityException se) {
			System.out
					.println("In the case of the default provider, and a security manager is installed, the checkWrite method is invoked to check write access to the file.");
		} catch (IOException e) {
			System.out.println("if an I/O error occurs");
		}
	}

	/*
	 * and files about information contain that objects create to class Path
	 * Java's use can You use You exist. even they whether and dates, creation
	 * sizes, locations, their as such directories, them, deleting as such
	 * directories, and files on operations perform to class Files the streams.
	 * output and input creating and attributes, their determining
	 * 
	 *File size: -> 345 
     *Number of words: -> 53
     *Absolute path: -> D:\PracticalQuiz3\words.txt
	 */
}