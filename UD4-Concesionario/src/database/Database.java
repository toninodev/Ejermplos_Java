package database;


public class Database {

    /**
     * Engade obj � base de datos
     * @param obj Obxecto a engadir
     * @return Obxecto engadido
     * @throws DBException Si se produce un erro no alta, por exemplo, si o obxecto xa existe.
     */
    public Object add(Object obj) throws DBException {
        throw new UnsupportedOperationException("Operaci�n non implamentada");
    }
    
    /**
     * Elimina obj da base de datos.
     * @param obj Elemento a eliminar. Se eliminar�n todos os obxectos na base de datos que sexan iguais ao recibido
     * como par�metro no sentido que estableza o m�todo equals da clase.
     * @return Obxecto eliminado
     * @throws DBException  Si se produce un erro durante o borrado, por exemplo, si o elemento non existe.
     */
    public Object delete(Object obj) throws DBException {
        throw new UnsupportedOperationException("Operaci�n non implamentada");
    }
    
    /**
     * Retorna un array con todos os obxectos na base de datos
     * @return Array con todos os elementos da base de datos
     * @throws database.DBException Si se produce un erro na lectura dos datos
     */
    public Object[] list() throws DBException {
        throw new UnsupportedOperationException("Operaci�n non implamentada");
    }
    
    /**
     * Selecciona o conxunto de obxectos na base de datos seleccionados polo Filter f
     * @param f - Filtro que permite seleccionar os obxectos desexados
     * @return Array cos obxectos desexados
     * @throws DBException Si se produce un erro na lectura ou selecci�n dos datos
     */
    public Object[] findAll(Filter f) throws DBException {
        throw new UnsupportedOperationException("Operaci�n non implamentada");    
    }
    
    /**
     * Selecciona o primeiro obxecto da base de datos seleccionado polo Filter f
     * @param f - Filtro que permite seleccionar os obxectos desexados
     * @return Primeiro obxecto que cumpla co filtro
     * @throws DBException Si se produce un erro na lectura ou selecci�n dos datos
     */
    public Object findOne(Filter f) throws DBException {
        throw new UnsupportedOperationException("Operaci�n non implamentada");    
    }
    
     /**
     * Selecciona o primeiro obxecto da base de datos que sexa igual que o recibido como 
     * par�metro no sentido de igualdade establecido en equals
     * @param obj - Obxecto a buscar
     * @return Primeiro obxecto que coincida
     * @throws DBException Si se produce un erro na lectura ou selecci�n dos datos
     */
    public Object find(Object obj) throws DBException {
        // Uso unha clase an�nima
        return findOne(new Filter() {
            @Override
            public boolean isValid(Object testobj) {
                return obj.equals(testobj);
            }
        });  
    }
    
    /**
     * Comeza unha "iteraci�n". A posterior chamada a next sobre este obxecto retornar� o primeiro obxecto
     */
    public void startIteration() {
        throw new UnsupportedOperationException("Operaci�n non implamentada");    
    }
    
    /**
     * Retorna o obxecto seguinte ao �ltimo devolto por next() ou null si non temos mais
     * @return Seguinte obxecto ou null indicando que xa non temos m�is
     */
    public Object next() {
        throw new UnsupportedOperationException("Operaci�n non implamentada");    
    }
    
    /**
     * Permite substitu�r o obxecto existente polo obxecto obj recibido como par�metro.
     * Para que a substituci�n se produza, o obxecto obj e o obxecto almacenado na base de datos
     * deben ser "iguais" segundo o criterio establecido mediante o m�todo equals da clase
     * @param obj Obxecto a almacenar substituindo o existente
     * @return O obxecto substitu�do
     * @throws DBException Si se produce un erro durante a modificaci�n, por sxemplo, si o obxecto non existe
     */
    public Object modify(Object obj) throws DBException {
        throw new UnsupportedOperationException("Operaci�n non implamentada");
    }
}
