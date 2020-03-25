package gameProject;

import org.lwjgl.input.*;
import org.newdawn.slick.*;

import org.newdawn.slick.state.*;

/**
 * MainMenu.java - Represents the Main Menu of the game
 * @author Ryan Lahowetz
 *
 */
public class MainMenu extends BasicGameState{

	
	Image playButton;
	Image exitButton;
	
	
	public MainMenu(int state)
	{
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		playButton = new Image("res/mainMenuFolder/1422699750.png.png");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		
		g.drawString("Click Play to Begin", 150, 50);
		
		g.drawImage(playButton, 150, 200);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		
		Input input = gc.getInput();
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		if((xPos > 157 && xPos < 390) && (yPos > 287 && yPos < 387)){
			if(input.isMouseButtonDown(0))
				sbg.enterState(1);
		}
			
		
	}
	
	public int getID()
	{
		return 0;
	}
}
