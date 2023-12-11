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
     * Figura é tan xenérico que non sabemos como retornar a súa posición.
     * @return 
     */
    public Coordenada getPosicion() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Temos un problema: Sabemos que as Figuras teñen un área que podemos calcular
     * a partir dos seus atributos. Pero "unha Figura" é algo tan xenérico que non
     * podemos saber como facelo.,,, de modo que  lanzamos unha Exception
     * 
     * Java e as linguaxes OOP proporcionan unha solución a iste problema que veremos no seguinte trimestre
     * @return 
     */
    public double getArea() {
        throw new UnsupportedOperationException(this+": Non se pode calcular o área");
    }

    @Override
    public String toString() {
        return nome;
    }
}
