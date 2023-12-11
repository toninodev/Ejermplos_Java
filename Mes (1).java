package utilities;

/**  Comentarios e explicación cortesía de ChatGPT.
 *
 * 
 
Enumeración que representa os doce meses do ano.
    Enumeración de Meses: O enum Mes representa os doze meses do ano.
Explicación detallada:

Enumeración de Meses: O enum Mes representa os doze meses do ano.
Atributo Privado dias: Cada valor de enum ten asociado o número de días que posúe.
Constructor Privado Mes(int dias): Cada valor de enum inicialízase co número de días correspondente.
Método getDias(): Retorna o número de días do mes.
Método num(): Retorna o número do mes (1 para Xaneiro, 2 para Febreiro, etc.).
Método toString(): Converte o nome do mes para unha representación máis amigable (coa primeira letra en maiúscula).
Método Estático get(int num): Obtén un mes a partir do seu número (1 para Xaneiro, 2 para Febreiro, etc.).
Método Estático get(String name): Obtén un mes a partir do seu nome (como unha cadea de caracteres).
Excepcións:
    Se o número do mes non está no intervalo de 1 a 12, lanza unha excepción IllegalArgumentException.
    Se o nome do mes non é válido, unha excepción IllegalArgumentException será lanzada.
 
 
Este enum proporciona unha maneira clara e eficaz de representar e manipular os meses do ano, facendo que o código sexa máis legible e fácil de manter.
 * 
 */
public enum Mes {
    XANEIRO(31), FEBREIRO(28), MARZO(31), ABRIL(30), MAIO(31), XUÑO(30), XULLO(31),
    AGOSTO(31), SETEMBRO(30), OUTUBRO(31), NOVEMBRO(30), DECEMBRO(31);

    // Atributo privado que almacena o número de días de cada mes.
    private final int dias;

    /**
     * Constructor que asigna o número de días a cada mes.
     * 
     * @param dias O número de días do mes.
     */
    private Mes(int dias) {
        this.dias = dias;
    }

    /**
     * Obtén o número de días do mes.
     * 
     * @return O número de días do mes.
     */
    public int getDias() {
        return dias;
    }

    /**
     * Obtén o número do mes (1 para Xaneiro, 2 para Febreiro, etc.).
     * 
     * @return O número do mes.
     */
    public int num() {
        return this.ordinal() + 1;
    }

    /**
     * Converte o nome do mes para unha representación máis amigable (coa primeira letra en maiúscula).
     * 
     * @return O nome do mes en formato amigable.
     */
    @Override
    public String toString() {
        String str = super.toString();
        return str.charAt(0) + str.substring(1).toLowerCase();
    }

    /**
     * Obter un mes a partir do seu número (1 para Xaneiro, 2 para Febreiro, etc.).
     * 
     * @param num O número do mes.
     * @return O mes correspondente.
     * @throws IllegalArgumentException Se o número do mes está fóra do rango válido (1 a 12).
     */
    public static Mes get(int num) {
        try {
            return Mes.values()[num - 1];
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("O número do mes debe estar entre 1 e 12");
        }
    }

    /**
     * Obter un mes a partir do seu nome (en formato de cadea de caracteres).
     * 
     * @param name O nome do mes.
     * @return O mes correspondente.
     * @throws IllegalArgumentException Se o nome do mes non é válido.
     */
    public static Mes get(String name) {
        try {
            // Intenta converter o nome a un número de mes
            return Mes.get(Integer.parseInt(name));
        } catch (NumberFormatException e) {
            // Se non é un número, intenta obter o mes polo seu nome en maiúsculas ou minúsculas.
            return Mes.valueOf(name.toUpperCase());
        }
    }
}
