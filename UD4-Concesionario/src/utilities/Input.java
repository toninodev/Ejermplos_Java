package utilities;

import errors.CancelException;
import java.util.Scanner;

/** Comentarios cortes�a de ChatGPT
 * 
 A clase Input proporciona m�todos para facilitar a entrada de datos desde a consola nun programa Java. 
 Estes m�todos permiten ao usuario introducir cadeas de texto, datas, n�meros enteiros, n�meros decimais e confirmar acci�ns. 
  
 A continuaci�n, unha descrici�n detallada dos m�todos principais:

* M�todo getString(String title, String defvalue)
    Descrici�n: Este m�todo solicita ao usuario que introduza unha cadea de texto desde a consola. Tam�n permite un valor predeterminado, que se usar� se o usuario non insire nada.
    Par�metros:
        title: O texto que se mostra ao usuario para indicar qu� tipo de entrada se espera.
        defvalue: O valor predeterminado que se usar� se o usuario non inserir nada (pode ser nulo).
        Sa�da: A cadea de texto inserida polo usuario ou o valor predeterminado se nada for inserido.
        Excepci�ns: Lanza unha excepci�n se o usuario inserir '*' para cancelar a operaci�n.
* M�todos para entrada de datas (getData)
    Descrici�n: Estes m�todos solicitan ao usuario que introduza unha data e devolven a data inserida como un obxecto Data.
    Par�metros:
        title: O texto que se mostra ao usuario para indicar que se espera unha data.
        defValue: O valor predeterminado que se usar� se o usuario non insire nada (pode ser nulo).
        min: A data m�nima permitida (pode ser nulo para non ter l�mite m�nimo).
        max: A data m�xima permitida (pode ser nulo para non ter l�mite m�ximo).
        Sa�da: A data inserida polo usuario como un obxecto Data.
        Excepci�ns: Lanza unha excepci�n se o usuario inserir '*' para cancelar a operaci�n.
        
* M�todos para entrada de n�meros enteiros (getInteger)
    Descrici�n: Estes m�todos solicitan ao usuario que introduza un n�mero enteiro e devolven o n�mero inserido como un obxecto Integer.
    Par�metros:
        title: O texto que se mostra ao usuario para indicar que se espera un n�mero enteiro.
        defValue: O valor predeterminado que se usar� se o usuario non insire nada (pode ser nulo).
        min: O valor m�nimo permitido (pode ser nulo para non ter l�mite m�nimo).
        max: O valor m�ximo permitido (pode ser nulo para non ter l�mite m�ximo).
        Sa�da: O n�mero enteiro inserido polo usuario como un obxecto Integer.
        Excepci�ns: Lanza unha excepci�n se o usuario inserir '*' para cancelar a operaci�n.
        
* M�todos para entrada de n�meros decimais (getDouble)
    Descrici�n: Estes m�todos solicitan ao usuario que introduza un n�mero decimal e devolven o n�mero inserido como un valor de punto flotante (double).
    Par�metros:
        title: O texto que se mostra ao usuario para indicar que se espera un n�mero decimal.
        defValue: O valor predeterminado que se usar� se o usuario non insire nada (pode ser nulo).
        min: O valor m�nimo permitido (pode ser nulo para non ter l�mite m�nimo).
        max: O valor m�ximo permitido (pode ser nulo para non ter l�mite m�ximo).
        Sa�da: O n�mero decimal inserido polo usuario como un valor de punto flotante (double).
        Excepci�ns: Lanza unha excepci�n se o usuario inserir '*' para cancelar a operaci�n.
        
* M�todo confirma(String msg)
    Descrici�n: Este m�todo solicita ao usuario confirmar unha acci�n e devolve un valor booleano indicando a resposta.
    Par�metros:
        msg: O mensaxe que se mostra ao usuario para solicitar a confirmaci�n.
        Sa�da: True se o usuario confirma (responde "Si"), False se o usuario nega (responde "Non").
        Excepci�ns: Lanza unha excepci�n se o usuario inserir '*' para cancelar a operaci�n.
        
A clase Input facilita a interacci�n do usuario co programa a trav�s da consola, permitindo unha entrada de datos controlada e
ofrecendo opci�ns predeterminadas para unha experiencia de usuario m�is c�moda.

*/
public class Input {
    
