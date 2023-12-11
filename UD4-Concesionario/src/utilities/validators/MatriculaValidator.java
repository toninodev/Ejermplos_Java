package utilities.validators;

import utilities.Validator;

/**
 *
 * @author xavi
 */
public class MatriculaValidator extends Validator {
    
    public MatriculaValidator() {}
    
    public MatriculaValidator(String matricula) {
        super(matricula);
    }
    
    @Override
    public boolean isValid() {
        if (object==null) throw new IllegalArgumentException("Non existe obxecto para validar");
        /** 
         ^- Inicio de cadea
         [0-9]{4} Catro díxitos
         [A-Z]{1,3} De unha a 3 letras da A a Z
         $ - Fin e cadea
         */
        String regex = "^[0-9}]{4}[A-Z]{1,3}$";
        String matricula=(String) object;
        message="Ok";
        boolean result=matricula.matches(regex);
        if (!result) message="A matrícula "+matricula+" non unha matrícula válida en España";
        return result;
    }
    
}
