/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dungeon.tracker;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
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
                            System.out.print("You chose to fight. How many times would you like to swing your sword? (1/2/3/4/5) ");
                            int fling_count = input.nextInt();
                            if (fling_count > 0 && fling_count <= 5) {
                                System.out.println(String.format("You successfully flang your sword %d times and defeated the zombie. Congratulations! ", fling_count));
                                System.out.print("You venture on and find the red diamond. As you put the lantern close to it, it shines up the room. Would you like to take the diamond? (y/n)");
                                answer = input.nextLine();
                                if (answer.equals("y")) {
                                    System.out.println("You took the diamond, the ceiling starts to rumble, you start running out the way you came and made it out safely. You sold the diamond for $50,000. YOU WIN!");
                                } else {
                                    System.out.println("You didn't take the diamond and wandered on in the dungeon struggling to find your way out and died of starvation.");
                                }
                            } else {
                                System.out.println("You cannot fling your sword that many times. Restart!");
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
}
