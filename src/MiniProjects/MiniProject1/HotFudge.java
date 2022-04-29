package MiniProjects.MiniProject1;

import java.math.BigDecimal;

public class HotFudge extends IceCreamDecorator {
    public HotFudge (IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public BigDecimal cost() {
        return super.cost().add(new BigDecimal(".99"));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", hot fudge";
    }
}
