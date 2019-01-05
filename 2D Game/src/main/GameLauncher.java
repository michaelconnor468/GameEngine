package main;

public class GameLauncher 
{
	/************************************************************************************
	 * Initializes a new GameManager object with its name and dimensions as parameters. *
	 * Calls the start() method of the GameManager object.								*
	 * 																					*
	 * @param args																		*
	 * @since Alpha 1.0																	*
	 ************************************************************************************/
	public static void main(String[] args)
	{
		GameManager gameManager = new GameManager("Alpha 1.0", 1800, 1000);
		gameManager.start();
	}
}