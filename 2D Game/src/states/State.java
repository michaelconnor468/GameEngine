package states;

import java.awt.Graphics;
import utilities.*;
import main.*;

public abstract class State 
{
	protected ObjectHandler objectHandler;
	private static State currentState = null;
	
	/**Initializes local objectHandler variable to that of parameter.
	 * 
	 * @param objectHandler
	 * @since Alpha 1.0
	 */
	public State(ObjectHandler objectHandler)
	{
		this.objectHandler = objectHandler;
	}
	
	public static void setState(State state)
	{
		currentState = state;
	}
	
	public static State getState()
	{
		return currentState;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
}
