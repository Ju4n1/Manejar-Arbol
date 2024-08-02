package TDAMapeo;

import TDALista.*;
import java.util.Iterator;
/**
 * Clase MapeoConHashAbierto implementa interfaz Map usando una tabla hash abierto.
 * 
 * @author Juan cruz Feuilles
 *
 * @param <K> parámetro genérico.
 * @param <V> parámetro genérico
 */
public class MapeoConHashAbierto<K,V> implements Map<K,V> {
	/**
	 * Atributos de clase.
	 */
	private PositionList<Entry<K,V>>[]buckets;
	private int size;
	
	
/**
 * Crea un mapeo usando una tabla hash abierta.	
 * @param tam tamaño de la tabla hash.
 */
	
public MapeoConHashAbierto(int tam){
	       buckets=(PositionList<Entry<K,V>>[])new DoubleLinkedList[tam];
	       for(int i=0; i<buckets.length;i++)
	    	   buckets[i]=new DoubleLinkedList<Entry<K,V>>();
size=0;}

/**
 * Permite crear una mapeo con hash abierto sin nesecidad de expesificar el tamaño dela tabla.
 */

public MapeoConHashAbierto(){
	                this(29);}



public int size(){
	  return size;}



public boolean isEmpty(){
	      return size==0;}



public V put(K k, V v)throws InvalidKeyException{
	      
	       checkKey(k);
	       Entry<K,V>nueva=new Entrada<K,V>(k,v);
	       V salida=null;
	       int code=Math.abs(k.hashCode())%buckets.length;
	       
	       Iterator<Entry<K,V>>ItEn=buckets[code].iterator();
	       
	       Entry<K,V>en=null;
	       boolean esta=false;
	     
	       while(ItEn.hasNext()&&!esta){
	    	   en=ItEn.next();
	    	   if(k.equals(en.getKey()))
	    		   esta=true;}
	       if(esta)
	    	    {salida=en.getValue();
                 en.setValue(v);}
	       else {
	    	     buckets[code].addLast(nueva);
	             size++;}
	       
	       if(buckets[code].size()/buckets.length==0.25)
	    	   reHash();
	      	   
return salida;}



public V get(K key)throws InvalidKeyException{
	        checkKey(key);
	        V salida=null;
	        boolean esta=false;
	        Entry<K,V>en=null;
	        int code=Math.abs(key.hashCode())%buckets.length;
	        Iterator<Entry<K,V>>it=buckets[code].iterator();
	        
	        while(it.hasNext()&&!esta){
	        	  en=it.next();
	        	  if(en.getKey().equals(key))
	        	     {esta=true;
	        	     salida=en.getValue();}
	                                   }
return salida;}


public V remove(K key)throws InvalidKeyException{
	           checkKey(key);
	           V salida=null;
	           boolean esta=false;
	           Position<Entry<K,V>>en=null;
	           int code=Math.abs(key.hashCode())%buckets.length;
	           Iterator<Position<Entry<K,V>>>it=buckets[code].positions().iterator();
	           
	           while(it.hasNext()&&!esta){
	        	     en=it.next();
	        	     if(en.element().getKey().equals(key))
	        	         {
	        	    	 try{
	        	    	     esta=true;
	        	    	     salida=en.element().getValue();
	        	             buckets[code].remove(en);
	        	             size--;
	        	    	     }
	        	    	 catch(InvalidPositionException e1){System.out.println(e1.getMessage());}
	        	    	  }
	                                     }
	        	   
return salida;}


public Iterable<Entry<K,V>> entries(){
	   PositionList<Entry<K,V>>l=new DoubleLinkedList<Entry<K,V>>();
       
	   for(int i=0;i<buckets.length;i++)
		     for(Entry<K,V>e :buckets[i])
		    	           l.addLast(e);
	   
return l;}



public Iterable<K> keys(){
	  PositionList<K>k=new DoubleLinkedList<K>();

     for(int i=0;i<buckets.length;i++)
    	    for(Entry<K,V>e: buckets[i])
    		      k.addLast(e.getKey());
                                      	  
return k;}



public Iterable<V> values(){
       PositionList<V>v=new DoubleLinkedList<V>();
      
       for(int i=0;i<buckets.length;i++)
    	       for(Entry<K,V>e: buckets[i])
    	    	    v.addLast(e.getValue());
	
return v;}

/**
 * Chequea que una clave no sea nula.
 * @param key clave que se decear chechear.
 * @throws InvalidKeyException lanza dicha excepcion si la clave es nula.
 */

private void checkKey(K key)throws InvalidKeyException{
	        
	      if(key==null)
	        	throw new InvalidKeyException("la clave es nula");}


/**
 * Redimenciona la tabla hash re insertando todas sus entradas.
 */
private void reHash(){
	
	//Creo un buckets auxiliar.
	PositionList<Entry<K,V>>[]nuevo=(PositionList<Entry<K,V>>[])new DoubleLinkedList[buckets.length*2+1];
	
	//Inicializa el buckets auxiliar con listas de entradas vacias.
	for(int j=0;j<nuevo.length;j++)
	    nuevo[j]=new DoubleLinkedList<Entry<K,V>>();
	
	int cod;
	
	//inserta todas las entradas en el buckets auxiliar.
	
	for(int i=0;i<buckets.length;i++)
		for(Entry<K,V> e:buckets[i]){
			cod=Math.abs((e.getKey()).hashCode())%nuevo.length;
			nuevo[cod].addLast(e);}

//Ahora el buckets auxiliar es el buckets.	
buckets=nuevo;}


}
