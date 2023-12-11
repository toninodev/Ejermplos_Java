package exemplo1_Figura;

public class Coordenada {
    private int x;
    private int y;
    
    public Coordenada(int y,int x) {
        this.x=x;
        this.y=y;
    }
    
    public void desplaza(int dy,int dx) {
        y=y+dy;
        x=x+dx;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    
    @Override
    public String toString() {
        return "("+y+","+x+")";
    }    
}