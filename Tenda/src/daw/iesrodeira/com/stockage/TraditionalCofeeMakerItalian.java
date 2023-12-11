package daw.iesrodeira.com.stockage;

import daw.iesrodeira.com.common.EANException;


public class TraditionalCofeeMakerItalian extends TraditionalCoffeeMaker {
    private boolean inductionCap;   // True si a cafetera é apta para inducción

    public TraditionalCofeeMakerItalian(String code, String ean_code, String brand, String model,boolean induction,int capacity) throws EANException {
        super(code, ean_code, brand, model,"ITALIANA",capacity);
        this.inductionCap=induction;
    }
    
    
    
}
