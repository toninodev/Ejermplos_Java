package utilities.validators;

import utilities.Validator;

public class RegexValidator extends Validator {
    private final String regex;
    private String errmsg="%s non é unha entrada válida";
    
    public RegexValidator(String text,String regex) {
        super(text);
        this.regex=regex;
    }
    
    public RegexValidator(String text,String regex,String msg) {
        this(text,regex);
        this.errmsg=msg;
    }
    
    @Override
    public boolean isValid() {
        if (object==null) throw new IllegalArgumentException("Non temos obxecto para validar");
        
        message="Ok";
        String str=(String) object;
        boolean result=str.matches(regex);
        if (!result) message=String.format(errmsg,str);
        return result;
    }
}
