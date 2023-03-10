/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dungeon.tracker;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Game {

    Place current;
    Set<Item> bag = new HashSet<>();

    Item lamp = new Item("lamp");
    Item sword = new Item("sword");

    Game() {
        Place entrance = new Place("You are at the dungeon entrace.");
        entrance.dark = false;

        Place corridor = new Place("As you walk down in the damp corridor of the dungeon.");

        Place zombieRoom = new Place("This room smells of rotten meat.");
        
        entrance.north = corridor;
        corridor.south = entrance;
        corridor.east = zombieRoom;
        zombieRoom.west=corridor;
        current = entrance;

        entrance.items.add(lamp);
        corridor.items.add(sword);
        
        Monster zombie = new Monster("John the zombie");
        zombieRoom.monster = zombie;
    }
    

    void start() {
        Scanner input = new Scanner(System.in);
        while (true) {
            if (!current.dark || bag.contains(lamp)) {
                System.out.println(current.description);
                if (!current.items.isEmpty()) {
                    System.out.println("Here you see: ");
                    for (Item item : current.items) {
                        System.out.println(item.name);
                    }
                }
                if (current.monster !=null){
                    System.out.println("There is a spooky monster here");
                    System.out.println(current.monster.name);
                }
            } else {
                System.out.println("It is dark you see darkness.");
            }
            System.out.print("What do you do? ");
            String answer = input.nextLine();

            if (answer.equals("help")){
                System.out.println("Commands north/south/east/west/take/i/exit.");
            }
            if (answer.equals("north")) {
                if (current.north != null) {
                    current = current.north;
                } else {
                    System.out.println("You cannot go there.");
                }
            }

            if (answer.equals("south")) {
                if (current.south != null) {
                    current = current.south;
                } else {
                    System.out.println("You cannot go there.");
                }
            }
            
            if (answer.equals("east")) {
                if (current.east != null) {
                    current = current.east;
                } else {
                    System.out.println("You cannot go there.");
                }
            }
            
            if (answer.equals("west")) {
                if (current.west != null) {
                    current = current.west;
                } else {
                    System.out.println("You cannot go there.");
                }
            }
            
            if (answer.equals("take")) {
                bag.addAll(current.items);
                current.items.clear();
            }
            if (answer.equals("exit")) {
                return;
            }
            if (answer.equals("i")) {
                System.out.println("You have:");
                for (Item item : bag) {
                    System.out.println(item.name);

                }
            }
        }

    }

    void startOld() {
        Scanner input = new Scanner(System.in);
        System.out.print("Would you like to start? (y/n) ");
        String answer = input.nextLine();

        if (answer.toLowerCase().strip().equals("y")) {
            System.out.print("You found a dungeon, would you like to enter? (y/n)");
            answer = input.nextLine().toLowerCase().strip();
            if (answer.equals("y")) {
                System.out.print("You entered the dungeon, you see a lit lantern. Would you like to pick it up? (y/n)");
                answer = input.nextLine().toLowerCase().strip();
                if (answer.equals("y")) {
                    System.out.println("You picked up the lantern and started walking deeper into the dungeon.");
                    System.out.print("As you walk down the damp corridors of the dungeon you see a room with a sword in a stone. Would you like to try pulling it out? (y/n)");
                    answer = input.nextLine().toLowerCase().strip();
                    if (answer.equals("y")) {
                        System.out.print("You pulled out the sword in one go and went on in the dungeon. A zombie jumps out of a corner. Would you like to run or fight? (r/f)");
                        answer = input.nextLine();
                        if (answer.equals("f")) {
                            System.out.print("You chose to fight. You swing your sword  ");

                            int dice = new Random().nextInt(6) + 1;
                            int zomdice = new Random().nextInt(6) + 1;

                            System.out.println("you throw " + dice);
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                            }
                            System.out.println("Zombie threw " + zomdice);
                            if (dice >= zomdice) {
                                System.out.println("You successfully swung your sword and defeated the zombie. Congratulations! ");
                            } else {
                                System.out.println("The zombie avoided yor sword and bite you. You spent the rest of youre undead life as a happy zombie in the dungeon.");
                                return;
                            }
                            System.out.print("You venture on and find the red diamond. As you put the lantern close to it, it shines up the room. Would you like to take the diamond? (y/n)");
                            answer = input.nextLine();
                            if (answer.equals("y")) {
                                System.out.println("You took the diamond, the ceiling starts to rumble, you start running out the way you came and made it out safely. You sold the diamond for $50,000. YOU WIN!");
                            } else {
                                System.out.println("You didn't take the diamond and wandered on in the dungeon struggling to find your way out and died of starvation.");
                            }

                        } else if (answer.equals("r")) {
                            System.out.println("You chose to run all the way to the beginning of the dungeon and saw a red diamond while you were running back. Such a shame!");

                        }
                    } else {
                        System.out.println("You left the sword and went on. You hear a groaning voice, so you turn the other way and see an exit. You leave the dungeon and go back to work.");
                    }
                } else {
                    System.out.println("You left the lantern and were too scared in the dark to continue. Restart!");
                }
            } else if (answer.equals("n")) {
                System.out.println("You didn't go into the dungeon and woke up to go to work. (Sad ending.)");
            }
        } else {
            System.out.println("Goodbye!");
        }
    }

    public static void main(String[] args) {
        new Game().start();
    }
}
