package MiniProjects.MiniProject2;


abstract public class Manufacturer {
    abstract Computer createComputer(String type);

    public Computer orderComputer(String type, String customer) {
        Computer computer = createComputer(type);
        computer.setCustomer(customer);
        computer.orderDetails();
        System.out.println("--- Making a " + computer.getManufacturer() + " " + computer.getType().toLowerCase() + " ---");
        computer.order();
        return computer;
    }
}
