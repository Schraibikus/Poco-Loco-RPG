public class Goblin extends Creature {

    public Goblin(int agility, int health, int gold, int strength){
        super(agility, health, gold, strength);
    }
    @Override
    public void attack(Creature creature) {
        super.attack(creature);
        System.out.printf("%s %s атаковал кривым кинжалом %s %s и нанес урон %d\n",
                this.getClass().getSimpleName(), this.getName(), creature.getClass().getSimpleName(),
                creature.getName(), this.getStrength());
    }

/*
    @Override
    public String toString() {
        return super.toString();
    }
*/
}
