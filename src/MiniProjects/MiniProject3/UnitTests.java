package MiniProjects.MiniProject3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class UnitTests {
    private static final int TIMEOUT = 2000;

    @Before
    public void setUp() {
    }

    @Test(timeout = TIMEOUT)
    public void testDepartmentsInitiallyEmpty() {
        int initialSize = Employee.getDepartments().size();
        assertEquals(initialSize, 0);
    }
}
