
package errors;

/**
 *
 * @author xavi
 */
public class CancelException extends Exception {
    public CancelException() {
        super("Operaci�n Cancelada");
    }
    
    public CancelException(String msg) {
        super(msg);
    }
    
}
