/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo1_Figura;

/**
 *
 * @author xavi
 */
public class Rectangulo extends Poligono {
    private int base;
    private int altura;
    
    public Rectangulo(Coordenada esquinasuperiorizquierda,int base,int altura) {
        super("Rectangulo",4);
        this.base=base;
        this.altura=altura;
        coord[0]=esquinasuperiorizquierda;
        coord[1]=new Coordenada(this.coord[0].getX()+base,this.coord[0].getY());
        coord[2]=new Coordenada(this.coord[0].getX()+base,this.coord[0].getY()+altura);
        coord[3]=new Coordenada(this.coord[0].getX(),this.coord[0].getY()+altura);
    }
    
    public Rectangulo(int y,int x,int base,int altura) {
        this(new Coordenada(y,x),base,altura);
    }
    
    @Override
    public Coordenada getPosicion() {
        return this.coord[0];
    }
    
    @Override
    public double getArea() {
        return base*altura;
    }
    
    @Override
    public String toString() {
        return this+" de "+base+"x"+altura+" en "+coord[0];
    }
    
}
