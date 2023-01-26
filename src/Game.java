import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    static final Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Назовите своего персонажа.");
        String name = scanner.nextLine();
        System.out.println("Имя вашего персонажа: " + name + "\n");

        Player player = new Player(name, 10, 100, 1000, 10, 0, 0);
//        Player player = new Player(name, (random.nextInt(10) + 1), (random.nextInt(100) + 1),
//                random.nextInt(1000), (random.nextInt(10) + 1), 0, 0);

//        Goblin goblin = new Goblin((random.nextInt(10) + 1), (random.nextInt(100) + 1),
//                random.nextInt(1000), (random.nextInt(10) + 1));
//        Goblin goblin1 = new Goblin((random.nextInt(10) + 1), (random.nextInt(100) + 1),
//                random.nextInt(1000), (random.nextInt(10) + 1));
//        Goblin goblin2 = new Goblin((random.nextInt(10) + 1), (random.nextInt(100) + 1),
//                random.nextInt(1000), (random.nextInt(10) + 1));
//        Goblin goblin3 = new Goblin((random.nextInt(10) + 1), (random.nextInt(100) + 1),
//                random.nextInt(1000), (random.nextInt(10) + 1));
//        Skeleton skeleton = new Skeleton((random.nextInt(10) + 1), (random.nextInt(100) + 1),
//                random.nextInt(1000), (random.nextInt(10) + 1));
//        Skeleton skeleton1 = new Skeleton((random.nextInt(10) + 1), (random.nextInt(100) + 1),
//                random.nextInt(1000), (random.nextInt(10) + 1));
//        Skeleton skeleton2 = new Skeleton((random.nextInt(10) + 1), (random.nextInt(100) + 1),
//                random.nextInt(1000), (random.nextInt(10) + 1));
//        Skeleton skeleton3 = new Skeleton((random.nextInt(10) + 1), (random.nextInt(100) + 1),
//                random.nextInt(1000), (random.nextInt(10) + 1));

/*
        List<Skeleton> skeletonList = new ArrayList<>();
        skeletonList.add(skeleton);
        skeletonList.add(skeleton1);
        skeletonList.add(skeleton2);
        skeletonList.add(skeleton3);

        for (Skeleton skeletons : skeletonList){
            System.out.println(skeletons);
        }

        List<Goblin> goblinList = new ArrayList<>();
        goblinList.add(goblin);
        goblinList.add(goblin1);
        goblinList.add(goblin2);
        goblinList.add(goblin3);

        for (Goblin goblins : goblinList){
            System.out.println(goblins);
        }
*/

        System.out.println("Ваши параметры: \n" + "HP: " + player.getHealth() + "\n"
                + "Сила: " + player.getStrength() + "\n" + "Ловкость: " + player.getAgility() + "\n"
                + "Золото: " + player.getGold() + "\n");

        nextWay(player);
        while (player.isLife() || scanner.nextInt() != 3) {
            caseContinied(player, new Goblin((random.nextInt(10) + 1), (random.nextInt(100) + 1),
                            random.nextInt(1000), (random.nextInt(10) + 1)),
                    new Skeleton((random.nextInt(10) + 1), (random.nextInt(100) + 1),
                            random.nextInt(1000), (random.nextInt(10) + 1)));
        }
    }

    private static void nextWay(Player player) {
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1. К торговцу (прикупить лечебного зелья)");
        System.out.println("2. Тёмный лес (возможно будет драка)");
        System.out.println("3. Домой к маме)))");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
//                    player.trade(new Player());
                    System.out.println("Торговец ещё не вышел на работу");
                }
                case 2 -> CaseTwo(player, new Goblin((random.nextInt(10) + 1), (random.nextInt(100) + 1),
                                random.nextInt(1000), (random.nextInt(10) + 1)),
                        new Skeleton((random.nextInt(10) + 1), (random.nextInt(100) + 1),
                                random.nextInt(1000), (random.nextInt(10) + 1)));
                case 3 -> System.out.println("Всё закончилось, ты дома. Золота собрано: " + player.getGold() + "\n");
                default -> System.out.println("Что-то пошло не так, повторите ввод, введите цифру от 1 до 3");
            }
        } else {
            System.out.println("Вы ввели некорректный символ, введите цифру от 1 до 3");
        }
    }

    private static void caseContinied(Player player, Goblin goblin, Skeleton skeleton) {
        System.out.println("Осталось здоровья: " + player.getHealth());
        System.out.println("Золота в сундуке: " + player.getGold() + "\n");

        System.out.println("Выберете дальнейшее действие: ");
        System.out.println("1. Вернуться в город");
        System.out.println("2. Продолжить торговлю/приключения" + "\n");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Вы вернулись в город");
                    nextWay(player);
                }
                case 2 -> CaseTwo(player, new Goblin((random.nextInt(10) + 1), (random.nextInt(100) + 1),
                                random.nextInt(1000), (random.nextInt(10) + 1)),
                        new Skeleton((random.nextInt(10) + 1), (random.nextInt(100) + 1),
                                random.nextInt(1000), (random.nextInt(10) + 1)));
            }
        }
    }


    private static void CaseTwo(Player player, Goblin goblin, Skeleton skeleton) {
        System.out.println("Вы встретили монстра!!!");
        int nextMonster = (random.nextInt(2) + 1);
        if (nextMonster == 1) {
            System.out.println("Это скелет, его параметры: \n" + "HP: " + skeleton.getHealth() + "\n"
                    + "Сила: " + skeleton.getStrength() + "\n" + "Ловкость: " + skeleton.getAgility() + "\n"
                    + "Золото: " + skeleton.getGold());
            System.out.println("Вступить в бой? (1 - да) (2 - нет)");
            if (scanner.nextInt() == 1) {
                Fight.fight(player, new Skeleton((random.nextInt(10) + 1), (random.nextInt(100) + 1),
                        random.nextInt(1000), (random.nextInt(10) + 1)));
            } else {
                System.out.println("Вы обманули скелета и прошли дальше");
            }
        } else {
            System.out.println("Это гоблин, его параметры: \n" + "HP: " + goblin.getHealth() + "\n"
                    + "Сила: " + goblin.getStrength() + "\n" + "Ловкость: " + goblin.getAgility() + "\n"
                    + "Золото: " + goblin.getGold());
            System.out.println("Вступить в бой? (1 - да) (2 - нет)");
            if (scanner.nextInt() == 1) {
                Fight.fight(player, new Goblin((random.nextInt(10) + 1), (random.nextInt(100) + 1),
                        random.nextInt(1000), (random.nextInt(10) + 1)));
            } else {
                System.out.println("Вы обманули гоблина и прошли дальше");
            }
        }
    }
}


