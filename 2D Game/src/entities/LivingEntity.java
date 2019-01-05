package entities;

import main.*;
import tiles.Tile;
import utilities.*;

public abstract class LivingEntity extends Entity
{
	protected ObjectHandler objectHandler;
	protected int health;
	protected float speed;
	protected float xMove, yMove;
	
	/**Sets local variables for the LivingEntity's health, speed, location, size.
	 * Also sets a local GameManager object reference pointer.
	 * Sets both x and y movement speeds to 0;
	 * 
	 * @param objectHandler
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @since Alpha 1.0
	 */
	public LivingEntity(ObjectHandler objectHandler, float x, float y, int width, int height)
	{
		super(objectHandler, x, y, width, height);
		health = 10;
		speed = 3;
		xMove = 0;
		yMove = 0;
		this.objectHandler = objectHandler;
	}
	
	/**Moves the player on the map based on the values of the xMove and yMove float
	 * variables.
	 * 
	 * @since Alpha 1.0
	 */
	public void move()
	{
		moveX();
		moveY();
	}
	
	public void moveX()
	{
		if(xMove > 0)
		{
			int tx = (int) (x + xMove + collisionBounds.x + collisionBounds.width) / Tile.TILE_SIZE;
			
			if(!collisionWithTile(tx, (int) (y + collisionBounds.y) / Tile.TILE_SIZE) && !collisionWithTile(tx, (int) (y + collisionBounds.y + collisionBounds.height) / Tile.TILE_SIZE))
			{
				x += xMove;
			}
			else
			{
				x = tx * Tile.TILE_SIZE - collisionBounds.x - collisionBounds.width - 1;
			}
		}
		else if(xMove < 0)
		{
			int tx = (int) (x + xMove + collisionBounds.x) / Tile.TILE_SIZE;
			
			if(!collisionWithTile(tx, (int) (y + collisionBounds.y) / Tile.TILE_SIZE) && !collisionWithTile(tx, (int) (y + collisionBounds.y + collisionBounds.height) / Tile.TILE_SIZE))
			{
				x += xMove;
			}
			else
			{
				x = tx * Tile.TILE_SIZE + Tile.TILE_SIZE - collisionBounds.x;
			}
		}
	}
	
	public void moveY()
	{
		if(yMove < 0)
		{
			int ty = (int) (y + yMove + collisionBounds.y) / Tile.TILE_SIZE;
			
			if(!collisionWithTile((int) (x + collisionBounds.x) / Tile.TILE_SIZE, ty) && !collisionWithTile((int) (x + collisionBounds.x + collisionBounds.width) / Tile.TILE_SIZE, ty))
			{
				y += yMove;
			}
			else
			{
				y = ty * Tile.TILE_SIZE + Tile.TILE_SIZE - collisionBounds.y;
			}
		}
		else if(yMove > 0)
		{
			int ty = (int) (y + yMove + collisionBounds.y + collisionBounds.height) / Tile.TILE_SIZE;
			
			if(!collisionWithTile((int) (x + collisionBounds.x) / Tile.TILE_SIZE, ty) && !collisionWithTile((int) (x + collisionBounds.x + collisionBounds.width) / Tile.TILE_SIZE, ty))
			{
				y += yMove;
			}
			else
			{
				y = ty * Tile.TILE_SIZE - collisionBounds.y - collisionBounds.height - 1;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y)
	{
		return objectHandler.getWorldManager().getTile(x, y).isSolid();
	}
	
	//Getters and setters

	public float getxMove() 
	{
		return xMove;
	}

	public void setxMove(float xMove) 
	{
		this.xMove = xMove;
	}

	public float getyMove() 
	{
		return yMove;
	}

	public void setyMove(float yMove) 
	{
		this.yMove = yMove;
	}

	public int getHealth() 
	{
		return health;
	}

	public void setHealth(int health) 
	{
		this.health = health;
	}

	public float getSpeed() 
	{
		return speed;
	}

	public void setSpeed(float speed) 
	{
		this.speed = speed;
	}
}
