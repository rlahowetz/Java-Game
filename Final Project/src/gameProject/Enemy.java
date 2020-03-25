package gameProject;
/**
 * Enemy.java - Models an enemy in Game.java
 * @author Ryan Lahowetz
 *
 */
public class Enemy {

	int att,def,health,coin,xpValue,lv;
	boolean dead;
	Hero hero;
	
	/**
	 * Enemy() - enemy stats based on stats of given hero
	 * @param hero_ - Hero - Current hero used in game
	 */
	public Enemy(Hero hero_){
		hero = hero_;
		att = (hero.getAttack() - 2);
		def = (hero.getDef() - 2);
		lv = (hero.getLvl());
		health = (hero.getCurrentHealth() - 5);
		xpValue = (hero.getNextXP()/10);
		coin = (lv * 2);
		dead = false;
	}
	
	/**
	 * Enemy() - enemy stats given (meant for bosses)
	 * @param hero_ - Hero - current hero used in game
	 * @param att_ - int - represents this enemy's attack
	 * @param def_ - int - represents this enemy's defense
	 * @param coin_ - int - represents this enemy's coin amount
	 * @param xpV - int - represents this enemy's experience value
	 * @param lv_ - int - represents this enemy's level
	 */
	public Enemy(Hero hero_, int att_,int def_,int coin_,int xpV,int lv_){
		hero = hero_;
		att = att_;
		def = def_;
		coin = coin_;
		xpValue = xpV;
		lv = lv_;
	}
	
	/**
	 * isDead() - returns true if this enemy is dead
	 * @return - boolean - true if enemy is dead
	 */
	public boolean isDead(){
		return dead;
	}
	
	/**
	 * battle() - pits enemy vs Hero - returns true if the hero has lost
	 * @return - boolean - true if hero is dead
	 */
	public boolean battle(){
		boolean lost;
		
			//attack > def
			if(hero.getAttack() > def){
				int damage = (hero.getMaxHealth()/10);
				hero.takeDamage(damage);
				this.dead = true;
				hero.gainXP(xpValue);
				hero.gainCoins(coin);
			}
			
			//attack == def
			if(hero.getAttack() == def){
				if(hero.getDef()>att){
					hero.takeDamage(hero.getCurrentHealth()-1);
					this.dead = true;
					hero.gainXP(xpValue);
					hero.gainCoins(coin);
				}
				else
					hero.takeDamage(hero.getCurrentHealth());
			}
			
			//attack < def
			if(hero.getAttack() < def){
				hero.takeDamage(hero.getCurrentHealth());
			}
		
		//deciding factor
		if(hero.isDead())
			lost = true;
		else
			lost=false;
		return lost;
	}
	
	/**
	 * getLvl() - returns enemy's level
	 * @return - int - integer representing this enemy's level
	 */
	public int getLvl(){
		return lv;
	}
}
