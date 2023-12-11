package daw.iesrodeira.com.common;


public class Article extends Product {
    private int articleCounter=0;
    
    protected int id;
    
    protected Section section;
    protected Provider provider;
    protected double price;             // Prezo de compra ao provedor
    protected Float profit_margin;      // Porcentaxe de beneficio a obter pola venta do artigo
    protected Float discount;           // Porcentaxe de desconto do artigo
    protected boolean onsale;           // Artigo en promoción     
    
    public Article(String code, String ean_code, String brand, String model) throws EANException {
        super(code,ean_code,brand,model);
        id=articleCounter+1;
        articleCounter++;
    }
    
    public Article(int id, String code, String ean_code, String brand, String model) throws EANException {
        super(code,ean_code,brand,model);
       
        articleCounter=id;
    }
    
    /**
     * Para non repetir código nas subclases de xeito innecesario
     */
    protected double applyDiscounts(boolean onsale,Float profit,Float discount,Float tax) {
        boolean keep_onsale=this.onsale;
        Float keep_margin=this.profit_margin;
        Float keep_discount=this.discount;
        double pvp;
        
        if (!this.onsale) this.onsale=onsale;
        if (this.profit_margin==null) this.profit_margin=profit;
        if (this.discount==null) this.discount=discount;
        pvp=applyDiscounts();
        if (tax!=null) pvp=pvp+pvp*tax;
        else           pvp=pvp+pvp*section.tax;
 
        this.onsale=keep_onsale;
        this.profit_margin=keep_margin;
        this.discount=keep_discount;
        return pvp;
    }
    
   
     private double applyDiscounts() {
        double total=price;             // Inicialmente e o precio ao que se mercou ao provedor
        double r_discount=discount;     // Desconto a aplicar
        double r_margin=profit_margin;  // Marxe de beneficio
        
        if (section.onsale || onsale) {     // O producto está en liquidación si está a sección ou o article
            total=price+(price*0.01);
        } else {
            if (discount==null) {           // Si non ten desconto propio, aplicamos o desconto indicado na sección
               r_discount=section.discount; 
            }
            if (profit_margin==null) {      // Si non ten establecido un marxe, aplicamos o marxe indicado na sección
                r_margin=section.profit;
            }
            total=price-(price*r_discount)+(price*r_margin);
        }
        return total;
    }
    
    public double getPVP() {
        return applyDiscounts(onsale,profit_margin,discount,null);
    }
}