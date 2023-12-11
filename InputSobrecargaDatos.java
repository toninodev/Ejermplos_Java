package utilities;

import errors.CancelException;
import java.util.Scanner;

/** Comentarios cortesía de ChatGPT
 * 
 A clase Input proporciona métodos para facilitar a entrada de datos desde a consola nun programa Java. 
 Estes métodos permiten ao usuario introducir cadeas de texto, datas, números enteiros, números decimais e confirmar accións. 
  
 A continuación, unha descrición detallada dos métodos principais:

* Método getString(String title, String defvalue)
    Descrición: Este método solicita ao usuario que introduza unha cadea de texto desde a consola. Tamén permite un valor predeterminado, que se usará se o usuario non insire nada.
    Parámetros:
        title: O texto que se mostra ao usuario para indicar qué tipo de entrada se espera.
        defvalue: O valor predeterminado que se usará se o usuario non inserir nada (pode ser nulo).
        Saída: A cadea de texto inserida polo usuario ou o valor predeterminado se nada for inserido.
        Excepcións: Lanza unha excepción se o usuario inserir '*' para cancelar a operación.
* Métodos para entrada de datas (getData)
    Descrición: Estes métodos solicitan ao usuario que introduza unha data e devolven a data inserida como un obxecto Data.
    Parámetros:
        title: O texto que se mostra ao usuario para indicar que se espera unha data.
        defValue: O valor predeterminado que se usará se o usuario non insire nada (pode ser nulo).
        min: A data mínima permitida (pode ser nulo para non ter límite mínimo).
        max: A data máxima permitida (pode ser nulo para non ter límite máximo).
        Saída: A data inserida polo usuario como un obxecto Data.
        Excepcións: Lanza unha excepción se o usuario inserir '*' para cancelar a operación.
        
* Métodos para entrada de números enteiros (getInteger)
    Descrición: Estes métodos solicitan ao usuario que introduza un número enteiro e devolven o número inserido como un obxecto Integer.
    Parámetros:
        title: O texto que se mostra ao usuario para indicar que se espera un número enteiro.
        defValue: O valor predeterminado que se usará se o usuario non insire nada (pode ser nulo).
        min: O valor mínimo permitido (pode ser nulo para non ter límite mínimo).
        max: O valor máximo permitido (pode ser nulo para non ter límite máximo).
        Saída: O número enteiro inserido polo usuario como un obxecto Integer.
        Excepcións: Lanza unha excepción se o usuario inserir '*' para cancelar a operación.
        
* Métodos para entrada de números decimais (getDouble)
    Descrición: Estes métodos solicitan ao usuario que introduza un número decimal e devolven o número inserido como un valor de punto flotante (double).
    Parámetros:
        title: O texto que se mostra ao usuario para indicar que se espera un número decimal.
        defValue: O valor predeterminado que se usará se o usuario non insire nada (pode ser nulo).
        min: O valor mínimo permitido (pode ser nulo para non ter límite mínimo).
        max: O valor máximo permitido (pode ser nulo para non ter límite máximo).
        Saída: O número decimal inserido polo usuario como un valor de punto flotante (double).
        Excepcións: Lanza unha excepción se o usuario inserir '*' para cancelar a operación.
        
* Método confirma(String msg)
    Descrición: Este método solicita ao usuario confirmar unha acción e devolve un valor booleano indicando a resposta.
    Parámetros:
        msg: O mensaxe que se mostra ao usuario para solicitar a confirmación.
        Saída: True se o usuario confirma (responde "Si"), False se o usuario nega (responde "Non").
        Excepcións: Lanza unha excepción se o usuario inserir '*' para cancelar a operación.
        
A clase Input facilita a interacción do usuario co programa a través da consola, permitindo unha entrada de datos controlada e
ofrecendo opcións predeterminadas para unha experiencia de usuario máis cómoda.

*/
public class Input {
    
    //  ################    Entrada de String
    
