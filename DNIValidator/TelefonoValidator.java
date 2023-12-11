package utilities.validators;

import utilities.Validator;


public class TelefonoValidator extends Validator {
    public TelefonoValidator(String telefono) {
        super(telefono);
    }
    
    @Override
    public boolean isValid() {
        /** Cortes�a de chatGPT.
          ^: Indica el inicio de la cadena.
          \\+: Coincide con el signo de +. Necesitamos escapar el signo de + con \\ porque es un car�cter especial en expresiones regulares.
          (34|0034|34)?: El c�digo de pa�s es opcional y puede ser "34", "+34" o "0034".
          [6789]: El primer d�gito del n�mero debe ser 6, 7, 8 o 9 (los prefijos de los n�meros m�viles en Espa�a).
          \\d{8}: Despu�s del primer d�gito, deben haber exactamente 8 d�gitos adicionales.
          $: Indica el final de la cadena.
         */
        String regex = "^(\\+34|\\+0034)?[6789]\\d{8}$";
        String telefono=(String) object;
        message="Ok";
        boolean result=telefono.matches(regex);
        if (!result) message="O tel�fono "+telefono+" non un tel�fono de Espa�a v�lido";
        return result;
    }
}
