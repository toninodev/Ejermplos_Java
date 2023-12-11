/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.iesrodeira.com.stockage;

import daw.iesrodeira.com.common.Article;
import daw.iesrodeira.com.common.EANException;
import static daw.iesrodeira.com.common.Section.INFORMATICA;

/**
 *
 * @author xavi
 */
class Storage extends Article {
    private static Float PROFIT_MARGIN;
    private static Float DISCOUNT;
    private static boolean ONSALE;
    
    private StorageType type;
    private int capacidad;

    
    
    public Storage(String code, String ean_code, String brand, String model) throws EANException {
        super(code, ean_code, brand, model);
        section=INFORMATICA;
    }
    
    
    public static Float getPROFIT_MARGIN() {
        return PROFIT_MARGIN;
    }

    public static void setPROFIT_MARGIN(Float PROFIT_MARGIN) {
        Storage.PROFIT_MARGIN = PROFIT_MARGIN;
    }

    public static Float getDISCOUNT() {
        return DISCOUNT;
    }

    public static void setDISCOUNT(Float DISCOUNT) {
        Storage.DISCOUNT = DISCOUNT;
    }

    public static boolean isONSALE() {
        return ONSALE;
    }

    public static void setONSALE(boolean ONSALE) {
        Storage.ONSALE = ONSALE;
    }


    public StorageType getType() {
        return type;
    }

    public void setType(StorageType type) {
        this.type = type;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    
}