    /**
     * Obtén unha cadea de texto da entrada do usuario.
     * 
     * @param title     O texto que se mostrará ao usuario para indicar que tipo de entrada se espera.
     * @param defvalue  O valor predeterminado que se utilizará se o usuario non inserir nada (pode ser nulo).
     * @return          A cadea de texto inserida polo usuario ou o valor predeterminado se nada for inserido.
     * @throws CancelException Se o usuario inserir '*' para cancelar a operación.
     */
    public static String getString(String title, String defvalue) throws CancelException {
        // Crea un Scanner para ler a entrada do usuario.
        Scanner scn = new Scanner(System.in);

        // Se defvalue non for nulo, engádeo ao título entre corchetes.
        if (defvalue != null) {
            title += " [" + defvalue + "] ";
        }

        // Amosa o título e indica que '*' pode ser inserido para cancelar a operación.
        System.out.print(title + " (* para cancelar): ");

        // Lee a liña inserida polo usuario.
        String line = scn.nextLine();

        // Comproba se o usuario inseriu '*' para cancelar a operación.
        if (line.equals("*")) {
            throw new CancelException();
        }

        // Se a liña está baleira e defvalue non for nulo, utiliza o valor predeterminado.
        if (line.length() == 0 && defvalue != null) {
            line = defvalue;
        }

        // Retorna a cadea inserida polo usuario ou o valor predeterminado.
        return line;
    }

    
    // Métodos para facer a entrada máis cómoda
    
    /**
     * Solicita a entrada dun String visualizando un título
     * @param title Título a amosar
     * @return String introducido
     * @throws CancelException Si o usuario desexa cancelar a entrada de datos
     */
    public static String getString(String title) throws CancelException {
        return getString(title,null);
    }
    
    
    /**
     * Este método solicita ao usuario que introduza unha cadea de texto desde a consola realizando unha validación. 
     * Tamén permite un valor predeterminado, que se usará se o usuario non insire nada.
     * A entrada se reintenta mentres non sexa válida ou non se cancele a operación
    Parámetros:
     * @param title  Letreiro a amosar antes de esperar pola entrada
     * @param defValue  Valor por defecto que se retorna si o usuario simplemente preme Enter
     * @param v Obxecto Validator encargado de decidir si a entrada realizada se considera válida
     * @return O String introducido
     * @throws CancelException Si o usuario decide cancelar a entrada
     */
    public static String getString(String title,String defValue,Validator v) throws CancelException {
        String str=null;
        boolean ok=false;
        do {
            str=getString(title,defValue);
            ok=v.isValid(str);
            if (!ok) System.out.println(v.getMessage());
        } while(!ok);
        return str;
    }
    
    
    //  ################    Entrada de Datas
    
    /**
    * Solicita ao usuario inserir unha data e devolve a data inserida como un obxecto Data.
    * 
    * @param title     O texto que se mostrará ao usuario para indicar que se espera unha data.
    * @param defValue  O valor predeterminado que se utilizará se o usuario non inserir nada (pode ser nulo).
    * @param min       A data mínima permitida (pode ser nulo para non ter límite mínimo).
    * @param max       A data máxima permitida (pode ser nulo para non ter límite máximo).
    * @return          A data inserida polo usuario como un obxecto Data.
    * @throws CancelException Se ocorre un erro durante o proceso.
    */
   public static Data getData(String title, Data defValue, Data min, Data max) throws CancelException {
       boolean ok = false;
       Data data = null;
       String oldvalue = null;

       // Se defValue non for nulo, obtemos a súa representación en cadea.
       if (defValue != null) {
           oldvalue = defValue.toString();
       }

       do {
           // Pedimos ao usuario que insira unha data como unha cadea de texto.
           String line = getString(title, oldvalue);

           // Validamos a data representada pola cadea de texto.
           try {
               data = new Data(line);
               if (min != null && data.eAntes(min)) {
                   System.out.println("A data debe ser maior ou igual a " + min);
               } else if (max != null && data.eDespois(max)) {
                   System.out.println("A data debe ser anterior ou igual a " + max);
               } else {
                   ok = true;
               }
           } catch (IllegalArgumentException e) {
               System.out.println(e.getMessage());
           }
       } while (!ok);

       return data;    
   }

    
    // Métodos para facer a entrada máis cómoda
    

    public static Data getData(String title) throws CancelException {
        return getData(title,null,null,null);
    }

    public static Data getData(String title,Data defValue) throws CancelException {
        return getData(title,defValue,null,null);
    }


    public static Data getData(String title,Data min,Data max) throws CancelException {
        return getData(title,null,min,max);
    }
    
    //  ################    Entrada de Enteiros    
    
