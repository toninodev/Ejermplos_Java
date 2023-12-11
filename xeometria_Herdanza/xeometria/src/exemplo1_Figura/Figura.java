package exemplo1_Figura;


public class Figura {
    String nome;
    
    public Figura(String nome) {
        this.nome=nome;
    }
    
    public void pinta() {
       System.out.println("Pintando "+this);
    }    
    
    public void setNome(String nome) {
       this.nome=nome;
    }
    
    /**
     * Figura � tan xen�rico que non sabemos como retornar a s�a posici�n.
     * @return 
     */
    public Coordenada getPosicion() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Temos un problema: Sabemos que as Figuras te�en un �rea que podemos calcular
     * a partir dos seus atributos. Pero "unha Figura" � algo tan xen�rico que non
     * podemos saber como facelo.,,, de modo que  lanzamos unha Exception
     * 
     * Java e as linguaxes OOP proporcionan unha soluci�n a iste problema que veremos no seguinte trimestre
     * @return 
     */
    public double getArea() {
        throw new UnsupportedOperationException(this+": Non se pode calcular o �rea");
    }

    @Override
    public String toString() {
        return nome;
    }
}
