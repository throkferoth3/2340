package MiniProjects.MiniProject2;

public class Dellis extends Manufacturer{
    public Computer createComputer(String type) {
        if (type == "Workstation") {
            return new DellisWorkstation();
        } else if (type == "Server") {
            return new DellisServer();
        } else if (type == "Laptop") {
            return new DellisLaptop();
        }
        return null;
    }
}
