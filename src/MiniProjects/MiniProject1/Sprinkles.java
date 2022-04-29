package MiniProjects.MiniProject1;

import java.math.BigDecimal;

public class Sprinkles extends IceCreamDecorator {
    public Sprinkles (IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public BigDecimal cost() {
        return super.cost().add(new BigDecimal(".79"));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", sprinkles";
    }
}
