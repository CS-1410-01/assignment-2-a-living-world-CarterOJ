public abstract class Creature {

    protected int hunger = 50;
    protected int health = 50;
    protected String name;

    public abstract void die(int d);
    public abstract void reproduce(int r);
}