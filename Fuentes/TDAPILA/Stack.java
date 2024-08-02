package TDAPILA;

/**
 * Interfaz Stack modela la implementacion de la extructura de datos Pila.
 *
 * @author Juan Cruz Feuilles.
 * 
 * @param <E> parámetro genérico de clase.
 */

public interface Stack<E> {

	/**
	 * Retorna la cantidad de elementos de la pila.
	 * @return elementos de la pila.
	 */
	
	int size();
	
	/** 
	 * Testea si la pila está vacía o no.
	 * @return verdadero si la pila está vacía.
	 */
	
	boolean isEmpty();
	
	/**
	 * Inserta el elemento en el tope de la pila.
	 * @param e el elemento a insertar.
	 */
	
	void push(E e);
	
	/**
	 * Retorna pero no remueve el elemento del tope de la pila.
	 * @return elemento del tope de la pila.
	 */
	
	E top() throws EmptyStackException;
	
	/**
	 * Remueve y retorna el tope de la pila.
	 * @return tope de la pila.
	 * @throws EmptyStackException. 
	 */
	
	E pop() throws EmptyStackException ;
}
