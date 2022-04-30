package MiniProjects.MiniProject1;

import java.math.BigDecimal;

public class Vanilla implements IceCream {

    private int scoops = 0;

    public Vanilla(int numOfScoops) {
        if (numOfScoops == 1  || numOfScoops == 2) {
            scoops = numOfScoops;
        } else {
            throw new IllegalArgumentException("Please enter 1 or 2 scoops");
        }
    }

    public BigDecimal cost() {
        if (scoops == 1) {
            return new BigDecimal("2.79");
        } else {
            return new BigDecimal("3.99");
        }
    }

    @Override
    public String getDescription() {
        if (scoops == 1) {
            return "A single scoop of vanilla ice cream";
        } else {
            return "A double scoop of vanilla ice cream";
        }
    }
}
