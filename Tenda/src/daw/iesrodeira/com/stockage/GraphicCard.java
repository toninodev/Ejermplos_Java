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
public class GraphicCard extends Article {
    private static Float PROFIT_MARGIN;
    private static Float DISCOUNT;
    private static boolean ONSALE;
    
    private ColdType coldtype;
    private int ram;
    private String conection;
    private String[] outputs;
    
    public GraphicCard(String code, String ean_code, String brand, String model) throws EANException {
        super(code, ean_code, brand, model);
    }


    public static Float getPROFIT_MARGIN() {
        return PROFIT_MARGIN;
    }

    public static void setPROFIT_MARGIN(Float PROFIT_MARGIN) {
        GraphicCard.PROFIT_MARGIN = PROFIT_MARGIN;
    }

    public static Float getDISCOUNT() {
        return DISCOUNT;
    }

    public static void setDISCOUNT(Float DISCOUNT) {
        GraphicCard.DISCOUNT = DISCOUNT;
    }

    public static boolean isONSALE() {
        return ONSALE;
    }

    public static void setONSALE(boolean ONSALE) {
        GraphicCard.ONSALE = ONSALE;
    }

    public ColdType getColdtype() {
        return coldtype;
    }

    public void setColdtype(ColdType coldtype) {
        this.coldtype = coldtype;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getConection() {
        return conection;
    }

    public void setConection(String conection) {
        this.conection = conection;
    }

    public String[] getOutputs() {
        return outputs;
    }

    public void setOutputs(String[] outputs) {
        this.outputs = outputs;
    }
    
    
}
