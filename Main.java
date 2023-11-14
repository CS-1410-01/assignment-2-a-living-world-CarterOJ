import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Random random = new Random();
        World world = new World();
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to your world! How many creatures do you want?");
        int userInput = in.nextInt();
        in.close();
        for (int i = 0; i < userInput; i++ ) {
            world.createCreature();
            if (random.nextInt(5) == 3) {
                if (i == 0) {
                    world.die(0);
                    i--;
                    userInput--;
                }
                else {
                    world.die(random.nextInt(i));
                    i--;
                    userInput--;
                }
            }
            else if (random.nextInt(5) == 2) {
                if (i == 0) {
                    world.reproduce(0);
                }
                else {
                    world.reproduce(random.nextInt(i));
                }
            }
        }
        String creaturesLeft = "";
        for (int i = 0; i < world.creatures.size(); i++) {
            if (i == world.creatures.size() - 1) {
                creaturesLeft = creaturesLeft + world.creatures.get(i);
            }
            else if (i == world.creatures.size() - 2) {
                creaturesLeft = creaturesLeft + world.creatures.get(i) + ", and ";
            }
            else {
                creaturesLeft = creaturesLeft + world.creatures.get(i) + ", ";
            }
        }
        System.out.println("Creatures that are left include " + creaturesLeft);
    }
}
