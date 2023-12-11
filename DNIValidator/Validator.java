package utilities;


public class Validator {
    protected String message="";  // Protected para facilitar a herdanza
    protected Object object;
    
    public Validator(Object obj) {
        object=obj;
    }
    
    public boolean isValid() {
        throw new UnsupportedOperationException("O Validator non esta definido. Debes crear unha subclase");
    }
    
    public boolean isValid(Object obj) {
        this.object=obj;
        return isValid();
    }
    
    public String getMessage() {
        return this.message;
    }
}
