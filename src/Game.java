import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Game {
    static final Random random = new Random();
    private static BufferedReader bufferedReader;
    private static Creature player = null;
    private static Fight fight = null;

    public static void main(String[] args) {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        fight = new Fight();
        System.out.println("Введите имя персонажа");
        try {
            command(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void command(String str) throws IOException {
        if (player == null) {
            player = new Hero(str, 20, 100, 100, 20, 0, 0);
            System.out.printf("Спасти наш мир от драконов вызвался %s!\n", player.getName());
            printNavigation();
        }
        switch (str) {
            case "1" -> {
                sellTrader(bufferedReader.readLine());
                printNavigation();
                command(bufferedReader.readLine());
            }
            case "2" -> commitFight();
            case "да" -> command("2");
            case "нет" -> {
                printNavigation();
                command(bufferedReader.readLine());
            }
            case "3" -> {
                System.out.printf("Вот всё и закончилось. Ты дома. Уровень здоровья: %d. Золота накоплено:%d. Опыт:%d \n",
                        player.getHealth(), player.getGold(), player.getExperience());
                System.exit(1);
            }
        }
        command(bufferedReader.readLine());
    }

    private static void printNavigation() {
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1.К Торговцу");
        System.out.println("2.В тёмный лес");
        System.out.println("3.Выход");
    }

    private static void commitFight() {
        fight.fight(player, createMonster(), new FightRepeated() {

            @Override
            public void fightWin() {
                System.out.printf("%s победил! Теперь у Вас %d опыта и %d золота, осталось %d здоровья.\n",
                        player.getName(), player.getExperience(), player.getGold(), player.getHealth());
                System.out.println("Желаете продолжить поход или вернуться в город? (да/нет)");
                try {
                    command(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void fightLost() {
            }
        });
    }

    interface FightRepeated {
        void fightWin();

        void fightLost();
    }

    private static Creature createMonster() {
        int nextMonster = (random.nextInt(3) + 1);
        if (nextMonster == 1) {
            return new Goblin(
                    (random.nextInt(20) + 1),
                    (random.nextInt(100) + 1),
                    (random.nextInt(100) + 1),
                    (random.nextInt(20) + 1),
                    (random.nextInt(100) + 1));
        } else if (nextMonster == 2) {
            return new Skeleton(
                    (random.nextInt(20) + 1),
                    (random.nextInt(100) + 1),
                    (random.nextInt(100) + 1),
                    (random.nextInt(20) + 1),
                    (random.nextInt(100) + 1));
        } else {
            return new Orc(
                    (random.nextInt(25) + 1),
                    (random.nextInt(150) + 1),
                    (random.nextInt(150) + 1),
                    (random.nextInt(25) + 1),
                    (random.nextInt(150) + 1));
        }
    }

    private static void sellTrader(String str) {
        System.out.println("Что желаете приобрести? зелье/меч/щит");
        int potion = 50;
        int pricePotion = 50;
        int sword = 5;
        int priceSword = 100;
        int shield = 10;
        int priceShield = 100;
        switch (str) {
            case "зелье" -> {
                if (player.getGold() < pricePotion) {
                    System.out.println("Не хватает денег на зелье(((");
                } else {
                    player.setHealth(player.getHealth() + potion);
                    player.setGold(player.getGold() - pricePotion);
                }
            }
            case "меч" -> {
                if (player.getGold() < priceSword) {
                    System.out.println("Не хватает денег на меч, дерись палкой)))");
                } else {
                    player.setStrength(player.getStrength() + sword);
                    player.setGold(player.getGold() - priceSword);
                }
            }
            case "щит" -> {
                if (player.getGold() < priceShield) {
                    System.out.println("Не хватает денег на щит(((");
                } else {
                    player.setAgility(player.getAgility() + shield);
                    player.setGold(player.getGold() - priceShield);
                }
            }
        }
    }
}
