package TDALista;

/**
 * Interfaz Position modela las Posiciones de una lista.
 * 
 * @author Juan Cruz Feuilles.
 *
 * @param <E> par�metro gen�rico de clase.
 */
public interface Position<E> {

/**
 * Retorna el elemento asociado a una posicion.
 * @return elemento que se encuentra en dicha posicion.
 */
public E element();

}
