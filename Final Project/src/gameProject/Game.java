package gameProject;

import org.newdawn.slick.*;

import org.newdawn.slick.state.*;

/**
 * Game.java - Controller for the state based game
 * @author Ryan Lahowetz
 *
 */
public class Game extends StateBasedGame{

	public static final String GAME_NAME = "Project Hunter";
	public static final int MAIN_MENU = 0;
	public static final int PLAY = 1;
	public static final int Game_Over = 3;
	
	public Game(String GAME_NAME)
	{
		super(GAME_NAME);
		this.addState(new MainMenu(MAIN_MENU));
		this.addState(new Play(PLAY));
		this.addState(new GameOver(Game_Over));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException
	{
		this.getState(MAIN_MENU).init(gc, this);
		this.getState(PLAY).init(gc, this);
		this.getState(Game_Over).init(gc, this);
		this.enterState(MAIN_MENU);
	}
	
	public static void main(String[] args) {
	
		AppGameContainer appGC;
		try
		{
			appGC = new AppGameContainer(new Game(GAME_NAME));
			appGC.setDisplayMode(600, 600, false);
			appGC.setShowFPS(false);
			appGC.start();
		}
		catch(SlickException e)
		{
			e.printStackTrace();
		}
		

	}

}
