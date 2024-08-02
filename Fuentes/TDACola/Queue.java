package TDACola;

/**
 * Clase Queue modela una cola.
 * @author Juan Cruz Feuilles.
 *
 * @param <E> parámetro genérico de clase.
 */

public interface Queue<E> {

	public void enqueue(E item);
 
    /**
	 * Método que elimina el elemento del frente de la cola y lo retorna. Si la cola está vacía se produce un error.
	 * @return E. 
	 * @throws EmptyQueueException. Si la cola está vacía.
	 */
    
    public E dequeue() throws EmptyQueueException;
 
    /**
	 * Método que retorna verdadero si la cola no tiene elementos y falso en caso contrario
	 * @return boolean
	 */
   
    public boolean isEmpty();
   

    /**
	 * Método que retorna el elemento del frente de la cola. Si la cola está vacía se produce un error.
	 * @return E
	 * @throws EmptyQueueException. Si la cola está vacía.
	 */
    
	public E front() throws EmptyQueueException;

	/**
	 * Método que retorna la cantidad de elementos de la cola.
	 * @return int size.
	 */
	
	public int size();
	
}
