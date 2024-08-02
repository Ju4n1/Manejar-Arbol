package TDALista;

import java.util.*;
/**
 * Clase ElementIterator implementa Iterador. 
 * 
 * @author Juan Cruz feuilles
 *
 * @param <E> parámetro genérico de clase.
 */
public class ElementIterator<E> implements Iterator<E> {
	
/**
 * Atributos de clase.	
 */
private PositionList<E>list;
private Position<E>cursor;

/**
 * Crea un nuevo iterador a partir de una lista.
 * @param list de la cual crea el iterador.
 * @throws EmptyListException controla que la lista no este vacia.
 */

public ElementIterator(PositionList<E>list)throws EmptyListException{
                    this.list=list;
                    if(list.isEmpty())
                    	 cursor=null;
                    else cursor=list.first();}  
/**
 * Consulta si hay elemento en el cursor
 * @return  verdadero si cursor no es nulo y flaso cuando lo es.
 */
public boolean hasNext(){
return cursor!=null;}

/**
 *Retorna el elemento que se encuentra en el cursor del iterador en caso que este no sea nulo.
 * @return E elemento que se encuentra en el cursor del iterador.
 * @throws NoSuchElementException lanza dicha excepcion cuando el cursor es nulo.
 */
public E next()throws NoSuchElementException{
	               if(cursor==null)
	            	   throw new NoSuchElementException("no tiene siguiente");
	              E salida=cursor.element();
	               try{
	            	   if(cursor==list.last())
	            		   cursor=null;
	            	   else cursor=list.next(cursor);
	               }
	               catch(EmptyListException|InvalidPositionException|BoundaryViolationException e)
	               {e.printStackTrace();}
	
return salida;}


}
