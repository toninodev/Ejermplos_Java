/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.iesrodeira.com.stockage;

import daw.iesrodeira.com.common.Article;
import daw.iesrodeira.com.common.EANException;
import static daw.iesrodeira.com.common.Section.COCINA;

public class CoffeeMaker extends Article {
    private static boolean ONSALE=false;
    private static Float DISCOUNT=null;
    private static Float PROFIT_MARGIN=null;
    private static Float TAX=null;  // IVE a aplicar a todos os CoffeeMaker

    public CoffeeMaker(String code, String ean_code, String brand, String model) throws EANException {
        super(code, ean_code, brand, model);
        this.section=COCINA;
    }
    
    public double getPVP() {
        return applyDiscounts(CoffeeMaker.ONSALE,CoffeeMaker.PROFIT_MARGIN,CoffeeMaker.DISCOUNT,CoffeeMaker.TAX);
    }

    /*public double applyDiscounts(boolean onsale,Float profit,Float discount,Float tax) {
        boolean keep_onsale=this.onsale;
        Float keep_margin=this.profit_margin;
        Float keep_discount=this.discount;
        double pvp;
        
        if (!this.onsale) this.onsale=onsale;
        if (this.profit_margin==null) this.profit_margin=profit;
        if (this.discount==null) this.discount=discount;
        if (tax!=null)  {
            double raw_amount=super.applyDiscounts();
            pvp=raw_amount+raw_amount*tax;
        } else pvp=super.getPVP();
        this.onsale=keep_onsale;
        this.profit_margin=keep_margin;
        this.discount=keep_discount;
        return pvp;
    }*/
    
}
