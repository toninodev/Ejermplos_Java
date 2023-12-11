package utilities.validators;

public class EmailValidator extends RegexValidator {
        
    public EmailValidator(String mail) {
        /** Cortesía de chatGPT.
         [a-zA-Z0-9_.+-]+: El nombre de usuario puede contener letras, números, puntos, guiones bajos, más y guiones.
         @: Debe haber un símbolo de arroba después del nombre de usuario.
         [a-zA-Z0-9-]+: El nombre del dominio puede contener letras, números y guiones.
         \\.: Después debe haber un punto literal (necesitamos escapar el punto con \\ porque el punto es un carácter especial en expresiones regulares).
         [a-zA-Z0-9-.]+$: El dominio de nivel superior (TLD) puede contener letras, números, guiones y puntos, y debe ser el final de la cadena.
        */
        super(mail,"^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$","A cadea %s non é un e-mail válido");
    }
}
