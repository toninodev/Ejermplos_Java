package composicionpolimorfismo;

import devices.Aspiradora;
import devices.Bombilla;
import devices.Device;
import devices.Motosierra;
import java.util.Scanner;

/**
 *
 * Destacar que non se pode chamaar a start / stop dun Device
 */
public class ComposicionPolimorfismo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        try {
            // Polimorfismo
            Scanner scn=new Scanner(System.in);
            Device motosierra=new Motosierra();
            Device bombilla=new Bombilla();
            Device aspiradora=new Aspiradora();
            
            bombilla.on();
            
            System.out.println("Para parar pulsa ENTER... en 3 segundos arranca.");
            Thread.sleep(3000);
            System.out.println("\n\n***** Arrancando Motosierra **** \n");
            motosierra.on();
            System.out.println("\n\n***** Arrancando Aspiradora **** \n");
            aspiradora.on();
            scn.nextLine();
            System.out.println("\n\n***** Parando Motosierra **** \n");
            motosierra.off();
            System.out.println("En 3 segundos paramos a aspiradora.\n*******************\n");
            Thread.sleep(3000);
            
            System.out.println("\n\n***** Parando Aspiradora **** \n");
            aspiradora.off();
            
            bombilla.off();
        } catch (InterruptedException ex) {
            System.out.println("Warning: "+ex.getMessage());
        }
    }
    
}
