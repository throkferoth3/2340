import javafx.scene.control.Button;
public class ShopEntry {
    private Button display;//The button that lets the player buy the tower
    private int[] cost; //[EasyCost, NormalCost, HardCost]
    private int towerIndicator;//Indicator for which tower is being placed. Start at 0 and increment for each new type of tower.
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
}
