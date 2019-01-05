package entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import utilities.*;
import main.*;

public abstract class Entity 
{
	protected ObjectHandler objectHandler;
	protected float x, y;
	protected int width, height;
	protected Rectangle collisionBounds;
	
	/**Sets local variables that determine the size of the Entity and its location
	 * within the map. Also initializes a local gameManager reference pointer.
	 * 
	 * @param gameManager
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @since Alpha 1.0
	 */
	public Entity(ObjectHandler objectHandler, float x, float y, int width, int height)
	{
		this.objectHandler = objectHandler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		collisionBounds = new Rectangle(0, 0, width, height);
	}
	
	public float getX() 
	{
		return x;
	}

	public void setX(float x) 
	{
		this.x = x;
	}

	public float getY() 
	{
		return y;
	}

	public void setY(float y) 
	{
		this.y = y;
	}

	public int getWidth() 
	{
		return width;
	}

	public void setWidth(int width) 
	{
		this.width = width;
	}

	public int getHeight() 
	{
		return height;
	}

	public void setHeight(int height) 
	{
		this.height = height;
	}

	public abstract void tick();
	public abstract void render(Graphics g);
}
