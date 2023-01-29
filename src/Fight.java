public class Fight {
    public void fight(Creature player, Creature monster, Game.FightRepeated fightRepeated) {
        Runnable runnable = () -> {
            int turn = 1;
            boolean isFightEnded = false;
            while (!isFightEnded) {
                System.out.println("--- Ход: " + turn + " ---");
                if (turn++ % 2 != 0) {
                    isFightEnded = makeHit(monster, player, fightRepeated);
                } else {
                    isFightEnded = makeHit(player, monster, fightRepeated);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private Boolean makeHit(Creature defender, Creature attacker, Game.FightRepeated fightRepeated) {
        int hit = attacker.attack();
        int defenderHealth = defender.getHealth() - hit;
        if (hit != 0) {
            System.out.printf("%s %s Нанес удар в %d единиц!\n", attacker.getClass().getSimpleName(), attacker.getName(), hit);
            System.out.printf("У %s %s осталось %d единиц здоровья...\n", defender.getClass().getSimpleName(), defender.getName(), defenderHealth);
        } else {
            System.out.printf("%s промахнулся!\n", attacker.getName());
        }
        if (defenderHealth <= 0 && defender instanceof Hero) {
            System.out.println("Герой пал в бою...");
            fightRepeated.fightLost();
            return true;

        } else if (defenderHealth <= 0) {
            System.out.printf("Враг повержен! Вы получаете %d опыт и % d золота\n", defender.getExperience(), defender.getGold());
            attacker.setExperience(attacker.getExperience() + defender.getExperience());
            attacker.setGold(attacker.getGold() + defender.getGold());
            fightRepeated.fightWin();
            return true;
        } else {
            defender.setHealth(defenderHealth);
            return false;
        }
    }
}
