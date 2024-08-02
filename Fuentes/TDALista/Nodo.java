package TDALista;
/**
 * Clase Nodo implementa la Intefaz Position.
 * 
 * @author Juan Cruz Feuilles
 *
 * @param <E> parámetro genérico de clase.
 */
public class Nodo<E> implements Position<E> {

/**
 * Atributos de clase.	
 */
private E rotulo;
private Nodo<E>anterior;
private Nodo<E>siguiente;

/**
 * Crea un nuevo nodo con su Rotulo, elemento Aterior y Siguiente correspondiente.
 * @param rotulo elemento asociado al nodo.
 * @param anterior nodo anterior al que se crea.
 * @param siguiente nodo siguiente al que se crea.
 */
public Nodo(E rotulo, Nodo<E>anterior,Nodo<E>siguiente){
	         this.anterior=anterior;
	         this.rotulo=rotulo;
	         this.siguiente=siguiente;
                                                       }

public E element(){
	return rotulo;
                  }

/**
 * Retorna el nodo anterior.
 * @return nodo anterior.
 */
public Nodo<E> getAnterior(){
	 return anterior;
                     }

/**
 * Retorna el nodo siguiente.
 * @return nodo siguiente.
 */
public Nodo<E> getSiguiente(){
	  return siguiente;
                       }
/**
 * Actualiza el elemento asociado al nodo.
 * @param rot nuevo elemento.
 */
public void setElement(E rot){
	    rotulo=rot;
                  }
/**
 * Actualiza el nodo siguiente.
 * @param n nuevo siguiente.
 */
public void setSiguiente(Nodo<E>n){
	   siguiente=n;
                   }
/**
 * Acutaliza el nodo anterior.
 * @param n nuevo anterior.
 */
public void setAnterior(Nodo<E>n){
	    anterior=n;
                  }


}
