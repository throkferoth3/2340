package MiniProjects.MiniProject1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UnitTests {

    private static final int TIMEOUT = 2000;

    @Test(timeout = TIMEOUT)
    public void doubleVanillaFudgeSprinkles() {
        IceCream iceCream = new Sprinkles(new HotFudge(new Vanilla(2)));
        assertEquals("A double scoop of vanilla ice cream, hot fudge, sprinkles $5.77", iceCream.getDescription() + " $" + iceCream.cost());
    }

    @Test(timeout = TIMEOUT)
    public void singleVanilla2CaramelWhippedCream() {
        IceCream iceCream = new WhippedCream(new Caramel(new Caramel(new Vanilla(1))));
        assertEquals("A single scoop of vanilla ice cream, caramel, caramel, whipped cream $5.07", iceCream.getDescription() + " $" + iceCream.cost());
    }

    @Test(timeout = TIMEOUT)
    public void doubleChocolateNoToppings() {
        IceCream iceCream = new Chocolate(2);
        assertEquals("A double scoop of chocolate ice cream $3.99", iceCream.getDescription() + " $" + iceCream.cost());
    }

    @Test(timeout = TIMEOUT)
    public void singleChocolateManyToppings() {
        IceCream iceCream = new WhippedCream(new Caramel(new WhippedCream(new Sprinkles(new Sprinkles(new Chocolate(1))))));
        assertEquals("A single scoop of chocolate ice cream, sprinkles, sprinkles, whipped cream, caramel, whipped cream $6.26", iceCream.getDescription() + " $" + iceCream.cost());
    }
}
