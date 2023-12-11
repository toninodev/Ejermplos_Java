package utilities.validators;

import utilities.Validator;


public class TelefonoValidator extends Validator {
    public TelefonoValidator() {}
    
    public TelefonoValidator(String telefono) {
        super(telefono);
    }
    
    @Override
    public boolean isValid() {
        if (object==null) throw new IllegalArgumentException("Non existe obxecto para validar");
        /** Cortesía de chatGPT.
          ^: Indica el inicio de la cadena.
          \\+: Coincide con el signo de +. Necesitamos escapar el signo de + con \\ porque es un carácter especial en expresiones regulares.
          (34|0034|34)?: El código de país es opcional y puede ser "34", "+34" o "0034".
          [6789]: El primer dígito del número debe ser 6, 7, 8 o 9 (los prefijos de los números móviles en España).
          \\d{8}: Después del primer dígito, deben haber exactamente 8 dígitos adicionales.
          $: Indica el final de la cadena.
         */
        String regex = "^(\\+34|\\+0034)?[6789]\\d{8}$";
        String telefono=(String) object;
        message="Ok";
        boolean result=telefono.matches(regex);
        if (!result) message="O teléfono "+telefono+" non un teléfono de España válido";
        return result;
    }
}
