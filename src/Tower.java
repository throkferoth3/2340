abstract class Tower {

    private int cost = 0;

    /**
     * Constructor that sets all towers to a default cost based on difficulty.
     * If you want to make the different towers have different costs, make this
     * class an interface and put implementation details in the tower subclasses.
     *
     * @param difficulty difficulty of game.
     */
    public Tower(int difficulty) {
        switch (difficulty) { // switch statement from comment
            case 0:
                cost = 15;
                break;
            case 1:
                cost = 20;
                break;
            case 2:
                cost = 25;
                break;
            default:
                break;
        }
    }

    public boolean buyTower() {
        if (PlayerInfo.getMoney() >= cost) {
            PlayerInfo.setMoney(PlayerInfo.getMoney() - cost);
            return true;
        }
        return false;
    }

    public int getCost() {
        return cost;
    }

}