package TDAMapeo;

/**
 * Clase Entrada implementa interfaz Entry.
 * 
 * @author Juan Cruz Feuillles
 *
 * @param <K> par�metro gen�rico.
 * @param <V> par�metro gen�rico.
 */

public class Entrada<K,V> implements Entry<K,V>{

	
private K key;
private V value;


public Entrada(K key, V value){
	this.key=key;
	this.value=value;
                              }

public V getValue(){
	  return value;}

public K getKey(){
	  return key;}

public void setKey(K k){
	             key=k;}

public void setValue(V v){
	             value=v;}

}
