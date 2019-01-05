package utilities;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class Utilities 
{
	/**Converts all file contents of the given path into a String object.
	 * 
	 * @param path
	 * @return String
	 * @since Alpha 1.0
	 */
	public static String loadFileAsString(String path)
	{
		StringBuilder stringBuilder = new StringBuilder();
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null)
			{
				stringBuilder.append(line + "\n");
			}
			
			br.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return stringBuilder.toString();
	}
	
	/**Uses the parseInt method of the Integer class to return an int value
	 * from a String. Helps as it already contains the required try/catch statement
	 * thus making code cleaner elsewhere.
	 * 
	 * @param number
	 * @return int
	 * @since Alpha 1.0
	 */
	public static int parseInt(String number)
	{
		try
		{
			return Integer.parseInt(number);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	
	/**Loads an image from the given path parameter. Exits program should an exception
	 * be thrown.
	 * 
	 * @param path
	 * @return BufferedImage
	 * @since Alpha 0.0
	 */
	public static BufferedImage loadImage(String path)
	{
		try
		{
			return ImageIO.read(Utilities.class.getResourceAsStream(path));
		}
		catch(Exception e)
		{
			System.exit(0);
		}
		return null;
	}
}
