package daw.iesrodeira.com.common;

public class EANValidator extends Validator {
    private int siguienteDecena(int num) {
        return (num+9)/10*10;
        
        /*int res=num%10;
        while(res%10!=0) {
            num++;
            res=num%10;
        }
        return num;*/
    }
    
    /**
     * https://www.codigos-qr.com/calcular-digito-de-control-ean13-gtin13/
     * @param obj
     * @return 
     */
    @Override
    public boolean isValid(Object obj) {
        String ean=(String) obj;
        char[] digits=ean.toCharArray();
        int suma_impares=0;
        int suma_pares=0;
        /*for(int idx=0;idx<digits.length-2;idx+=2) {
            suma_pares+=digits[idx]-'0';                      
            suma_impares+=digits[idx+1]-'0';
        }*/
        int idx=0;
        while(idx<digits.length-2) {
            suma_pares+=digits[idx]-'0';
            suma_impares+=digits[idx+1]-'0';
            idx=idx+2;
        }
        
        int control=digits[digits.length-1]-'0';
        suma_impares=suma_impares*3;
        int total=suma_pares+suma_impares;
        
        int decenasuperior=siguienteDecena(total);
  
        return ((decenasuperior-total)==control);
    }
}
