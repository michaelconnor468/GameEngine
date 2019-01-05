package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import gfx.Assets;
import gfx.Display;
import gfx.GameCamera;
import input.*;
import states.*;
import states.State;
import utilities.*;

public class GameManager implements Runnable 
{
	private Display display;
	private int width, height;
	public String title;
	private boolean running = false;
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;
	
	private State gameState;
	
	public InputManager inputManager;
	
	public GameCamera gameCamera;
	
	private ObjectHandler objectHandler;
	
	/**Sets local variables to parameters and initializes a KeyManager object
	 * 
	 * @param title
	 * @param width
	 * @param height
	 * @since Alpha 1.0
	 */
	public GameManager(String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		inputManager = new InputManager();
	}
	
	/**Creates a Display, GameCamera, and various State objects.
	 * Initializes game Assets and sets the current state to the gameState.
	 * 
	 * @since Alpha 1.0
	 */
	private void init()
	{
		display = new Display(title, width, height);
		display.frame.addKeyListener(inputManager);
		Assets.init();
		
		gameCamera = new GameCamera(this, 0, 0);
		objectHandler = new ObjectHandler(this);
		
		gameState = new GameState(objectHandler);
		State.setState(gameState);
	}
	
	/**Calls the tick() method of the keyManager to refresh which keys are pressed.
	 * Calls the tick() method of the current state object.
	 * 
	 * @since ALpha 1.0
	 */
	private void tick()
	{
		inputManager.tick();
		
		if(State.getState() != null)
		{
			State.getState().tick();
		}
	}
	
	/**Creates a BufferStrategy object and a Graphics object from the BufferStrategy.
	 * Clears the screen, then calls the render method of the current application state.
	 * Calls the show() method of the BufferStrategy object then disposes of the Graphics object.
	 * 
	 * @since Alpha 1.0
	 */
	private void render()
	{
		bs = display.canvas.getBufferStrategy();
		if(bs == null)
		{
			//Triple buffering makes it flash; use double
			display.canvas.createBufferStrategy(2);
			return;
		}
		g = bs.getDrawGraphics();
		
		//Clears Screen
		g.clearRect(0, 0, width, height);
		
		if(State.getState() != null)
		{
			State.getState().render(g);
		}
		
		bs.show();
		g.dispose();
	}
	
	/**Calls this object's init() method.
	 * Calls this object's tick() and render() methods every 1/60 seconds.
	 * Calls this objects stop() method when the "running" boolean variable is set to false.
	 * 
	 * @since Alpha 1.0
	 */
	public void run()
	{
		init();
		
		int ticksPerSecond = 60;
		double timePerTick = 1000000000/ticksPerSecond;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1)
			{
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000)
			{
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	/**First method that is called by the launcher.
	 * Creates this object on a separate thread unless there is one already running.
	 * 
	 * @since Alpha 1.0
	 */
	public synchronized void start()
	{
		if(running)
		{
			return;
		}
		running = true;
		
		thread = new Thread(this);
		thread.start();
	}
	
	/**Shuts down the thread and game.
	 * 
	 * @since Alpha 1.0
	 */
	public synchronized void stop()
	{
		if(!running)
		{
			return;
		}
		running = false;
		
		try 
		{
			thread.join();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
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
}