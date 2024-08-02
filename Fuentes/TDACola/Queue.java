package TDACola;

/**
 * Clase Queue modela una cola.
 * @author Juan Cruz Feuilles.
 *
 * @param <E> par�metro gen�rico de clase.
 */

public interface Queue<E> {

	public void enqueue(E item);
 
    /**
	 * M�todo que elimina el elemento del frente de la cola y lo retorna. Si la cola est� vac�a se produce un error.
	 * @return E. 
	 * @throws EmptyQueueException. Si la cola est� vac�a.
	 */
    
    public E dequeue() throws EmptyQueueException;
 
    /**
	 * M�todo que retorna verdadero si la cola no tiene elementos y falso en caso contrario
	 * @return boolean
	 */
   
    public boolean isEmpty();
   

    /**
	 * M�todo que retorna el elemento del frente de la cola. Si la cola est� vac�a se produce un error.
	 * @return E
	 * @throws EmptyQueueException. Si la cola est� vac�a.
	 */
    
	public E front() throws EmptyQueueException;

	/**
	 * M�todo que retorna la cantidad de elementos de la cola.
	 * @return int size.
	 */
	
	public int size();
	
}
