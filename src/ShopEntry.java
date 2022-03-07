import javafx.scene.control.Button;
public class ShopEntry {
    private Button display;//The button that lets the player buy the tower
    private int[] cost; //[EasyCost, NormalCost, HardCost]
    private int towerIndicator;//Indicator for which tower is being placed. Start at 0 and increment for each new type of tower.
    public ShopEntry() {
        cost = new int[]{0, 0, 0};
        towerIndicator = 0;
        display = null;
    }
    public ShopEntry(int[] c, int tI, String name) {
        cost = c;
        towerIndicator = tI;
        display = new Button(name);
    }
    public Button getDisplay() {
        return display;
    }
    public int getCost() {
        return cost[PlayerInfo.getDifficulty()];
    }
    public int getTowerIndicator() {
        return towerIndicator;
    }
    public void setCost(int[] cost) {
        for (int i = 0; i < cost.length; i++) {
            if (cost[i] < 0) {
                throw new IllegalArgumentException("Cost cannot be negative.");
            }
        }
        this.cost = cost;
    }
}
