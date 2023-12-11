package utilities;

import java.util.NoSuchElementException;

/**
 * Esta clase representa una lista dinámica que permite almacenar y manipular objetos de manera dinámica.
 * 
 * Comentarios cortesía de chatGPT
 * 
 */
public class DinamicArray {

    /**
     * Primer nodo de la lista.
     */
    protected DinamicArrayNode first = null;

    /**
     * Último nodo de la lista.
     */
    protected DinamicArrayNode last = null;

    /**
     * Longitud actual de la lista.
     */
    private int length = 0;
    
    /**
     * Posición de percorrido
     */
    DinamicArrayNode itidx=null;
    DinamicArrayNode lastit=null;

    /**
     * Clase interna que representa un nodo en la lista dinámica.
     */
    private class DinamicArrayNode {
        /**
         * Información almacenada en el nodo.
         */
        Object info = null;

        /**
         * Referencia al siguiente nodo.
         */
        DinamicArrayNode next = null;

        /**
         * Referencia al nodo anterior.
         */
        DinamicArrayNode prev = null;

        /**
         * Constructor para inicializar un nodo con la información proporcionada.
         *
         * @param info La información que se almacenará en el nodo.
         */
        DinamicArrayNode(Object info) {
            this.info = info;
        }
    }

    /**
     * Agrega un objeto al final de la lista.
     *
     * @param obj El objeto que se agregará a la lista.
     * @return El objeto que se agregó a la lista.
     */
    public Object add(Object obj) {
        DinamicArrayNode newNode = new DinamicArrayNode(obj);

        // Verificar si la lista no está vacía
        if (first != null) {
            // Si first no es null, entonces last tampoco es null
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        } else {
            // Primer nodo en la lista
            last = newNode;
            first = newNode;
        }
        length++;  // Incrementar la longitud de la lista
        return obj;  // Devolver el objeto agregado
    }

    /**
     * Obtiene la longitud actual de la lista.
     *
     * @return La longitud actual de la lista.
     */
    public int length() {
        return length;
    }

    /**
     * Obtiene el objeto en la posición indicada.
     *
     * @param idx La posición del objeto que se desea obtener.
     * @return El objeto en la posición indicada.
     * @throws IndexOutOfBoundsException Si el índice está fuera de los límites de la lista.
     */
    public Object get(int idx) throws IndexOutOfBoundsException {
        DinamicArrayNode node = findNode(idx);
        return node.info;
    }

    /**
     * Elimina el objeto en la posición indicada.
     *
     * @param idx La posición del objeto que se desea eliminar.
     * @return El objeto que se eliminó.
     */
    public Object delete(int idx) {
        DinamicArrayNode node = findNode(idx);
        Object info = node.info;

        // Actualizar las referencias de los nodos anterior y siguiente
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;

        if (node==first) first=node.next;
        if (node==last) last=node.prev;
        
        length--;  // Decrementar la longitud de la lista
        return info;  // Devolver el objeto eliminado
    }

    /**
     * Inserta un objeto en una posición específica.
     *
     * @param obj El objeto que se insertará en la lista.
     * @param idx La posición en la que se insertará el objeto.
     * @return El objeto que se insertó en la lista.
     * @throws IndexOutOfBoundsException Si el índice está fuera de los límites de la lista.
     */
    public Object insert(Object obj, int idx) throws IndexOutOfBoundsException {
        DinamicArrayNode newNode = new DinamicArrayNode(obj);
        DinamicArrayNode node = findNode(idx);

        // Configurar las referencias del nuevo nodo y actualizar las referencias de los nodos adyacentes
        newNode.prev = node.prev;
        newNode.next = node;
        if (node.prev != null) node.prev.next = newNode;
        node.prev = newNode;

        // Actualizar first y last si es necesario
        if (newNode.prev == null) first = newNode;
        if (newNode.next == null) last = newNode;

        return obj;  // Devolver el objeto insertado
    }
    
    /**
     * Retorna un array con todos os obxectos almacenados
     * 
     * @return Array cos obxectos da lista
     */
    public Object[] toArray() {
        int idx;
        Object[] array=new Object[length];
        DinamicArrayNode w=first;
        idx=0;
        while(w!=null) {
            array[idx]=w.info;
            w=w.next;
            idx++;
        }
        return array;
    }
    

    /**
     * Encuentra el nodo en una posición específica.
     *
     * @param idx La posición del nodo que se desea encontrar.
     * @return El nodo en la posición indicada.
     * @throws IndexOutOfBoundsException Si el índice está fuera de los límites de la lista.
     */
    private DinamicArrayNode findNode(int idx) throws IndexOutOfBoundsException {
        // Verificar si el índice es mayor que la longitud de la lista
        if (idx < 0|| idx >= length) throw new IndexOutOfBoundsException("Last node is " + length + " starting at 0");

        DinamicArrayNode walkNode = first;
        int w = 0;

        // Iterar hasta llegar al nodo deseado
        while (w <= idx) {
            walkNode = walkNode.next;
            w++;
        }

        return walkNode;
    }
    
    /**
     * Inicializa o obxecto para comezar a percorrer os elementos
     */
    public void startIteration() {
        itidx=first;
        lastit=null;
    }
    
    /**
     * Nos indica si o obxecto ten mais elementos por percorrer
     * @return true si ten máis elementos por percorrer, false en outro caso
     */
    public boolean hasNext() {
        return itidx!=null;
    }
    
    /**
     * Retorna o elemento seguinte ao ultimo retornado pola anterior chamada a next()
     * @return Elemento seguinte
     * @throws NoSuchElementException  Si non existe un elemento seguinte.
     */
    public Object next() throws NoSuchElementException {
        if (itidx==null) throw new NoSuchElementException();
        Object data=itidx.info;
        lastit=itidx;
        itidx=itidx.next;
        return data;
    }
    
    /**
     * Elimina o nodo devolto pola última chamada a next()
     * 
     * @throws IllegalStateException Si non se chamou a next() ou xa se eliminou ese nodo
     */
    public void remove() throws IllegalStateException {
        if (lastit==null) throw new IllegalStateException();
       
        // Actualizar las referencias de los nodos anterior y siguiente
        if (lastit.prev != null) lastit.prev.next = lastit.next;
        if (lastit.next != null) lastit.next.prev = lastit.prev;

        if (lastit==first) first=lastit.next;
        if (lastit==last) last=lastit.prev;
        
        length--;  // Decrementar la longitud de la lista
        
        lastit=null;
    }
    
    /**
     * Elimina o elemento almacenado na posición do último elemento retornado por next() e o 
     * substitúe polo obxecto recibido como parámetro. Retorna o valor eliminado
     * @param obj - Obxecto que se vai a almacenar no sitio do vello
     * @return o obxecto que se elimina do DinamicArray
     * @throws IllegalStateException Si non se chamou a next() ou non temos anterior
     */
    public Object put(Object obj) throws IllegalStateException {
        if (lastit==null) throw new IllegalStateException();
        Object old=lastit.info;
        lastit.info=obj;
        return old;
    }
            
}
