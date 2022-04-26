import java.util.ArrayList;
import java.util.HashMap;

public class PlayerInfo {
    private static int difficulty;
    private static int money;
    private static int health;
    private static String name;
    private static ArrayList<Tower> ownedTowers = new ArrayList<Tower>();
    private static HashMap<Integer, Enemy> enemyHashMap = new HashMap<>();
    private static int roundNumber = 1;

    private static int damageTaken = 0;
    private static int upgradesPurchased = 0;
    private static int towersPlaced = 0;
    public static int getDamageTaken() {
        return damageTaken;
    }
    public static int getUpgradesPurchased() {
        return upgradesPurchased;
    }
    public static void incrementUpgradesPurchased() {
        upgradesPurchased++;
    }
    public static int getTowersPlaced() {
        return towersPlaced;
    }

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
    public static int getRoundNumber() {return roundNumber;}
    public static void setRoundNumber(int roundNumberNew) {roundNumber = roundNumberNew;}
    public static void takeDamage(int damage) {
        if (PlayerInfo.getHealth() - damage < 0) {
            PlayerInfo.setHealth(0);
        } else {
            PlayerInfo.setHealth(PlayerInfo.getHealth() - damage);
        }
        damageTaken += damage;
    }

    public static void setName(String n) {
        name = n;
    }
    public static void addTower(Tower t) {
        ownedTowers.add(t);
        towersPlaced++;
    }
    public static void addEnemy(Enemy e) {
        enemyHashMap.put(e.getId(), e);
    }
    public static void clearEnemies() {
        enemyHashMap.clear();
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
    public static void resetStats() {
        damageTaken = 0;
        towersPlaced = 0;
        upgradesPurchased = 0;
    }
}
