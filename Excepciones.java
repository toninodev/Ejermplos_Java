/*
 *  Unha Excepcion e unha sinal (un obxecto) que se envia para notificar "algo"
    Java ten 2 tipos de excepcions:
        - Vixiadas ó(checked)
        - Non Vixiadas (unchecked)

    As Exception constituen un sistema de xestion de errores. Tradicionalmente un metodo
    indicaba mediante un valor de retorno si o traballo se fixo correctamente ou si set tivo algun
    problema. Esto ten varios problemas:
        1.- Si o metodo produce resultados que non se distinguen do codigo de error non podemos 
           saber si e un resultado ou e un error.
        2.- Non permite indicar erros nun construtor.
        3.- E incomodo de xestionar y moitas veces o programador non comproba o resultado para ver
         si existe un erro ou non.
 
    Xestionando os erros mediante Excepcions, cando se da unha condicion de erro nos limitamos a "lanzar"
    un obxecto (Exception) que describe a situación.Si a excepcion e vixiada temos a obriga de:
        1.- "Capturar" ese obxecto con un "catch" en algun punto.
OU
        2.-  Indicar na cabeceira do metodo, que o metodo e posible que lance un obxecto Exception
*/
package excepciones;

import java.util.Scanner;


/*class DezException extends Exception {

    DezException(String msg) {
        super(msg);
    }
}*/

class ParException extends Exception {
    @Override
    public String getMessage() {
        return "Non e par";
    }
} 

public class Excepciones {
    private static Scanner scn=new Scanner(System.in);
    
    static Exception error=new Exception() {
            @Override
            public String getMessage() {
                return "Non pode ser 10, dende clase anonima";
            }
    };
    
    
    private static int test1() throws Exception   {
        int veces;
        
        System.out.print("Introduce un numero par:");
        int n=Integer.parseInt(scn.nextLine());
        if (n%2!=0) throw new ParException();
        if (n==10) throw error;
            System.out.println("Calculo correcto: Retornando valor");
        if (n==16) throw error;
        
        
       
        return n;              
    }
    
    
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args)  {
        boolean epar=false;
        try {
        do {
            try {
                // TODO code application logic here
                Excepciones.test1();
                epar=true;
            } catch (NumberFormatException ex) {
                System.out.println("Debes escribir un numero");

            } catch (ParException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Intentao de novo");
            }
            } while(!epar);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
