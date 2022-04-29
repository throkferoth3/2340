package MiniProjects.MiniProject1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UnitTests {

    private static final int TIMEOUT = 2000;

    @Test(timeout = TIMEOUT)
    public void doubleVanillaFudgeSprinkles() {
        IceCream iceCream = new Sprinkles(new HotFudge(new Vanilla(2)));
        assertEquals(iceCream.getDescription() + " $" + iceCream.cost(), "A double scoop of vanilla ice cream, hot fudge, sprinkles $5.77");
    }
}
