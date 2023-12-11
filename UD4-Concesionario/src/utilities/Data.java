package utilities;

import java.time.LocalDate;

/**
 * Clase que representa una fecha. Comentarios cortes�a de ChatGPT
 */
public class Data {
    private int dia;
    private Mes mes;
    private int ano;

    /**
     * Constructor que inicializa una fecha con d�a, mes y a�o dados.
     * 
     * @param dia  El d�a de la fecha.
     * @param mes  El mes de la fecha.
     * @param ano  El a�o de la fecha.
     * @throws IllegalArgumentException Si el a�o es anterior a 1900 o el d�a es inv�lido para el mes actual.
     */
    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = Mes.get(mes);
        if (ano < 1900) throw new IllegalArgumentException("O ano debe ser posterior a 1900");
        this.ano = ano;
        int diasmes = dias();
        if (dia < 1 || dia > diasmes) throw new IllegalArgumentException(mes + " so ten " + diasmes);
    }

    /**
     * Constructor que inicializa una fecha con d�a, mes (como cadena) y a�o dados.
     * 
     * @param dia  El d�a de la fecha.
     * @param mes  El mes de la fecha como cadena.
     * @param ano  El a�o de la fecha.
     * @throws IllegalArgumentException Si el a�o es anterior a 1900 o el d�a es inv�lido para el mes actual.
     */
    public Data(int dia, String mes, int ano) {
        this(dia, Mes.get(mes), ano);
    }

    /**
     * Constructor que inicializa una fecha con d�a, mes (como objeto Mes) y a�o dados.
     * 
     * @param dia  El d�a de la fecha.
     * @param mes  El mes de la fecha como objeto Mes.
     * @param ano  El a�o de la fecha.
     * @throws IllegalArgumentException Si el a�o es anterior a 1900 o el d�a es inv�lido para el mes actual.
     */
    public Data(int dia, Mes mes, int ano) {
        this(dia, mes.num(), ano);
    }

    /**
     * Constructor que inicializa una fecha a partir de una instancia de LocalDate.
     * 
     * @param date Una instancia de LocalDate.
     */
    public Data(LocalDate date) {
        this(date.getDayOfMonth(), date.getMonthValue(), date.getYear());
    }

    /**
     * Constructor que inicializa una fecha a partir de una cadena con el formato "dia de mes de a�o".
     * 
     * @param data La cadena que representa la fecha.
     * @throws IllegalArgumentException Si la cadena no es una fecha v�lida.
     */
    public Data(String data) {
        String str = data.replace(" de ", " ");
        str = str.replace("-", " ");
        str = str.replace("/", " ");
        String[] partes = str.split(" ");
        try {
            this.dia = Integer.parseInt(partes[0]);
            this.mes = Mes.get(partes[1]);
            this.ano = Integer.parseInt(partes[2]);
            if ((ano < 1900) || (this.dia < 1) || (this.dia > dias())) throw new Exception();
        } catch (Exception e) {
            throw new IllegalArgumentException(data + " non � unha data v�lida");
        }
    }

    /**
     * Obtiene el d�a de la fecha.
     * 
     * @return El d�a de la fecha.
     */
    public int getDia() {
        return dia;
    }

    /**
     * Establece el d�a de la fecha.
     * 
     * @param dia El nuevo valor para el d�a.
     * @throws IllegalArgumentException Si el d�a no es v�lido para el mes actual.
     */
    public void setDia(int dia) {
        int diasmes = dias();
        if (dia < 1 || dia > diasmes) throw new IllegalArgumentException(mes + " so ten " + diasmes);
        this.dia = dia;
    }

    /**
     * Obtiene el mes de la fecha.
     * 
     * @return El mes de la fecha.
     */
    public Mes getMes() {
        return mes;
    }

    /**
     * Establece el mes de la fecha.
     * 
     * @param mes El nuevo valor para el mes.
     * @throws IllegalArgumentException Si el d�a se vuelve inv�lido para el nuevo mes.
     */
    public void setMes(Mes mes) {
        this.mes = mes;
        int diasmes = dias();
        if (dia > diasmes) throw new IllegalArgumentException("O d�a " + dia + " de " + mes + " non existe, " + mes + " so ten " + diasmes);
    }

    /**
     * Obtiene el a�o de la fecha.
     * 
     * @return El a�o de la fecha.
     */
    public int getAno() {
        return ano;
    }

    /**
     * Establece el a�o de la fecha.
     * 
     * @param ano El nuevo valor para el a�o.
     * @throws IllegalArgumentException Si el a�o es anterior a 1900 o el d�a se vuelve inv�lido para el mes actual.
     */
    public void setAno(int ano) {
        this.ano = ano;
        if (ano < 1900) throw new IllegalArgumentException("O ano non pode ser menor de 1900");
        if (this.dia > dias()) throw new IllegalArgumentException("O d�a " + dia + " non � v�lido. O mes de " + mes + " do ano " + ano + " so ten " + dias() + " d�as");
    }

    /**
     * Comprueba si la fecha actual es anterior a otra fecha dada.
     * 
     * @param d La fecha con la que se compara.
     * @return True si la fecha actual es anterior a la fecha dada, False en caso contrario.
     */
    public boolean eAntes(Data d) {
        return toLocalDate().isBefore(d.toLocalDate());
    }

    /**
     * Comprueba si la fecha actual es posterior a otra fecha dada.
     * 
     * @param d La fecha con la que se compara.
     * @return True si la fecha actual es posterior a la fecha dada, False en caso contrario.
     */
    public boolean eDespois(Data d) {
        return toLocalDate().isAfter(d.toLocalDate());
    }

    /**
     * Obtiene el n�mero de d�as en el mes actual.
     * 
     * @return El n�mero de d�as en el mes actual.
     */
    public int getDiasMes() {
        return dias();
    }

    /**
     * Suma un n�mero de d�as a la fecha actual.
     * 
     * @param dias El n�mero de d�as a sumar.
     * @return La fecha actualizada.
     */
    public Data sumaDias(int dias) {
        LocalDate d = toLocalDate();
        if (dias < 0) d = d.minusDays(-dias);
        else d = d.plusDays(dias);
        this.dia = d.getDayOfMonth();
        this.mes = Mes.get(d.getMonthValue());
        this.ano = d.getYear();
        return this;
    }

    /**
     * Convierte la fecha a una instancia de LocalDate.
     * 
     * @return Una instancia de LocalDate que representa la fecha.
     */
    public LocalDate toLocalDate() {
        return LocalDate.of(this.ano, this.mes.num(), this.dia);
    }

    /**
     * Dende un construtor non se DEBE chamar a un m�todo que non sexa privado e non sexa final.
     * 
     * @return O n�mero de d�as no mes actual.
     */
    private int dias() {
        int dias = mes.getDias();
        if ((mes == Mes.FEBREIRO) && Data.anoBisiesto(ano)) dias++;
        return dias;
    }

    /**
     * Devuelve una cadena que representa la fecha en el formato "dia de mes de ano".
     * 
     * @return Una cadena que representa la fecha.
     */
    @Override
    public String toString() {
        return dia + " de " + mes + " de " + ano;
    }

    /**
     * Comprueba si un a�o es bisiesto.
     * 
     * @param ano El a�o a comprobar.
     * @return True si el a�o es bisiesto, False en caso contrario.
     */
    public static boolean anoBisiesto(int ano) {
        return (ano % 4 == 0) && (ano % 100 != 0) || (ano % 400 == 0);
    }

    /**
     * Obtiene la fecha actual como un objeto Data.
     * 
     * @return La fecha actual.
     */
    public static Data today() {
        return new Data(LocalDate.now());
    }
}
