package devices;


public class Aspiradora extends Device {
    private final Motor motor;
    
    // Crear MotorAspiradora con verificacións antes do arranque...
    // O Motor pode ter corrente ou non ter
    
    public Aspiradora() {
        super("Aspiradora");
        motor=new Motor("SSSSiiiiiiiuuuuuuu");
        sw=new Interruptor(this);
    }
    
    @Override
    void start() {
        //super.start();
        motor.start();
    }
    
    @Override
    void stop() {
        //super.stop();
        motor.stop();
    }    
}
