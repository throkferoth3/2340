public class PlayerInfo {
    private static int difficulty;
    private static int money;
    private static int health;
    private static String name;

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
    public static void modifyMoney(int m) {
        money += m;
    }
    public static void setHealth(int h) {
        health = h;
    }
    public static void modifyHealth(int h) {
        health += h;
    }
    public static void setName(String n) {
        name = n;
    }
}
