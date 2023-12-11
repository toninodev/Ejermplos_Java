/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.iesrodeira.com.stockage;

import daw.iesrodeira.com.common.EANException;

/**
 *
 * @author xavi
 */
public class CapExpressCofeeMaker extends ExpressCoffeeMaker {
    private static boolean ONSALE=false;
    private static Float DISCOUNT=null;
    private static Float PROFIT_MARGIN=null;
    
    private CapType captype;

    public CapExpressCofeeMaker(String code, String ean_code, String brand, String model) throws EANException {
        super(code, ean_code, brand, model);
    }
    
    public double getPVP() {
        return applyDiscounts(ONSALE,PROFIT_MARGIN,DISCOUNT,null);
    }
}
