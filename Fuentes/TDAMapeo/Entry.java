package TDAMapeo;

/**
 * Interfaz Entry modela los elementos de la que posee la extructura mapeo.
 * 
 * @author Juan Cruz Feuilles.
 *
 * @param <K> parámetro genérico.
 * @param <V> parámetro genérico.
 */

public interface Entry<K,V>{

/**
 * 	Retorna clave asociada a la entrada.
 * @return clave de la entrada.
 */
	
public K getKey();

/**
 * Retrona el valor aosociado a la entrada.
 * @return valor de la entrada.
 */

public V getValue();

/**
 *Actualiza la clave de la entrada. 
 */

public void setKey(K k);

/**
 *Actualiza el valor de la entrada. 
 */
public void setValue(V v);
	
}
