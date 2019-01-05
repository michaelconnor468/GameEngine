package utilities;

import gfx.GameCamera;
import input.InputManager;
import main.GameManager;
import world.WorldManager;

public class ObjectHandler 
{
	private GameManager gameManager;
	private WorldManager worldManager;
	
	public ObjectHandler(GameManager gameManager)
	{
		this.gameManager = gameManager;
	}
	
	public GameCamera getGameCamera()
	{
		return gameManager.gameCamera;
	}
	
	public InputManager getInputManager()
	{
		return gameManager.inputManager;
	}
	
	public int getWidth()
	{
		return gameManager.getWidth();
	}
	
	public GameManager getGameManager() 
	{
		return gameManager;
	}

	public void setGameManager(GameManager gameManager) 
	{
		this.gameManager = gameManager;
	}

	public WorldManager getWorldManager() 
	{
		return worldManager;
	}

	public void setWorldManager(WorldManager worldManager) 
	{
		this.worldManager = worldManager;
	}

	public int getHeight()
	{
		return gameManager.getHeight();
	}
}

