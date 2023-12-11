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
class Monitor extends Article {
    private static Float PROFIT_MARGIN;
    private static Float DISCOUNT;
    private static boolean ONSALE;
    
    private ScreenType screentype;
    private int size;
    private int width;
    private int height;
    
    
    public Monitor(String code, String ean_code, String brand, String model) throws EANException {
        super(code, ean_code, brand, model);
        section=INFORMATICA;
    }
    
    
    public static Float getPROFIT_MARGIN() {
        return PROFIT_MARGIN;
    }

    public static void setPROFIT_MARGIN(Float PROFIT_MARGIN) {
        Monitor.PROFIT_MARGIN = PROFIT_MARGIN;
    }

    public static Float getDISCOUNT() {
        return DISCOUNT;
    }

    public static void setDISCOUNT(Float DISCOUNT) {
        Monitor.DISCOUNT = DISCOUNT;
    }

    public static boolean isONSALE() {
        return ONSALE;
    }

    public static void setONSALE(boolean ONSALE) {
        Monitor.ONSALE = ONSALE;
    }


    public ScreenType getScreentype() {
        return screentype;
    }

    public void setScreentype(ScreenType screentype) {
        this.screentype = screentype;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
