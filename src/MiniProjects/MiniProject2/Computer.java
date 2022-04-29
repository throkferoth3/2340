package MiniProjects.MiniProject2;

abstract public class Computer {
    protected String type, manufacturer, customer;
    public void setCustomer(String c) {
        customer = c;
    }
    public String getType() {
        return type;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    abstract public void addMemory();
    abstract public void addHdd();
    abstract public void addCpu();
    abstract public void addGpu();
    public void orderDetails() {
        System.out.println(customer + " ordered a " + manufacturer + " " + type);
    }
    abstract public void order();
}
