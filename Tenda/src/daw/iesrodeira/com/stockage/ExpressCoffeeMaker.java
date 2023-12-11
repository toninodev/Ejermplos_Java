/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.iesrodeira.com.stockage;

import daw.iesrodeira.com.common.EANException;

/**
 * ATENCION: Os ExpressCoffeeMaker teñen o mesmo IVE que o xeral dos CofeeMaker ou 
 * o mesmo IVE que a Section a que pertencen si non temos un IVE establecido para os
 * CofeeMaker
 * 
 * @author xavi
 */
public class ExpressCoffeeMaker extends CoffeeMaker {
    private static boolean ONSALE=false;
    private static Float DISCOUNT=null;
    private static Float PROFIT_MARGIN=null;    
    
    private int watts;
    private int pressure;

    public ExpressCoffeeMaker(String code, String ean_code, String brand, String model) throws EANException {
        super(code, ean_code, brand, model);
    }
    
    public double getPVP() {
        return applyDiscounts(ExpressCoffeeMaker.ONSALE,ExpressCoffeeMaker.PROFIT_MARGIN,ExpressCoffeeMaker.DISCOUNT,null);
    }
}
