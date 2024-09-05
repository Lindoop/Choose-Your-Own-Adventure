import java.util.*;

public class Player{
	private String name;
	private String title;
	private int health;
	private int damage;
	Random rand = new Random();

	public Player(){
		name = "Traveler";
		title = "Peasant";
		health = 100;
		damage = 15;
	}

	public Player(String n, String t, int h, int d){
    this.name=n;
    this.title=t;
    this.health=h;
		this.damage = d;
  }

	public int attack(){
		return this.damage;
	}

	public int defend(Monster m){
		int incomingAttack = m.attack();
		System.out.println("You lost "+incomingAttack+" amount of damage");
		health -= incomingAttack;
		if (health > 0){
			return this.health;
		}
		return 1;
	}
	
  public String getName(){
    return this.name;
  }

  public String getTitle(){
    return this.title; 
  }

  public int getHealth(){
    return this.health;
  }

  public int getDamage(){
    return this.damage;
  }


  public boolean isAlive(){
    return health>0; 
  }

  public void setName(String name){
    this.name = name;
  }

  public void setTitle(String title){
    this.title = title; 
  }

  public void setHealth(int health){
    this.health = health;
  }

  public void setDamage(int damage){
    this.damage = damage;
  }	
}