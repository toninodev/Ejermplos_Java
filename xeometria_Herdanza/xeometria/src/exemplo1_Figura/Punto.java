package exemplo1_Figura;

public class Punto extends Figura {
    private final Coordenada posicion;
    
    public Punto(int y,int x) {
        super("Punto");
        this.posicion=new Coordenada(y,x);
    }
    
    public Punto(Coordenada c) {
        super("Punto");
        this.posicion=c;
    }
    
    public void desplaza(int dy,int dx) {
        posicion.desplaza(dy, dx);
    }
    
    @Override
    public String toString() {
        String str=super.toString();
        return str+posicion;
    }
}
