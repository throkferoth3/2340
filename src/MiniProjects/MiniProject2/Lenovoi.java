package MiniProjects.MiniProject2;

public class Lenovoi extends Manufacturer {
    public Computer createComputer(String type) {
        if (type == "Workstation") {
            return new LenovoiWorkstation();
        } else if (type == "Server") {
            return new LenovoiServer();
        } else if (type == "Laptop") {
            return new LenovoiLaptop();
        }
        return null;
    }
}
