package MiniProjects.MiniProject2;

public class HPi extends Manufacturer {
    public Computer createComputer(String type) {
        if (type == "Workstation") {
            return new HPiWorkstation();
        } else if (type == "Server") {
            return new HPiServer();
        } else if (type == "Laptop") {
            return new HPiLaptop();
        }
        return null;
    }
}
