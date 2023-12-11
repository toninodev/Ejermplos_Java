package utilities;

import java.time.LocalDate;

/**
 * Clase que representa una fecha. Comentarios cortesía de ChatGPT
 */
public class Data {
    private int dia;
    private Mes mes;
    private int ano;

    /**
     * Constructor que inicializa una fecha con día, mes y año dados.
     * 
     * @param dia  El día de la fecha.
     * @param mes  El mes de la fecha.
     * @param ano  El año de la fecha.
     * @throws IllegalArgumentException Si el año es anterior a 1900 o el día es inválido para el mes actual.
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
     * Constructor que inicializa una fecha con día, mes (como cadena) y año dados.
     * 
     * @param dia  El día de la fecha.
     * @param mes  El mes de la fecha como cadena.
     * @param ano  El año de la fecha.
     * @throws IllegalArgumentException Si el año es anterior a 1900 o el día es inválido para el mes actual.
     */
    public Data(int dia, String mes, int ano) {
        this(dia, Mes.get(mes), ano);
    }

    /**
     * Constructor que inicializa una fecha con día, mes (como objeto Mes) y año dados.
     * 
     * @param dia  El día de la fecha.
     * @param mes  El mes de la fecha como objeto Mes.
     * @param ano  El año de la fecha.
     * @throws IllegalArgumentException Si el año es anterior a 1900 o el día es inválido para el mes actual.
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
     * Constructor que inicializa una fecha a partir de una cadena con el formato "dia de mes de año".
     * 
     * @param data La cadena que representa la fecha.
     * @throws IllegalArgumentException Si la cadena no es una fecha válida.
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
            throw new IllegalArgumentException(data + " non é unha data válida");
        }
    }

    /**
     * Obtiene el día de la fecha.
     * 
     * @return El día de la fecha.
     */
    public int getDia() {
        return dia;
    }

    /**
     * Establece el día de la fecha.
     * 
     * @param dia El nuevo valor para el día.
     * @throws IllegalArgumentException Si el día no es válido para el mes actual.
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
     * @throws IllegalArgumentException Si el día se vuelve inválido para el nuevo mes.
     */
    public void setMes(Mes mes) {
        this.mes = mes;
        int diasmes = dias();
        if (dia > diasmes) throw new IllegalArgumentException("O día " + dia + " de " + mes + " non existe, " + mes + " so ten " + diasmes);
    }

    /**
     * Obtiene el año de la fecha.
     * 
     * @return El año de la fecha.
     */
    public int getAno() {
        return ano;
    }

    /**
     * Establece el año de la fecha.
     * 
     * @param ano El nuevo valor para el año.
     * @throws IllegalArgumentException Si el año es anterior a 1900 o el día se vuelve inválido para el mes actual.
     */
    public void setAno(int ano) {
        this.ano = ano;
        if (ano < 1900) throw new IllegalArgumentException("O ano non pode ser menor de 1900");
        if (this.dia > dias()) throw new IllegalArgumentException("O día " + dia + " non é válido. O mes de " + mes + " do ano " + ano + " so ten " + dias() + " días");
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
     * Obtiene el número de días en el mes actual.
     * 
     * @return El número de días en el mes actual.
     */
    public int getDiasMes() {
        return dias();
    }

    /**
     * Suma un número de días a la fecha actual.
     * 
     * @param dias El número de días a sumar.
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
     * Dende un construtor non se DEBE chamar a un método que non sexa privado e non sexa final.
     * 
     * @return O número de días no mes actual.
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
     * Comprueba si un año es bisiesto.
     * 
     * @param ano El año a comprobar.
     * @return True si el año es bisiesto, False en caso contrario.
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
