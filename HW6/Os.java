package HW6;

public enum Os {
    mac ("macOs"), 
    win ("windows"), 
    dos ("without os"), 
    lin ("linux");

    private String osName;

    Os(String osName){
        this.osName = osName;
    }
    public String getOsName(){
        return osName;
    }

    @Override
    public String toString(){
        return osName;
    }
}
