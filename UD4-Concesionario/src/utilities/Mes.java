package utilities;

/**  Comentarios e explicaci�n cortes�a de ChatGPT.
 *
 * 
 
Enumeraci�n que representa os doce meses do ano.
    Enumeraci�n de Meses: O enum Mes representa os doze meses do ano.
Explicaci�n detallada:

Enumeraci�n de Meses: O enum Mes representa os doze meses do ano.
Atributo Privado dias: Cada valor de enum ten asociado o n�mero de d�as que pos�e.
Constructor Privado Mes(int dias): Cada valor de enum inicial�zase co n�mero de d�as correspondente.
M�todo getDias(): Retorna o n�mero de d�as do mes.
M�todo num(): Retorna o n�mero do mes (1 para Xaneiro, 2 para Febreiro, etc.).
M�todo toString(): Converte o nome do mes para unha representaci�n m�is amigable (coa primeira letra en mai�scula).
M�todo Est�tico get(int num): Obt�n un mes a partir do seu n�mero (1 para Xaneiro, 2 para Febreiro, etc.).
M�todo Est�tico get(String name): Obt�n un mes a partir do seu nome (como unha cadea de caracteres).
Excepci�ns:
    Se o n�mero do mes non est� no intervalo de 1 a 12, lanza unha excepci�n IllegalArgumentException.
    Se o nome do mes non � v�lido, unha excepci�n IllegalArgumentException ser� lanzada.
 
 
Este enum proporciona unha maneira clara e eficaz de representar e manipular os meses do ano, facendo que o c�digo sexa m�is legible e f�cil de manter.
 * 
 */
public enum Mes {
    XANEIRO(31), FEBREIRO(28), MARZO(31), ABRIL(30), MAIO(31), XU�O(30), XULLO(31),
    AGOSTO(31), SETEMBRO(30), OUTUBRO(31), NOVEMBRO(30), DECEMBRO(31);

    // Atributo privado que almacena o n�mero de d�as de cada mes.
    private final int dias;

    /**
     * Constructor que asigna o n�mero de d�as a cada mes.
     * 
     * @param dias O n�mero de d�as do mes.
     */
    private Mes(int dias) {
        this.dias = dias;
    }

    /**
     * Obt�n o n�mero de d�as do mes.
     * 
     * @return O n�mero de d�as do mes.
     */
    public int getDias() {
        return dias;
    }

    /**
     * Obt�n o n�mero do mes (1 para Xaneiro, 2 para Febreiro, etc.).
     * 
     * @return O n�mero do mes.
     */
    public int num() {
        return this.ordinal() + 1;
    }

    /**
     * Converte o nome do mes para unha representaci�n m�is amigable (coa primeira letra en mai�scula).
     * 
     * @return O nome do mes en formato amigable.
     */
    @Override
    public String toString() {
        String str = super.toString();
        return str.charAt(0) + str.substring(1).toLowerCase();
    }

    /**
     * Obter un mes a partir do seu n�mero (1 para Xaneiro, 2 para Febreiro, etc.).
     * 
     * @param num O n�mero do mes.
     * @return O mes correspondente.
     * @throws IllegalArgumentException Se o n�mero do mes est� f�ra do rango v�lido (1 a 12).
     */
    public static Mes get(int num) {
        try {
            return Mes.values()[num - 1];
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("O n�mero do mes debe estar entre 1 e 12");
        }
    }

    /**
     * Obter un mes a partir do seu nome (en formato de cadea de caracteres).
     * 
     * @param name O nome do mes.
     * @return O mes correspondente.
     * @throws IllegalArgumentException Se o nome do mes non � v�lido.
     */
    public static Mes get(String name) {
        try {
            // Intenta converter o nome a un n�mero de mes
            return Mes.get(Integer.parseInt(name));
        } catch (NumberFormatException e) {
            // Se non � un n�mero, intenta obter o mes polo seu nome en mai�sculas ou min�sculas.
            return Mes.valueOf(name.toUpperCase());
        }
    }
}
