import java.util.Random;

public abstract class Creature implements Fighter {
    static final Random random = new Random();

    private String name;
    private int agility;
    private int health;
    private int gold;
    private int strength;
    private int experience;
    private int level;


    public Creature(int agility, int health, int gold, int strength, int experience) {
        this.name = "Безымянный";
        this.agility = agility;
        this.health = health;
        this.gold = gold;
        this.strength = strength;
        this.experience = experience;
    }


    public Creature(String name, int agility, int health, int gold, int strength, int experience, int level) {
        this.name = name;
        this.agility = agility;
        this.health = health;
        this.gold = gold;
        this.strength = strength;
        this.experience = experience;
        this.level = level;
    }

    @Override
    public int attack() {
        if (agility * 3 > random.nextInt(50) + 1) {
            return strength;
        } else if (health * 2 > random.nextInt(100) + 1) {
            return strength * 2;
        } else return 0;
    }

    @Override
    public int levelUp() {
        if (experience <= 499) {
            level = 1;
        } else if (experience >= 500 && experience <= 999) {
            level = 2;
        } else {
            level = 3;
        }
        return level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
