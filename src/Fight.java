public class Fight {
    public static void fight(Creature player, Creature monster){
        while (player.isLife() && monster.isLife()){
            player.attack(monster);
            monster.attack(player);
        }
        if (player.isLife()){
            System.out.printf("%s по имени %s убит\n", monster.getClass().getSimpleName(), monster.getName());
            System.out.printf("%s по имени %s победил и получил золото убитого, в размере: %d\n",
                    player.getClass().getSimpleName(), player.getName(), monster.getGold());
        } else if (monster.isLife()) {
            System.out.printf("%s по имени %s убит\n", player.getClass().getSimpleName(), player.getName());
            System.out.printf("%s по имени %s победил\n", monster.getClass().getSimpleName(), monster.getName());
        } else {
            System.out.println("В общем, все умерли...");
        }
    }
}
