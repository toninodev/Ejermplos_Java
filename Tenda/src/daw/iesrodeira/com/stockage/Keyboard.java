package daw.iesrodeira.com.stockage;

import daw.iesrodeira.com.common.Article;
import daw.iesrodeira.com.common.EANException;
import static daw.iesrodeira.com.common.Section.INFORMATICA;

/**
 *
 * @author xavi
 */
public class Keyboard extends Article {
    private static Float PROFIT_MARGIN;
    private static Float DISCOUNT;
    private static boolean ONSALE;
    
    private KeyLayout layout;
    private KeyType type;
    private String language;

    
    public Keyboard(String code, String ean_code, String brand, String model) throws EANException {
        super(code, ean_code, brand, model);
        section=INFORMATICA;
    }

    
    
    public static Float getPROFIT_MARGIN() {
        return PROFIT_MARGIN;
    }

    public static void setPROFIT_MARGIN(Float PROFIT_MARGIN) {
        Keyboard.PROFIT_MARGIN = PROFIT_MARGIN;
    }

    public static Float getDISCOUNT() {
        return DISCOUNT;
    }

    public static void setDISCOUNT(Float DISCOUNT) {
        Keyboard.DISCOUNT = DISCOUNT;
    }

    public static boolean isONSALE() {
        return ONSALE;
    }

    public static void setONSALE(boolean ONSALE) {
        Keyboard.ONSALE = ONSALE;
    }

    public KeyLayout getLayout() {
        return layout;
    }

    public void setLayout(KeyLayout layout) {
        this.layout = layout;
    }

    public KeyType getType() {
        return type;
    }

    public void setType(KeyType type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    
}
