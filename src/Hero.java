public class Hero extends Creature {

    private int level;

    public Hero(String name, int agility, int health, int gold, int strength, int experience, int level) {
        super(name, agility, health, gold, strength, experience);
        this.level = level;
    }

}
