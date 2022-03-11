import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnitTests {

    private static final int TIMEOUT = 2000;

    @Before
    public void setUp() {

    }

    @Test(timeout = TIMEOUT)
    public void healthVariesBasedOnDifficulty() {
        PlayerInfo.setDifficulty(0);
        PlayerInfo.initHealthAndMoney();
        assertEquals(20, PlayerInfo.getHealth());
        PlayerInfo.setDifficulty(1);
        PlayerInfo.initHealthAndMoney();
        assertEquals(15, PlayerInfo.getHealth());
        PlayerInfo.setDifficulty(2);
        PlayerInfo.initHealthAndMoney();
        assertEquals(10, PlayerInfo.getHealth());
    }

    @Test(timeout = TIMEOUT)
    public void invalidCoordinateTowerPlacement() {
        assertFalse(PlayerInfo.validPlacement(20, 20));
    }

    @Test(timeout = TIMEOUT)
    public void pathOverlapTowerPlacement() {
        boolean t = true;
        Path p = new Path();
        assertEquals(true, p.isWithin(p.getDisplay().getX(), p.getDisplay().getY()));
    }
    @Test(timeout = TIMEOUT)
    public void testAddTower() {
        Tower t = new RedTower(0d, 0d);
        PlayerInfo.addTower(t);
        assertEquals(PlayerInfo.getTowerList().size(), 1);

    }
    @Test(timeout = TIMEOUT)
    public void testNegativeCost() {
        boolean exception = false;
        ShopEntry sE = new ShopEntry();
        try {
            sE.setCost(new int[]{0, -1, 0});
        } catch (IllegalArgumentException e) {
            exception = true;
        }
        Assert.assertTrue(exception);
    }
    @Test(timeout = TIMEOUT)
    public void checkTowerColors() {
        Tower r = new RedTower(1.0, 1.0);
        Tower g = new GreenTower(1.0, 1.0);
        Tower b = new BlueTower(1.0, 1.0);
        assertEquals(r.getDisplay().getFill(), Color.RED);
        assertEquals(g.getDisplay().getFill(), Color.GREEN);
        assertEquals(b.getDisplay().getFill(), Color.BLUE);
    }
    @Test(timeout = TIMEOUT)
    public void checkInsufficientFunds() {
        PlayerInfo.setDifficulty(0);
        PlayerInfo.initHealthAndMoney();
        ShopEntry shop = new ShopEntry();
        PlayerInfo.setMoney(0);
        boolean error = false;
        shop.setCost(new int[]{20, 20, 20});
        Button b = shop.getDisplay();
        try {
             b.fire();
        } catch(Exception e) {
            error = true;
        }
        Assert.assertTrue(error);
    }
    @Test(timeout = TIMEOUT)
    public void checkTowerIndicator() {
        PlayerInfo.setDifficulty(0);
        PlayerInfo.initHealthAndMoney();
        ShopEntry shop = new ShopEntry();
        Button b = shop.getDisplay();
        b.fire();
        Tower r = new RedTower(1.0, 1.0);
        PlayerInfo.addTower(r);
        assertEquals(shop.getTowerIndicator(), 0);
    }
    
}