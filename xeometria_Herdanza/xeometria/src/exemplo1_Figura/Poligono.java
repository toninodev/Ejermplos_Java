/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo1_Figura;

/**
 *
 * @author xavi
 */
public class Poligono extends Figura {
    protected Coordenada[]  coord;
    
    public Poligono(String nome,int numvertices) {
        super(nome);
        coord=new Coordenada[numvertices];
    }
    
    public void setVertice(int nv,Coordenada c) {
        try {
            coord[nv]=c;
        } catch(IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("os vértices de "+nome+" van dende 0 a "+(coord.length-1));
        }
    }
            
    public void pinta() {
        int idx;
        
        System.out.println("Pintando "+nome);
        for(idx=0;idx<coord.length-1;idx++) {
            System.out.println("\tTrazando liña dende "+coord[idx]+" a "+coord[idx+1]);
        }
        System.out.println("\tTrazando liña dende "+coord[idx]+" a "+coord[0]);
    }
    
    
    public static void main(String[] args) {
        Poligono p=new Poligono("Pentagono",5);
        p.setVertice(0,new Coordenada(5,3));
        p.setVertice(1,new Coordenada(8,11));
        p.setVertice(2,new Coordenada(21,14));
        p.setVertice(3,new Coordenada(22,31));
        p.setVertice(4,new Coordenada(112,18));
        p.pinta();
    }
}
