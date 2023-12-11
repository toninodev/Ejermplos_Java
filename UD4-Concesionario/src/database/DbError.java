package database;

public enum DbError {
    NOTEXISTS("O elemento %s non Existe"), DUPLICATE("O elemento %s xa existe"),
    ERRDELETE("Fallo borrando elemento %s"), ERRUPDATE("Fallo actualizando o elemnento %s"),
    ERRINSERT("Fallo engadindo o novo elmemento %s"); 
    
    private final String errmsg;   
        
    private DbError(String msg) {
        errmsg=msg;
    }
        
    public String getMessage() {
        return errmsg;
    } 
}
