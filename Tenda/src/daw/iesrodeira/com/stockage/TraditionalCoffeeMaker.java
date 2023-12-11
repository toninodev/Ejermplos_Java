package daw.iesrodeira.com.stockage;

import daw.iesrodeira.com.common.EANException;

/**
 * 
 * @author xavi
 */
public class TraditionalCoffeeMaker extends CoffeeMaker {
    private static boolean ONSALE=false;
    private static Float DISCOUNT=null;
    private static Float PROFIT_MARGIN=null;
    private static Float TAX=null;  // IVE a aplicar a todos os TraditionalCofeeMaker
    
    String type;    // Non vale a pena un enum. Poñemos "PRESION", "ITALIANA" ou "GOTEO"
    float capacity;

    public TraditionalCoffeeMaker(String code, String ean_code, String brand, String model,String type,float capacity) throws EANException {
        super(code, ean_code, brand, model);
        this.type=type;
        this.capacity=capacity;
    }
    
    
    public double getPVP() {
        return applyDiscounts(ONSALE,PROFIT_MARGIN,DISCOUNT,TAX);
    }
}
