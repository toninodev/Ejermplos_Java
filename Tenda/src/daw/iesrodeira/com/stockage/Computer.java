package daw.iesrodeira.com.stockage;

import daw.iesrodeira.com.common.Article;
import daw.iesrodeira.com.common.EANException;

public class Computer extends Article {
    private static Float PROFIT_MARGIN;
    private static Float DISCOUNT;
    private static boolean ONSALE; 
    private static Float TAX;       // IVE a aplicar a todos os Computer

    private Storage[] storage;
    private Monitor monitor;
    private Keyboard board;
    private Mouse mouse;
    private GraphicCard graphic;

    private int ram;
    private String cpu;
    private String connections;

    
    public Computer(String code, String ean_code, String brand, String model) throws EANException {
        super(code, ean_code, brand, model);
    }
    
    
    public static Float getPROFIT_MARGIN() {
        return PROFIT_MARGIN;
    }

    public static void setPROFIT_MARGIN(Float PROFIT_MARGIN) {
        Computer.PROFIT_MARGIN = PROFIT_MARGIN;
    }

    public static Float getDISCOUNT() {
        return DISCOUNT;
    }

    public static void setDISCOUNT(Float DISCOUNT) {
        Computer.DISCOUNT = DISCOUNT;
    }

    public static boolean isONSALE() {
        return ONSALE;
    }

    public static void setONSALE(boolean ONSALE) {
        Computer.ONSALE = ONSALE;
    }

    public Storage[] getStorage() {
        return storage;
    }

    public void setStorage(Storage[] storage) {
        this.storage = storage;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Keyboard getBoard() {
        return board;
    }

    public void setBoard(Keyboard board) {
        this.board = board;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public GraphicCard getGraphic() {
        return graphic;
    }

    public void setGraphic(GraphicCard graphic) {
        this.graphic = graphic;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getConnections() {
        return connections;
    }

    public void setConnections(String connections) {
        this.connections = connections;
    }
    
    public double getPVP() {
        return applyDiscounts(Computer.ONSALE,Computer.PROFIT_MARGIN,Computer.DISCOUNT,Computer.TAX);
    }

 /*public double getPVP() {
        boolean keep_onsale=this.onsale;
        Float keep_margin=this.profit_margin;
        Float keep_discount=this.discount;
        double pvp;
        
        if (!this.onsale) this.onsale=Computer.ONSALE;
        if (this.profit_margin==null) this.profit_margin=Computer.PROFIT_MARGIN;
        if (this.discount==null) this.discount=Computer.DISCOUNT;
        if (TAX!=null)  {
            double raw_amount=super.applyDiscounts();
            pvp=raw_amount+raw_amount*TAX;
        } else pvp=super.getPVP();
        this.onsale=keep_onsale;
        this.profit_margin=keep_margin;
        this.discount=keep_discount;
        return pvp;
    }*/
    
}
