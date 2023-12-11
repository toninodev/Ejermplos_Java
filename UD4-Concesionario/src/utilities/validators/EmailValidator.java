package utilities.validators;

public class EmailValidator extends RegexValidator {
    public EmailValidator() {
        super("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");
        setErrmsg("A cadea %s non � un e-mail v�lido");
    }
        
    public EmailValidator(String mail) {
        /** Cortes�a de chatGPT.
         [a-zA-Z0-9_.+-]+: El nombre de usuario puede contener letras, n�meros, puntos, guiones bajos, m�s y guiones.
         @: Debe haber un s�mbolo de arroba despu�s del nombre de usuario.
         [a-zA-Z0-9-]+: El nombre del dominio puede contener letras, n�meros y guiones.
         \\.: Despu�s debe haber un punto literal (necesitamos escapar el punto con \\ porque el punto es un car�cter especial en expresiones regulares).
         [a-zA-Z0-9-.]+$: El dominio de nivel superior (TLD) puede contener letras, n�meros, guiones y puntos, y debe ser el final de la cadena.
        */
        super(mail,"^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$","A cadea %s non � un e-mail v�lido");
    }
}
