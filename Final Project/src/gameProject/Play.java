package gameProject;

import java.util.Random;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 * Play.java - represents the first play state 
 * @author Ryan Lahowetz
 *
 */
public class Play extends BasicGameState{
	
	Random ran = new Random();
	
	Hero heroObject = new Hero();
	
	Image villan;
	Enemy enemy = new Enemy(heroObject);
	int enemyLocX = -50;
	int enemyLocY = -50;
	int enemyWidth = 50;
	int enemyHeight = 50;
	
	Animation hero, heroUp, heroDown, heroLeft, heroRight;
	Image world;
	
	int[] duration = {300,300};
	float heroPositionX=0;
	float heroPositionY=0;
	float shiftX = heroPositionX + 300;
	float shiftY = heroPositionY + 300;
	
	
	
	
	public Play(int state)
	{
		
	}
	
	/**
	 * init() - Initializes all images
	 */
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		Image[] walkUp = {new Image("res/playPics/blocky_examine.png"), new Image("res/playPics/blocky_examine.png")};
		Image[] walkDown = {new Image("res/playPics/blocky.png"), new Image("res/playPics/blocky.png")};
		Image[] walkLeft = {new Image("res/playPics/blocky_left.png"), new Image("res/playPics/blocky_left.png")};
		Image[] walkRight = {new Image("res/playPics/blocky_right.png"), new Image("res/playPics/blocky_right.png")};
		
		
		villan = new Image("res/playPics/Enemy1.png");
		
		world = new Image("res/playPics/World2.png");
		
		heroUp = new Animation(walkUp, duration, false);
		heroDown = new Animation(walkDown, duration, false);
		heroLeft = new Animation(walkLeft, duration, false);
		heroRight = new Animation(walkRight, duration, false);
		
		hero = heroDown;
	}
	
	/**
	 * render() - renders all images on screen
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		
		world.draw(heroPositionX,heroPositionY);
		
		//villan.draw(heroPositionX + enemyLocX,heroPositionY + enemyLocY);
		
		
		hero.draw(shiftX,shiftY);
		
		g.drawString("Find and battle the ninjas",250,50);
		g.drawString("Attc: " + heroObject.getAttack() + "\nDef: " + heroObject.getDef() + 
				"\nlvl: " + heroObject.getLvl() + "\nHealth: " + heroObject.getCurrentHealth() + "/" +
				heroObject.getMaxHealth() + "\nXP: " + heroObject.getXP() + "/" + heroObject.getNextXP() +
				"\nCoins: " + heroObject.getCoins(), 0, 0);
		
	}
	
	/**
	 * update() - updates images on screen
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		Input input = gc.getInput();
		
		//controls
		if(input.isKeyDown(Input.KEY_W)){
			hero = heroUp;
			heroPositionY += delta*.1f;
			
		}
		
		if(input.isKeyDown(Input.KEY_S)){
			hero = heroDown;
			heroPositionY -= delta*.1f;
			
		}
		
		if(input.isKeyDown(Input.KEY_A)){
			hero = heroLeft;
			heroPositionX += delta*.1f;
			
		}
		
		if(input.isKeyDown(Input.KEY_D)){
			hero = heroRight;
			heroPositionX -= delta*.1f;
			
		}
		
		if(heroPositionX > 285.5){
			heroPositionX = (float)(285.5);
		}
		
		if(heroPositionX < -149.9){
			heroPositionX = (float)(-149.9);
		}
		
		if(heroPositionY > 281){
			heroPositionY = (float)(281);
		}
		
		if(heroPositionY < -169.9){
			heroPositionY = (float)(-169.9);
		}
		
		
		
		if((heroPositionY <= enemyLocY) && (heroPositionX <= enemyLocX) &&
				(heroPositionY >= (enemyLocY - enemyHeight)) && (heroPositionX >= (enemyLocX - enemyWidth))){
			enemy.battle();
		}
		
		if(enemy.isDead()){
			enemy = new Enemy(heroObject);
		    enemyLocX = ran.nextInt(434)-149;
		    enemyLocY = ran.nextInt(450)-169;
		}
		
		if(heroObject.isDead()){
			sbg.enterState(3);
		}
		
		
	}
	
	/**
	 * getID() - returns the id num for this state
	 */
	public int getID()
	{
		return 1;
	}
}
