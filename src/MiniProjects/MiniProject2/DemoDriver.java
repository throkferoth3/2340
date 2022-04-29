package MiniProjects.MiniProject2;

public class DemoDriver {
    public static void main(String[] args) {
        Manufacturer dellis = new Dellis();
        Manufacturer hpi = new HPi();
        Manufacturer lenovoi = new Lenovoi();

        dellis.orderComputer("Workstation", "Micheal");
        hpi.orderComputer("Server", "Hanna");
        lenovoi.orderComputer("Laptop", "Lenny");

        hpi.orderComputer("Workstation", "Joe");
    }
}
