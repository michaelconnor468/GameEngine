package entities;

import gfx.*;
import utilities.*;

import java.awt.Color;
import java.awt.Graphics;
import main.*;

public class Player extends LivingEntity
{
	public Player(ObjectHandler objectHandler, float x, float y)
	{
		super(objectHandler, x, y, 64, 64);
		
		collisionBounds.x = 23;
		collisionBounds.y = 40;
		collisionBounds.width = 17;
		collisionBounds.height = 17;
	}

	@Override
	public void tick() 
	{
		getInput();
		move();
		objectHandler.getGameCamera().centerOnEntity(this);
	}
	
	/**Sets values of the XMove and yMove variables based on boolean values of which
	 * keys are pressed from the InputManager object. Sets them based on the entity's speed
	 * value.
	 * 
	 * @since Alpha 1.0
	 */
	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		
		if(objectHandler.getInputManager().up)
		{
			yMove = -speed;
		}
		if(objectHandler.getInputManager().down)
		{
			yMove = speed;
		}
		if(objectHandler.getInputManager().left)
		{
			xMove = -speed;
		}
		if(objectHandler.getInputManager().right)
		{
			xMove = speed;
		}
	}

	/**Draws the player in the middle of the screen based on the given dimensions.
	 * 
	 * @since Alpha 1.0
	 */
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.test2, (int)(x - objectHandler.getGameCamera().getxOffset()), (int)(y - objectHandler.getGameCamera().getyOffset()), width, height, null);
		
		//Collision Debug
		//g.setColor(Color.red);
		//g.fillRect((int) (x + collisionBounds.x - objectHandler.getGameCamera().getxOffset()),(int) (y + collisionBounds.y - objectHandler.getGameCamera().getyOffset()),collisionBounds.width, collisionBounds.height);
	}
	
	
}
