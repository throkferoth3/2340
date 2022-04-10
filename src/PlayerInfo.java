import java.util.ArrayList;
import java.util.HashMap;

public class PlayerInfo {
    private static int difficulty;
    private static int money;
    private static int health;
    private static String name;
    private static ArrayList<Tower> ownedTowers = new ArrayList<Tower>();
    private static HashMap<Integer, Enemy> enemyHashMap = new HashMap<>();

    public static int getDifficulty() {
        return difficulty;
    }
    public static int getMoney() {
        return money;
    }
    public static int getHealth() {
        return health;
    }
    public static String getName() {
        return name;
    }
    public static void setDifficulty(int d) {
        difficulty = d;
    }
    public static void setMoney(int m) {
        money = m;
    }
    public static void setHealth(int h) {
        health = h;
        if (h == 0) {
            Controller.switchToGameOver();
        }
    }

    public static void takeDamage(int damage) {
        if (PlayerInfo.getHealth() - damage < 0) {
            PlayerInfo.setHealth(0);
        } else {
            PlayerInfo.setHealth(PlayerInfo.getHealth() - damage);
        }
    }

    public static void setName(String n) {
        name = n;
    }
    public static void addTower(Tower t) {
        ownedTowers.add(t);
    }

    public static ArrayList<Tower> getTowerList() {
        return ownedTowers;
    }
    public static HashMap<Integer, Enemy> getEnemyMap() {
        return enemyHashMap;
    }
    public static void initHealthAndMoney() {
        ownedTowers.clear();

        switch (difficulty) {
        case 0:
            health = 20;
            money = 100;
            break;
        case 1:
            health = 15;
            money = 75;
            break;
        case 2:
            health = 10;
            money = 50;
            break;
        default:
            break;
        }
    }

    public static boolean validPlacement(double x, double y) {
        if (ownedTowers == null) {
            return true;
        }
        if (y <= 30) {
            return false;
        }
        for (int i = 0; i < ownedTowers.size(); i++) {
            if (ownedTowers.get(i).isWithin(x, y)) {
                return false;
            }
        }
        return true;
    }
}
