package MiniProjects.MiniProject1;

import java.math.BigDecimal;

public class Caramel extends IceCreamDecorator {
    public Caramel (IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public BigDecimal cost() {
        return super.cost().add(new BigDecimal(".89"));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", caramel";
    }
}
