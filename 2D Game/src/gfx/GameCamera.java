package gfx;

import main.*;
import entities.*;

public class GameCamera 
{
	public GameManager gameManager;
	private float xOffset, yOffset;
	
	/**Initializes local variables.
	 * 
	 * @param gameManager
	 * @param xOffset
	 * @param yOffset
	 * @since Alpha 1.0
	 */
	public GameCamera(GameManager gameManager, float xOffset, float yOffset)
	{
		this.gameManager = gameManager;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	/**Called to change the camera offset values by the amount given into the methods
	 * parameters.
	 * 
	 * @param xAmount
	 * @param yAmount
	 * @since Alpha 1.0
	 */
	public void move(float xAmount, float yAmount)
	{
		xOffset += xAmount;
		yOffset += yAmount;
	}
	
	/**Centers the camera on the entity given as a parameter.
	 * 
	 * @param e
	 * @since Alpha 1.0
	 */
	public void centerOnEntity(Entity e)
	{
		xOffset = e.getX() - gameManager.getWidth() / 2 + e.getWidth()/2;
		yOffset = e.getY() - gameManager.getHeight() / 2 + e.getHeight()/2;
	}

	public float getxOffset() 
	{
		return xOffset;
	}

	public void setxOffset(float xOffset) 
	{
		this.xOffset = xOffset;
	}

	public float getyOffset() 
	{
		return yOffset;
	}

	public void setyOffset(float yOffset) 
	{
		this.yOffset = yOffset;
	}
	
	
}
