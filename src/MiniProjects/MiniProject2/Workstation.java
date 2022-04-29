package MiniProjects.MiniProject2;

abstract public class Workstation extends Computer {
    public void addMemory() {
        System.out.println("\tadding " + manufacturer + " memory");
    }
    public void addHdd() {
        System.out.println("\tadding " + manufacturer + " hdd");
    }
    public void addCpu() {
        System.out.println("\tadding " + manufacturer + " cpu");
    }
    public void addGpu() {
        System.out.println("\tadding a powerful " + manufacturer + " gpu");
    }
    public void addAudioCard() {
        System.out.println("\tadding an audio card ");
    }
    public void addNetworkCard() {
        System.out.println("\tadding a generic network card");
    }
    public void order() {
        addMemory();
        addHdd();
        addCpu();
        addGpu();
        addAudioCard();
        addNetworkCard();
    }
}
