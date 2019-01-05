package world;

import java.awt.Graphics;
import utilities.*;
import main.GameManager;
import tiles.Tile;
import utilities.Utilities;

public class WorldManager
{
	private ObjectHandler objectHandler;
	private int width, height;
	private int[][] tiles;
	private int spawnX, spawnY;
	
	/**Initializes local GameManager variable and calls the loadWorld() method
	 * using the given path String.
	 * 
	 * @param objectHandler
	 * @param path
	 * @since Alpha 1.0
	 */
	public WorldManager(ObjectHandler objectHandler, String path)
	{
		this.objectHandler = objectHandler;
		loadWorld(path);
	}
	
	public void tick()
	{
		
	}
	
	/**Calls each tiles render method to display the map to the screen. Uses simple math
	 * and Offset variables from the GameCamera class to only render the visible portion of the
	 * game, thus saving memory.
	 * 
	 * @param g
	 * @since Alpha 1.0
	 */
	public void render(Graphics g)
	{
		int xStart = (int)Math.max(0, (objectHandler.getGameCamera().getxOffset() / Tile.TILE_SIZE) - 1);
		int xEnd = (int)Math.min(width, (objectHandler.getGameCamera().getxOffset() + objectHandler.getWidth()) / Tile.TILE_SIZE + 1);
		int yStart = (int)Math.max(0, (objectHandler.getGameCamera().getyOffset() / Tile.TILE_SIZE) - 1);
		int yEnd = (int)Math.min(height, (objectHandler.getGameCamera().getyOffset() + objectHandler.getHeight()) / Tile.TILE_SIZE + 1);
		
		for(int y = yStart; y < yEnd; y++)
		{
			for(int x = xStart; x < xEnd; x++)
			{
				getTile(x, y).render(g,(int)(x * Tile.TILE_SIZE - objectHandler.getGameCamera().getxOffset()),(int)(y * Tile.TILE_SIZE - objectHandler.getGameCamera().getyOffset()));
			}
		}
	}
	
	/**Returns the tile within the game's 2D array using the given x and y parameters
	 * Returns a default tile (BedRock) should the array have a null pointer.
	 * 
	 * @param x
	 * @param y
	 * @return Tile
	 * @since Alpha 1.0
	 */
	public Tile getTile(int x, int y)
	{
		if(x < 0 || y < 0 || x >= width || y >= height)
		{
			return Tile.grassTile;
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
		{
			return Tile.rockTile;
		}
		else
		{
			return t;
		}
	}
	
	/**Reads the save file format and creates a 2D tiles[] array containing all
	 * of the tiles that are part of the map. Uses the String reference to the save
	 * file as a parameter.
	 * 
	 * @param path
	 * @since Alpha 1.0
	 */
	private void loadWorld(String path)
	{
		String file = Utilities.loadFileAsString(path);
		String[] saveBits = file.split("\\s+");
		width = Utilities.parseInt(saveBits[0]);
		height = Utilities.parseInt(saveBits[1]);
		spawnX = Utilities.parseInt(saveBits[2]);
		spawnY = Utilities.parseInt(saveBits[3]);
		
		tiles = new int[width][height];
		
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				tiles[x][y] = Utilities.parseInt(saveBits[(x + y * width) + 4]);
			}
		}
		
	}
}
