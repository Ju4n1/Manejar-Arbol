package TDALista;
import java.util.Iterator;


/**
 * Clase DoubleLinkedList implementa la Interfaz PositionList usando una lista doblemente enlazada con sentinelas.
 * @author Juan Cruz Feuilles.
 *
 * @param <E> parámetro genérico de clase.
 */
public class DoubleLinkedList<E> implements PositionList<E> {

	/*
	 * Atributos de clase.
	 */
private Nodo<E>head;
private Nodo<E>tail;
private int size;

/**
 * Crea una nueva Lista doblemente enlazada usando dos sentinelas dummys.
 */

public DoubleLinkedList(){
	 head=new Nodo(null,null,null);
	 tail=new Nodo(null,null,null);
	 head.setSiguiente(tail);
	 tail.setAnterior(head);
	 size=0;}

public int size(){
	       return size;}

public boolean isEmpty(){
	          return size==0;}


public Position<E> first()throws EmptyListException{
	   if(isEmpty())
	      throw new EmptyListException("La lista esta vacia:::::Lista.first()");
	   return head.getSiguiente();}


public Position<E> last()throws EmptyListException{
	   if(isEmpty())
		   throw new EmptyListException("La lista esta vacia::::Lista.last()");
	   return tail.getAnterior();}


public Position<E> prev(Position<E>pos)throws InvalidPositionException,BoundaryViolationException{
	              Nodo<E>nodo=checkPosition(pos);
	              if(nodo.getAnterior()==head)
	            	   throw new BoundaryViolationException("No se puede pedir anterior al nodo cabeza:::::Lista.prev(cabeza)");
	               
return nodo.getAnterior();}


public Position<E> next(Position<E>pos)throws InvalidPositionException,BoundaryViolationException{
	              Nodo<E>nodo=checkPosition(pos);
	              if(nodo.getSiguiente()==tail)
	            	  throw new BoundaryViolationException("No se puede pedir siguiente al nodo cola:::::Lista.next(cola)");

return nodo.getSiguiente();}
	             
	            	             
public void addFirst(E elem){
	   Nodo<E>nuevo=new Nodo<E>(elem,null,null);
	   nuevo.setAnterior(head);
	   nuevo.setSiguiente(head.getSiguiente());
	   head.getSiguiente().setAnterior(nuevo);
	   head.setSiguiente(nuevo);
       size++;             }



public void addLast(E elem){
	   Nodo<E>nuevo=new Nodo(elem,null,null);
	   nuevo.setSiguiente(tail);
	   nuevo.setAnterior(tail.getAnterior());
	   tail.getAnterior().setSiguiente(nuevo);
	   tail.setAnterior(nuevo);
	   size++;}


public void addBefore(Position<E>pos, E elem)throws InvalidPositionException{
	          
            Nodo<E>nodo=checkPosition(pos);
            Nodo<E>nuevo=new Nodo(elem,null,null);
           
            nuevo.setSiguiente(nodo);
            nuevo.setAnterior(nodo.getAnterior());
            nodo.getAnterior().setSiguiente(nuevo);
            nodo.setAnterior(nuevo);
            
           size++;}



public void addAfter(Position<E>pos, E elem)throws InvalidPositionException{
	       
	        Nodo<E>nodo=checkPosition(pos);
	        Nodo<E>nuevo=new Nodo<E>(elem,null,null);
	        
	        nodo.getSiguiente().setAnterior(nuevo);
	        nuevo.setSiguiente(nodo.getSiguiente());
	        nuevo.setAnterior(nodo);
	        nodo.setSiguiente(nuevo);
	        
	        size++;}





public E set(Position<E>pos, E elem)throws InvalidPositionException{
	          Nodo<E>nodo=checkPosition(pos);
	          if(isEmpty())
	        	  throw new InvalidPositionException("No se puede cambiar el rotulo de una posicion en una lista vacia:::::Lista.set(pos)");
	          E salida=nodo.element();
	          nodo.setElement(elem);
return salida;}



public E remove(Position<E>pos)throws InvalidPositionException{
	            
	            if(isEmpty())
	            	throw new InvalidPositionException("no puedo eliminar de una lista vacia:::::::Lista.remove(pos)");
	            Nodo<E>nodo=checkPosition(pos);
	            E salida=nodo.element();
	           
	            nodo.getAnterior().setSiguiente(nodo.getSiguiente());
	            nodo.getSiguiente().setAnterior(nodo.getAnterior());
	            nodo.setSiguiente(null);
	            nodo.setAnterior(null);
	            
	     	    size--;

return salida;}


public Iterator<E> iterator(){
	
	try{return new ElementIterator(this);}
	catch(EmptyListException e)
	     {e.printStackTrace();}
return null;}


public Iterable<Position<E>> positions(){
	  PositionList<Position<E>>list=new DoubleLinkedList<Position<E>>();
      
	  try{
		  if(!isEmpty()){
			   Position<E> p=first();
			   while(p!=null){
				  list.addLast(p);
				  p=next(p);
			                 }
		                 }
	     }
	  catch(InvalidPositionException e1){System.out.println(e1.getMessage());}
	  catch(BoundaryViolationException e2){System.out.println(e2.getMessage());}
	  catch(EmptyListException e3){System.out.println(e3.getMessage());}
	 
return list;}

/**
 * Chequea que una posicion no sea nula y la retorna.
 * @param pos posicion a chequear.
 * @return posicion no nula de la lista.
 * @throws InvalidPositionException lanza dicha excepción cuando la posicion es nula.
 */

private Nodo<E> checkPosition(Position<E>pos)throws InvalidPositionException{
	         
	         if(pos==null)
	        	 throw new InvalidPositionException("la posicion es nula::::Lista.checkPosition()");
	     try{
	         return (Nodo<E>)pos;}
	     
	     catch(ClassCastException e){new InvalidPositionException("La posicion no corresponde a una lista:::::CheckPosition(p)");}
	     
return null;}

}
