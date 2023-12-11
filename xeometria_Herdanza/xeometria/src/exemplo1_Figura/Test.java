/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo1_Figura;

/**
 *
 * @author xavi
 */
public class Test {
   public static void main(String[] args) {
       Figura f;
       
       try {
           f=new Figura("Indeterminada");
           f.pinta();
           System.out.printf("Area %.4f\n",f.getArea());
           
       } catch(UnsupportedOperationException e) {
           System.out.println(e.getMessage());
       }
       
       try {
           f=new Circunferencia(5,6,120);
           f.pinta();
           System.out.printf("Area %.4f\n",f.getArea());
           
       } catch(UnsupportedOperationException e) {
           System.out.println(e.getMessage());
       }
       
       try {
           f=new Rectangulo(5,6,120,87);
           f.pinta();
           System.out.printf("Area %.4f\n",f.getArea());
           
       } catch(UnsupportedOperationException e) {
           System.out.println(e.getMessage());
       }
       
       try {
           f=new Cadrado(5,6,120);
           f.pinta();
           System.out.printf("Area %.4f\n",f.getArea());
           
       } catch(UnsupportedOperationException e) {
           System.out.println(e.getMessage());
       }
       
   }    
}
