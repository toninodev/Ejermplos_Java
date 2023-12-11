package devices;

public class Interruptor {
    private boolean on=false;
    private Device device=null;
    
    protected Interruptor() {}
    
    public Interruptor(Device device) {
        this.device=device;
    }
    
    public void click() {
        if (device==null) throw new IllegalArgumentException("No such device");
        on=!on;
        if (on) device.start();
        else    device.stop();
    }
    
    public boolean isOn() {
        return on;
    }
}
