package HW6;

public enum Cpu {
    intel ("Intel"),
    amd ("Amd");

    private String cpuName;

    Cpu(String cpuName){
        this.cpuName = cpuName;
    }
    public String getCpuName(){
        return cpuName;
    }

    @Override
    public String toString(){
        return cpuName;
    }
}
