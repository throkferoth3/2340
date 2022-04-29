package MiniProjects.MiniProject2;

abstract public class Server extends Computer{
    public void addMemory() {
        System.out.println("\tadding multiple " + manufacturer + " memory chips");
    }
    public void addHdd() {
        System.out.println("\tadding multiple " + manufacturer + " hdds");
    }
    public void addCpu() {
        System.out.println("\tadding a powerful " + manufacturer + " cpu with many cores");
    }
    public void addGpu() {
        System.out.println("\tadding a generic " + manufacturer + " gpu");
    }
    public void addNetworkCard() {
        System.out.println("\tadding a powerful " + manufacturer + " network card");
    }
    public void order() {
        addMemory();
        addHdd();
        addCpu();
        addGpu();
        addNetworkCard();
    }
}
