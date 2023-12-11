package daw.iesrodeira.com.common;

import java.util.Arrays;

/**
 *
 * @author xavi
 */
class Tin {
    enum NifType { 
        A("Sociedade Anónima"),
        B("Sociedade de Responsabilididade Limitada"),
        C("Sociedade Colectiva"),
        D("Sociedade Comanditaria"),
        E("Comunidade de Bens"),
        F("Sociedade Cooperativa"),
        G("Asociación ou Fundación"),
        H("Comunidade de Propietarios Horizontal"),
        J("Sociedad Civil"),
        N("Entidade Extranxeira"),
        P("Corporación Local"),
        Q("Organismo Público"),
        R("Organización Relixiosa"),
        S("Administración Xeral do Estado / Comunidade Autónoma"),
        U("Unión Temporal de Empresas"),
        V("Non definido"),
        W("Establecemento Permanente Entidade non Residente"),
        K("Menor de 14 anos"),
        L("Residente no Extranxeiro"),
        M("Extranxeiro sen NIE"),
        NIE("Numero de Identificación de Extranxeiro (NIE)"),
        DNI("Documento Nacional de Identidade (DNI)");
                      
    
        String description;
        
        NifType(String description) {
            this.description=description;
        }
        
        public String description() {
            return description;
        }
    }
    private static final String STARTNIF_X="ABCDEFGHJNPQRSUV";
    private static final String STARTNIE="XYZ";
    private static final String STARTNIF_F="KLM";
    private static final String DNICONTROL="TRWAGMYFPDXBNJZSQVHLCKE";
    private static final String NIFCONTROL="ABCDEFGHIJ";
    
    private final char[] tin;
    private final NifType type;
    private final char control;

    Tin(String cif) throws TINException {
        this.tin=cif.toUpperCase().toCharArray();

        try {
            this.control=this.tin[this.tin.length-1];
            if (isNif()) {
                type=NifType.valueOf(String.valueOf(tin[0]));
                if (!verificaNif(tin)) throw new TINException(cif+" non e un nif valido");
            } else {
                if (isNie()) {
                    type=NifType.NIE;
                } else type=NifType.DNI;
                if (!verificaDni(tin)) throw new TINException(cif+" non e un dni/nie válido");
            }
        } catch(IllegalArgumentException e) {
            throw new TINException(cif+" non é unha identificación válida");
        }
    }
        
    public boolean isID() {
        return !isNif();
    }
    
    public boolean isNif() {
        return (STARTNIF_X.indexOf(tin[0])>=0 || STARTNIF_F.indexOf(tin[0])>=0);
    }
    
    public boolean isNie() {
        return STARTNIE.indexOf(tin[0])>=0;
    }
    
    public char getControl() {
        return control;
    }
    
    public String type() {
        return "no";
    }
    
    public static boolean verificaDni(char[] letras) {
        if (STARTNIE.indexOf(letras[0])>=0)
            letras[0]=(char)(STARTNIE.indexOf(letras[0])+'0');
        
        if (letras.length!=9) return false;
        char control=letras[letras.length-1];
        try {
            int num=Integer.parseInt(new String(Arrays.copyOfRange(letras,0,letras.length-1)));
            return DNICONTROL.toCharArray()[num%23]==control;
        } catch(NumberFormatException e) {
            
        }
        return false;
    }

    
    
    public static boolean verificaNif(char[] letras) {
        try {
            Integer.valueOf(new String(Arrays.copyOfRange(letras,1,letras.length-1)));
            int suma_par=sumaPares(letras);
            int suma_impar=sumaImpares(letras);
            int total=suma_par+suma_impar;
            int cc=10-(total%10);

            if (Character.isDigit(letras[letras.length-1])) {
                return ((cc+'0')==letras[letras.length-1]);
            } else {
                return NIFCONTROL.toCharArray()[cc-1]==letras[letras.length-1];
            }
        } catch(NumberFormatException e) {
            
        }
        return false;
    }
    
    private static int sumaPares(char[] letras) {
        int suma=0;
        for(int idx=2;idx<letras.length-2;idx+=2) {
            suma=suma+(letras[idx]-'0');
        }
        return suma;
    }
    
    private static int sumaImpares(char[] letras) {
        int suma=0;
        for(int idx=1;idx<letras.length;idx+=2) {
            int n=(letras[idx]-'0')*2;
            n=(n/10)+(n%10);
            suma=suma+n;
        }
        return suma;
    }
}
