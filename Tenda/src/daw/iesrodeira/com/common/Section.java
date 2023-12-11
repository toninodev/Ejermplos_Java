package daw.iesrodeira.com.common;

/**
 *  
 * @author xavi
 */
public enum Section {
    TEXTIL("Productos Textiles"), 
    PERFUMERIA("Productos de Perfumeria"),
    FARMACIA("Productos de Farmacia"), INFORMATICA(""), TECNOLOXIA(""), LIBRERIA(""), PAPELERIA(""), COCINA(""), ELECTRODOMÉSTICOS(""), ALIMENTACION("");
    
    public float discount;
    public float tax;
    public float profit;
    public boolean onsale;
    public final String description;
  
    Section(String description) {
        this.description=description;
        this.onsale=false;
        this.profit=0.1f;
        this.tax=0.21f;
        this.discount=0;
    }
}