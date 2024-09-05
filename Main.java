/*
* Names: Linda Chen and Ridika Tabassum
* Project Description: Creating text base game for culminating project based on dungeons and dragons 
* Date Created: May 23, 2023
* Last Edited: June 12, 2023
* Ethics: This work is ours.
*/

import java.util.*;
import java.io.*;
import java.nio.*;

public class Main {
  public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		Random rand = new Random();
    System.out.println("\n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-\n\nThe Ridinda Dungeon\n");
		System.out.println("Welcome traveler.");
		boolean menu = true;
		while (menu){
			System.out.printf("%n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-%n%nSelect an option:%n%n1. Start Game%n2. Credits%n%n: ");
		int choice = kb.nextInt();
		String temp = kb.nextLine();
		switch(choice){
			case 1: 
				menu = false;
				System.out.printf("%n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-%n%n1. New Game%n2. Load File%n%n: ");
				int game = kb.nextInt();
				boolean start = true;
				while(start){
					if (game == 1){
						roles();
						start = false;
						break;
					} else if (game == 2){
						start = false;
						String flush = kb.nextLine();
						System.out.printf("%n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-%n%nWhat was the name associated with the file you logged out of?%n%n: ");
						String name = kb.nextLine()+".csv";
						try{
							File userFile = new File(name);
							Scanner reader = new Scanner(userFile);
							String ln = reader.nextLine();
							if (reader.hasNext()){
								while (reader.hasNextLine()){
									ln = reader.nextLine();
									String[] lineData = ln.split(",");
									Player p = new Player(lineData[0], lineData[1], Integer.parseInt(lineData[2]), Integer.parseInt(lineData[3]));
									System.out.println("\nYour file will be uploaded now. Welcome back "+p.getName()+".\n\n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-\n");
									newGame(p);
								}
							} else {
								System.out.println("\nERROR: File empty.\nStarting new file.");
								roles();
							}
						} catch (FileNotFoundException e){
							System.out.printf("ERROR: File not found.%n");
							System.out.println("Starting new game");
							roles();
						}
						break;
					} else {
						confused();
						start = true;
					}
				}
				break;
      case 2: 
				menu = false;
        System.out.println("Credits");
				break;			
			}
		}
  }

	public static void roles(){
		Player p = new Player();
		Scanner kb = new Scanner(System.in);
		System.out.printf("%n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-%n%nWelcome Traveler.%n");
		System.out.printf("%nWhat is your name?%n%n: ");
		p.setName(kb.nextLine());
		boolean role = true;
		while (role){
			System.out.printf("%n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-%n%nSelect a character: %n%n1. Noble%n2. Wizard%n3. Witch%n4. Ranger%n5. Peasant%n6. Fairy%n%n: ");
			int t = kb.nextInt();
			String temp = kb.nextLine();
			if (t == 7){
				break;
			}
			
		switch(t){
			case 1: 
				System.out.printf("%n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-%n%n");
				System.out.println("You can brandish your fist, covered in golden rings and deal high damage.");
				System.out.printf("%nDo you wish to change your role?%n%n: ");
				String change = kb.nextLine();
				if (change.equalsIgnoreCase("yes")){
					role = true;
					continue;
				} else if (change.equalsIgnoreCase("no")){
					role = false;
					p.setTitle("Noble");
					p.setDamage(15);
					p.setHealth(90);
					break;
				} else {
					role = true;
					confused();
				}
			case 2:
				System.out.printf("%n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-%n%n");
        System.out.println("With a twirl of your magical staff, you deal high damage to your foes.");
				System.out.printf("%nDo you wish to change your role?%n%n: ");
				change = kb.nextLine();
				if (change.equalsIgnoreCase("yes")){
					role = true;
					break;
				} else if (change.equalsIgnoreCase("no")){
					role = false;
					p.setTitle("Wizard");
					p.setDamage(20);
					p.setHealth(100);
					break;
				} else {
					role = true;
					confused();
				}
			case 3:
				System.out.printf("%n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-%n%n");
				System.out.println("Throwing your potions is your specialty and you deal high damage to your enemies.");
				System.out.printf("%nDo you wish to change your role?%n%n: ");
				change = kb.nextLine();
				if (change.equalsIgnoreCase("yes")){
					role = true;
					break;
				} else if (change.equalsIgnoreCase("no")){
					role = false;
					p.setTitle("Witch");
					p.setDamage(25);
					p.setHealth(60);
					break;
				} else {
					role = true;
					confused();
				}
			case 4:
				System.out.printf("%n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-%n%n");
				System.out.println("Quick and nimble, your arrows pierce the foes, dealing low damage.");
				System.out.printf("%nDo you wish to change your role?%n%n: ");
				change = kb.nextLine();
				if (change.equalsIgnoreCase("yes")){
					role = true;
					break;
				} else if (change.equalsIgnoreCase("no")){
					role = false;
					p.setTitle("Ranger");
					p.setDamage(10);
					p.setHealth(120);
					break;
				} else {
					role = true;
					confused();
				}
			case 5:
				System.out.printf("%n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-%n%n");
				System.out.println("As a normal traveler, you have mediocre stats.");
				System.out.printf("%nDo you wish to change your role?%n%n: ");
				change = kb.nextLine();
				if (change.equalsIgnoreCase("yes")){
					role = true;
					break;
				} else if (change.equalsIgnoreCase("no")){
					role = false;
					p.setTitle("Peasant");
					p.setDamage(10);
					p.setHealth(100);
					break;
				} else {
					role = true;
					confused();
				}
			case 6:
				System.out.printf("%n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-%n%n");
				System.out.println("Small and fragile, you swiftly dodge your opponents' attacks and deal mediocre damage.");
				System.out.printf("%nDo you wish to change your role?%n%n: ");
				change = kb.nextLine();
				if (change.equalsIgnoreCase("yes")){
					role = true;
					break;
				} else if (change.equalsIgnoreCase("no")){
					role = false;
					p.setTitle("Fairy");
					p.setDamage(15);
					p.setHealth(100);
					break;
				} else {
					role = true;
					confused();
				}
			} //end of switch 
		} //end of while
		System.out.printf("%n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-%n%nNow that you've selected your role.%n");
		System.out.println("Welcome to the world of Ridinda, "+p.getTitle()+" "+p.getName()+".\n\n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-\n");
		newGame(p);
	}
	
	public static void saveData(Player p){
		Scanner kb = new Scanner(System.in);
		System.out.println("\n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-\n\nSince you died, you may save your data and try again.");
					
		String fileName = p.getName()+".csv";
		String content = p.getName() + "'s File" + System.lineSeparator() + p.getName()+","+p.getTitle()+","+100+","+p.getDamage();
		try{
			File file = new File(fileName);
			if (file.createNewFile()){
				try (FileWriter writer = new FileWriter(fileName)){
					writer.write(content);
					System.out.println("File created: " + file.getAbsolutePath());
				} catch (IOException e){
					System.out.println("An error occurred: "+e.getMessage());
					e.printStackTrace();
				}
			} else {
				System.out.print("File already exists.\n\nDo you wish to overwrite the existing file?\n> Yes\n> No\n\n:");
				String choice = kb.nextLine();
				if(choice.equalsIgnoreCase("yes")){
					try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(content.getBytes());
            System.out.println("File overwritten successfully.");
        	} catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        	}
				} else if (choice.equalsIgnoreCase("no")){
						System.out.println("Data not saved.");
				} else {
					confused();
					saveData(p);
				}
				endGame(p);
			}
		} catch (IOException e){
			System.out.println("An error occurred: " + e.getMessage());
      e.printStackTrace();
		}
	}

	public static void endGame(Player p){
		System.out.println("\n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-");
		System.out.println(" _____  _   _  _____  _   _  _   _     _     _  _____  _   _     ___    _____  ___       ___    _      _____  _     _  _  _   _  ___   \n(_   _)( ) ( )(  _  )( ) ( )( ) ( )   ( )   ( )(  _  )( ) ( )   (  _`\\ (  _  )|  _`\\    (  _`\\ ( )    (  _  )( )   ( )(_)( ) ( )(  _`\\ \n  | |  | |_| || (_) || `\\| || |/'/'   `\\`\\_/'/'| ( ) || | | |   | (_(_)| ( ) || (_) )   | |_) )| |    | (_) |`\\`\\_/'/'| || `\\| || ( (_)\n  | |  |  _  ||  _  || , ` || , <       `\\ /'  | | | || | | |   |  _)  | | | || ,  /    | ,__/'| |  _ |  _  |  `\\ /'  | || , ` || |___ \n  | |  | | | || | | || |`\\ || |\\`\\       | |   | (_) || (_) |   | |    | (_) || |\\ \\    | |    | |_( )| | | |   | |   | || |`\\ || (_, )\n  (_)  (_) (_)(_) (_)(_) (_)(_) (_)      (_)   (_____)(_____)   (_)    (_____)(_) (_)   (_)    (____/'(_) (_)   (_)   (_)(_) (_)(____/'");
		System.out.println("\n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-\n\n");
		System.exit(0);
	}

	public static int battle(Player p, Monster m){
		Scanner kb = new Scanner(System.in);
		System.out.println("\n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-\n\nYou are battling a "+ m.getName()+", "+m.getDescription()+".");
		System.out.printf("%n-------------------------------------------------%n|%26s%22s%n|-----------------------------------------------|%n|%s%20d|%s%19d|%n|-----------------------------------------------|%n|%s%12d|%s%11d|%n|-----------------------------------------------|%n", "STATS", "|", "HP:", p.getHealth(), "DMG:", p.getDamage(), "MONSTER HP:", m.getHealth(), "MONSTER DMG:", m.getDamage());
		System.out.printf("%nWhat will you do?%n> Attack%n> Run%n%n: ");
		String choice = kb.nextLine();
		if (choice.equalsIgnoreCase("attack")){
			m.defend(p);
			while (m.getHealth() > 0){
				p.defend(m);
				if (p.getHealth() > 0){
					battle(p, m);
					if (m.getHealth() <= 0){
						return 1;
					}
					break;
				} else {
					return -1;
				}
			}
		} else if (choice.equalsIgnoreCase("run")){
			return 2;
		} else {
			confused();
			battle(p, m);
		}
		return 1;
	}

	public static void newGame(Player p){
		System.out.print("You are "+p.getName()+", a "+p.getTitle()+" living in the kingdom of Ridinda. ");
		if (p.getTitle().equals("Noble")){
			nobleStory(p);
		} else if (p.getTitle().equals("Wizard")){
			wizardStory(p);
		} else if (p.getTitle().equals("Witch")){
			witchStory(p);
		} else if (p.getTitle().equals("Ranger")){
			rangerStory(p);
		} else if (p.getTitle().equals("Peasant")){
			peasantStory(p);
		} else {
			fairyStory(p);
		}
	}

	public static void confused(){
		Random rand = new Random();
		int confuse = rand.nextInt(5)+1;
		if (confuse == 1){
			System.out.println("\nYour confusing me. Try something different.\n");
		} else if (confuse == 2){
      System.out.println("\nSorry that doesn't make sense to me.\n");
    } else if (confuse == 3){
			System.out.println("\nI'm not sure what you mean.\n");
		} else if (confuse == 4){
      System.out.println("\nUhh, try something else.\n");
    } else {
			System.out.println("\nWhat? I don't understand.\n");
		}
  }

	public static int guessTheNumber(int number, int guess, int counter){
		Scanner kb = new Scanner(System.in);
		if (guess < 1000 || guess > 9999){
			System.out.print("\nYou enter in the number "+guess+", but remember that it is a 4-digit number you should be trying.\n\n: ");
			guess = kb.nextInt();
			counter++;
			return guessTheNumber(number, guess, counter);
		} else if (guess == number){
			System.out.println("\nYou enter in the number "+guess+" ... Oh! The gate is opening. You did it.\n");
			return counter;
		}else if (guess > number){
			System.out.print("\nYou enter in the number "+guess+". Nothing happens. Looks like you should try something lower.\n\n: ");
			guess = kb.nextInt();
			counter++;
			return guessTheNumber(number, guess, counter);
		} else if (guess < number){
			System.out.print("\nYou enter in the number "+guess+". Nothing happens. Looks like you should try something higher.\n\n: ");
			guess = kb.nextInt();
			counter++;
			return guessTheNumber(number, guess, counter);
		} else {
			System.out.print("\nWhat are you thinking? That clearly isn't the password. Try again.\n\n: ");
			guess = kb.nextInt();
			counter++;
			return guessTheNumber(number, guess, counter);
		}
	}

	public static int mazeSequence(String direction, int phase){
		Scanner kb = new Scanner(System.in);
		boolean choice = true;
		if (phase == 0){
			System.out.println("You turn "+direction+" and go down a straight road for a while. During this time you wonder if you’re ever going to reach the end. Determined as you are, you use your staff as a lantern. You reach another fork in the maze.");
		} else if (phase == 1){
			System.out.println("You turn "+direction+", leading straight into another fork. You start to regain some hope. You reach another fork in the maze.");
		} else if (phase == 2){
			System.out.println("You turn "+direction+" this time before your light suddenly goes out. You try to recast the spell but to no luck. This must be a more complex curse from the builders of the ruin. You must be close. You venture down the corridor. You reach another fork in the maze.");
		} else if (phase == 3){
			System.out.println("How long have you been turning? You don’t know, it seems like it’s been forever. The darkness is starting to get to you. You reach another fork in the maze.");
		} else if (phase == 4){
			System.out.println("You turn "+direction+" again. You think that the darkness must be making you feel claustrophobic, but it is the walls pushing toward you. You start running, desperately trying to outrun the maze closing in on you. You see another fork in the maze.");
		} else if (phase == 5){
			System.out.println("You quickly make a "+direction+" and see a light in the distance. The walls are still closing in on you, faster than ever. You try to cast a speed spell as a last resort… and it works! You speed towards the light and enter a room. You did it.");
		}
		if (phase != 5){
			do{
				System.out.print("\nWhich way?\n> Left\n> Right\n\n: ");
				String action = kb.nextLine();
				if (action.equalsIgnoreCase("left")){
					phase++;
					choice = false;
					return mazeSequence("left", phase);
				} else if (action.equalsIgnoreCase("right")){
					phase++;
					choice = false;
					return mazeSequence("right", phase);
				} else {
					choice = true;
					confused();
					return mazeSequence(direction, phase);
				}
			} while(choice);
		} else {
			return 1;
		}
	}
	
	public static void nobleStory(Player p){
		Scanner kb = new Scanner(System.in);
		Random rand = new Random();
		boolean choice = true;
		String action = "";
		System.out.println("You have a pouch of gold and a small dagger. You are awakened by one of your servants who tells you that your keep is under attack. You look out the window and see an army of undead warriors attack the guards and destroy them. You grab your sword and dagger and go down into the keep, you see that the courtyard and gatehouse are being attacked by the undead.");
		do{
			System.out.print("\nWhat will you do?\n> Attack\n> Ignore\n\n: ");
			action = kb.nextLine();
			if (action.equalsIgnoreCase("attack")){
				choice = false;
				Monster m = new Monster("Undead", "A corpse still trapped in this world", 30, 10);
				int result = battle(p, m);
					if (result == 1){
						System.out.println("\nMonster dead. YOU WON");
						System.out.println("\n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-\n");
					} else if (result == -1){
						System.out.println("\nYou died. GAME OVER");
						System.out.println("\n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-\n");
						saveData(p);
						break;
					} else if (result == 2){
						System.out.println("You fled from the scene.");
						System.out.println("\n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-\n");
					} else {
						System.out.println("How did you get here?");
						System.out.println("\n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-\n");
					}
				
			} else if (action.equalsIgnoreCase("ignore")){
				System.out.println("\nYou walked away as a coward, leaving the undead to freely enter your keep.");
				choice = false;
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);
		System.out.println("You go towards the blacksmith to get a new weapon, but realize that the blacksmith’s cabin is in complete ruins while everything else is unharmed. After a moment of shock, you determine that the undead came from the blacksmith and the undead at your keep were just a distraction. Why they took the blacksmith is still unknown to you, but you decide to suit up and venture off to retrieve the blacksmith from the monsters.\n\nYou decide to venture off on the paved road you had your servants make so long ago. Eventually, though, the road comes to an end and you begin walking on endless plains. You walk for a long time, the sun’s beginning to set, before seeing a small hut in the distance.");
		do{
			System.out.print("\nWhat will you do?\n> Knock\n> Ignore\n\n: ");
			action = kb.nextLine();
			if (action.equalsIgnoreCase("knock")){
				choice = false;
				System.out.println("\nYou walk up to it and knock. A few seconds later, a frail old lady opens the door. She says something in a different language to something behind her. You ask if you can stay the night. She eerily smiles and says that she has an extra bed for him to stay on. You become uncomfortable, but know you can’t survive the night outside anyways so you go in. You see a large alligator on the couch, chewing up an arm. You feel sick, but decide to not question it. Alligators are carnivores anyway. The old lady leads you to a door, opening it for you. You enter cautiously and see a regular bedroom, albeit a bit dusty. The old lady bids you goodnight and closes the door behind you.");
				System.out.println("\n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-\n");
				System.out.println("You wake up in the middle of the night to the sound of the door opening. You slowly reach over to where you left your knife and wait. Growls are emitting from the door, so you slowly turn around to come face to face with the alligator, but the alligator is bigger than when you first saw it.");
				do{
					System.out.print("\nWhat will you do?\n> Attack\n> Run\n\n: ");
					action = kb.nextLine();
					if (action.equalsIgnoreCase("attack")){
						choice = false;
						Monster m = new Monster("Giant Alligator", "A huge, threatening carnivorous alligator", 60, 30);
						int result = battle(p, m);
							if (result == 1){
								System.out.println("\nMonster dead. YOU WON");
							} else if (result == -1){
								System.out.println("\nInjured heavily from several open wounds, you watch as the alligator looms over to deal a final bite. Your last thoughts were that of how you shouldn’t have entered the hut, before one last stab of pain and everything goes black.");
								System.out.println("\nYou died. GAME OVER");
								saveData(p);
								break;
							} else if (result == 2){
								System.out.println("Terrified, you try to run away, but the alligator tackles you immediately. As it rears back to deal a final blow, you look over the alligator to see the frail old lady. You realize that she's the vile witch that you've been trying to get rid of the entire time. As you curse your little naive self, the world goes black.");
								System.out.println("\nYou died. GAME OVER");
								saveData(p);
							} else {
								System.out.println("How did you get here?");
							}
					} else if (action.equalsIgnoreCase("run")){
						System.out.println("\nYou quickly jump out of bed. You try to see if you can get around the alligator and reach the door, but it seems like you can’t. You look to the window on your right and see that there is a lock on it.");
						do{
							System.out.print("\nWhat will you do?\n> Door\n> Window\n\n: ");
							action = kb.nextLine();
							if (action.equalsIgnoreCase("door")){
							System.out.println("You make a run for the door, thinking you can make it. But the old lady is standing there, wearing a black gown? Oh, you realize, this old lady is the vile witch that lives near your town.");
							do{
								System.out.print("\nWhat will you do?\n> Attack\n> Run\n\n: ");
								action = kb.nextLine();
								if (action.equalsIgnoreCase("attack")){
									choice = false;
									Monster m = new Monster("Vile Witch", "A frail old alligator lady that is going to kill you", 90, 20);
									int result = battle(p, m);
									if (result == 1){
										System.out.println("\nMonster dead. YOU WON");
									} else if (result == -1){
										System.out.println("\nHeavily injured, you stare up at the witch as she looms over you. She utters a killing command to the alligator. You regretfully think of the blacksmith you were unable to save and how you shouldn’t have entered this hut, before everything goes black.");
										System.out.println("\nYou died. GAME OVER");
										saveData(p);
										break;
									} else if (result == 2){
										System.out.println("Changing your mind last second, you try to run away from the witch's wrath. You, however, forgot that she can cast spells and you feel your legs seize up and you fall to the ground. Paralyzed, you stare up at the witch as she looms over you. She utters a killing command to the alligator. You regretfully think of the blacksmith you were unable to save and how you shouldn’t have entered this hut, before everything goes black.");
										System.out.println("\nYou died. GAME OVER");
										saveData(p);
									} else {
										System.out.println("How did you get here?");
									}
									System.out.println("\n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-\n");
								} else if (action.equalsIgnoreCase("run")){
										System.out.println("\nYou fake the witch out, managing to run past the door. You, however, forgot that she can cast spells and you feel your legs seize up and you fall to the ground. Paralyzed, you stare up at the witch as she looms over you. She utters a killing command to the alligator. You regretfully think of the blacksmith you were unable to save and how you shouldn’t have entered this hut, before everything goes black.");
										choice = false;
								} else {
									confused();
									choice = true;
									continue;
								}
							} while (choice);
						} else if (action.equalsIgnoreCase("window")){
								choice = false;
								System.out.println("\nYou quickly examine the lock and realize that you have to organize the numbers listed.");
								ArrayList<Integer> list = new ArrayList<>();
								for (int i = 0; i < 10; i++){
									list.add(rand.nextInt(10)+1);
								}
								System.out.println(list);
								do{
									Sorting s = new Sorting();
									System.out.print("\nWhat will you do?\n> Swap\n> Select\n> Insert\n> Merge\n> Quick\n\n: ");
									action = kb.nextLine();
									if (action.equalsIgnoreCase("swap")){
										choice = false;
										s.bubbleSort(list);
									} else if (action.equalsIgnoreCase("select")){
										choice = false;
										s.selectSort(list);
									} else if (action.equalsIgnoreCase("insert")){
										choice = false;
										s.insertSort(list);
									} else if (action.equalsIgnoreCase("merge")){
										choice = false;
										s.mergeSort(list);
									} else if (action.equalsIgnoreCase("quick")){
										choice = false;
										s.quickSort(list);
									} else {
										confused();
										choice = true;
										continue;
									}
									System.out.print("You did it! You sorted the numbers and the window unlocked.");
									System.out.println("Surprisingly, the alligator remained quiet as you were doing this, and you leap out into the night, running away from the hut. You look back to see if the alligator or the old lady are following you, but see nothing. There wasn’t a hut in the first place? You don’t stop to ponder this however, and keep running.");
								} while (choice);	
							} else {
								confused();
								choice = true;
								continue;
							}
						} while (choice);
					} else {
						confused();
						choice = true;
						continue;
					}
				} while (choice);
			} else if (action.equalsIgnoreCase("ignore")){
				System.out.println("\nYou gather your senses and remember that this is still a strange hut and you shouldn’t enter anyone’s hut unless it’s family or an ally.");
				choice = false;
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);
		System.out.println("You eventually come to a fortress-like building. There are undead wandering around and you know this is the right place. You look around and, surprisingly, see a peasant near the wall of the fortress. You recognize this peasant, it is one of the peasants that live in the town under your rule after all.");
		do{
			System.out.print("\nWhat will you do?\n> Team\n> Solo\n\n: ");
			action = kb.nextLine();
			if (action.equalsIgnoreCase("team")){
				choice = false;
				System.out.println("You decide to team up with the peasant to infiltrate the fortress. The two of you successfully climb over the wall and come up to a horrific scene. It is the blacksmith, tied to a post in the center, over a fire. You quickly go up to the blacksmith and cut him free, the peasant helping. Unfortunately, the three of you notice a couple of undead heading over and know that the whole horde will be alerted soon.");
				do{
					System.out.print("\nWhat will you do?\n> Attack\n> Run\n\n: ");
					action = kb.nextLine();
					if (action.equalsIgnoreCase("attack")){
						choice = false;
						System.out.println("You realize that the three of you are clearly outmatched. You, a courageous ruler, decide to sacrifice yourself to the undead so that the peasant and blacksmith can escape, as the town desperately needs the blacksmith.");
						Monster m = new Monster("Undead Horde", "A group of corpses that will kill you", 150, 40);
						int result = battle(p, m);
						if (result == 1){
							System.out.println("\nMonster dead. YOU WON");
						} else if (result == -1){
							System.out.println("\nYou realize that the three of you are clearly outmatched. You, a courageous ruler, decide to sacrifice yourself to the undead so that the peasant and blacksmith can escape, as the town desperately needs the blacksmith. As you succumb to the undead, you see the peasant hauling the blacksmith over the fortress and suddenly everything goes white.");
							System.out.println("\nYou died. GAME OVER");
							saveData(p);
							break;
						} else if (result == 2){
							System.out.println("\nYou carry the blacksmith, as the peasant brandishes a sword and charges towards the undead, yelling out to you that you need to run away now. You regret leaving the peasant but know that, without the blacksmith, the town will succumb to the monsters so you mournfully run away with the blacksmith as the peasant. You return to the town with the blacksmith. Everyone congratulates you for bringing him back, but no one seems to realize the peasant, the hero, never returned. In fact, you don’t think anyone knew of their existence except you. In honor of the peasant, you have a statue built for them.");
							saveData(p);
						} else {
							System.out.println("How did you get here?");
						}
						System.out.println("\n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-\n");
					} else if (action.equalsIgnoreCase("run")){
						System.out.println("\nYou carry the blacksmith, as the peasant brandishes a sword and charges towards the undead, yelling out to you that you need to run away now. You regret leaving the peasant but know that, without the blacksmith, the town will succumb to the monsters so you mournfully run away with the blacksmith as the peasant.\n\n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-\n\nYou return to the town with the blacksmith. Everyone congratulates you for bringing him back, but no one seems to realize the peasant, the hero, never returned. In fact, you don’t think anyone knew of their existence except you. In honor of the peasant, you have a statue built for them.");
						endGame(p);
						choice = false;
					} else {
						confused();
						choice = true;
						continue;
					}
				} while (choice);
			} else if (action.equalsIgnoreCase("solo")){
				System.out.println("\nYou quickly jump over the wall. You see the blacksmith tied to a post in the center over a fire. You quickly go up to the blacksmith and cut him free, all the while the undead seem to realize there’s an infiltrator. You frantically cut faster, hoping you can get the blacksmith free before the whole fortress of undead realizes you are here. You free the blacksmith and quickly put him on your back. There’s a whole crowd of undead surrounding you. You fear you may not be able to save the both of you, but you try anyway. You start running, slowed down by the weight of the blacksmith, towards the wall. You have to fight a couple undead along the way, but you have your eyes set on the wall you have to climb. You start to climb the wall, but some of the undead have grabbed onto your leg. You brace yourself but hear a shout. You look up. It’s the peasant, reaching an arm down. They yell to pass the blacksmith over, so you, not thinking twice, immediately throw him up. The peasant safely loads the blacksmith over the wall but, when you reach out a hand, expecting the peasant to also bring you over to safety, the peasant looks away. You, betrayed, begin to fall into the undead, succumbing to the darkness.");
				choice = false;
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);
	}

	public static void wizardStory(Player p){
		Scanner kb = new Scanner(System.in);
		Random rand = new Random();
		boolean choice = true;
		String action = "";
		System.out.println("You have a staff and a spellbook. You finish your long journey and finally arrive at the ruin you've been looking for. You have come here searching for a mystical spellbook of great power called the book of essence. You look around and see no one in the sky island. You look down and see a trail leading underground, to a large underground temple. As you enter you notice a large figure, as your eyes adjust to the darkness you see a ginormous statue of a rabbit and a serpent. You keep that in mind as you reach a gate. It seems like this gate can be opened by entering a four digit number.\n");
		int number = rand.nextInt(9000)+1000;
		System.out.print("What is your guess?\n\n: ");
		int guess = kb.nextInt();
		String flush = kb.nextLine();
		guessTheNumber(number, guess, 0);
		System.out.println("You walk past the now open gate, feeling proud of yourself. As you venture deeper into the temple and realize you’re stuck in a maze.");
		do{
			System.out.print("\nWhich way?\n> Left\n> Right\n\n: ");
			String direction = kb.nextLine();
			if (direction.equalsIgnoreCase("left")){
				choice = false;
				mazeSequence("left", 0);
				System.out.println("\n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-\n");
			} else if (direction.equalsIgnoreCase("right")){
				mazeSequence("right", 0);
				choice = false;
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);
		System.out.println("You are suddenly quite famished and decide to stop to take a rest after running.");
		do{
			System.out.print("\nWhat will you eat?\n> Fruit\n> Meat\n\n: ");
			action = kb.nextLine();
			if (action.equalsIgnoreCase("fruit")){
				choice = false;
				System.out.println("You bring out fruits to try and relieve your thirst. You hear a rustle to your left. You turn and make eye contact with a large rabbit. You scream, dropping all your fruits and backing away hastily picking up your staff. The rabbit’s eyes aren’t on you though, they are staring at the fruits you dropped. The rabbit lops over to the fruit and starts to gobble them up.");
				do{
					System.out.print("\nWhat will you do?\n> Attack\n> Offer Food\n\n: ");
					action = kb.nextLine();
					if (action.equalsIgnoreCase("attack")){
						choice = false;
						System.out.println("You take advantage of the rabbit being distraacted by the fruit and charge.");
						Monster m = new Monster("Giant Bunny", "A seemingly nonthreatening animal but you attack anyway", 60, 10);
						int result = battle(p, m);
						if (result == 1){
							System.out.println("\nMonster dead. YOU WON");
						} else if (result == -1){
							System.out.println("\nThe rabbit was stronger than you thought and, as you look up at the rabbit weakly, you see the engravings on the walls of the temple. There are rabbits and serpents. The rabbit must be a sort of guardian? You can't think anymore, and, as you fall into the darkness, you think about all the wonders that you could have seen in the ruins if you hadn't been so on edge.");
							System.out.println("\nYou died. GAME OVER");
							saveData(p);
							break;
						} else if (result == 2){
							System.out.println("\nYou tried to flee from the serpent, but to no avail, it strikes you down with its powerful tail, and everything goes black.");
							saveData(p);
						} else {
							System.out.println("How did you get here?");
						}
						System.out.println("\n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-\n");
						System.out.println("You stand, victorious. However, you feel a terrifying presence behind you. You fear to turn around, but you do anyway. A giant serpent stares at you with cold anger. You back away, clutching your staff with fear as the serpent slithers towards you. You look around, seeing if there’s any way you can escape the serpent’s wrath, when you realize: the engravings of the temple are of serpents and rabbits. You look back up at the serpent as it reels back for the finishing strike, realizing in horror that the serpent is one of the guardians of the ruins. The serpent strikes you down as your last thoughts were of how foolish you were to kill the rabbit guardian while it wasn’t even threatening. You deserve this.");
						endGame(p);
					} else if (action.equalsIgnoreCase("offer food")){
						choice = false;
						System.out.println("The rabbit doesn’t seem to be threatening and overall just… hungry? You have more fruits left in your traveling bag, so you dump out the remainder of the fruits and assorted vegetables in front of the rabbit. It eagerly jumps over to devour the fruits. You watch in amusement as the rabbit messily eats, but suddenly feel a presence above you. You look up and see a serpent. It doesn’t seem rather threatening, however, but it does seem to be blocking something. You watch as it drops down and reveals a hole in the ceiling.");
					} else {
						confused();
						choice = true;
						continue;
					}
				} while (choice);
			} else if (action.equalsIgnoreCase("meat")){
				choice = false;
				System.out.println("You bring out a sandwich you made containing some lamb and beef. Something lands on the ground beside your feet. It’s a rock? You look up to see a large serpent observing you. You stumble back, dropping your sandwich and hastily picking up your staff. The serpent picks up the fallen sandwich and gobbles it up.");
				do{
					System.out.print("\nWhat will you do?\n> Attack\n> Offer Food\n\n: ");
					action = kb.nextLine();
					if (action.equalsIgnoreCase("attack")){
						choice = false;
						System.out.println("You charge at the serpent, as fearful as you are.");
						Monster m = new Monster("Giant Serpent", "A large serpent that you fear you may not be able to kill", 70, 30);
						int result = battle(p, m);
						if (result == 1){
							System.out.println("\nMonster dead. YOU WON");
						} else if (result == -1){
							System.out.println("\nHeavily wounded as you are, you realize the engravings on the temple are of serpents and rabbits. You look back up at the serpent as it reels back for the finishing strike, realizing in horror that the serpent is one of the guardians of the ruins. The serpent strikes you down as your last thoughts were of how you failed to truly learn the ruins like you swore to do.");
							System.out.println("\nYou died. GAME OVER");
							saveData(p);
							break;
						} else if (result == 2){
							System.out.println("\nYou tried to flee from the serpent, but to no avail, it strikes you down with its powerful tail, and everything goes black.");
							saveData(p);
						} else {
							System.out.println("How did you get here?");
						}
						System.out.println("\n-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-~~*~~-\n");
					} else if (action.equalsIgnoreCase("offer food")){
						choice = false;
						System.out.println("You realize that maybe the serpent has been here for as long as the ruin has been and hasn’t seen that many humans or anything to feed on. You summon another sandwich from your bag and offer it to the serpent. The serpent stares at the sandwich in your hand, before lowering itself and opening its mouth to welcome the sandwich. You toss the sandwich into the mouth and watch as the serpent eagerly eats it. The serpent regards you with a newfound respect, and drops down, revealing a hole in the ceiling.");
					} else {
						confused();
						choice = true;
						continue;
					}
				} while (choice);
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);
		System.out.println("The serpent looks at you and you, somehow knowing what it wants, climb onto the serpent. It starts to rise up towards the hole in the ceiling, you duck as it passes through the hole. It seems like forever you’ve been rising, but eventually you reach a room. This room is covered head to toe with ancient books and scrolls. You itch to go towards them immediately, but you turn towards the serpent. The serpent gives you an approving nod and off you go. Pulling out books and books, scrolls and maps. You sit down beside your little stack, eager to continue your life here, surrounded by everything you worked hard to get to. You hear a rumble behind you, as the serpent seems to shrink and come towards you. It climbs your staff and engraves itself onto it. You stare at your new staff transfixed, as you hear soft steps behind you. It’s a large rabbit. Staring at you, before also shrinking and climbing onto your head. You are now the new guardian of the ruins, able to test other researchers like yourself and teach them lessons.");
	}

	public static void witchStory(Player p){
		Scanner kb = new Scanner(System.in);
		Random rand = new Random();
		boolean choice = true;
		System.out.println("You have a wand and a pet alligator named Bob. As you sit in your swamp hut mixing a magical potion, you hear a knock at the door. You open it and see a hooded figure on the other side. They knock again and, when you open it, they smile eerily.");
		do{
			System.out.print("What will you do?\n> Engage\n> Ignore\n\n: ");
			String action = kb.nextLine();
			if (action.equalsIgnoreCase("engage")){
				choice = false;
				System.out.println("\nYou ask what the hooded figure wants, and he draws out a dagger and attacks.");
				Monster m = new Monster("Mysterious Figure", "Unknown humanoid figure with a dagger.", 75, 15);
				int result = battle(p, m);
				if (result == 1){
					System.out.println("\nMonster dead. YOU WON");
				} else if (result == -1){
					System.out.println("\nYou were unable to kill the mysterious figure and, as the dagger plunges through your frail body, you give into the darkness. Distinctly, you hear Bob attack the mysterious figure.");
					System.out.println("\nYou died. GAME OVER");
					saveData(p);
					break;
				} else if (result == 2){
					System.out.println("\nYou fled the scene.");
				} else {
					System.out.println("How did you get here?");
				}
			} else if (action.equalsIgnoreCase("ignore")){
				choice = false;
				System.out.println("\nYou closed the door and locked it with one of your spells.");
				System.out.println("The figure draws a sword through your door, almost piercing you. Your alligator becomes enraged and charges through the door to deal with the hooded figure. A couple seconds later, Bob comes back with a severed arm.");
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);
		System.out.println("You grasp the severed arm of the hooded figure that is now dead. Suddenly, you hear thunderous shouting in the distance as a horde of barbarians come out of the trees to attack you.");
		do{
			System.out.print("What will you do?\n> Attack\n> Run\n\n: ");
			String action = kb.nextLine();
			if (action.equalsIgnoreCase("attack")){
				choice = false;
				System.out.println("\nYou stand your guard, regardless of the fact you are clearly outmatched.");
				Monster m = new Monster("Horde of Barbarians", "A large group of humans looking to end your life", 130, 30);
				int result = battle(p, m);
				if (result == 1){
							System.out.println("\nMonster dead. YOU WON");
						} else if (result == -1){
							System.out.println("\nAs you’re dying, you look up to see the barbarians attacking the alligator. You cast a quick spell to transform him into a bird and call out for him to flee. He does, hesitantly. Oh what a loyal friend, are your last thoughts.");
							System.out.println("\nYou died. GAME OVER");
							saveData(p);
							break;
						} else if (result == 2){
							System.out.println("\nYou fled the scene.");
						} else {
							System.out.println("How did you get here?");
						}
			} else if (action.equalsIgnoreCase("run")){
				choice = false;
				System.out.println("\nYou closed the door and locked it with one of your spells.");
				System.out.println("The figure draws a sword through your door, almost piercing you. Your alligator becomes enraged and charges through the door to deal with the hooded figure. A couple seconds later, Bob comes back with a severed arm.");
			} else {
				confused();
				choice = true;
				continue;
			}
		} while(choice);
	}

	public static void rangerStory(Player p){ 
		Scanner kb = new Scanner(System.in);
		Random rand = new Random();
		boolean choice = true;
		String action;
    System.out.println("You have a hunting bow and a quiver of arrows. You have been searching for a mystical beast for 3 months tracking it through the forest. As you crouch behind a clump of trees you see a pair of eyes glowing from the path. "); 
    do{
			System.out.println("What will you do?\n> Inspect\n> run\n\n: ");
			action = kb.nextLine();
			if (action.equalsIgnoreCase("inspect")){
				choice = false;
				System.out.println("As you adjust to the dark lighting of the dreary forest, to find behold the one and only beast you have been searching for. However, you pull out your pouch only to find it does not quite match the description of what's written in the book. It was titled the “beast”, described to be as large as 3 bears with legs as big as boulders, and unique gold eyes. Here, towering over you was simply a bear with oddly gold-piercing eyes seeming as if it is performing its daily hunt for survival. Nonetheless, you do not doubt your senses and believe that this is the beast you have been venturing day and night in hopes of learning more. "); 
        
			} else if (action.equalsIgnoreCase("run") || action.equalsIgnoreCase("run away")){
				System.out.println("\nYou decided to flee from the glowing eyes.");
        do{
					System.out.print("Would you like to rechoose your role?\n> Yes\n> No\n\n: ");
					action = kb.nextLine();
					if (action.equalsIgnoreCase("yes")){
						choice = false;
						roles();
					} else if (action.equalsIgnoreCase("no")){
						choice = false;
						endGame(p);
					} else {
						confused();
						choice = true;
						continue;
					}
				} while (choice);
        choice = false;
        
      } else {
				confused();
				choice = true;
				continue;
			}
		} while (choice); 
     
    do{
			System.out.println("What is ypur first reaction?\n> Attack\n> run\n\n: ");
			action = kb.nextLine();
			if (action.equalsIgnoreCase("attack")){
				choice = false;
				System.out.println("You pull back your bow string and send the arrow flying. Your shot hits the creature on the shoulder and it falls to the ground screaming. You draw your sword and run forward, cutting through the beast's neck. The beast lets out another piercing screech. ");
			} else if (action.equalsIgnoreCase("run") || action.equalsIgnoreCase("run away")){
				System.out.println("\nYou fled away, deciding that hunting down this monster was not meant to be.");
				do{
					System.out.print("Would you like to rechoose your role?\n> Yes\n> No\n\n: ");
					action = kb.nextLine();
					if (action.equalsIgnoreCase("yes")){
						choice = false;
						roles();
					} else if (action.equalsIgnoreCase("no")){
						choice = false;
						endGame(p);
					} else {
						confused();
						choice = true;
						continue;
					}
				} while (choice);
        choice = false;
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);

    System.out.println("Preparing for another attack, suddenly the tone shifts and it goes quiet. You get confused as you watch the beast laying down as if it were asleep. ");
     do{
			System.out.println("What will you do?\n> Inspect\n> Ignore\n\n: ");
			action = kb.nextLine();
			if (action.equalsIgnoreCase("inspect")){
				choice = false;
				System.out.println("You poke the beast, finally waking it. As it opens its eyes your confusion turns into alarm as its eyes went from golden to a raging red, this time staring at you as if it were your prey. Looking at you with a hunger for pain and anger, you slowly position yourself for another encounter. When the beast gets up with a moan, this time seeming bigger and stronger than it previously was, this time seeming must more like the name of its description. Like the size of 3 bears but with thick legs. The beast lunges at you with might, so strong the wind follows it almost knocking off your balance as you dodge the attack with strength and speed. From your distance you pull out another arrow this time lighting it on fire in hopes it will have a more painful impact on the beast, this time aiming for its heart. ");
			} else if (action.equalsIgnoreCase("ignore")){
				System.out.println("\nYou walked away as a coward.");
        do{
					System.out.print("Would you like to rechoose your role?\n> Yes\n> No\n\n: ");
					action = kb.nextLine();
					if (action.equalsIgnoreCase("yes")){
						choice = false;
						roles();
					} else if (action.equalsIgnoreCase("no")){
						choice = false;
						endGame(p);
					} else {
						confused();
						choice = true;
						continue;
					}
				} while (choice);
				choice = false;
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);
     do{
			System.out.print("What will you do?\n> Shoot\n> Ignore\n\n: ");
			action = kb.nextLine();
			if (action.equalsIgnoreCase("shoot")){
				choice = false;
				System.out.println("You shoot the arrow with a slight tremor and a bead of sweat rolling down your forehead, you breathe and release.Your arrow misses by a mere few inches, barely piercing and instantly extinguishing the fire from the arrow. ");
			} else if (action.equalsIgnoreCase("ignore")){
				System.out.println("\nYou walked away as a coward.");
        do{
					System.out.print("Would you like to rechoose your role?\n> Yes\n> No\n\n: ");
					action = kb.nextLine();
					if (action.equalsIgnoreCase("yes")){
						choice = false;
						roles();
					} else if (action.equalsIgnoreCase("no")){
						choice = false;
						endGame(p);
					} else {
						confused();
						choice = true;
						continue;
					}
				} while (choice);
				choice = false;
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);
    System.out.println("The beast stays unreacted as if it were merely pinched by a bug. This time the beast backs off into the shadows, quickly and quietly causing you to lose all trace. How is it possible? Such a large creature vanished without a trace. Suddenly you hear a large rumble from behind, as you turn around a large blow hits you in the head sending you flying forward and blacking out for a second. After a few seconds, you open your eyes readjusting to the light, feeling dizzy and seeing stars, dazed by the sudden interaction. Suddenly in instant fear rushing through your veins you stand up faster than you should have. Drawing your sword, ignoring the pulsing in your head and your bones shrieking for a break. A fast shadow passes by catching your attention, thesis time fixing your stance hyper-aware of your surroundings determined to defeat this beast. You see another shadow this time you…");

     do{
			System.out.println("What will you do?\n> attack\n> Ignore\n\n: ");
			action = kb.nextLine();
			if (action.equalsIgnoreCase("attack")){
				choice = false;
				System.out.println("This time you hear a satisfying shrill, from the creature, you experience a slight feeling of pride ");
        
			} else if (action.equalsIgnoreCase("ignore") || action.equalsIgnoreCase("walk away")){
				System.out.println("\nYou walked away as a coward.");
        do{
					System.out.print("Would you like to rechoose your role?\n> Yes\n> No\n\n: ");
					action = kb.nextLine();
					if (action.equalsIgnoreCase("yes")){
						choice = false;
						roles();
					} else if (action.equalsIgnoreCase("no")){
						choice = false;
						endGame(p);
					} else {
						confused();
						choice = true;
						continue;
					}
				} while (choice);
				//endGame(p);
				choice = false;
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);
    System.out.println("but it suddenly disappears as the creature steps out of the shadows into your view. The creature seems to have shape-shifted yet again. This time the legs the actual size of boulders, your attack seeming like nothing but a small scratch against the creature's main. This time the creature looks at you with stronger fire than ever before, as if a fire were burning within. You quickly retreat to a nearby temple to recover from your events, deciding on whether you should…");
     do{
			System.out.print("What will you do?\n> attack\n> Ignore\n\n: ");
			action = kb.nextLine();
			if (action.equalsIgnoreCase("attack")){
				choice = false;
				System.out.println("Now make up your mind you take this as your last chance to defeat the bearst. It's all or nothing, you prepare yourself for the final attempt at succession. Suddenly you remember your pouch, pulling it out of your clutch you breathe as you unravel it quickly scanning for the desired page. THERE! Behold the page of the weakness of the bearst. Although, the book lacked specific instructions you trace your fingers alone outlining the images and writing to discover the small scribble on the corner. The scribe reads a riddle “What it cannot SEE it cannot defeat, eliminate and you shall succeed”. You take a moment to let everything soak in pondering on the answer...");

        System.out.println("After a moment of thinking you realize...Press Enter to continue.");
        String Ans = kb.nextLine();
        do {
            System.out.println("What is the answer?");
            Ans = kb.nextLine();
        } while (!Ans.equalsIgnoreCase("eye"));

        System.out.println("CORRECT");

        System.out.println("Finally having your answer you decide to set off with renewed determination. After all, you are the best Ranger.You step out of the temple carefully watching your step, forcing yourself to remain quiet as you camouflage into the trees in search of the creature. In a moment you see the piercing eyes of the one and only. You accidentally step on a twig lost in thought and the creature quickly turns spotting you. With a grunt, the creature begins charging at you at full speed. Hurriedly you choose your weapon..");
      
			} else if (action.equalsIgnoreCase("ignore") || action.equalsIgnoreCase("walk away")){
				System.out.println("\nYou walked away as a coward.");
        do{
					System.out.print("Would you like to rechoose your role?\n> Yes\n> No\n\n: ");
					action = kb.nextLine();
					if (action.equalsIgnoreCase("yes")){
						choice = false;
						roles();
					} else if (action.equalsIgnoreCase("no")){
						choice = false;
						endGame(p);
					} else {
						confused();
						choice = true;
						continue;
					}
				} while (choice);
				choice = false;
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);

     do{
			System.out.println("What weapon will you choose??\n> Sword\n> Arrow\n\n: ");
      action = kb.nextLine();
			if (action.equalsIgnoreCase("sword")){
				choice = false;
				System.out.println("You pull out your sword right on time as the creature is about to pounce and you dodge his attack in a split second. Recovering from the quick encounter you notice a large gash around its lower neck. Using this as one of your weaknesses you use your acrobatic skills and climb onto the main raging the beast and stabbing it straight into the gash. Sending a shrill scream through the air causing birds and animals from the nearby environment to run away. Now is your only chance. In an instant you pull out the sword, causing the creature to send out a grunt and immediately pierce through its right eye. Letting out another shrill pain the bearst begins to sway losing its balance and falling to its side. ");
        Monster m = new Monster("Beast", "Humongous beast with glowing and beady eyes", 40, 10);
				battle(p, m);
        int result = battle(p, m);
					if (result == 1){
						System.out.println("\nMonster dead. YOU WON");
					} else if (result == -1){
						System.out.println("\nYou died. GAME OVER");
						saveData(p);
						break;
					} else if (result == 2){
						System.out.println("You fled from the scene.");
					} else {
						System.out.println("How did you get here?");
					}

        System.out.println("Immediately you escape bracing for impact and watch as the creature tumbles over. Slowly shrinking back to its original form of a bear, you notice the eyes dull its bright shade of gold. You watch as the creature loses its life…");
        endGame(p);
        
			} else if (action.equalsIgnoreCase("arrow")){
				System.out.println("You pull out your arrow, fixing your position and adjusting the arrow as you breathe aiming for the eye of the creature ahead of you. One shot and it's all over. You press release. In slow motion, the arrow speeds through the air at full speed straight into the creature's eye. In a clean fashion, merely missing the eye by a centimeter. You release the breath you realize you have unknowingly been holding.");
        Monster m = new Monster("Beast", "Humongous beast with glowing and beady eyes", 40, 10);
				battle(p, m);
        int result = battle(p, m);
					if (result == 1){
						System.out.println("\nMonster dead. YOU WON");
					} else if (result == -1){
						System.out.println("\nYou died. GAME OVER");
						saveData(p);
						break;
					} else if (result == 2){
						System.out.println("You fled from the scene.");
					} else {
						System.out.println("How did you get here?");
					}
				choice = false;
        System.out.println("You decide to closely inspect the creature and watch as the creature tumbles over. Slowly shrinking back to its original form of a bear, you notice the eyes dull its bright shade of gold. You watch as the creature loses life…");
        endGame(p);
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);
		
	}

	public static void peasantStory(Player p){
		Scanner kb = new Scanner(System.in);
		Random rand = new Random();
		boolean choice = true;
		String action;
		System.out.println("You have a pitchfork and nothing else. You dream of getting out of your village and having an adventure. You go to your fields and begin working. You see a noble attacking the undead.");
     do{
			System.out.println("What will you do?\n> Help\n> Ignore\n\n: ");
			action = kb.nextLine();
			if (action.equalsIgnoreCase("help")){
				choice = false;
				System.out.println("Armed with a rusty pitchfork and a heart full of courage, you face the horde of undead creatures before them. The putrid stench of decay fills the air as the zombies and skeletons close in, their hollow eyes fixed on their next meal. With a scream, you charge forward, determined to protect your village from this unholy menace. Swinging the pitchfork with all your might, you strike at the first approaching zombie. The tines of the fork pierce through its decaying flesh, causing it to stumble backward. ");
				Monster m = new Monster("Undead", "A corpse still trapped in this world", 30, 10);
				battle(p, m);
			} else if (action.equalsIgnoreCase("ignore") || action.equalsIgnoreCase("walk away")){
				System.out.println("\nYou walked away as a coward.");
        do{
					System.out.print("Would you like to rechoose your role?\n> Yes\n> No\n\n: ");
					action = kb.nextLine();
					if (action.equalsIgnoreCase("yes")){
						choice = false;
						roles();
					} else if (action.equalsIgnoreCase("no")){
						choice = false;
						endGame(p);
					} else {
						confused();
						choice = true;
						continue;
					}
				} while (choice);
				choice = false;
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);
  
    System.out.println("Undeterred, you press on, fending off multiple undead assailants at once. Knowing you cannot rely solely on your weapon, you…");
    do{
			System.out.printf("\nWhat will you do?\n> tactics\n> Run away\n\n: ");
			action = kb.nextLine();
			if (action.equalsIgnoreCase("tactics")){
				choice = false;
				System.out.println("you resort to clever tactics. You lure the skeletal foes into tripping over gravestones and obstacles, by throwing rocks, using past undead flesh on you covering your human scent, confusing the zombies. As the zombies stumble and fall, you deliver swift strikes on their vulnerable heads, severing limbs and dispatching them one by one.");
				Monster m = new Monster("Undead", "A corpse still trapped in this world", 30, 10);
				int result = battle(p, m);
					if (result == 1){
						System.out.println("\nMonster dead. YOU WON");
					} else if (result == -1){
						System.out.println("\nYou died. GAME OVER");
						saveData(p);
						break;
					} else if (result == 2){
						System.out.println("You fled from the scene.");
					} else {
						System.out.println("How did you get here?");
					}
        
			} else if (action.equalsIgnoreCase("run") || action.equalsIgnoreCase("walk away")){
				System.out.println("\nYou ran away as a coward.");
        do{
					System.out.println("Would you like to rechoose your role?\n> Yes\n> No\n\n: ");
					action = kb.nextLine();
					if (action.equalsIgnoreCase("yes")){
						choice = false;
						roles();
					} else if (action.equalsIgnoreCase("no")){
						choice = false;
						endGame(p);
					} else {
						confused();
						choice = true;
						continue;
					}
				} while (choice);
				choice = false;
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);
    System.out.println("However, the odds are against you, and your energy decreases as the relentless undead attack continues. With every swing and every step, you become more fatigued. Your clothes are torn, and blood trickles down from various cuts and scratches inflicted by the vicious creatures.");
     do{
			System.out.println("What will you do?\n> Fight\n> Run\n\n: ");
			action = kb.nextLine();
			if (action.equalsIgnoreCase("fight")){
				choice = false;
				Monster m = new Monster("Undead", "A corpse still trapped in this world", 30, 10);
        int result = battle(p, m);
					if (result == 1){
						System.out.println("\nMonster dead. YOU WON");
					} else if (result == -1){
						System.out.println("\nYou died. GAME OVER");
						saveData(p);
						break;
					} else if (result == 2){
						System.out.println("You fled from the scene.");
					} else {
						System.out.println("How did you get here?");
					}
			} else if (action.equalsIgnoreCase("run") || action.equalsIgnoreCase("run away")){
				System.out.println("\nYou ran away as a coward.");
        do{
					System.out.print("Would you like to rechoose your role?\n> Yes\n> No\n\n: ");
					action = kb.nextLine();
					if (action.equalsIgnoreCase("yes")){
						choice = false;
						roles();
					} else if (action.equalsIgnoreCase("no")){
						choice = false;
						endGame(p);
					} else {
						confused();
						choice = true;
						continue;
					}
				} while (choice);
				choice = false;
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);

     do{
			System.out.println("What will you do?\n> Continue\n> ignore\n\n: ");
			action = kb.nextLine();
			if (action.equalsIgnoreCase("continue")){
				choice = false;
				System.out.println("Your unified presence renews your determination, and they fight alongside each other, creating a wall of resistance against the undead. Together, you and Noble form a strategy. You target the necromancer, the source of the undead's existence. While some other nobles engage in direct combat, others provide cover and support, ensuring that you and the noble can reach the necromancer unimpeded With a final burst of energy (The necromer is where all the undead energy is fueled). You charge through the throng of the undead, cutting down any creature that stands in your way. You reach the necromancer, whose dark magic has been sustaining the undead. With a mighty swing of the pitchfork, you impale the necromancer, disrupting their spells and causing the remaining undead to crumble to dust. ");
				Monster m = new Monster("Undead", "A corpse still trapped in this world", 30, 10);
				battle(p, m);
        int result = battle(p, m);
					if (result == 1){
						System.out.println("\nMonster dead. YOU WON");
					} else if (result == -1){
						System.out.println("\nYou died. GAME OVER");
						saveData(p);
						break;
					} else if (result == 2){
						System.out.println("You fled from the scene.");
					} else {
						System.out.println("How did you get here?");
					}
			} else if (action.equalsIgnoreCase("ignore") || action.equalsIgnoreCase("walk away")){
				System.out.println("\nYou walked away as a coward.");
        do{
					System.out.println("Would you like to rechoose your role?\n> Yes\n> No\n\n: ");
					action = kb.nextLine();
					if (action.equalsIgnoreCase("yes")){
						choice = false;
						roles();
					} else if (action.equalsIgnoreCase("no")){
						choice = false;
						endGame(p);
					} else {
						confused();
						choice = true;
						continue;
					}
				} while (choice);
				choice = false;
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);

    System.out.println("The battle is won, and the villagers rejoice with you and noble in your hard-fought victory. They tend to your wounds and honor the fallen. Weary but proud, you are hailed as a hero, a symbol of resilience in the face of unimaginable horror. Your bravery and determination have saved the village from the clutches of the undead, securing a future of peace and hope. Your courage and strength impressed the nobles, and together they reunite and give you the title of knight.");
		
	}

  public static void Poster(int[][]myArr){
     for (int a = 0; a < myArr.length; a++) {
        int sum = 0; // reset sum to zero for each row
          for (int b = 0; b < myArr[a].length; b++) {
            sum += myArr[a][b];
            }
          System.out.printf("\nROW " + (a + 1) + ": " + sum);
        }
    }  

  public static void Print(int[][]myArr){
    for (int i = 0; i < myArr.length; i++) {
    for (int j = 0; j < myArr[i].length; j++) {
        System.out.print(myArr[i][j] + " ");
    }
    System.out.println();
}
  }

	public static void fairyStory(Player p){
		Scanner kb = new Scanner(System.in);
		Random rand = new Random();
		boolean choice = true;
		String action;
    System.out.println("You live in a fairy realm hidden under a grassy hill near the castle. Your wings sparkle in the sunlight and you are very small and good at hiding. You are fascinated by humans and love to watch them from their flowers where you blend in. While you are hiding, suddenly a large group of humans surround your hill. They are searching for something but suddenly spot your wings poking out through the grass. You notice the humans slowly attempting to approach you, in hopes of capturing a fairy present to add to their hunting squad. You decide to…"); 
     do{
      System.out.println("nWhat will you do?\n> Attack\n> Run\n\n: ");
      action = kb.nextLine();
			if (action.equalsIgnoreCase("attack")){
				choice = false;
				System.out.printf("\nHurriedly, you pull out the little remaining pixie dust that is contained in your pouch. Holding it above you sprinkle it on your wings and fly to a higher level, preparing your attack. From above you notice the humans pull out a large net the size of the biggest tree in the realm. You decide you are no match for such human-made nonsense and continue to decide which elements you will use for victory.");
        
			} else if (action.equalsIgnoreCase("run")){
				System.out.println("\nYou flew away in fear, rushing towards your hideout.");
        do{
					System.out.println("Would you like to rechoose your role?\n> Yes\n> No\n\n: ");
					action = kb.nextLine();
					if (action.equalsIgnoreCase("yes")){
						choice = false;
						roles();
					} else if (action.equalsIgnoreCase("no")){
						choice = false;
						endGame(p);
					} else {
						confused();
						choice = true;
						continue;
					}
				} while (choice);
				choice = false;
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);
    
		 do{ 
			System.out.print("What powers will you use?\n> Earth\n> Animals\n\n: ");
			action = kb.nextLine();
			if (action.equalsIgnoreCase("earth")){
				choice = false;
				System.out.printf("\nYou sing an enchanted riddle calling all roots of the nearby trees to assist you in your task and protect you from the human hunters. “Oh trees and plants of the land lend me your roots and I shall be protected, your friend and fairy of the realm.” With a rumble you see roots sprout from under the soil wrapping their thick branches around the humans, capturing half of them. Fear in their eyes you smile with joy. However, your victory is short-lived when you notice the non-captured humans pull out a shiny metal rod that seems to be sharp to the touch. Slicing through the roots and vines. These humans are always inconsiderate of nature and always the main cause of environmental disruptions, disrespecting what provides for them. For a moment you experience hot bubbling RAGE.");
			} else if (action.equalsIgnoreCase("animals")){
        
        System.out.println("What forest animal would you want helping you?");
        String Animal = kb.nextLine();
				System.out.printf("\nYou sing an enchanted riddle calling all small animals of the nearby woods to assist you in your task and protect you from the human hunters. “Oh animals of the land lend me your strengths and I shall be protected, your friend and fairy of the realm.” With a rumble you see an army of "+Animal+" attacking the humans watching their confusion and inability to balance. Fear in their eyes you smile with joy. However, your victory is short-lived when you notice the non-captured humans pull out a shiny metal rod that seems to be sharp to the touch. Slicing through the army. These humans are always inconsiderate of nature and always the main cause of environmental disruptions, disrespecting what provides for them. For a moment you experience hot bubbling RAGE.");
				choice = false;
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);

     do{
			System.out.println("What will you do with your rage?\n> Attack\n> calm down and WALK away\n\n: ");
			action = kb.nextLine();
			if (action.equalsIgnoreCase("attack")){
				choice = false;
				
			} else if (action.equalsIgnoreCase("walk") || action.equalsIgnoreCase("walk away")){
				System.out.println("\nYou walked away as a coward.");
        do{
					System.out.print("Would you like to rechoose your role?\n> Yes\n> No\n\n: ");
					action = kb.nextLine();
					if (action.equalsIgnoreCase("yes")){
						choice = false;
						roles();
					} else if (action.equalsIgnoreCase("no")){
						choice = false;
						endGame(p);
					} else {
						confused();
						choice = true;
						continue;
					}
				} while (choice);
				choice = false;
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);

     do{
			System.out.println("What powers will you use?\n> Water\n> Fast flying\n\n: ");
			action = kb.nextLine();
			if (action.equalsIgnoreCase("water")){
        System.out.printf("\nImpulsely you call for the water and river near the woods, in seconds a rumble of water comes rushing to the humans at full speed. Hoping to drown them with your rage you allow the water to crash down on the humans…once..twice..three times. Every time you feel succession the humans rise again as if nothing happened with their wet clothes and gear. This rages you more, the durability of these humans rages you as they were always seen as “undefeatable” but you want justice. You want to change. No longer shall these humans be feared - Suddenly you feel the tree rock. In an instant, you are captured by one of the human hunters that have managed to spot you and climb the tree. Blinded by your rage you lacked your own safety, you curse at yourself. Now trapped in a glass container you…");
				choice = false;
			} else if (action.equalsIgnoreCase("fast flying") || action.equalsIgnoreCase("fast")){
				System.out.println("\nImpulsively you summon your fast-flying powers and decide you fight the human hunters yourself. Blinded by rage you fly straight to the swarm of humans and pull out a small shield and sword, which seems like a needle compared to them, but used against humans can be poisonous. You manage to stab 3 humans as you watch them fall to the ground attempting to make sense of the situation and 2 more rushing to help. But wait… Where is the last one? Quickly you swarm to find him, but before you can you are caught and trapped in a glass container…");
				choice = false;
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);

     do{
			System.out.println("What will you do?\n> scream\n> use magic\n\n: ");
			action = kb.nextLine();
			if (action.equalsIgnoreCase("scream")){
        System.out.printf("\nYou attempt to use the remaining strength and power you have against the glass. In hopes of which you create a large ball of magic with all your might and shoot. But as the magic was about to hit the glass it reflects and hits you straight in the head. You attempt to curse as you realize the glasses' power. You rage once again, but suddenly your smell powder. In confusion, you look up and see white dust as if snow falling from the top of the container. Suddenly, you feel dizzy and fussy as the world around you turns into a blur and goes black.");
				choice = false;
			} else if (action.equalsIgnoreCase("magic") || action.equalsIgnoreCase("Magic")){
				System.out.println("\n You attempt to scream praying the nearby animals and fairies may hear you, but they were too far away. Suddenly your screams are quieted by the smell of powder. In confusion, you look up and see white dust as if snow falling from the top of the container. Suddenly, you feel dizzy and fussy as the world around you turns into a blur and goes black.");
				choice = false;
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);

    System.out.printf("\n\nYou wake up to the smell of gasoline and a smell of metal, due to the powder your senses are hindered. Feeling dizzy you lay there motionless unable to move, suddenly you remember flashbacks of what had previously happened and get up in a jolt. Now aware of your surroundings you take in the sight around you. You observe that you are in a dark room and there is a human-sized door in front of you, you fly closer to the door and you notice a hint of light shining under the bottom. ");

     do{
  			System.out.println("What will you do?\n> go THROUGH DOOR\n> Stay\n\n: ");
			action = kb.nextLine();
			if (action.equalsIgnoreCase("through door")){
				choice = false;
				System.out.printf("\nYou manage to crawl under the little peak, and suddenly a light shines blinding you unable. As you rub your eyes, finally adjusting to the lighting you see a bunch of animals trapped in little cages. To the right, you see small metal bars…A WINDOW!");
			} else if (action.equalsIgnoreCase("stay") || action.equalsIgnoreCase("Stay")){
				System.out.println("\nYou die of eventual starvation.");
        saveData(p);
        endGame(p);
				choice = false;
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);

     do{
			System.out.println("What will you do?\n> Help\n> run\n\n: ");
			action = kb.nextLine();
			if (action.equalsIgnoreCase("help")){
				choice = false;
				System.out.printf("\nYou decide to save the animals as the civil fairy you are, to start off you count the number of animals within the factory and realize there are 10 caged. You also note which animals are in each cage.");

        String [] variAnimal= {"Squirrel","dog","cat","cow","pigeon","horse","lion","tiger","snake","capybara"};

        for(int i=0; i < variAnimal.length;i++){
          System.out.print(" You see a"+variAnimal[i]+".");
        }

        System.out.println("You wonder why anyone w");
        
			} else if (action.equalsIgnoreCase("run") || action.equalsIgnoreCase("run away")){
				System.out.println("\nYou ran away as a coward.");
        do{
					System.out.print("Would you like to rechoose your role?\n> Yes\n> No\n\n: ");
					action = kb.nextLine();
					if (action.equalsIgnoreCase("yes")){
						choice = false;
						roles();
					} else if (action.equalsIgnoreCase("no")){
						choice = false;
						endGame(p);
					} else {
						confused();
						choice = true;
						continue;
					}
				} while (choice);
				choice = false;
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);

    System.out.printf("\nNow with renewed determination, you look for the key. Observing the factory you notice a small metal box in the corner. As you fly closer to it you realize it is a large metal vault that requires a combination. You recall using a vault somewhat 10 years ago and remember there was a 3-number combination. You decide to give it a try...");
    System.out.println("Enter in 3 numbers between 0 - 9 with spaces in between.");
    String Answer = kb.nextLine();
    System.out.println("You entered the wrong passcode. Try again.");

    System.out.printf("\nYou start to lose hope, as you realize there could be over 1000 different possibilities. Suddenly you hear one of the dogs scream, instantly you jump up to see what's going on and help. As you grow closer you see the dog and decide to communicate with it. It says “Woof Woof WOOF”. You attempt in translating barking, realizing he says “There is a number ”. You follow the dog's eyes and notice a row of numbers on the wall titled “lock combinations”. As you approach closer to the poster you see 9 numbers displayed…");

    int[][] myArr = {
            {1, 2, 3},
            {2, 4, 1},
            {3, 2, 3}
        };
    System.out.printf("\n");
    Print(myArr);
    System.out.printf("\nOn top of the poster it said, stated to add the rows in order to get the desired numbers to unlock the animals in ugly humanfont. Quickly you do mental math and calculate...");
    Poster(myArr);
  System.out.printf("\nYou dial the numbers within the vault and finally hear a successful click. Unlocking the door you see 2 keys, the first one is purple and the second one is gold. Carefully you enter the vault and pick up one of the keys…");

   do{
		System.out.println("Which key do you choose?\n> Gold\n> Purple\n\n: ");
			action = kb.nextLine();
			if (action.equalsIgnoreCase("gold")){
        System.out.printf("\nYou safely excite the vault with the gold key in hand. You start to fly and open up all the animals cages, each one opening woth a satisfying kink.");
				choice = false;
				
			} else if (action.equalsIgnoreCase("purple")){
        System.out.printf("\nYou lift the purple key, immediately the lock door closes behind you and you die due to lack of oxygen.");
				choice = false;
        saveData(p);
				endGame(p);
			} else {
					confused();
					choice = true;
					continue;
				}
			} while (choice);

    System.out.printf("\nAs you open the last animal's vault, suddenly you hear a scream “OI THE ANIMALS ARE OUT”, and a sudden alarm, causing all the animals including you to jump. Knowing that time was almost up you pull out your magic powers and decide to…");

     do{
      System.out.print("What will you do?\n> Attack\n> Run\n\n: ");
      action = kb.nextLine();
			if (action.equalsIgnoreCase("attack")){
				choice = false;
				System.out.printf("\nAs you decide this you see 2 humans enter the factory with their fairy nets. When you spot the first human, you use a lightning spell, which you use to constantly electrocute the human.\n");

        Monster m = new Monster("human", "a disgusting ungrateful human animal hunter", 30, 10);
				battle(p, m);
        int result = battle(p, m);
					if (result == 1){
						System.out.println("\nMonster dead. YOU WON");
					} else if (result == -1){
						System.out.println("\nYou died. GAME OVER");
						saveData(p);
						break;
					} else if (result == 2){
						System.out.println("You fled from the scene.");
					} else {
						System.out.println("How did you get here?");
					}
    System.out.printf("\nAs you win against the first human you hear a loud cry from all the animals, just to turn and see the nect human attempt to capture you, to which you dodge. All the animals and you look at eachother in unison, agreeing to take this one down together. All the animals circle the human and you pull out your lightning powers once again. And you strike.\n");

        m = new Monster("human", "a disgusting ungrateful human animal hunter", 30, 10);
				battle(p, m);
        result = battle(p, m);
					if (result == 1){
						System.out.println("\nMonster dead. YOU WON");
					} else if (result == -1){
						System.out.println("\nYou died. GAME OVER");
						saveData(p);
						break;
					} else if (result == 2){
						System.out.println("You fled from the scene.");
					} else {
						System.out.println("How did you get here?");
					}

    System.out.printf("\nDefeating the humans you and the animals work together to escape the factor through the door. Finally free. The animals all walk with you back to your fairy forest and thank you for helping them escape. With a final goodbye you close the door to your cozy home. You wonder what next story awaits.");
        endGame(p);
        
			} else if (action.equalsIgnoreCase("run")){
				System.out.println("\nYou flew away in fear, rushing towards your hideout.");
        do{
					System.out.print("Would you like to rechoose your role?\n> Yes\n> No\n\n: ");
					action = kb.nextLine();
					if (action.equalsIgnoreCase("yes")){
						choice = false;
						roles();
					} else if (action.equalsIgnoreCase("no")){
						choice = false;
						endGame(p);
					} else {
						confused();
						choice = true;
						continue;
					}
				} while (choice);
				choice = false;
			} else {
				confused();
				choice = true;
				continue;
			}
		} while (choice);
	}
} //end of class