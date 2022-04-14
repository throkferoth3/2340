import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;

import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
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
        } catch (Exception e) {
            error = true;
        }
        Assert.assertTrue(error);
    }
    @Test(timeout = TIMEOUT)
    public void checkTowerIndicator() {
        PlayerInfo.setDifficulty(0);
        PlayerInfo.initHealthAndMoney();
        ShopEntry shop = new ShopEntry();
        Tower r = new RedTower(1.0, 1.0);
        PlayerInfo.addTower(r);
        assertEquals(shop.getTowerIndicator(), 0);
    }
    /**
     * M4 unit test to check that the three enemies have different colors.
     */
    @Test(timeout = TIMEOUT)
    public void checkEnemyColors() {
        Enemy p = new PurpleEnemy();
        Enemy y = new YellowEnemy();
        Enemy o = new OrangeEnemy();
        assertEquals(p.getCircle().getFill(), Color.PURPLE);
        assertEquals(y.getCircle().getFill(), Color.YELLOW);
        assertEquals(o.getCircle().getFill(), Color.ORANGE);
    }
    /**
     * M4 unit test to verify that the healths of the different types of enemies
     * can be properly accessed and altered.
     */
    @Test(timeout = TIMEOUT)
    public void checkHealthFunctionalities() {
        Enemy p = new PurpleEnemy();
        Enemy y = new YellowEnemy();
        Enemy o = new OrangeEnemy();
        p.setHealth(30);
        y.setHealth(30);
        o.setHealth(30);
        assertEquals(p.getHealth(), 30);
        assertEquals(y.getHealth(), 30);
        assertEquals(o.getHealth(), 30);
    }

    @Test(timeout = TIMEOUT)
    public void checkEnemyHealth() {
        Enemy p = new PurpleEnemy();
        Enemy y = new YellowEnemy();
        Enemy o = new OrangeEnemy();
        assertEquals(y.getHealth(), 2);
        assertEquals(o.getHealth(), 3);
        assertEquals(p.getHealth(), 1);
    }
    
    @Test(timeout = TIMEOUT)

    public void checkEnemyDamage() {
        Enemy p = new PurpleEnemy();
        Enemy y = new YellowEnemy();
        Enemy o = new OrangeEnemy();
        assertEquals(y.getDamage(), 1);
        assertEquals(o.getDamage(), 1);
        assertEquals(p.getDamage(), 1);
    }


    @Test(timeout = TIMEOUT)
    public void checkReset() {
        PlayerInfo.setMoney(-1);
        PlayerInfo.setDifficulty(0);
        PlayerInfo.initHealthAndMoney();
        assertEquals(PlayerInfo.getMoney(), 100);
    }

    @Test(timeout = TIMEOUT)
    public void checkDifferingHealth() {
        Enemy p = new PurpleEnemy();
        Enemy y = new YellowEnemy();
        Enemy o = new OrangeEnemy();
        assertNotEquals(p.getHealth(), y.getHealth());
        assertNotEquals(o.getHealth(), y.getHealth());
        assertNotEquals(p.getHealth(), o.getHealth());
    }

    @Test(timeout = TIMEOUT)
    public void playerTakeDamage() {
        PlayerInfo.setDifficulty(0);
        PlayerInfo.initHealthAndMoney();
        PlayerInfo.takeDamage(1);
        assertEquals(19, PlayerInfo.getHealth());
    }

    @Test(timeout = TIMEOUT)
    public void checkEnemyShape() {
        Enemy p = new PurpleEnemy();
        Enemy y = new YellowEnemy();
        Enemy o = new OrangeEnemy();
        assertTrue(p.getCircle() instanceof Circle);
        assertTrue(y.getCircle() instanceof Circle);
        assertTrue(o.getCircle() instanceof Circle);
    }
    @Test(timeout = TIMEOUT)
    public void checkAttackersEmpty() {
        Enemy e = new PurpleEnemy();
        int size = e.getAttackers().size();
        assertEquals(0, size);
    }
    @Test(timeout = TIMEOUT)
    public void testAddAttackers() {
        Enemy e = new PurpleEnemy();
        Tower t = new RedTower(1.0, 1.0);
        e.addAttacker(t);
        assertTrue(e.getAttackers().contains(t));
    }

    @Test(timeout = TIMEOUT)
    public void testUpdateHealth() {
        PurpleEnemy p = new PurpleEnemy();
        p.setHealth(0);
        Text test = p.updateHealth();
        assertEquals("" + p.getHealth(), test.getText());
    }

    @Test(timeout = TIMEOUT)
    public void testEnemyHealthIndicator() {
        PurpleEnemy p = new PurpleEnemy();
        Text test = p.getEnemyHealthText();
        assertNotNull(test);
    }

    @Test(timeout = TIMEOUT)
    public void testCreateInitText() { // creates the initial text for enemy hp
        Enemy enemy = new OrangeEnemy();
        Text test = enemy.createInitText();
        assertEquals("" + enemy.getHealth(), test.getText());
        enemy = new YellowEnemy();
        test = enemy.createInitText();
        assertEquals("" + enemy.getHealth(), test.getText());
        enemy = new PurpleEnemy();
        test = enemy.createInitText();
        assertEquals("" + enemy.getHealth(), test.getText());
    }

    @Test(timeout = TIMEOUT)
    public void testCreateDisplay() { // creates initial enemy display with text inside it
        Enemy enemy = new OrangeEnemy();
        StackPane test = enemy.createDisplay();
        assertTrue(test.getChildren().get(0) instanceof Circle);
        assertTrue(test.getChildren().get(1) instanceof Text);
    }
     
}
