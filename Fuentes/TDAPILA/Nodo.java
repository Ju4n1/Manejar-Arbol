package TDAPILA;

/**
 * Clase Nodo modela los elementos que contiene la pila enlazada.
 * 
 * @author Juan Cruz Feuilles.
 *
 * @param <E> parámetro genérico de clase.
 */

public class Nodo<E> {

	
private E rotulo;
private Nodo<E> siguiente;


/**
 * Crea un nuevo nodo y le asigna un siguiente.
 *
 * @param elemento rotulo del nodo.
 * 
 * @param siguiente nodo siguiente al nodo creado.
 * 
 */

public Nodo(E rotulo, Nodo<E>siguiente){
	    this.rotulo=rotulo;
	    this.siguiente=siguiente;}


/**
 * Crea un nuevo nodo solo con su rotulo.
 * @param rotulo rotulo del nodo.
 */
public Nodo(E rotulo){
	  this.rotulo=rotulo;
	  siguiente=null;}


/**
 * Crea un nodo dummy.
 */
public Nodo(){
	rotulo=null;
	siguiente=null;}

/**
 * Retorna el rotulo del nodo.
 * @return rotulo nuevo.
 */
public E getElemento(){
	   return rotulo;}

/**
 * Retrona el nodo siguiente.
 * @return nodo siguiente.
 */
public Nodo<E> getSiguiente(){
	   return siguiente;}


/**
 * Actualiza el rotulo del nodo.
 * @param elem nuevo elemento.
 */
public void setElemento(E item){
	    rotulo=item;}


/**
 * Actualiza el nodo siguiente.
 * @param n nuevo nodo siguiente.
 */
public void setSiguiente(Nodo<E> n){
	     siguiente=n;}
	
}
