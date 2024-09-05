import java.util.*;

public class Monster{
	private String name;
	private String description;
	private int health;
	private int damage;
	Random rand = new Random();
	
	public Monster(String n, String d, int h, int dmg){
		this.name = n;
		this.description = d;
		this.health = h;
		this.damage = dmg;
	}

	public int attack(){
		return this.damage;
	}

	public int defend(Player p){
		int incomingAttack = p.attack();
		System.out.println("The monster lost "+incomingAttack+" amount of damage");
		health -= incomingAttack;
		if (health > 0){
			return this.health;
		}
		return 1;
	}
	
	public Monster newRandomMonster(){
		int random = rand.nextInt(8) + 1;
		Monster monster = new Monster("null", "null", 0, 0);
		switch(random){
			case 1:
				monster.setName("Goblin");
				monster.setDescription("A grotesque, small enemy with a medium skill-set");
				monster.setHealth(30);
				monster.setDamage(15);
				break;
			case 2:
				monster.setName("Orc");
				monster.setDescription("A brutish, green mass of destruction with high damage");
				monster.setHealth(20);
				monster.setDamage(30);
				break;
			case 3:
				monster.setName("Shadow");
				monster.setDescription("A dark, elusive entity capable of striking hard");
				monster.setHealth(40);
				monster.setDamage(20);
				break;
			case 4:
				monster.setName("Ghoul");
				monster.setDescription("A pitiful humanoid figure that can't distinguish between friend and foe");
				monster.setHealth(30);
				monster.setDamage(10);
				break;
			case 5:
				monster.setName("Basilisk");
				monster.setDescription("A large snake-being that paralyses its foes with its menacing stare");
				monster.setHealth(40);
				monster.setDamage(25);
				break;
			case 6:
				monster.setName("Banshee");
				monster.setDescription("A writhering soul with a powerful voice capable of deafening its enemies");
				monster.setHealth(50);
				monster.setDamage(15);
				break;
			case 7:
				monster.setName("Skeleton");
				monster.setDescription("A creature made up of entirely bones that creak with revenge");
				monster.setHealth(20);
				monster.setDamage(10);
				break;
		}
		return monster;
	}

	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}

	public int getHealth(){
		return health;
	}

	public int getDamage(){
		return damage;
	}

	public boolean isAlive(){
		return health > 0;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public void setHealth(int health){
		this.health = health;
	}

	public void setDamage(int damage){
		this.damage = damage;
	}

	public String toString(){
		return name + " " + description;
	}
}