    //  ################    Entrada de String
    
    /**
     * Obt�n unha cadea de texto da entrada do usuario.
     * 
     * @param title     O texto que se mostrar� ao usuario para indicar que tipo de entrada se espera.
     * @param defvalue  O valor predeterminado que se utilizar� se o usuario non inserir nada (pode ser nulo).
     * @return          A cadea de texto inserida polo usuario ou o valor predeterminado se nada for inserido.
     * @throws CancelException Se o usuario inserir '*' para cancelar a operaci�n.
     */
    public static String getString(String title, String defvalue) throws CancelException {
        // Crea un Scanner para ler a entrada do usuario.
        Scanner scn = new Scanner(System.in);

        // Se defvalue non for nulo, eng�deo ao t�tulo entre corchetes.
        if (defvalue != null) {
            title += " [" + defvalue + "] ";
        }

        // Amosa o t�tulo e indica que '*' pode ser inserido para cancelar a operaci�n.
        System.out.print(title + " (* para cancelar): ");

        // Lee a li�a inserida polo usuario.
        String line = scn.nextLine();

        // Comproba se o usuario inseriu '*' para cancelar a operaci�n.
        if (line.equals("*")) {
            throw new CancelException();
        }

        // Se a li�a est� baleira e defvalue non for nulo, utiliza o valor predeterminado.
        if (line.length() == 0 && defvalue != null) {
            line = defvalue;
        }

        // Retorna a cadea inserida polo usuario ou o valor predeterminado.
        return line;
    }

    
    // M�todos para facer a entrada m�is c�moda
    
