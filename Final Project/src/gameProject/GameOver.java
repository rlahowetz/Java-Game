package gameProject;
import org.lwjgl.input.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
/**
 * GameOver.java - state for a game over screen
 * @author Ryan Lahowetz
 *
 */
public class GameOver extends BasicGameState{
	String gameOver = "Game Over";
	
	public GameOver(int state){
		
	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawString(gameOver, 300, 300);
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	public int getID() {
		return 3;
	}

}
