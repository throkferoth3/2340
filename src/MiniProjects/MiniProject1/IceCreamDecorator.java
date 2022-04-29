package MiniProjects.MiniProject1;

import java.math.BigDecimal;

public abstract class IceCreamDecorator implements IceCream {

    private IceCream currentIceCream;

    public IceCreamDecorator(IceCream iceCream) {
        currentIceCream = iceCream;
    }

    public BigDecimal cost() {
        return currentIceCream.cost();
    }

    public String getDescription()  {
        return currentIceCream.getDescription();
    }
}
