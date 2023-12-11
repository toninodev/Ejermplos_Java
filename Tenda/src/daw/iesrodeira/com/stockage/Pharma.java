/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.iesrodeira.com.stockage;

import daw.iesrodeira.com.common.Article;
import daw.iesrodeira.com.common.EANException;
import daw.iesrodeira.com.common.Section;

/**
 *
 * @author xavi
 */
public class Pharma extends Article {
    private static Float PROFIT_MARGIN;
    private static Float DISCOUNT;
    private static boolean ONSALE;
    
    private String composicion;
    private String modoempleo;
    private String principioactivo;
    private String[] indicaciones;
    private String prospecto;
    
    
    public Pharma(String code, String ean_code, String brand, String model) throws EANException {
        super(code, ean_code, brand, model);
        section=Section.FARMACIA;
    }
    
    public static Float getPROFIT_MARGIN() {
        return PROFIT_MARGIN;
    }

    public static void setPROFIT_MARGIN(Float PROFIT_MARGIN) {
        Pharma.PROFIT_MARGIN = PROFIT_MARGIN;
    }

    public static Float getDISCOUNT() {
        return DISCOUNT;
    }

    public static void setDISCOUNT(Float DISCOUNT) {
        Pharma.DISCOUNT = DISCOUNT;
    }

    public static boolean isONSALE() {
        return ONSALE;
    }

    public static void setONSALE(boolean ONSALE) {
        Pharma.ONSALE = ONSALE;
    }

    public String getComposicion() {
        return composicion;
    }

    public void setComposicion(String composicion) {
        this.composicion = composicion;
    }

    public String getModoempleo() {
        return modoempleo;
    }

    public void setModoempleo(String modoempleo) {
        this.modoempleo = modoempleo;
    }

    public String getPrincipioactivo() {
        return principioactivo;
    }

    public void setPrincipioactivo(String principioactivo) {
        this.principioactivo = principioactivo;
    }

    public String[] getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String[] indicaciones) {
        this.indicaciones = indicaciones;
    }

    public String getProspecto() {
        return prospecto;
    }

    public void setProspecto(String prospecto) {
        this.prospecto = prospecto;
    }

    public double getPVP() {
        boolean keep_onsale=this.onsale;
        Float keep_margin=this.profit_margin;
        Float keep_discount=this.discount;
        
        if (!this.onsale) this.onsale=Pharma.ONSALE;
        if (this.profit_margin==null) this.profit_margin=Pharma.PROFIT_MARGIN;
        if (this.discount==null) this.discount=Pharma.DISCOUNT;
        double pvp=super.getPVP();
        this.onsale=keep_onsale;
        this.profit_margin=keep_margin;
        this.discount=keep_discount;
        return pvp;
    }
}
