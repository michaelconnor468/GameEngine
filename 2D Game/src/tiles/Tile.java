package tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile 
{
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(1);
	public static Tile rockTile = new RockTile(2);
	
	protected BufferedImage texture;
	public final int id;
	public static final int TILE_SIZE = 64;
	
	/**Initializes local variables texture and id, and adds an Object reference
	 * to the tiles[] array indexed with the given id.
	 * 
	 * @param texture
	 * @param id
	 * @since Alpha 1.0
	 */
	public Tile(BufferedImage texture, int id)
	{
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick()
	{
		
	}
	
	/**Called upon to draw the tile on the screen using the passed along Graphics object.
	 * 
	 * @param g
	 * @param x
	 * @param y
	 * @since Alpha 1.0
	 */
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture, x, y, TILE_SIZE, TILE_SIZE, null);
	}
	
	public boolean isSolid()
	{
		return false;
	}
}
