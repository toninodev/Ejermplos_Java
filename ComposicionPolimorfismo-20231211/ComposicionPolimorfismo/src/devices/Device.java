package devices;

public class Device {
    // Crear DeviceMotor para dispositivos con motor
    
    
    private final String name;
    // Composición
    protected Interruptor sw; // Podería ser unha clase interna: Facer o exemplo - Permitimos o acceso as clases derivadas
    
    Device(String name) {
        this.name=name;
    }
    
    public boolean on() {
        if (sw==null) throw new IllegalArgumentException("No device switch");
        if (!sw.isOn()) {
            sw.click();
        } else {
            System.out.println(name+" xa estaba prendido");
        }
        return sw.isOn();
    }
    
    public boolean off() {
        if (sw==null) throw new IllegalArgumentException("No device switch");
        if (sw.isOn()) {
            sw.click();
        } else {
            System.out.println(name+" xa estaba apagado");
        }
        return !sw.isOn();
    }
    
    // Acceso default so dende o propio package
    //
    void start() {
        System.out.println("Encendendo "+name);
    }
    
    void stop() {
        System.out.println("Apagando "+name);
    }
}
