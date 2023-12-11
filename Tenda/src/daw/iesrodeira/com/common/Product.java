package daw.iesrodeira.com.common;

/**
 * ATENCION: Un mellor deseño sería que en lugar de facer que os Article sexan Product, utilizar
 * composición e facer que os Product tean Articles no almacen. Deste xeito a clase Product
 * tería un atributo Article[] articles; 
 * 
 * @author xavi
 */
public class Product {
    protected final String code;            // Código do fabricante
    protected final String ean_code;        // Num EAN do codigo de barras
    protected final String brand;           // Marca
    protected final String model;           // Modelo
    protected String photo;                 // Foto
    protected String description;           // Descrición do producto

    public Product(String code, String ean_code, String brand, String model) throws EANException {
        Validator v=new EANValidator();
        if (!v.isValid(ean_code)) throw new EANException("O codigo EAN do produto non e correcto");
        this.code = code;
        this.ean_code = ean_code;
        this.brand = brand;
        this.model = model;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getEan_code() {
        return ean_code;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getPhoto() {
        return photo;
    }

    public String getDescription() {
        return description;
    }
    
    
    
}
