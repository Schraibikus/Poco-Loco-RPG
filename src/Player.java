public class Player extends Creature {

    Traider traider = new Traider();

    private int experience = 0;
    private int level = 0;

    public Player(String name, int agility, int health, int gold, int strength, int experience, int level) {
        super(name, agility, health, gold, strength);
        this.experience = experience;
        this.level = level;
    }

    @Override
    public void attack(Creature creature) {
        super.attack(creature);
        System.out.printf("%s %s атаковал мечем %s %s и нанес урон %d\n",
                this.getClass().getSimpleName(), this.getName(), creature.getClass().getSimpleName(),
                creature.getName(), this.getStrength());
    }

//    public void trade(Player player) {
//        player.getGold() -= traider.price;
//        player.getHealth() += traider.healthUp;
//    }


/*
    public void levelUp(){
        if (experience > 100){
            level++;
        }
    }
    public void experienceUp(Creature creature){
        experience += creature.getHealth();
    }
*/


}
class Traider{
    int price = 500;
    int healthUp = 50;
}

