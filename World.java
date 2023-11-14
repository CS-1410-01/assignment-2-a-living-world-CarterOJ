import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class World extends Creature {

    public World() {
        System.out.println("The world is being generated...");
    }

    protected ArrayList<String> creatures = new ArrayList<String>();

    public void createCreature() {
       try {
            Scanner in = new Scanner(new File("name.txt"));
            String names = "";
            while (in.hasNext()) {
                names = names + in.next();
            }
            String [] namesList = names.split(",");
            Random random = new Random();
            name = (namesList [random.nextInt(namesList.length)]);
            creatures.add(name);
            System.out.println("A creature named " + name + " with " + health + 
            " health and " + hunger + " hunger has spawned!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void die(int d) {
            System.out.println(creatures.get(d) + " has died!");
            creatures.remove(d);
    }
    public void reproduce(int r) {
            System.out.println(creatures.get(r) + " has reproduced!");
            creatures.add(creatures.get(r));
    }
}
