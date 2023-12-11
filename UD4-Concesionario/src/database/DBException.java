
package database;


public class DBException extends Exception {
    private DbError errcode;
    
    public DBException(DbError errcode,String reason) {
        super(reason);
        this.errcode=errcode;
    }
    
    public DBException(DbError errcode) {
        this(errcode,"Unknown");
    }
    
    /**
     * Sobrepoñemos o método getMessage de Exception
     * @return mensaxe de erro
     */
    @Override
    public String getMessage() {
        return errcode.getMessage();
    }
    
    public String getReason() {
        return super.getMessage();
    }
    
}
