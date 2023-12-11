/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo1_Figura;

/**
 *
 * @author xavi
 */
public class Cadrado extends Rectangulo {
    
    public Cadrado(int y,int x,int lado) {
        super(y,x,lado,lado);
        this.nome="Cadrado";
    }
    
    public Cadrado(Coordenada esquinasuperiorizquierda, int lado) {
        this(esquinasuperiorizquierda.getY(),esquinasuperiorizquierda.getX(),lado);
    }
    
}
