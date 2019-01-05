package gfx;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display 
{
	public JFrame frame;
	public Canvas canvas;
	private String title;
	private int width, height;
	
	/**Initializes local variables to given parameters and calls the createDisplay()
	 * method.
	 * 
	 * @param title
	 * @param width
	 * @param height
	 * @since Alpha 1.0
	 */
	public Display(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	/**Creates the JFrame and canvas upon which the game will be displays. Sets
	 * default close operations, preferred size for the canvas, resizable as false.
	 * Calls th pack() method of the canvas object.
	 * 
	 * @since Alpha 1.0
	 */
	private void createDisplay()
	{
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
}
