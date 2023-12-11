package exemplo1_Figura;


public class Circunferencia extends Figura {
    public static final double PI=3.1414592;
    private Coordenada centro;
    private int radio;

    public Circunferencia(Coordenada centro,int radio) {
        super("Circunferencia");
        this.centro=centro;
        this.radio=radio;
    }
    
    public Circunferencia(int y,int x,int radio) {
        this(new Coordenada(y,x),radio);
    }
        
    @Override
    public double getArea() {
        return 2*PI*radio;
    }
    
    @Override
    public void pinta() {
        System.out.println("Pintando unha circunferencia con centro en "+centro+" e radio "+radio);
    }
    
    @Override
    public String toString() {
        return "Circunferencia"+centro;
    }
    
    public static void main(String[] args) {
        Circunferencia c=new Circunferencia(6,6,123);
        System.out.println("O área da "+c+" é "+c.getArea());
        c.pinta();
    }
    
}
