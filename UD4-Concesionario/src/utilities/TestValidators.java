package utilities;

import java.util.Scanner;
import utilities.validators.DNIValidator;
import utilities.validators.EmailValidator;
import utilities.validators.MatriculaValidator;
import utilities.validators.TelefonoValidator;


public class TestValidators {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        String texto;
        Validator v;
                
        System.out.print("DNI: "); texto=scn.nextLine();
        v=new DNIValidator(texto);
        if (v.isValid())  System.out.println(texto+" e un DNI/NIE v�lido");
        else              System.out.println(v.getMessage());
        
        System.out.print("Email: "); texto=scn.nextLine();
        v=new EmailValidator(texto);
        if (v.isValid())  System.out.println(texto+" e un e-mail v�lido");
        else              System.out.println(v.getMessage());

        System.out.print("Matr�cula: "); texto=scn.nextLine();
        v=new MatriculaValidator(texto);
        if (v.isValid())  System.out.println(texto+" e unha matr�cual espa�ola v�lida");
        else              System.out.println(v.getMessage());

        System.out.print("Tel�fono: "); texto=scn.nextLine();
        v=new TelefonoValidator(texto);
        if (v.isValid())  System.out.println(texto+" e un DNI/NIE v�lido");
        else              System.out.println(v.getMessage());

        
    }
}
