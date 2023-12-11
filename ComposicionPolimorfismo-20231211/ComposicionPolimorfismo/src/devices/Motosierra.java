package devices;

/**
 *  Crear DeviceMotor....  Aspiradora
 * @author xavi
 */
public class Motosierra extends Device {
    private final Motor motor;
    
    // Crear MotorMotosierra con un sonido distinto en el arranque...
    
    public Motosierra() {
        super("Motosierra");
        motor=new Motor("BrrBrrrrrBrrrrr RRRR");
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