    /**
     * Solicita ao usuario inserir un número enteiro e devolve o número inserido como un obxecto Integer.
     * 
     * @param title     O texto que se mostrará ao usuario para indicar que se espera un número enteiro.
     * @param defValue  O valor predeterminado que se utilizará se o usuario non inserir nada (pode ser nulo).
     * @param min       O valor mínimo permitido (pode ser nulo para non ter límite mínimo).
     * @param max       O valor máximo permitido (pode ser nulo para non ter límite máximo).
     * @return          O número enteiro inserido polo usuario como un obxecto Integer.
     * @throws CancelException Se ocorre un erro durante o proceso.
     */
    public static int getInteger(String title, Integer defValue, Integer min, Integer max) throws CancelException {
        boolean ok = false;
        Integer number = null;
        String oldvalue = null;

        // Se defValue non for nulo, obtemos a súa representación en cadea.
        if (defValue != null) {
            oldvalue = Integer.toString(defValue);
        }

        do {
            // Pedimos ao usuario que insira un número enteiro como unha cadea de texto.
            String line = getString(title, oldvalue);

            // Validamos o número Integer representado pola cadea de texto.
            try {
                number = Integer.valueOf(line);
                if (min != null && number < min) {
                    System.out.println("O número debe ser maior ou igual a " + min);
                } else if (max != null && number > max) {
                    System.out.println("O número debe ser menor ou igual a " + max);
                } else {
                    ok = true;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!ok);

        return number;
    }

    
    // Métodos para facer a entrada máis cómoda
    
    public static int getInteger(String title) throws CancelException {
        return getInteger(title,null,null,null);
    }

    public static int getInteger(String title,Integer defValue) throws CancelException {
        return getInteger(title,defValue,null,null);
    }
    
    public static int getInteger(String title,Integer min,Integer max) throws CancelException {
       return getInteger(title,null,min,max);
    }
    
    //  ################    Entrada de Decimais

   
    /**
     * Solicita ao usuario inserir un número decimal e devolve o número inserido como un valor de punto flotante (double).
     * 
     * @param title     O texto que se mostrará ao usuario para indicar que se espera un número decimal.
     * @param defValue  O valor predeterminado que se utilizará se o usuario non inserir nada (pode ser nulo).
     * @param min       O valor mínimo permitido (pode ser nulo para non ter límite mínimo).
     * @param max       O valor máximo permitido (pode ser nulo para non ter límite máximo).
     * @return          O número decimal inserido polo usuario como un valor de punto flotante (double).
     * @throws CancelException Se ocorre un erro durante o proceso.
     */
    public static double getDouble(String title, Double defValue, Double min, Double max) throws CancelException {
        Double number = null;
        boolean ok = false;
        String oldvalue = null;

        // Se defValue non for nulo, obtemos a súa representación en cadea.
        if (defValue != null) {
            oldvalue = Double.toString(defValue);
        }

        do {
            // Pedimos ao usuario que insira un número decimal como unha cadea de texto.
            String line = getString(title, oldvalue);

            // Validamos o número Double representado pola cadea de texto.
            try {
                number = Double.valueOf(line);
                if (min != null && number < min) {
                    System.out.println("O número debe ser maior ou igual a " + min);
                } else if (max != null && number > max) {
                    System.out.println("O número debe ser menor ou igual a " + max);
                } else {
                    ok = true;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!ok);

        return number;
    }

    
    // Métodos para facer a entrada máis cómoda
            
    public static double getDouble(String title) throws CancelException {
        return getDouble(title,null,null,null);
    }
    
    public static double getDouble(String title,Double defValue) throws CancelException {
        return getDouble(title,defValue,null,null);
    }

    public static double getDouble(String title,double min,double max) throws CancelException {
        return getDouble(title,null,min,max);
    }
    
    //  ################    Entrada de Booleanos (si/non)
    
    
    /**
     * Solicita ao usuario confirmar unha acción e devolve un valor booleano indicando a resposta.
     * 
     * @param msg       O mensaxe que se mostrará ao usuario para solicitar a confirmación.
     * @return          True se o usuario confirma (responde "Si"), False se o usuario nega (responde "Non").
     * @throws CancelException Se ocorre un erro durante o proceso.
     */
    public static boolean confirma(String msg) throws CancelException {
        String line;
        boolean ok;

        do {
            // Pedimos ao usuario que confirme a acción.
            line = getString(msg + " (Si/Non)").toUpperCase();

            // Verificamos se a resposta é válida (Si ou Non).
            ok = line.equals("SI") || line.equals("NON");

            // Se a resposta non é válida, mostramos un mensaxe de erro.
            if (!ok) {
                System.out.println("Debes contestar Si ou Non");
            }
        } while (!ok);

        // Devolvemos true se o usuario respondeu "Si", e false se respondeu "Non".
        return line.equals("SI");
    }

}
