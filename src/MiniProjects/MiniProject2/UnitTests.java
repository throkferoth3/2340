package MiniProjects.MiniProject2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UnitTests {
    private static final int TIMEOUT = 2000;

    @Test(timeout = TIMEOUT)
    public void testInvalidType() {
        Manufacturer m = new Dellis();
        Computer test = m.createComputer("X");
        assertEquals(test, null);
    }
    @Test(timeout = TIMEOUT)
    public void testCustomer() {
        Manufacturer m = new Dellis();
        Computer test = m.orderComputer("Server", "Joe");
        assertEquals(test.customer, "Joe");
    }
    @Test(timeout = TIMEOUT)
    public void testType() {
        Manufacturer m = new HPi();
        Computer test = m.orderComputer("Laptop", "Ryan");
        assertEquals(test.type, "Laptop");
    }
    @Test(timeout = TIMEOUT)
    public void testManufacturer() {
        Manufacturer m = new Lenovoi();
        Computer test = m.orderComputer("Workstation", "Kate");
        assertEquals(test.manufacturer, "Lenovoi");
    }
}
