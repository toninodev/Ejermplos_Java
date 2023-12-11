
package errors;

/**
 *
 * @author xavi
 */
public class CancelException extends Exception {
    public CancelException() {
        super("Operación Cancelada");
    }
    
    public CancelException(String msg) {
        super(msg);
    }
    
}
