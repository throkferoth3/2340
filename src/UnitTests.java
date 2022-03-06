import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class UnitTests {

    private static final int TIMEOUT = 200;

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
    public void negativeCoordinateTowerPlacement() {
        assertFalse(PlayerInfo.validPlacement(-1, -2));
    }
}