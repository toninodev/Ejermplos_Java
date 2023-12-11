/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clasesinternaseestaticas;

import java.util.Scanner;

/**
 *
 * @author xavi
 */
public class ClasesInternasEstaticas {
    static private String atributoEstaticoPrivado;
    private String atributoPrivado;
    
    class InternalClass {
        InternalClass() {
            atributoPrivado="CLASE INTERNA: Modificado por un obxecto de tipo InternalClass";
            atributoEstaticoPrivado="CLASE INTERNA: Este atributo existe a nivel de clase. A s�a modificaci�n � global";
        }
        
        public void show() {
            System.out.println(atributoPrivado);
            System.out.println(atributoEstaticoPrivado);
        }
    }
    
    static class StaticInternalClass {
        StaticInternalClass() {
            // Isto � un erro, porque ao ser a clase est�tica o atributo atributoPrivado non existe. So existe en cada un dos obxectos
            // que se instancien
            //atributoPrivado="CLASE INTERNA: Modificado por un obxecto de tipo StaticInternalClass";
            atributoEstaticoPrivado="CLASE INTERNA ESTATICA: Este atributo existe a nivel de clase. A s�a modificaci�n � global";
        }
        
        public void show() {
            // Isto non se pode facer, xa que atributoPrivado non � est�tico e non estamos en ning�n obxecto
            // System.out.println(atributoPrivado);
            System.out.println(atributoEstaticoPrivado);
        }
    }
    
    public InternalClass getInternalClassObject() {
        return new InternalClass();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Probando clase interna static");
        // ERRO: Como InternalClass non � est�tica, so se pode instanciar dende un obxecto da clase ClasesInternasEstaticas
        //InternalClass ic=new InternalClass();
        StaticInternalClass sic=new StaticInternalClass();
        sic.show();
        System.out.println("\nProbando clase interna non static");
        ClasesInternasEstaticas cis=new ClasesInternasEstaticas();
        // IMPORTANTE: Fixarse como o operador new est� precedido polo obxecto para o que se vai a crear o obxecto.
        InternalClass ic=cis.new InternalClass();   // Creamos un obxecto InternalClass que est� DENTRO do obxecto cis
        ic.show();
        
        ic=cis.getInternalClassObject();
        ic.show();
        
        System.out.println("Probando clase an�nima");
        String name=Input.getString("Elixe entre Manuel e Mar�a", new Filter() {
            @Override
            public boolean isValid(Object obj) {
                String name=(String)obj;
                return name.toUpperCase().equals("MANUEL") || name.toUpperCase().equals("MARIA");
            }
            
        });
        System.out.println("Elexido: "+name);
    }
    
}

    
    class Filter {
        // M�todo que me indica si o obxecto recibido como par�metro � v�lido ou non
        public boolean isValid(Object obj) {
            throw new UnsupportedOperationException("Not implemented. Must be subclassed");
        }
    }
    
    class Input {
      public static String getString(String title,Filter filter) {
         Scanner scn=new Scanner(System.in);
         String str;
         do {
             System.out.print(title+": ");
             str=scn.nextLine();
         } while(!filter.isValid(str));
         return str;
      }
   }
    
