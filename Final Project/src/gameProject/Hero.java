package gameProject;
import java.util.Random;
/**
 * Hero.java - Models the hero of the game
 * @author Ryan Lahowetz
 *
 */
public class Hero {

	int currentHealth,maxHealth,lv,att,def,curXP,nextXP,coins;
	boolean dead;
	
	/**
	 * Hero() - initializes the hero's stats
	 */
	public Hero(){
		currentHealth = 10;
		maxHealth = 10;
		lv = 1;
		coins = 0;
		att = 10;
		def = 10;
		curXP = 0;
		nextXP = 100;
		dead = false;
	}
	
	/**
	 * getCoins() - returns an integer value representing number of coins the hero has
	 * @return coins - int - number of collected coins
	 */
	public int getCoins(){
		return coins;
	}
	
	/**
	 * getLvl() - returns the integer representing the hero's current level
	 * @return lv - int - Hero's current level
	 */
	public int getLvl(){
		return lv;
	}
	
	/**
	 * getCurrentHealth() - returns an integer representing the hero's current health
	 * @return currentHealth - int - integer representing hero's current health
	 */
	public int getCurrentHealth(){
		return currentHealth;
	}
	
	/**
	 * getMaxHealth() - returns an integer representing the hero's maximum health value
	 * @return maxHealth - int - integer for hero's max health
	 */
	public int getMaxHealth(){
		return maxHealth;
	}
	
	/**
	 * getAttack() - returns an integer representing the hero's Attack stat
	 * @return att - int - hero's attack stat
	 */
	public int getAttack(){
		return att;
	}
	
	/**
	 * getDef() - returns an integer representing the hero's Defense stat
	 * @return def - int - hero's deffense stat
	 */
	public int getDef(){
		return def;
	}
	
	/**
	 * getXP() - returns an integer representing the hero's current Experience points
	 * @return curXP - int - hero's current xp
	 */
	public int getXP(){
		return curXP;
	}
	
	/**
	 * getNextXP() - returns an integer representing the hero's xp needed to level up
	 * @return nextXP - int - int representing xp needed to level up
	 */
	public int getNextXP(){
		return nextXP;
	}
	
	/**
	 * isDead() - returns a boolean value: true if hero is dead (0 current health)
	 * @return dead - boolean - true if hero is dead
	 */
	public boolean isDead(){
		return dead;
	}
	
	/**
	 * gainCoins() - adds given coins to total collected coins
	 * @param coins_ - int - coins to be added
	 */
	public void gainCoins(int coins_){
		this.coins += coins_;
	}
	
	/**
	 * spendCoins() - subtracts the price from the collected coins
	 * @param price - coins to be subtracted
	 */
	public void spendCoins(int price){
		this.coins -= price;
	}
	
	/**
	 * takeDamage() - subtracts given damage and checks if hero is dead
	 * @param dam - int - damage to be taken
	 */
	public void takeDamage(int dam){
		currentHealth -= dam;
		if(currentHealth <= 0){
			currentHealth = 0;
			dead = true;
		}
	}
	
	/**
	 * gainXP() - adds given XP to current XP and levels up if needed
	 * @param xp - int - xp to be added
	 */
	public void gainXP(int xp){
		curXP += xp;
		if(curXP >= nextXP){
			int excess = curXP - nextXP;
			this.lvlUp();
			curXP = excess;
		}
	}
	
	/**
	 * lvlUp() - randomly increases each stat (maxHealth,attack,deffense) between 5-10 and increases lvl by 1
	 */
	private void lvlUp(){
		Random ran = new Random();
		maxHealth += (ran.nextInt(6) + 5);
		if(maxHealth > 100){
			maxHealth = 100;
		}
		att += (ran.nextInt(6) + 5);
		if(att > 100){
			att = 100;
		}
		def += (ran.nextInt(6) + 5);
		if(def > 100){
			def = 100;
		}
		lv++;
	}
}
