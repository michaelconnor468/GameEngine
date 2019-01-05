package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener
{
	private boolean[] inputKeys;
	public boolean up, down, left, right;
	
	public InputManager()
	{
		inputKeys = new boolean[256];
	}
	
	/**Continuously updates boolean values for which input keys are being pressed
	 * and which are not.
	 * 
	 * @since Alpha 1.0
	 */
	public void tick()
	{
		up = inputKeys[KeyEvent.VK_W];
		down = inputKeys[KeyEvent.VK_S];
		left = inputKeys[KeyEvent.VK_A];
		right = inputKeys[KeyEvent.VK_D];
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		inputKeys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		inputKeys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}
	
}
