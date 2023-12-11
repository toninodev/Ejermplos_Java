package validable;

import java.util.Scanner;


public class Util {
    public static String entradaValidada(String title,Validable validator,char cancel) throws CancelException {
        Scanner scn=new Scanner(System.in);
        String str;
        boolean valid;
        
        do {
            System.out.print(title+" (* para cancelar): ");
            str=scn.nextLine();
            if (str.equals(Character.toString(cancel))) throw new CancelException();
            valid=validator.isValid(str);
            if (!valid) System.out.println("Entrada non válida");
        } while(!valid);
        return str;
    }
    
    // Versión "compacta"
    //
    public static Semana getSemana(String title) throws CancelException {
        // Non é necesario capturar o erro IllegalArgumentException, entre outras cousas porque a entrada non admite
        // valores erroneos
        return Semana.valueOf(entradaValidada("Dia da Semana",new Validable() {
            @Override
            public boolean isValid(String str) {
                for(Semana s: Semana.values()) {
                    if (str.equalsIgnoreCase(s.toString())) return true;
                }
                return false;
            }
        },'*').toUpperCase());
    }
    
    /* Versión máis "explicada"
    
        public static Semana getSemana(String title) throws CancelException {
            // Creamos o obxecto Validable que necesitamos cunha clase anónima
            Validable v=new Validable() {
                // Sobrepoñemos este método de Validable para que se comporte como queremos
                @Override
                public boolean isValid(String str) {
                    for(Semana s: Semana.values()) {
                        if (str.equalsIgnoreCase(s.toString())) return true;
                    }
                    return false;
                }
            };
            // Retornamos o obxecto Semana a partir do String en maiúsculas
            return Semana.valueOf(entradaValidada("Dia da Semana",v,'*').toUpperCase());
        }
    */
}