    /**
     * Solicita a entrada dun String visualizando un t�tulo
     * @param title T�tulo a amosar
     * @return String introducido
     * @throws CancelException Si o usuario desexa cancelar a entrada de datos
     */
    public static String getString(String title) throws CancelException {
        return getString(title,null);
    }
    
    
    /**
     * Este m�todo solicita ao usuario que introduza unha cadea de texto desde a consola realizando unha validaci�n. 
     * Tam�n permite un valor predeterminado, que se usar� se o usuario non insire nada.
     * A entrada se reintenta mentres non sexa v�lida ou non se cancele a operaci�n
    Par�metros:
     * @param title  Letreiro a amosar antes de esperar pola entrada
     * @param defValue  Valor por defecto que se retorna si o usuario simplemente preme Enter
     * @param v Obxecto Validator encargado de decidir si a entrada realizada se considera v�lida
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
    * @param title     O texto que se mostrar� ao usuario para indicar que se espera unha data.
    * @param defValue  O valor predeterminado que se utilizar� se o usuario non inserir nada (pode ser nulo).
    * @param min       A data m�nima permitida (pode ser nulo para non ter l�mite m�nimo).
    * @param max       A data m�xima permitida (pode ser nulo para non ter l�mite m�ximo).
    * @return          A data inserida polo usuario como un obxecto Data.
    * @throws CancelException Se ocorre un erro durante o proceso.
    */
   public static Data getData(String title, Data defValue, Data min, Data max) throws CancelException {
       boolean ok = false;
       Data data = null;
       String oldvalue = null;

       // Se defValue non for nulo, obtemos a s�a representaci�n en cadea.
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

    
    // M�todos para facer a entrada m�is c�moda
    

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
     * Solicita ao usuario inserir un n�mero enteiro e devolve o n�mero inserido como un obxecto Integer.
     * 
     * @param title     O texto que se mostrar� ao usuario para indicar que se espera un n�mero enteiro.
     * @param defValue  O valor predeterminado que se utilizar� se o usuario non inserir nada (pode ser nulo).
     * @param min       O valor m�nimo permitido (pode ser nulo para non ter l�mite m�nimo).
     * @param max       O valor m�ximo permitido (pode ser nulo para non ter l�mite m�ximo).
     * @return          O n�mero enteiro inserido polo usuario como un obxecto Integer.
     * @throws CancelException Se ocorre un erro durante o proceso.
     */
    public static int getInteger(String title, Integer defValue, Integer min, Integer max) throws CancelException {
        boolean ok = false;
        Integer number = null;
        String oldvalue = null;

        // Se defValue non for nulo, obtemos a s�a representaci�n en cadea.
        if (defValue != null) {
            oldvalue = Integer.toString(defValue);
        }

        do {
            // Pedimos ao usuario que insira un n�mero enteiro como unha cadea de texto.
            String line = getString(title, oldvalue);

            // Validamos o n�mero Integer representado pola cadea de texto.
            try {
                number = Integer.valueOf(line);
                if (min != null && number < min) {
                    System.out.println("O n�mero debe ser maior ou igual a " + min);
                } else if (max != null && number > max) {
                    System.out.println("O n�mero debe ser menor ou igual a " + max);
                } else {
                    ok = true;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!ok);

        return number;
    }

    
    // M�todos para facer a entrada m�is c�moda
    
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
     * Solicita ao usuario inserir un n�mero decimal e devolve o n�mero inserido como un valor de punto flotante (double).
     * 
     * @param title     O texto que se mostrar� ao usuario para indicar que se espera un n�mero decimal.
     * @param defValue  O valor predeterminado que se utilizar� se o usuario non inserir nada (pode ser nulo).
     * @param min       O valor m�nimo permitido (pode ser nulo para non ter l�mite m�nimo).
     * @param max       O valor m�ximo permitido (pode ser nulo para non ter l�mite m�ximo).
     * @return          O n�mero decimal inserido polo usuario como un valor de punto flotante (double).
     * @throws CancelException Se ocorre un erro durante o proceso.
     */
    public static double getDouble(String title, Double defValue, Double min, Double max) throws CancelException {
        Double number = null;
        boolean ok = false;
        String oldvalue = null;

        // Se defValue non for nulo, obtemos a s�a representaci�n en cadea.
        if (defValue != null) {
            oldvalue = Double.toString(defValue);
        }

        do {
            // Pedimos ao usuario que insira un n�mero decimal como unha cadea de texto.
            String line = getString(title, oldvalue);

            // Validamos o n�mero Double representado pola cadea de texto.
            try {
                number = Double.valueOf(line);
                if (min != null && number < min) {
                    System.out.println("O n�mero debe ser maior ou igual a " + min);
                } else if (max != null && number > max) {
                    System.out.println("O n�mero debe ser menor ou igual a " + max);
                } else {
                    ok = true;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!ok);

        return number;
    }

    
    // M�todos para facer a entrada m�is c�moda
            
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
     * Solicita ao usuario confirmar unha acci�n e devolve un valor booleano indicando a resposta.
     * 
     * @param msg       O mensaxe que se mostrar� ao usuario para solicitar a confirmaci�n.
     * @return          True se o usuario confirma (responde "Si"), False se o usuario nega (responde "Non").
     * @throws CancelException Se ocorre un erro durante o proceso.
     */
    public static boolean confirma(String msg) throws CancelException {
        String line;
        boolean ok;

        do {
            // Pedimos ao usuario que confirme a acci�n.
            line = getString(msg + " (Si/Non)").toUpperCase();

            // Verificamos se a resposta � v�lida (Si ou Non).
            ok = line.equals("SI") || line.equals("NON");

            // Se a resposta non � v�lida, mostramos un mensaxe de erro.
            if (!ok) {
                System.out.println("Debes contestar Si ou Non");
            }
        } while (!ok);

        // Devolvemos true se o usuario respondeu "Si", e false se respondeu "Non".
        return line.equals("SI");
    }

}
