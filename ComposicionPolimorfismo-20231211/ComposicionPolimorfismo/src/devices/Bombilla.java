package devices;

public class Bombilla extends Device {
    public Bombilla() {
        super("Bombilla");
        sw=new Interruptor(this);
    }
}
