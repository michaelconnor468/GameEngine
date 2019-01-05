package states;

import java.awt.Graphics;
import entities.*;
import main.*;
import world.*;
import utilities.*;

public class GameState extends State
{
	private Player player;
	private WorldManager worldManager;
	
	/**Calls the superclass' constructor.
	 * Creates a new Player object, giving it the current GameManager object, and its starting location.
	 * Creates a new World object, giving it the current GameManager object and a save file location.
	 * 
	 * @since Alpha 1.0
	 * @param objectHandler
	 */
	public GameState(ObjectHandler objectHandler)
	{
		super(objectHandler);
		worldManager = new WorldManager(objectHandler, "resources/worlds/world1.txt");
		objectHandler.setWorldManager(worldManager);
		player = new Player(objectHandler, 100, 100);
	}
	
	/**Calls the tick() methods of the local World and Player objects.
	 * 
	 * @since Alpha 1.0
	 */
	@Override
	public void tick()
	{
		worldManager.tick();
		player.tick();
	}
	
	/**Calls the render() methods of the local world and player objects and further conveys the graphics object
	 * that was originally passed in by the GameManager object.
	 * 
	 * @since Alpha 1.0
	 */
	@Override
	public void render(Graphics g)
	{
		worldManager.render(g);
		player.render(g);
	}
}
