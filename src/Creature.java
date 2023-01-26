import java.util.Random;

public abstract class Creature {
    static final Random random = new Random();

    private final String name;
    private final int agility;
    private int health;
    private int gold;
    private final int strength;
    private boolean isLife = true;

    public Creature(int agility, int health, int gold, int strength){
        this.name = "Безымянный";
        this.agility = agility;
        this.health = health;
        this.gold = gold;
        this.strength = strength;

    }
    public Creature(String name, int agility, int health, int gold, int strength){
        this.name = name;
        this.agility = agility;
        this.health = health;
        this.gold = gold;
        this.strength = strength;
    }

    public void attack(Creature creature){

        if (creature.agility * 3 > random.nextInt(50) + 1){
            creature.health -= this.strength;
        } else {
            creature.health = creature.health;
            System.out.println("Промах");
        }
        if (creature.health < 0){
            creature.health = 0;
            creature.isLife = false;
            this.gold += creature.gold;
        }

    }

    public String getName() {
        return name;
    }

    public int getAgility() {
        return agility;
    }

    public int getHealth() {
        return health;
    }

    public int getGold() {
        return gold;
    }

    public int getStrength() {
        return strength;
    }

    public boolean isLife() {
        return isLife;
    }
}
