package MiniProjects.MiniProject2;

abstract public class Laptop extends Computer {
    public void addMemory() {
        System.out.println("\tadding a light " + manufacturer + " memory");
    }
    public void addHdd() {
        System.out.println("\tadding a light " + manufacturer + " hdd");
    }
    public void addCpu() {
        System.out.println("\tadding a light " + manufacturer + " cpu");
    }
    public void addGpu() {
        System.out.println("\tadding a light " + manufacturer + " gpu");
    }
    public void addWifiCard() {
        System.out.println("\tadding a light WiFi card");
    }
    public void order() {
        addMemory();
        addHdd();
        addCpu();
        addGpu();
        addWifiCard();
    }
}
