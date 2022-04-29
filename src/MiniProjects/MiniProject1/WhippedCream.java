package MiniProjects.MiniProject1;

import java.math.BigDecimal;

public class WhippedCream extends IceCreamDecorator {
    public WhippedCream (IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public BigDecimal cost() {
        return super.cost().add(new BigDecimal(".50"));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", whipped cream";
    }
}
