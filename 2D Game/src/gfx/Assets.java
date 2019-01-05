package gfx;

import java.awt.image.BufferedImage;
import utilities.*;

public class Assets 
{
	private static final int WIDTH = 64;
	private static final int HEIGHT = 64;
	
	public static BufferedImage grass, rock, test2;
	
	/**Initializes all the local BufferedImage objects containing the textures of their
	 * respective entities or tiles.
	 * 
	 * @since Alpha 1.0
	 */
	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(Utilities.loadImage("/textures/sprite_sheet.png"));
		
		grass = sheet.crop(0, 0, WIDTH, HEIGHT);
		rock = sheet.crop(WIDTH * 2, 0, WIDTH, HEIGHT);
		test2 = sheet.crop(WIDTH, 0, WIDTH, HEIGHT);
	}
}
