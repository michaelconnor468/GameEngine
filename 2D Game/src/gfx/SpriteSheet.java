package gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet 
{
	private BufferedImage sheet;
	
	/**Initializes the local BufferedImage object as the BufferedImage given in the
	 * parameters.
	 * 
	 * @param sheet
	 * @since Alpha 1.0
	 */
	public SpriteSheet(BufferedImage sheet)
	{
		this.sheet = sheet;
	}
	
	/**Returns the desired section of the sprite sheet associated with the object using the
	 * given parameters.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return BufferedImage
	 * @since Alpha 1.0
	 */
	public BufferedImage crop(int x, int y, int width, int height)
	{
		return sheet.getSubimage(x, y, width, height);
	}
}
