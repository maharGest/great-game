import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class MyProgram {
    public static void main(String[] args) throws InterruptedException {
        Random NumberPicker = new Random();

        double firstMonsters = 6.0;
        double secondMonsters = 12.0;
        Map<String, Double> stats = new TreeMap();

        stats.put("untilNextLevel", 15.0);
        stats.put("level", 1.0);
        stats.put("exp", 0.0);
        stats.put("strengthLevel", 1.0);
        stats.put("expGain", 1.0);
        stats.put("expGainBonus", 1.0);
        stats.put("money", 0.0);
        stats.put("moneyGain", 1.0);
        stats.put("maxHealth", 20.0);
        stats.put("currentExpGain", 0.0);
        stats.put("potionStrengthModifier", 1.0);
        stats.put("potionDefenseModifier", 1.0);
        stats.put("potionExpModifier", 1.0);

        Map<String, String> status = new TreeMap();

        status.put("fightingOrShoping", "n");
        status.put("upgrade", "n");
        status.put("gameContinue", "s");
        status.put("continueFighting", "n");
        status.put("move", "n/a");
        status.put("gameStarted", "n");
        status.put("usedPotion", "n");
        status.put("enoughMoney", "y");

        Map<String, Double> numberStatus = new TreeMap();

        numberStatus.put("currentDamage", 0.0);
        numberStatus.put("currentHealth", 20.0);

        Map<String, Integer> monster = new TreeMap();

        monster.put("fly", 0);
        monster.put("spider", 0);
        monster.put("moth", 0);
        
        monster.put("frog", 0);
        monster.put("duck", 0);
        monster.put("squirrel", 0);

        Map<String, Double> monsterStats = new TreeMap();

        monsterStats.put("flyHealth", 5.0);
        monsterStats.put("spiderHealth", 6.0);
        monsterStats.put("mothHealth", 3.0);
        monsterStats.put("flyDamage", 2.0);
        monsterStats.put("spiderDamage", 3.0);
        monsterStats.put("mothDamage", 1.0);

        monsterStats.put("frogHealth", 10.0);
        monsterStats.put("duckHealth", 12.0);
        monsterStats.put("squirrelHealth", 8.0);
        monsterStats.put("frogDamage", 4.0);
        monsterStats.put("duckDamage", 5.0);
        monsterStats.put("squirrelDamage", 3.0);

        Map<String, Double> monsterStatus = new TreeMap();

        monsterStatus.put("spawnedMonster", 1000.0);
        monsterStatus.put("currentHealth", 0.0);
        monsterStatus.put("currentEnemyDamage", 0.0);

        Map<String, String> baggedItems = new TreeMap();

        baggedItems.put("item1", "n/a");
        baggedItems.put("item2", "n/a");
        baggedItems.put("item3", "n/a");
        baggedItems.put("item4", "n/a");
        baggedItems.put("item5", "n/a");
        baggedItems.put("potionChoice", "n/a");

        Map<String, Double> shopItems = new TreeMap();

        shopItems.put("lesserHealthPotion", 10.0);
        shopItems.put("healthPotion", 30.0);
        shopItems.put("greaterHealthPotion", 50.0);
        shopItems.put("strengthPotion", 50.0);
        shopItems.put("expPotion", 100.0);
        shopItems.put("defensePotion", 50.0);

        System.out.println("welcome");
        Thread.sleep(3000);
        System.out.println("in this game, enemy kill times and exp drops scale with level");
        Thread.sleep(6000);
        System.out.println("enter name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        if (status.get("gameStarted").equals("n")) {
            System.out.println("press 's' to start");
            status.replace("gameStarted", scanner.nextLine());
        }
        if (status.get("gameContinue").equals("n") || status.get("gameStarted").equals("s")) {
            System.out.println("press 'c' to continue");
            status.replace("gameContinue", scanner.nextLine());
        }

        while (status.get("gameContinue").equals("c") || status.get("gameStarted").equals("s")) {
            stats.replace("untilNextLevel", stats.get("level") * 15.0);

            monsterStats.replace("flyHealth", 5.0 * (stats.get("level") / 2));
            monsterStats.replace("spiderHealth", 6.0 * (stats.get("level") / 2));
            monsterStats.replace("mothHealth", 3.0 * (stats.get("level") / 2));
            monsterStats.replace("frogHealth", 10.0 * (stats.get("level") / 4));
            monsterStats.replace("duckHealth", 12.0 * (stats.get("level") / 4));
            monsterStats.replace("squirrelHealth", 8.0 * (stats.get("level") / 4));

            monster.replace("fly", 0);
            monster.replace("moth", 0);
            monster.replace("spider", 0);
            monster.replace("frog", 0);
            monster.replace("duck", 0);
            monster.replace("squirrel", 0);

            monsterStats.replace("flyDamage", 2.0 * (stats.get("level") / 2));
            monsterStats.replace("spiderDamage", 3.0 * (stats.get("level") / 2));
            monsterStats.replace("mothDamage", 1.0 * (stats.get("level") / 2));
            monsterStats.replace("frogDamage", 4.0 * (stats.get("level") / 4));
            monsterStats.replace("duckDamage", 5.0 * (stats.get("level") / 4));
            monsterStats.replace("squirrelDamage", 3.0 * (stats.get("level") / 4));

            System.out.println("enter f to fight or s to shop, in the fight, you can use i for item and a for attack");
            status.put("fightingOrShoping", scanner.nextLine());
            Thread.sleep(1000);

            while (status.get("fightingOrShoping").equals("s")) {
                clearScreen();
                System.out.println(
                        "type the option given for the potion you want. Example: If i wanted the lesser health potion, I would type lh");
                System.out.println(
                        "health potions: lh: Lesser health potion, heals 10 hp, 10 dollars. h: normal health potion, heals 30 hp, 30 dollars. gh: greater health potion, heals 50 hp, 50 dollars");
                System.out.println(
                        "buffs: sp: Strength potion, doubles damage for one hit, 50 dollars. dp: defense potion, halfs damage of one enemy hit, 50 dollars. ep: exp potion, doubles exp from battle, 100 dollars.");
                System.out.println("to leave, type 'n' ");

                baggedItems.replace("potionChoice", scanner.nextLine());

                if (baggedItems.get("potionChoice").equals("lh")) {
                    // Heads up, the ! turns the .equals into a .doesnotequal
                    if (stats.get("money") < 10.0) {
                        System.out.println("you don't have enough money for this item, try again");
                        Thread.sleep(5000);
                        clearScreen();
                        status.replace("enoughMoney", "n");
                    }
                    if (status.get("enoughMoney").equals("y")) {
                    if (!baggedItems.get("item1").equals("n/a")) {
                        if (!baggedItems.get("item2").equals("n/a")) {
                            if (!baggedItems.get("item3").equals("n/a")) {
                                if (!baggedItems.get("item4").equals("n/a")) {
                                    if (!baggedItems.get("item5").equals("n/a")) {
                                        System.out.println(
                                                "you have no more space for items, use the items you already have");
                                        Thread.sleep(5000);
                                        clearScreen();
                                        status.replace("fightingOrShoping", "f");

                                    }
                                    baggedItems.replace("item5", "lesser healing potion");
                                    System.out.println("your inventory is now full, time to go to battle!");
                                    Thread.sleep(5000);
                                    status.replace("fightingOrShoping", "f");
                                    clearScreen();
                                }
                                baggedItems.replace("item4", "lesser healing potion");
                                System.out.println("press f to go to battle, or s to continue shopping");
                                status.replace("fightingOrShoping", scanner.nextLine());
                                Thread.sleep(5000);
                                clearScreen();
                            }
                            baggedItems.replace("item3", "lesser healing potion");
                            System.out.println("press f to go to battle, or s to continue shopping");
                            status.replace("fightingOrShoping", scanner.nextLine());
                            Thread.sleep(5000);
                            clearScreen();
                        }
                        baggedItems.replace("item2", "lesser healing potion");
                        System.out.println("press f to go to battle, or s to continue shopping");
                        status.replace("fightingOrShoping", scanner.nextLine());
                        Thread.sleep(5000);
                        clearScreen();
                    }
                    baggedItems.replace("item1", "lesser healing potion");
                    System.out.println("press f to go to battle, or s to continue shopping");
                    status.replace("fightingOrShoping", scanner.nextLine());
                    Thread.sleep(5000);
                    clearScreen();
                    }
                }
                if (baggedItems.get("potionChoice").equals("h")) {
                    // Heads up, the ! turns the .equals into a .doesnotequal
                    if (stats.get("money") < 30.0) {
                        System.out.println("you don't have enough money for this item, try again");
                        Thread.sleep(5000);
                        clearScreen();
                        status.replace("enoughMoney", "n");
                    }
                    if (status.get("enoughMoney").equals("y")) {
                    if (!baggedItems.get("item1").equals("n/a")) {
                        if (!baggedItems.get("item2").equals("n/a")) {
                            if (!baggedItems.get("item3").equals("n/a")) {
                                if (!baggedItems.get("item4").equals("n/a")) {
                                    if (!baggedItems.get("item5").equals("n/a")) {
                                        System.out.println(
                                                "you have no more space for items, use the items you already have");
                                        Thread.sleep(5000);
                                        clearScreen();
                                        status.replace("fightingOrShoping", "f");

                                    }
                                    baggedItems.replace("item5", "healing potion");
                                    System.out.println("your inventory is now full, time to go to battle!");
                                    Thread.sleep(5000);
                                    status.replace("fightingOrShoping", "f");
                                    clearScreen();
                                }
                                baggedItems.replace("item4", "healing potion");
                                System.out.println("press f to go to battle, or s to continue shopping");
                                status.replace("fightingOrShoping", scanner.nextLine());
                                Thread.sleep(5000);
                                clearScreen();
                            }
                            baggedItems.replace("item3", "healing potion");
                            System.out.println("press f to go to battle, or s to continue shopping");
                            status.replace("fightingOrShoping", scanner.nextLine());
                            Thread.sleep(5000);
                            clearScreen();
                        }
                        baggedItems.replace("item2", "healing potion");
                        System.out.println("press f to go to battle, or s to continue shopping");
                        status.replace("fightingOrShoping", scanner.nextLine());
                        Thread.sleep(5000);
                        clearScreen();
                    }
                    baggedItems.replace("item1", "healing potion");
                    System.out.println("press f to go to battle, or s to continue shopping");
                    status.replace("fightingOrShoping", scanner.nextLine());
                    Thread.sleep(5000);
                    clearScreen();
                    }
                }

                if (baggedItems.get("potionChoice").equals("gh")) {
                    // Heads up, the ! turns the .equals into a .doesnotequal
                    if (stats.get("money") < 50.0) {
                        System.out.println("you don't have enough money for this item, try again");
                        Thread.sleep(5000);
                        clearScreen();
                        status.replace("enoughMoney", "n");
                    }
                    if (status.get("enoughMoney").equals("y")) {
                    if (!baggedItems.get("item1").equals("n/a")) {
                        if (!baggedItems.get("item2").equals("n/a")) {
                            if (!baggedItems.get("item3").equals("n/a")) {
                                if (!baggedItems.get("item4").equals("n/a")) {
                                    if (!baggedItems.get("item5").equals("n/a")) {
                                        System.out.println(
                                                "you have no more space for items, use the items you already have");
                                        Thread.sleep(5000);
                                        clearScreen();
                                        status.replace("fightingOrShoping", "f");

                                    }
                                    baggedItems.replace("item5", "greater healing potion");
                                    System.out.println("your inventory is now full, time to go to battle!");
                                    Thread.sleep(5000);
                                    status.replace("fightingOrShoping", "f");
                                    clearScreen();
                                }
                                baggedItems.replace("item4", "greater healing potion");
                                System.out.println("press f to go to battle, or s to continue shopping");
                                status.replace("fightingOrShoping", scanner.nextLine());
                                Thread.sleep(5000);
                                clearScreen();
                            }
                            baggedItems.replace("item3", "greater healing potion");
                            System.out.println("press f to go to battle, or s to continue shopping");
                            status.replace("fightingOrShoping", scanner.nextLine());
                            Thread.sleep(5000);
                            clearScreen();
                        }
                        baggedItems.replace("item2", "greater healing potion");
                        System.out.println("press f to go to battle, or s to continue shopping");
                        status.replace("fightingOrShoping", scanner.nextLine());
                        Thread.sleep(5000);
                        clearScreen();
                    }
                    baggedItems.replace("item1", "greater healing potion");
                    System.out.println("press f to go to battle, or s to continue shopping");
                    status.replace("fightingOrShoping", scanner.nextLine());
                    Thread.sleep(5000);
                    clearScreen();
                }
            }

                if (baggedItems.get("potionChoice").equals("sp")) {
                    // Heads up, the ! turns the .equals into a .doesnotequal\
                    if (stats.get("money") < 50.0) {
                        System.out.println("you don't have enough money for this item, try again");
                        Thread.sleep(5000);
                        clearScreen();
                        status.replace("enoughMoney", "n");
                    }
                    if (status.get("enoughMoney").equals("y")) {
                    if (!baggedItems.get("item1").equals("n/a")) {
                        if (!baggedItems.get("item2").equals("n/a")) {
                            if (!baggedItems.get("item3").equals("n/a")) {
                                if (!baggedItems.get("item4").equals("n/a")) {
                                    if (!baggedItems.get("item5").equals("n/a")) {
                                        System.out.println(
                                                "you have no more space for items, use the items you already have");
                                        Thread.sleep(5000);
                                        clearScreen();
                                        status.replace("fightingOrShoping", "f");

                                    }
                                    baggedItems.replace("item5", "strength potion");
                                    System.out.println("your inventory is now full, time to go to battle!");
                                    Thread.sleep(5000);
                                    status.replace("fightingOrShoping", "f");
                                    clearScreen();
                                }
                                baggedItems.replace("item4", "strength potion");
                                System.out.println("press f to go to battle, or s to continue shopping");
                                status.replace("fightingOrShoping", scanner.nextLine());
                                Thread.sleep(5000);
                                clearScreen();
                            }
                            baggedItems.replace("item3", "strength potion");
                            System.out.println("press f to go to battle, or s to continue shopping");
                            status.replace("fightingOrShoping", scanner.nextLine());
                            Thread.sleep(5000);
                            clearScreen();
                        }
                        baggedItems.replace("item2", "strength potion");
                        System.out.println("press f to go to battle, or s to continue shopping");
                        status.replace("fightingOrShoping", scanner.nextLine());
                        Thread.sleep(5000);
                        clearScreen();
                    }
                    baggedItems.replace("item1", "strength potion");
                    System.out.println("press f to go to battle, or s to continue shopping");
                    status.replace("fightingOrShoping", scanner.nextLine());
                    Thread.sleep(5000);
                    clearScreen();
                }
            }

                if (baggedItems.get("potionChoice").equals("dp")) {
                    // Heads up, the ! turns the .equals into a .doesnotequal
                    if (stats.get("money") < 50.0) {
                        System.out.println("you don't have enough money for this item, try again");
                        Thread.sleep(5000);
                        clearScreen();
                        status.replace("enoughMoney", "n");
                    }
                    if (status.get("enoughMoney").equals("y")) {
                    if (!baggedItems.get("item1").equals("n/a")) {
                        if (!baggedItems.get("item2").equals("n/a")) {
                            if (!baggedItems.get("item3").equals("n/a")) {
                                if (!baggedItems.get("item4").equals("n/a")) {
                                    if (!baggedItems.get("item5").equals("n/a")) {
                                        System.out.println(
                                                "you have no more space for items, use the items you already have");
                                        Thread.sleep(5000);
                                        clearScreen();
                                        status.replace("fightingOrShoping", "f");

                                    }
                                    baggedItems.replace("item5", "defense potion");
                                    System.out.println("your inventory is now full, time to go to battle!");
                                    Thread.sleep(5000);
                                    status.replace("fightingOrShoping", "f");
                                    clearScreen();
                                }
                                baggedItems.replace("item4", "defense potion");
                                System.out.println("press f to go to battle, or s to continue shopping");
                                status.replace("fightingOrShoping", scanner.nextLine());
                                Thread.sleep(5000);
                                clearScreen();
                            }
                            baggedItems.replace("item3", "defense potion");
                            System.out.println("press f to go to battle, or s to continue shopping");
                            status.replace("fightingOrShoping", scanner.nextLine());
                            Thread.sleep(5000);
                            clearScreen();
                        }
                        baggedItems.replace("item2", "defense potion");
                        System.out.println("press f to go to battle, or s to continue shopping");
                        status.replace("fightingOrShoping", scanner.nextLine());
                        Thread.sleep(5000);
                        clearScreen();
                    }
                    baggedItems.replace("item1", "defense potion");
                    System.out.println("press f to go to battle, or s to continue shopping");
                    status.replace("fightingOrShoping", scanner.nextLine());
                    Thread.sleep(5000);
                    clearScreen();
                }
            }

                if (baggedItems.get("potionChoice").equals("ep")) {
                    // Heads up, the ! turns the .equals into a .doesnotequal
                    if (stats.get("money") < 100.0) {
                        System.out.println("you don't have enough money for this item, try again");
                        Thread.sleep(5000);
                        clearScreen();
                        status.replace("enoughMoney", "n");
                    }
                    if (status.get("enoughMoney").equals("y")) {
                    if (!baggedItems.get("item1").equals("n/a")) {
                        if (!baggedItems.get("item2").equals("n/a")) {
                            if (!baggedItems.get("item3").equals("n/a")) {
                                if (!baggedItems.get("item4").equals("n/a")) {
                                    if (!baggedItems.get("item5").equals("n/a")) {
                                        System.out.println(
                                                "you have no more space for items, use the items you already have");
                                        Thread.sleep(5000);
                                        clearScreen();
                                        status.replace("fightingOrShoping", "f");

                                    }
                                    baggedItems.replace("item5", "exp potion");
                                    System.out.println("your inventory is now full, time to go to battle!");
                                    Thread.sleep(5000);
                                    status.replace("fightingOrShoping", "f");
                                    clearScreen();
                                }
                                baggedItems.replace("item4", "exp potion");
                                System.out.println("press f to go to battle, or s to continue shopping");
                                status.replace("fightingOrShoping", scanner.nextLine());
                                Thread.sleep(5000);
                                clearScreen();
                            }
                            baggedItems.replace("item3", "exp potion");
                            System.out.println("press f to go to battle, or s to continue shopping");
                            status.replace("fightingOrShoping", scanner.nextLine());
                            Thread.sleep(5000);
                            clearScreen();
                        }
                        baggedItems.replace("item2", "exp potion");
                        System.out.println("press f to go to battle, or s to continue shopping");
                        status.replace("fightingOrShoping", scanner.nextLine());
                        Thread.sleep(5000);
                        clearScreen();
                    }
                    baggedItems.replace("item1", "exp potion");
                    System.out.println("press f to go to battle, or s to continue shopping");
                    status.replace("fightingOrShoping", scanner.nextLine());
                    Thread.sleep(5000);
                    clearScreen();
                }
                if (baggedItems.get("potionChoice").equals("n")) {
                    status.replace("fightingOrShoping", "f");
                    Thread.sleep(2000);
                    clearScreen();
                }
            }
            }
            
                   
            
            while (status.get("fightingOrShoping").equals("f")) {

                if (stats.get("level") < 6.0) {
                    monster.replace("fly", NumberPicker.nextInt(4));
                    monster.replace("moth", NumberPicker.nextInt(4));
                    monster.replace("spider", NumberPicker.nextInt(4));
                    while (monster.get("fly").equals("moth")) {

                        monster.replace("moth", NumberPicker.nextInt(4));
                    }
                    while (monster.get("spider").equals("moth")) {
                        monster.replace("spider", NumberPicker.nextInt(4));
                    }
                    while (monster.get("spider").equals("fly")) {
                        monster.replace("Fly", NumberPicker.nextInt(4));
                    }
                 

                    clearScreen();
                    if (monster.get("spider").equals(1)) {
                        System.out.println("a spider appeared!");
                    } else if (monster.get("fly").equals(1)) {
                        System.out.println("a fly appeared!");
                    } else if (monster.get("moth").equals(1)) {
                        System.out.println("a moth appeared");
                    }
                    while (monster.get("spider").equals(1)) {
                        monsterStatus.replace("currentHealth", monsterStats.get("spiderHealth"));
                        System.out.println("your move (f or i)");
                        status.replace("move", scanner.nextLine());
                        if (status.get("move").equals("f")) {
                            numberStatus.replace("currentDamage", (stats.get("strengthLevel") + NumberPicker.nextInt(3)));

                            monsterStatus.replace("currentHealth",
                                    monsterStatus.get("currentHealth")
                                            - (numberStatus.get("currentDamage") * stats.get("potionStrengthModifier")));
                            numberStatus.replace("potionStrengthModifier", 1.0);
                            System.out.println("you dealt " + numberStatus.get("currentDamage") + " damage");

                            status.replace("move", "n");

                            if (monsterStatus.get("currentHealth") < 1) {
                                stats.replace("money", stats.get("money") + (3.0 * stats.get("moneyGain")));
                                stats.replace("exp",
                                        stats.get("exp") + ((3 * stats.get("expGain")) * stats.get("potionExpModifier")));
                                stats.replace("untilNextLevel", stats.get("untilNextLevel")
                                        - ((3 * stats.get("expGain")) * stats.get("potionExpModifier")));
                                System.out.println("you won! You now have " + stats.get("exp") + " exp, "
                                        + stats.get("money") + " money, and " + stats.get("untilNextLevel")
                                        + " exp until the next level");

                                status.replace("fightingOrShoping", "n");
                                stats.replace("potionExpModifier", 1.0);
                                Thread.sleep(5000);
                                clearScreen();
                                monster.replace("spider", 0);
                            }
                        } else if (status.get("move").equals("i")) {

                            System.out.println("choose your item, use i1 for item 1, i2 for item 2, and so on.");
                            System.out.println("item 1: " + baggedItems.get("item1") + " item 2: "
                                    + baggedItems.get("item2") + " item 3:" + baggedItems.get("item3") + " item 4: "
                                    + baggedItems.get("item4") + " item 5: " + baggedItems.get("item5"));
                            status.replace("usedPotion", scanner.nextLine());
                            if (status.get("usedPotion").equals("i1")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item1").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item1").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item1", "n/a");
                            } else if (status.get("usedPotion").equals("i2")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item2").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item2").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }

                                baggedItems.replace("item2", "n/a");

                            } else if (status.get("usedPotion").equals("i3")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item3").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item3").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item3", "n/a");

                            } else if (status.get("usedPotion").equals("i4")) {
                                if (baggedItems.get("item4").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item4").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item4").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item4", "n/a");

                            } else if (status.get("usedPotion").equals("i5")) {
                                if (baggedItems.get("item5").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item5").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item5").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item5", "n/a");

                            }

                        }
                    }
                    
                        if (status.get("fightingOrShoping").equals("f")) {
                            System.out.println("monster's turn");
                            monsterStatus.replace("currentEnemyDamage", monsterStats.get("spiderDamage"));
                            numberStatus.replace("currentHealth",
                                    numberStatus.get("currentHealth")
                                            - (monsterStats.get("spiderDamage") / stats.get("potionDefenseModifier")));
                            stats.replace("potionDefenseModifier", 1.0);
                            System.out.println("you took " + monsterStatus.get("currentEnemyDamage")
                                    + " damage, you have " + numberStatus.get("currentHealth") + "HP");

                            if (numberStatus.get("currentHealth") < 1.0) {
                                System.out.println(
                                        "game over, if you continue, you will keep your level but your exp, money, and items will be removed");
                                Thread.sleep(8000);
                                stats.replace("exp", 0.0);
                                stats.replace("money", 0.0);
                                monsterStatus.replace("currentEnemyDamage", 0.0);
                                numberStatus.replace("currentHealth", stats.get("maxHealth"));
                                Thread.sleep(2000);
                                monster.replace("spider", 0);

                            }
                        }

                    
                    while (monster.get("fly").equals(1)) {
                        monsterStatus.replace("currentHealth", monsterStats.get("flyHealth"));
                        System.out.println("your move (f or i)");
                        status.replace("move", scanner.nextLine());
                        if (status.get("move").equals("f")) {
                            numberStatus.replace("currentDamage", (stats.get("strengthLevel") + NumberPicker.nextInt(3)));

                            monsterStatus.replace("currentHealth",
                                    monsterStatus.get("currentHealth")
                                            - (numberStatus.get("currentDamage") * stats.get("potionStrengthModifier")));
                            stats.replace("potionStrengthModifier", 1.0);
                            System.out.println("you dealt " + numberStatus.get("currentDamage") + " damage");

                            if (monsterStatus.get("currentHealth") < 1) {

                                stats.replace("money", stats.get("money") + (2.0 * stats.get("moneyGain")));
                                stats.replace("exp",
                                        stats.get("exp") + ((2 * stats.get("expGain")) * stats.get("potionExpModifier")));
                                stats.replace("untilNextLevel", stats.get("untilNextLevel")
                                        - ((2 * stats.get("expGain")) * stats.get("potionExpModifier")));
                                System.out.println("you won! You now have " + stats.get("exp") + " exp, "
                                        + stats.get("money") + " money, and " + stats.get("untilNextLevel")
                                        + " exp until the next level");

                                status.replace("fightingOrShoping", "n");
                                stats.replace("potionExpModifier", 1.0);
                                Thread.sleep(5000);
                                clearScreen();
                                monster.replace("fly", 0);
                            }
                        } else if (status.get("move").equals("i")) {

                            System.out.println("choose your item, use i1 for item 1, i2 for item 2, and so on.");
                            System.out.println("item 1: " + baggedItems.get("item1") + " item 2: "
                                    + baggedItems.get("item2") + " item 3:" + baggedItems.get("item3") + " item 4: "
                                    + baggedItems.get("item4") + " item 5: " + baggedItems.get("item5"));
                            status.replace("usedPotion", scanner.nextLine());
                            if (status.get("usedPotion").equals("i1")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item1").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item1").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item1", "n/a");
                            } else if (status.get("usedPotion").equals("i2")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item2").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item2").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }

                                baggedItems.replace("item2", "n/a");

                            } else if (status.get("usedPotion").equals("i3")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item3").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item3").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item3", "n/a");

                            } else if (status.get("usedPotion").equals("i4")) {
                                if (baggedItems.get("item4").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item4").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item4").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item4", "n/a");

                            } else if (status.get("usedPotion").equals("i5")) {
                                if (baggedItems.get("item5").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item5").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item5").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item5", "n/a");

                            }

                        }        
                            if (status.get("fightingOrShoping").equals("f")) {

                                System.out.println("monster's turn");
                                monsterStatus.replace("currentEnemyDamage", monsterStats.get("flyDamage"));
                                numberStatus.replace("currentHealth",
                                        numberStatus.get("currentHealth")
                                                - (monsterStats.get("flyDamage") / stats.get("potionDefenseModifier")));
                                stats.replace("potionDefenseModifier", 1.0);
                                System.out.println("you took " + monsterStatus.get("currentEnemyDamage")
                                        + " damage, you have" + numberStatus.get("currentHealth") + " HP");

                                if (numberStatus.get("currentHealth") < 1.0) {
                                    System.out.println(
                                            "game over, if you continue, you will keep your level but your exp, money, and items will be removed");
                                    Thread.sleep(8000);
                                    stats.replace("exp", 0.0);
                                    stats.replace("money", 0.0);
                                    monsterStatus.replace("currentEnemyDamage", 0.0);
                                    numberStatus.replace("currentHealth", stats.get("maxHealth"));
                                    monster.replace("fly", 0);
                                    Thread.sleep(2000);

                                }
                            }

                        
                    }
                
                    while (monster.get("moth").equals(1)) {
                        monsterStatus.replace("currentHealth", monsterStats.get("mothHealth"));
                        System.out.println("your move (f or i)");
                        status.replace("move", scanner.nextLine());
                        if (status.get("move").equals("f")) {
                            numberStatus.replace("currentDamage", (stats.get("strengthLevel") + NumberPicker.nextInt(3)));

                            monsterStatus.replace("currentHealth",
                                    monsterStatus.get("currentHealth")
                                            - (numberStatus.get("currentDamage") * stats.get("potionStrengthModifier")));

                            System.out.println("you dealt " + numberStatus.get("currentDamage") + " damage");

                            if (monsterStatus.get("currentHealth") < 1) {
                                stats.replace("money", stats.get("money") + (1.0 * stats.get("moneyGain")));
                                stats.replace("exp",
                                    stats.get("exp") + ((1 * stats.get("expGain")) * stats.get("potionExpModifier")));
                                stats.replace("untilNextLevel", stats.get("untilNextLevel")
                                    - ((1 * stats.get("expGain")) * stats.get("potionExpModifier")));
                                System.out.println("you won! You now have " + stats.get("exp") + " exp, " + stats.get("money")
                                    + " money, and " + stats.get("untilNextLevel") + " exp until the next level");

                                status.replace("fightingOrShoping", "n");
                                stats.replace("potionExpModifier", 1.0);
                                Thread.sleep(5000);
                                monster.replace("moth", 0);
                                clearScreen();
                            }
                        } else if (status.get("move").equals("i")) {

                            System.out.println("choose your item, use i1 for item 1, i2 for item 2, and so on.");
                            System.out.println("item 1: " + baggedItems.get("item1") + " item 2: "
                                    + baggedItems.get("item2") + " item 3:" + baggedItems.get("item3") + " item 4: "
                                    + baggedItems.get("item4") + " item 5: " + baggedItems.get("item5"));
                            status.replace("usedPotion", scanner.nextLine());
                            if (status.get("usedPotion").equals("i1")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item1").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item1").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item1", "n/a");
                            } else if (status.get("usedPotion").equals("i2")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item2").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item2").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }

                                baggedItems.replace("item2", "n/a");

                            } else if (status.get("usedPotion").equals("i3")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item3").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item3").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item3", "n/a");

                            } else if (status.get("usedPotion").equals("i4")) {
                                if (baggedItems.get("item4").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item4").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item4").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item4", "n/a");

                            } else if (status.get("usedPotion").equals("i5")) {
                                if (baggedItems.get("item5").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item5").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item5").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item5", "n/a");

                            }

                        }
                        if (status.get("fightingOrShoping").equals("f")) {

                            System.out.println("monster's turn");
                            monsterStatus.replace("currentEnemyDamage", monsterStats.get("mothDamage"));
                            numberStatus.replace("currentHealth",
                                    numberStatus.get("currentHealth")
                                            - (monsterStats.get("mothDamage") / stats.get("potionDefenseModifier")));
                            stats.replace("potionDefenseModifier", 1.0);
                            System.out.println("you took " + monsterStatus.get("currentEnemyDamage") + "damage, you have "
                                    + numberStatus.get("currentHealth") + " HP");

                            if (numberStatus.get("currentHealth") < 1.0) {
                                System.out.println(
                                        "game over, if you continue, you will keep your level but your exp, money, and items will be removed");
                                Thread.sleep(8000);
                                stats.replace("exp", 0.0);
                                stats.replace("money", 0.0);
                                monsterStatus.replace("currentEnemyDamage", 0.0);
                                numberStatus.replace("currentHealth", stats.get("maxHealth"));
                                monster.replace("moth", 0);
                                Thread.sleep(2000);

                            }
                        }

                    

                }
                } else if (stats.get("level") > 6.0 || stats.get("level") < secondMonsters) {
                    monster.replace("frog", NumberPicker.nextInt(4));
                    monster.replace("duck", NumberPicker.nextInt(4));
                    monster.replace("squirrel", NumberPicker.nextInt(4));
                    while (monster.get("frog").equals("duck")) {

                        monster.replace("duck", NumberPicker.nextInt(4));
                    }
                    while (monster.get("squirrel").equals("duck")) {
                        monster.replace("squirrel", NumberPicker.nextInt(4));
                    }
                    while (monster.get("squirrel").equals("frog")) {
                        monster.replace("frog", NumberPicker.nextInt(4));
                    }                    
                
                    clearScreen();
                    if (monster.get("squirrel").equals(1)) {
                        System.out.println("a squirrel appeared!");
                    } else if (monster.get("frog").equals(1)) {
                        System.out.println("a frog appeared!");
                    } else if (monster.get("duck").equals(1)) {
                        System.out.println("a duck appeared");
                    }

                    while (monster.get("frog").equals(1)) {

                        monsterStatus.replace("currentHealth", monsterStats.get("frogHealth"));
                        System.out.println("your move (f or i)");
                        status.replace("move", scanner.nextLine());
                        if (status.get("move").equals("f")) {
                            
                            numberStatus.replace("currentDamage", (stats.get("strengthLevel") + NumberPicker.nextInt(3)));
                            monsterStatus.replace("currentHealth",
                                    monsterStatus.get("currentHealth")
                                            - (numberStatus.get("currentDamage") * stats.get("potionStrengthModifier")));
                            System.out.println("you dealt " + numberStatus.get("currentDamage") + " damage");

                            status.replace("move", "n");
                            
                            if (monsterStatus.get("currentHealth") < 1) {
                                stats.replace("money", stats.get("money") + (4.0 * stats.get("moneyGain")));
                                stats.replace("exp",
                                    stats.get("exp") + ((4 * stats.get("expGain")) * stats.get("potionExpModifier")));
                                stats.replace("untilNextLevel", stats.get("untilNextLevel")
                                    - ((4 * stats.get("expGain")) * stats.get("potionExpModifier")));
                                System.out.println("you won! You now have " + stats.get("exp") + " exp, " + stats.get("money")
                                    + " money, and " + stats.get("untilNextLevel") + " exp until the next level");

                                status.replace("fightingOrShoping", "n");
                                stats.replace("potionExpModifier", 1.0);
                                Thread.sleep(5000);
                                monster.replace("frog", 0);
                                clearScreen();
                            }

                        } else if (status.get("move").equals("i")) {

                            System.out.println("choose your item, use i1 for item 1, i2 for item 2, and so on.");
                            System.out.println("item 1: " + baggedItems.get("item1") + " item 2: "
                                    + baggedItems.get("item2") + " item 3:" + baggedItems.get("item3") + " item 4: "
                                    + baggedItems.get("item4") + " item 5: " + baggedItems.get("item5"));
                            status.replace("usedPotion", scanner.nextLine());
                            if (status.get("usedPotion").equals("i1")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item1").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item1").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item1", "n/a");
                            } else if (status.get("usedPotion").equals("i2")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item2").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item2").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }

                                baggedItems.replace("item2", "n/a");

                            } else if (status.get("usedPotion").equals("i3")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item3").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item3").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item3", "n/a");

                            } else if (status.get("usedPotion").equals("i4")) {
                                if (baggedItems.get("item4").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item4").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item4").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item4", "n/a");

                            } else if (status.get("usedPotion").equals("i5")) {
                                if (baggedItems.get("item5").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item5").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item5").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item5", "n/a");

                            }

                        }
                        if (status.get("fightingOrShoping").equals("f")) {

                            System.out.println("monster's turn");
                            monsterStatus.replace("currentEnemyDamage", monsterStats.get("frogDamage"));
                            numberStatus.replace("currentHealth",
                                    numberStatus.get("currentHealth")
                                            - (monsterStats.get("frogDamage") / stats.get("potionDefenseModifier")));
                            stats.replace("potionDefenseModifier", 1.0);
                            System.out.println("you took " + monsterStatus.get("currentEnemyDamage") + "damage, you have "
                                    + numberStatus.get("currentHealth") + " HP");

                            if (numberStatus.get("currentHealth") < 1.0) {
                                System.out.println(
                                        "game over, if you continue, you will keep your level but your exp, money, and items will be removed");
                                Thread.sleep(8000);
                                stats.replace("exp", 0.0);
                                stats.replace("money", 0.0);
                                monsterStatus.replace("currentEnemyDamage", 0.0);
                                numberStatus.replace("currentHealth", stats.get("maxHealth"));
                                monster.replace("moth", 0);
                                Thread.sleep(2000);

                            }
                        }
                        
                    }
                    while (monster.get("duck").equals(1)) {
                        monsterStatus.replace("currentHealth", monsterStats.get("duckHealth"));
                        System.out.println("your move (f or i)");
                        status.replace("move", scanner.nextLine());
                        if (status.get("move").equals("f")) {
                            numberStatus.replace("currentDamage", (stats.get("strengthLevel") + NumberPicker.nextInt(3)));

                            monsterStatus.replace("currentHealth",
                                    monsterStatus.get("currentHealth")
                                            - (numberStatus.get("currentDamage") * stats.get("potionStrengthModifier")));

                            System.out.println("you dealt " + numberStatus.get("currentDamage") + " damage");

                            if (monsterStatus.get("currentHealth") < 1) {
                                stats.replace("money", stats.get("money") + (1.0 * stats.get("moneyGain")));
                                stats.replace("exp",
                                    stats.get("exp") + ((1 * stats.get("expGain")) * stats.get("potionExpModifier")));
                                stats.replace("untilNextLevel", stats.get("untilNextLevel")
                                    - ((1 * stats.get("expGain")) * stats.get("potionExpModifier")));
                                System.out.println("you won! You now have " + stats.get("exp") + " exp, " + stats.get("money")
                                    + " money, and " + stats.get("untilNextLevel") + " exp until the next level");

                                status.replace("fightingOrShoping", "n");
                                stats.replace("potionExpModifier", 1.0);
                                Thread.sleep(5000);
                                monster.replace("moth", 0);
                                clearScreen();
                            }
                        } else if (status.get("move").equals("i")) {

                            System.out.println("choose your item, use i1 for item 1, i2 for item 2, and so on.");
                            System.out.println("item 1: " + baggedItems.get("item1") + " item 2: "
                                    + baggedItems.get("item2") + " item 3:" + baggedItems.get("item3") + " item 4: "
                                    + baggedItems.get("item4") + " item 5: " + baggedItems.get("item5"));
                            status.replace("usedPotion", scanner.nextLine());
                            if (status.get("usedPotion").equals("i1")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item1").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item1").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item1", "n/a");
                            } else if (status.get("usedPotion").equals("i2")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item2").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item2").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }

                                baggedItems.replace("item2", "n/a");

                            } else if (status.get("usedPotion").equals("i3")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item3").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item3").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item3", "n/a");

                            } else if (status.get("usedPotion").equals("i4")) {
                                if (baggedItems.get("item4").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item4").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item4").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item4", "n/a");

                            } else if (status.get("usedPotion").equals("i5")) {
                                if (baggedItems.get("item5").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item5").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item5").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item5", "n/a");

                            }

                        }        
                            if (status.get("fightingOrShoping").equals("f")) {

                                System.out.println("monster's turn");
                                monsterStatus.replace("currentEnemyDamage", monsterStats.get("flyDamage"));
                                numberStatus.replace("currentHealth",
                                        numberStatus.get("currentHealth")
                                                - (monsterStats.get("flyDamage") / stats.get("potionDefenseModifier")));
                                stats.replace("potionDefenseModifier", 1.0);
                                System.out.println("you took " + monsterStatus.get("currentEnemyDamage")
                                        + " damage, you have" + numberStatus.get("currentHealth") + " HP");

                                if (numberStatus.get("currentHealth") < 1.0) {
                                    System.out.println(
                                            "game over, if you continue, you will keep your level but your exp, money, and items will be removed");
                                    Thread.sleep(8000);
                                    stats.replace("exp", 0.0);
                                    stats.replace("money", 0.0);
                                    monsterStatus.replace("currentEnemyDamage", 0.0);
                                    numberStatus.replace("currentHealth", stats.get("maxHealth"));
                                    monster.replace("fly", 0);
                                    Thread.sleep(2000);

                                }
                            }

                        
                    }
                
                    while (monster.get("moth").equals(1)) {
                        monsterStatus.replace("currentHealth", monsterStats.get("mothHealth"));
                        System.out.println("your move (f or i)");
                        status.replace("move", scanner.nextLine());
                        if (status.get("move").equals("f")) {
                            numberStatus.replace("currentDamage", (stats.get("strengthLevel") + NumberPicker.nextInt(3)));

                            monsterStatus.replace("currentHealth",
                                    monsterStatus.get("currentHealth")
                                            - (numberStatus.get("currentDamage") * stats.get("potionStrengthModifier")));

                            System.out.println("you dealt " + numberStatus.get("currentDamage") + " damage");

                            if (monsterStatus.get("currentHealth") < 1) {
                                stats.replace("money", stats.get("money") + (1.0 * stats.get("moneyGain")));
                                stats.replace("exp",
                                    stats.get("exp") + ((1 * stats.get("expGain")) * stats.get("potionExpModifier")));
                                stats.replace("untilNextLevel", stats.get("untilNextLevel")
                                    - ((1 * stats.get("expGain")) * stats.get("potionExpModifier")));
                                System.out.println("you won! You now have " + stats.get("exp") + " exp, " + stats.get("money")
                                    + " money, and " + stats.get("untilNextLevel") + " exp until the next level");

                                status.replace("fightingOrShoping", "n");
                                stats.replace("potionExpModifier", 1.0);
                                Thread.sleep(5000);
                                monster.replace("moth", 0);
                                clearScreen();
                            }
                        } else if (status.get("move").equals("i")) {

                            System.out.println("choose your item, use i1 for item 1, i2 for item 2, and so on.");
                            System.out.println("item 1: " + baggedItems.get("item1") + " item 2: "
                                    + baggedItems.get("item2") + " item 3:" + baggedItems.get("item3") + " item 4: "
                                    + baggedItems.get("item4") + " item 5: " + baggedItems.get("item5"));
                            status.replace("usedPotion", scanner.nextLine());
                            if (status.get("usedPotion").equals("i1")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item1").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item1").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item1", "n/a");
                            } else if (status.get("usedPotion").equals("i2")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item2").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item2").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }

                                baggedItems.replace("item2", "n/a");

                            } else if (status.get("usedPotion").equals("i3")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item3").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item3").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item3", "n/a");

                            } else if (status.get("usedPotion").equals("i4")) {
                                if (baggedItems.get("item4").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item4").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item4").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item4", "n/a");

                            } else if (status.get("usedPotion").equals("i5")) {
                                if (baggedItems.get("item5").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item5").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item5").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item5", "n/a");

                            }

                        }
                        if (status.get("fightingOrShoping").equals("f")) {

                            System.out.println("monster's turn");
                            monsterStatus.replace("currentEnemyDamage", monsterStats.get("mothDamage"));
                            numberStatus.replace("currentHealth",
                                    numberStatus.get("currentHealth")
                                            - (monsterStats.get("mothDamage") / stats.get("potionDefenseModifier")));
                            stats.replace("potionDefenseModifier", 1.0);
                            System.out.println("you took " + monsterStatus.get("currentEnemyDamage") + "damage, you have "
                                    + numberStatus.get("currentHealth") + " HP");

                            if (numberStatus.get("currentHealth") < 1.0) {
                                System.out.println(
                                        "game over, if you continue, you will keep your level but your exp, money, and items will be removed");
                                Thread.sleep(8000);
                                stats.replace("exp", 0.0);
                                stats.replace("money", 0.0);
                                monsterStatus.replace("currentEnemyDamage", 0.0);
                                numberStatus.replace("currentHealth", stats.get("maxHealth"));
                                monster.replace("moth", 0);
                                Thread.sleep(2000);

                            }
                        }

                    

                }
            } else if (stats.get("level") > 6.0 || stats.get("level") < secondMonsters) {
                    monster.replace("frog", NumberPicker.nextInt(4));
                    monster.replace("duck", NumberPicker.nextInt(4));
                    monster.replace("squirrel", NumberPicker.nextInt(4));
                    while (monster.get("frog").equals("duck")) {

                        monster.replace("duck", NumberPicker.nextInt(4));
                    }
                    while (monster.get("squirrel").equals("duck")) {
                        monster.replace("squirrel", NumberPicker.nextInt(4));
                    }
                    while (monster.get("squirrel").equals("frog")) {
                        monster.replace("frog", NumberPicker.nextInt(4));
                    }                    
                
                    clearScreen();
                    if (monster.get("squirrel").equals(1)) {
                        System.out.println("a squirrel appeared!");
                    } else if (monster.get("frog").equals(1)) {
                        System.out.println("a frog appeared!");
                    } else if (monster.get("duck").equals(1)) {
                        System.out.println("a duck appeared");
                    }

                    while (monster.get("frog").equals(1)) {

                        monsterStatus.replace("currentHealth", monsterStats.get("frogHealth"));
                        System.out.println("your move (f or i)");
                        status.replace("move", scanner.nextLine());
                        if (status.get("move").equals("f")) {
                            
                            numberStatus.replace("currentDamage", (stats.get("strengthLevel") + NumberPicker.nextInt(3)));
                            monsterStatus.replace("currentHealth",
                                    monsterStatus.get("currentHealth")
                                            - (numberStatus.get("currentDamage") * stats.get("potionStrengthModifier")));
                            System.out.println("you dealt " + numberStatus.get("currentDamage") + " damage");

                            status.replace("move", "n");
                            
                            if (monsterStatus.get("currentHealth") < 1) {
                                stats.replace("money", stats.get("money") + (4.0 * stats.get("moneyGain")));
                                stats.replace("exp",
                                    stats.get("exp") + ((4 * stats.get("expGain")) * stats.get("potionExpModifier")));
                                stats.replace("untilNextLevel", stats.get("untilNextLevel")
                                    - ((4 * stats.get("expGain")) * stats.get("potionExpModifier")));
                                System.out.println("you won! You now have " + stats.get("exp") + " exp, " + stats.get("money")
                                    + " money, and " + stats.get("untilNextLevel") + " exp until the next level");

                                status.replace("fightingOrShoping", "n");
                                stats.replace("potionExpModifier", 1.0);
                                Thread.sleep(5000);
                                monster.replace("frog", 0);
                                clearScreen();
                            }

                        } else if (status.get("move").equals("i")) {

                            System.out.println("choose your item, use i1 for item 1, i2 for item 2, and so on.");
                            System.out.println("item 1: " + baggedItems.get("item1") + " item 2: "
                                    + baggedItems.get("item2") + " item 3:" + baggedItems.get("item3") + " item 4: "
                                    + baggedItems.get("item4") + " item 5: " + baggedItems.get("item5"));
                            status.replace("usedPotion", scanner.nextLine());
                            if (status.get("usedPotion").equals("i1")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item1").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item1").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item1", "n/a");
                            } else if (status.get("usedPotion").equals("i2")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item2").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item2").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }

                                baggedItems.replace("item2", "n/a");

                            } else if (status.get("usedPotion").equals("i3")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item3").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item3").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item3", "n/a");

                            } else if (status.get("usedPotion").equals("i4")) {
                                if (baggedItems.get("item4").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item4").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item4").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item4", "n/a");

                            } else if (status.get("usedPotion").equals("i5")) {
                                if (baggedItems.get("item5").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item5").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item5").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item5", "n/a");

                            }

                        }
                        if (status.get("fightingOrShoping").equals("f")) {

                            System.out.println("monster's turn");
                            monsterStatus.replace("currentEnemyDamage", monsterStats.get("frogDamage"));
                            numberStatus.replace("currentHealth",
                                    numberStatus.get("currentHealth")
                                            - (monsterStats.get("frogDamage") / stats.get("potionDefenseModifier")));
                            stats.replace("potionDefenseModifier", 1.0);
                            System.out.println("you took " + monsterStatus.get("currentEnemyDamage") + "damage, you have "
                                    + numberStatus.get("currentHealth") + " HP");

                            if (numberStatus.get("currentHealth") < 1.0) {
                                System.out.println(
                                        "game over, if you continue, you will keep your level but your exp, money, and items will be removed");
                                Thread.sleep(8000);
                                stats.replace("exp", 0.0);
                                stats.replace("money", 0.0);
                                monsterStatus.replace("currentEnemyDamage", 0.0);
                                numberStatus.replace("currentHealth", stats.get("maxHealth"));
                                monster.replace("frog", 0);
                                Thread.sleep(2000);

                            }
                        }
                    }
                    while (monster.get("duck").equals(1)) {

                        monsterStatus.replace("currentHealth", monsterStats.get("duckHealth"));
                        System.out.println("your move (f or i)");
                        status.replace("move", scanner.nextLine());
                        if (status.get("move").equals("f")) {
                            
                            numberStatus.replace("currentDamage", (stats.get("strengthLevel") + NumberPicker.nextInt(3)));
                            monsterStatus.replace("currentHealth",
                                    monsterStatus.get("currentHealth")
                                            - (numberStatus.get("currentDamage") * stats.get("potionStrengthModifier")));
                            System.out.println("you dealt " + numberStatus.get("currentDamage") + " damage");

                            status.replace("move", "n");
                            
                            if (monsterStatus.get("currentHealth") < 1) {
                                stats.replace("money", stats.get("money") + (5.0 * stats.get("moneyGain")));
                                stats.replace("exp",
                                    stats.get("exp") + ((5 * stats.get("expGain")) * stats.get("potionExpModifier")));
                                stats.replace("untilNextLevel", stats.get("untilNextLevel")
                                    - ((4 * stats.get("expGain")) * stats.get("potionExpModifier")));
                                System.out.println("you won! You now have " + stats.get("exp") + " exp, " + stats.get("money")
                                    + " money, and " + stats.get("untilNextLevel") + " exp until the next level");

                                status.replace("fightingOrShoping", "n");
                                stats.replace("potionExpModifier", 1.0);
                                Thread.sleep(5000);
                                monster.replace("duck", 0);
                                clearScreen();
                            }

                        } else if (status.get("move").equals("i")) {

                            System.out.println("choose your item, use i1 for item 1, i2 for item 2, and so on.");
                            System.out.println("item 1: " + baggedItems.get("item1") + " item 2: "
                                    + baggedItems.get("item2") + " item 3:" + baggedItems.get("item3") + " item 4: "
                                    + baggedItems.get("item4") + " item 5: " + baggedItems.get("item5"));
                            status.replace("usedPotion", scanner.nextLine());
                            if (status.get("usedPotion").equals("i1")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item1").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item1").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item1", "n/a");
                            } else if (status.get("usedPotion").equals("i2")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item2").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item2").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }

                                baggedItems.replace("item2", "n/a");

                            } else if (status.get("usedPotion").equals("i3")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item3").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item3").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item3", "n/a");

                            } else if (status.get("usedPotion").equals("i4")) {
                                if (baggedItems.get("item4").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item4").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item4").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item4", "n/a");

                            } else if (status.get("usedPotion").equals("i5")) {
                                if (baggedItems.get("item5").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item5").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item5").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item5", "n/a");

                            }

                        }
                        if (status.get("fightingOrShoping").equals("f")) {

                            System.out.println("monster's turn");
                            monsterStatus.replace("currentEnemyDamage", monsterStats.get("duckDamage"));
                            numberStatus.replace("currentHealth",
                                    numberStatus.get("currentHealth")
                                            - (monsterStats.get("duckDamage") / stats.get("potionDefenseModifier")));
                            stats.replace("potionDefenseModifier", 1.0);
                            System.out.println("you took " + monsterStatus.get("currentEnemyDamage") + "damage, you have "
                                    + numberStatus.get("currentHealth") + " HP");

                            if (numberStatus.get("currentHealth") < 1.0) {
                                System.out.println(
                                        "game over, if you continue, you will keep your level but your exp, money, and items will be removed");
                                Thread.sleep(8000);
                                stats.replace("exp", 0.0);
                                stats.replace("money", 0.0);
                                monsterStatus.replace("currentEnemyDamage", 0.0);
                                numberStatus.replace("currentHealth", stats.get("maxHealth"));
                                monster.replace("duck", 0);
                                Thread.sleep(2000);

                            }
                        }
                    }
                    while (monster.get("squirrel").equals(1)) {

                        monsterStatus.replace("currentHealth", monsterStats.get("squirrelHealth"));
                        System.out.println("your move (f or i)");
                        status.replace("move", scanner.nextLine());
                        if (status.get("move").equals("f")) {
                            
                            numberStatus.replace("currentDamage", (stats.get("strengthLevel") + NumberPicker.nextInt(3)));
                            monsterStatus.replace("currentHealth",
                                    monsterStatus.get("currentHealth")
                                            - (numberStatus.get("currentDamage") * stats.get("potionStrengthModifier")));
                            System.out.println("you dealt " + numberStatus.get("currentDamage") + " damage");

                            status.replace("move", "n");
                            
                            if (monsterStatus.get("currentHealth") < 1) {
                                stats.replace("money", stats.get("money") + (6.0 * stats.get("moneyGain")));
                                stats.replace("exp",
                                    stats.get("exp") + ((6 * stats.get("expGain")) * stats.get("potionExpModifier")));
                                stats.replace("untilNextLevel", stats.get("untilNextLevel")
                                    - ((4 * stats.get("expGain")) * stats.get("potionExpModifier")));
                                System.out.println("you won! You now have " + stats.get("exp") + " exp, " + stats.get("money")
                                    + " money, and " + stats.get("untilNextLevel") + " exp until the next level");

                                status.replace("fightingOrShoping", "n");
                                stats.replace("potionExpModifier", 1.0);
                                Thread.sleep(5000);
                                monster.replace("squirrel", 0);
                                clearScreen();
                            }

                        } else if (status.get("move").equals("i")) {

                            System.out.println("choose your item, use i1 for item 1, i2 for item 2, and so on.");
                            System.out.println("item 1: " + baggedItems.get("item1") + " item 2: "
                                    + baggedItems.get("item2") + " item 3:" + baggedItems.get("item3") + " item 4: "
                                    + baggedItems.get("item4") + " item 5: " + baggedItems.get("item5"));
                            status.replace("usedPotion", scanner.nextLine());
                            if (status.get("usedPotion").equals("i1")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item1", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item1").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item1").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item1").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item1", "n/a");
                            } else if (status.get("usedPotion").equals("i2")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item2", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item2").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item2").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item2").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }

                                baggedItems.replace("item2", "n/a");

                            } else if (status.get("usedPotion").equals("i3")) {
                                if (baggedItems.get("item1").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item3", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item3").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item3").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item3").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item3", "n/a");

                            } else if (status.get("usedPotion").equals("i4")) {
                                if (baggedItems.get("item4").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item4", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item4").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item4").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item4").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item4", "n/a");

                            } else if (status.get("usedPotion").equals("i5")) {
                                if (baggedItems.get("item5").equals("lesser healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 10.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the lesser healing potion and gained 10 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 30.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the healing potion and gained 30 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("greater healing potion")) {
                                    numberStatus.replace("currentHealth", numberStatus.get("currentHealth") + 50.0);
                                    while (numberStatus.get("currentHealth") > stats.get("maxHealth")) {
                                        numberStatus.replace("currentHealth", numberStatus.get("currentHealth") - 1.0);
                                    }
                                    baggedItems.replace("item5", "n/a");
                                    System.out.println("you used the greater healing potion and gained 50 hp, you have "
                                            + numberStatus.get("currentHealth") + " hp");
                                    Thread.sleep(5000);
                                    clearScreen();

                                } else if (baggedItems.get("item5").equals("strength potion")) {
                                    stats.replace("potionStrengthModifier", 2.0);
                                    System.out.println("you used the strength potion, your next attack will be stronger");
                                } else if (baggedItems.get("item5").equals("defense potion")) {
                                    stats.replace("potionDefenseModifier", 2.0);
                                    System.out.println(
                                            "you used the defense potion, you will now take less damage on the next enemy turn");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else if (baggedItems.get("item5").equals("exp potion")) {
                                    stats.replace("potionExpModifier", 2.0);
                                    System.out.println(
                                            "you used the exp potion, you will gain more exp at the end of this battle.");
                                    Thread.sleep(5000);
                                    clearScreen();
                                } else {
                                    System.out.println("there isn't any potion in this slot!");
                                    Thread.sleep(3000);
                                    clearScreen();
                                }
                                baggedItems.replace("item5", "n/a");

                            }

                        }
                        if (status.get("fightingOrShoping").equals("f")) {

                            System.out.println("monster's turn");
                            monsterStatus.replace("currentEnemyDamage", monsterStats.get("squirrelDamage"));
                            numberStatus.replace("currentHealth",
                                    numberStatus.get("currentHealth")
                                            - (monsterStats.get("squirrelDamage") / stats.get("potionDefenseModifier")));
                            stats.replace("potionDefenseModifier", 1.0);
                            System.out.println("you took " + monsterStatus.get("currentEnemyDamage") + "damage, you have "
                                    + numberStatus.get("currentHealth") + " HP");

                            if (numberStatus.get("currentHealth") < 1.0) {
                                System.out.println(
                                        "game over, if you continue, you will keep your level but your exp, money, and items will be removed");
                                Thread.sleep(8000);
                                stats.replace("exp", 0.0);
                                stats.replace("money", 0.0);
                                monsterStatus.replace("currentEnemyDamage", 0.0);
                                numberStatus.replace("currentHealth", stats.get("maxHealth"));
                                monster.replace("squirrel", 0);
                                Thread.sleep(2000);

                            }
                        }
                    }
                }
                }
        }

        if (stats.get("exp") > (15 * stats.get("level")) || stats.get("untilNextLevel") < (1.0)) {
            clearScreen();
            status.put("fightingOrShoping", "n");
            stats.replace("level", stats.get("level") + 1);
            stats.replace("strengthLevel", stats.get("strengthLevel") + 1);
            stats.replace("health", stats.get("maxHealth") + 3);
            numberStatus.replace("currentHealth", stats.get("maxHealth"));
            System.out.println("You leveled up! you now kill faster and have more health.");
            System.out
                    .println("press 's' for strength, 'e' for more exp, 'm' for more money, and 'h' for more health.");
            status.put("upgrade", scanner.nextLine());

            if (status.get("upgrade").equals("s")) {
                System.out.println("You chose strength, you will now kill enemies faster");
                stats.replace("strengthLevel", stats.get("strengthLevel") + 1);
                Thread.sleep(5000);
                clearScreen();
                status.put("gameContinue", "n");
                status.put("upgrade", "n");
            } else if (status.get("upgrade").equals("e")) {
                System.out.println("you chose exp gain, you will now gain even more experience");
                stats.replace("expGain", stats.get("expGain") + 0.75);
                Thread.sleep(5000);
                clearScreen();
                status.put("gameContinue", "n");
                status.put("upgrade", "n");
            } else if (status.get("upgrade").equals("m")) {
                System.out.println("you chose money, you will now gain more money per kill");
                stats.replace("moneyGain", stats.get("moneyGain") + 0.5);
                Thread.sleep(5000);
                clearScreen();
                status.put("gameContinue", "n");
                status.put("upgrade", "n");
            } else if (status.get("upgrade").equals("h")) {
                System.out.println("you chose extra health, you will gain a few extra health points");
                stats.replace("maxHealth", stats.get("maxHealth") + 2);
                Thread.sleep(5000);
                clearScreen();
                status.put("gameContinue", "n");
                status.put("upgrade", "n");
            }

        }

    }
                
            
            
   
    
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}