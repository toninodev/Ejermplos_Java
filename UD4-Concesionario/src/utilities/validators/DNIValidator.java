package utilities.validators;

import utilities.Validator;

public class DNIValidator extends Validator {
    public DNIValidator(String dni) {
        super(dni);
    }
    
    public DNIValidator() {}
    
    @Override
    public boolean isValid() {
        if (object==null) throw new IllegalArgumentException("Non existe obxecto para validar");
        String regex = "^[a-zA-Z]?[0-9]{7,8}[a-zA-Z]$";
        message="Ok";
        String dni=(String) object;
        boolean result=dni.matches(regex);
        if (!result) message="O DNI/NIE "+dni+" debe ter a forma N9999999X onde N é unha letra para os NIE e un numero para os DNI e X unha letra";
        else         result=validID();
        return result;
    }
    
    public boolean isNif() {
        String dni=(String) object;
        if (validID()) return Character.isDigit(dni.charAt(0));
        return false;
    }

    public boolean isNie() {
        String dni=(String) object;
        if (!validID()) return false;
        char l=dni.charAt(0);
        return (l=='X' || l=='Y' || l=='Z');
    }
     
    // Utilidades
    
    private boolean validID() {
        String letrasNIF="TRWAGMYFPDXBNJZSQVHLCKE";
        if (object==null) {
            message="Non temos ningún DNI/NIE";
            return false;
        }
        String dni=(String) object;
        try {
            char letra=dni.charAt(dni.length()-1);
            char s=dni.charAt(0);
            if (s=='X' || s=='Y' || s=='Z') {
                char l=dni.charAt(0);
                int x=l-'X';
                dni=x+dni.substring(1);
            }
            int num=Integer.parseInt(dni.substring(0,dni.length()-1));
            if (letra==letrasNIF.charAt(num%23)) return true;
            message="A letra do DNI/NIE "+dni+" non corresponde co número";
            return false;
        } catch(IndexOutOfBoundsException | NumberFormatException e) {
            message="O DNI/NIE "+dni+" debe ter a forma N9999999X onde N é unha letra para os NIE e un numero para os DNI e X unha letra";
            return false;
        }
    }
}
