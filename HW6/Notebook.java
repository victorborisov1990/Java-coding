package HW6;
import java.lang.StringBuilder;

public class Notebook {
    private String model;
    private int ram_size;
    private int storage_size;
    private Cpu cpu;
    private Os os;

    public Notebook (String model, Cpu cpu, int ram, int storage, Os os){
        this.model = model;
        this.cpu = cpu;
        ram_size= ram;
        storage_size = storage;
        this.os = os;
    }

    public Notebook (String model, Cpu cpu, int ram, int storage){
        this.model = model;
        this.cpu = cpu;
        ram_size= ram;
        storage_size = storage;
        this.os = Os.dos;
    }

    public String getModel(){
        return model;
    }    
    public Cpu getCpu(){
        return cpu;
    }
    public int getRam(){
        return ram_size;
    }
    public int getStor(){
        return storage_size;
    }
    public Os getOs(){
        return os;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Ноутбук ")
            .append(model)
            .append(": процессор ")
            .append(cpu)
            .append(", оперативная память: ")
            .append(ram_size)
            .append(" Гб, объем диска: ")
            .append(storage_size)
            .append(" Гб, операционная система: ")
            .append(os);
        return sb.toString();
    }
    
}