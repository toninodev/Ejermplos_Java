package devices;

public class Motor  {
    private boolean running;
    protected String sonido;
    Runnable engine;
    
    public Motor(String sonido) {
        this.running=false;
        this.sonido=sonido;
        
        // Clase Anónima
        //
        this.engine=new Runnable() {
            @Override
            public void run() {
                while (running) {
                    System.out.println(sonido);
                    try {
                        Thread.sleep(0x30);
                    } catch (InterruptedException ex) {
                        System.out.println("Warning: "+ex.getMessage());
                    }
                }
            }
        };
    } 
        
    public void start() {
        Thread thread=new Thread(engine);
        running=true;
        thread.start();
    }
    
    public void stop() {
        running=false;
    }
    
    public static void main(String[] args) throws InterruptedException {
        Motor m=new Motor("bRrRrRr");
        System.out.println("*** Starting\n");
        m.start();
        Thread.sleep(100);
        m.stop();
        System.out.println("\n****Stopped");
        Thread.sleep(500);
        System.out.println("\n***Starting\n");
        m.start();
        Thread.sleep(100);
        m.stop();
        System.out.println("\n****Stopped");
    }
}
