package TDAArbol;

import java.util.Iterator;


import TDALista.*;
/**
 * Clase Arbol impelenta la interfaz Tree usando nodos y lista de hijos.
 * 
 * @author Juan cruz Feuilles.
 *
 * @param <E> parámetro genérico de clase.
 */
public class Arbol<E> implements Tree<E> {
/**
 * Atributos de clase.
 */
private TNodo<E>root;
private int size;


/**
 * Crea una nuevo Arbol vacio y con raíz nula.
 */
public Arbol(){
	root=null;
	size=0;}



public int size(){
	       return size;}



public boolean isEmpty(){
	     return size==0;}



public Position<E> root()throws EmptyTreeException{
	  if(isEmpty())
		  throw new EmptyTreeException("una arbol vacio no tiene raiz::::::Arbol.root()");
return root;}



public Position<E> parent(Position<E>pos)throws InvalidPositionException,BoundaryViolationException{
	              
	               TNodo<E>nodo=checkPosition(pos);
	               if(isEmpty())
	            	   throw new BoundaryViolationException("no se puede pedri padre de un arbol vacio");
	               if(nodo==root)
	            	   throw new BoundaryViolationException("la posicion raiz no tiene padre::::::Arbol.parent(raiz)");
return nodo.getParent();}



public Iterable<Position<E>> children(Position<E>pos)throws InvalidPositionException{
	                        TNodo<E>nodo=checkPosition(pos);
	                        PositionList<Position<E>>list=new DoubleLinkedList<Position<E>>();
	                        for(TNodo<E>nod: nodo.getChildren())
	                        	            list.addLast(nod);
	                        
return list;}



public boolean isRoot(Position<E>pos)throws InvalidPositionException{
	           TNodo<E>nodo=checkPosition(pos);
	           
return nodo==root;}



public boolean isExternal(Position<E>pos)throws InvalidPositionException{
	           TNodo<E>nodo=checkPosition(pos);
	           
return nodo.getChildren().size()==0;}



public boolean isInternal(Position<E>pos)throws InvalidPositionException{
               TNodo<E>nodo=checkPosition(pos);	

return nodo.getChildren().size()!=0;}



public void createRoot(E elem)throws InvalidOperationException{
	                 if(!isEmpty())
	                	 throw new InvalidOperationException("no se puede crear una raiz si el arbol ya tiene una::::::::Arbol.createRoot(raiz)");
	
	                 TNodo<E>raiz=new TNodo<E>(elem,null);
	                 root=raiz;
	                 size=1;}



public Position<E> addFirstChild(Position<E>pos, E elem)throws InvalidPositionException{
	        TNodo<E>padre=checkPosition(pos);
	        TNodo<E>nuevo=new TNodo<E>(elem,padre);
            padre.getChildren().addFirst(nuevo);
            size++;
return nuevo;}



public Position<E> addLastChild(Position<E>pos, E elem)throws InvalidPositionException{
	               TNodo<E>padre=checkPosition(pos);
	               TNodo<E>nuevo=new TNodo<E>(elem,padre);
	               padre.getChildren().addLast(nuevo);
	               size++;
return nuevo;}



public Position<E> addBefore(Position<E>p, Position<E>rb, E e)throws InvalidPositionException{
	        TNodo<E>padre=checkPosition(p);
	        TNodo<E>hermano=checkPosition(rb);
	        
	        
	        
	        if(hermano.getParent()!=p)
	        	 throw new InvalidPositionException("la posicion RB no es hijo de la posicion Pos::::::::::::Arbol.addBefore(pos,rb,e)");
	        TNodo<E>hijo=new TNodo<E>(e,padre);
	        PositionList<TNodo<E>>hermanos=padre.getChildren();
	        try{
	        	Position<TNodo<E>>pos=hermanos.first();
	        	boolean seguir=true;
	        	while(seguir&&pos!=null){
	        		   if(pos.element()==hermano)
	        			    seguir=false;
	        		   else if(pos==hermanos.last())
	        			         pos=null;       
	        		   else pos=hermanos.next(pos);}
	        	hermanos.addBefore(pos,hijo);
	        	size++;
	        	
	           }
	        catch(EmptyListException e1){System.out.println(e1.getMessage());}
	        catch(BoundaryViolationException e2){System.out.println(e2.getMessage());}
return hijo;}



public Position<E> addAfter(Position<E>p, Position<E>lb,E elem)throws InvalidPositionException{
	               TNodo<E>padre=checkPosition(p);
	               TNodo<E>hermano=checkPosition(lb);
	               
	              
	               if(hermano.getParent()!=padre)
	            	    throw new InvalidPositionException("la posicion lb no es hijo de la posicion p:::::::Arbol.addAfter(p,lb,e)");
	               TNodo<E>nuevo=new TNodo(elem,padre);
	               try{ 
	            	   PositionList<TNodo<E>>hermanos=padre.getChildren();
	                   Position<TNodo<E>>pos=hermanos.first();
	                   boolean seguir=true;
	                   while(seguir&&pos!=null){
	                	     if(hermano!=pos.element())
	                	    	  if(pos!=hermanos.last())
	                	    		  pos=hermanos.next(pos);
	                	    	  else pos=null;
	                	     else {
	                	    	  hermanos.addAfter(pos,nuevo);
	                	    	  seguir=false;
	                	    	  size++;
	                	    	  
	                	          }
	                                           }
	                   if(pos==null&&!seguir)
	                	   throw new InvalidPositionException("la posicion pasada por parametros es invalida"); 
	            	   
	                  }
	               catch(BoundaryViolationException e1){}
	               catch(EmptyListException e2){}
return nuevo;}



public void removeExternalNode(Position<E>p)throws InvalidPositionException{
	         if(isEmpty())
	        	 throw new InvalidPositionException("no se puede eliminar de un árbol vacio");
             TNodo<E>nodo=checkPosition(p);

             if(!isExternal(p))
            	throw new InvalidPositionException("la posicion no corresponde a un nodo interno:::::Arbol.removeImternarNode(p)");
             if(nodo==root)
            	 {root=null; size--;}
             else
             try{
            	 PositionList<TNodo<E>>hermanos=nodo.getParent().getChildren();
            	 boolean esta=false;
            	 Position<TNodo<E>>pos=hermanos.first();
            	 while(!esta&&pos!=null){
            		    if(pos.element()!=nodo)
            		    	if(pos!=hermanos.last())
            		    		pos=hermanos.next(pos);
            		    	else{pos=null;}
            		    else{
            		    	esta=true;
            		    	nodo.setParent(null);
            		        hermanos.remove(pos);
            		        size--;}
            	                        }
                }
             catch(InvalidPositionException e1){}
             catch(EmptyListException e2){}
             catch(BoundaryViolationException e3){}
}



public void removeInternalNode(Position<E>p)throws InvalidPositionException{
	         
	         if(!isInternal(p))
	        	 throw new InvalidPositionException("la posicion no corresponde a un nodo interno::::::Arbol.removeInternalNode(p)");
	         TNodo<E>nodo=checkPosition(p);
	         try{
	        	 if(root==nodo&&nodo.getChildren().size()==1)
	        	     {root=nodo.getChildren().first().element();
	        	      root.setParent(null);}
	        	 else{
	        		  if(nodo==root)
	        		     throw new InvalidPositionException("no se puede eliminar un nodo interno con más de un hijo::::::Arbol.removeInternalNode(p)");
	        	      else{
	        	    	   TNodo<E>padre=nodo.getParent();
	        	    	   PositionList<TNodo<E>>hermanos=padre.getChildren();
	        	    	   Position<TNodo<E>>pos=hermanos.first();
	        	    	   boolean esta=false;
	        	    	   while(!esta&&pos!=null){
	        	    		     if(pos.element()!=nodo)
	        	    		    	 if(pos==hermanos.last())
	        	    		    		 pos=null;
	        	    		    	 else pos=hermanos.next(pos);
	        	    		     else esta=true;
	        	    	                           }
	        	    	   PositionList<TNodo<E>>hijos=nodo.getChildren();
	        	    	   for(TNodo<E>h: hijos){
	        	    		   hermanos.addBefore(pos,h);
	        	    		   h.setParent(padre);
	        	    	                        }
	        	    	   nodo.setParent(null);
	        	    	   hermanos.remove(pos);
	        	    	   size--;
	        	          }
	                  
	         
	         
	                }
	        	 
	         }
	         catch(EmptyListException e1){System.out.println(e1.getMessage());}
	         catch(BoundaryViolationException e2){System.out.println(e2.getMessage());}
	
}
	  




public void removeNode(Position<E>p)throws InvalidPositionException{
	        
	        /*Podría chequear que el arbol no este vacio, pero lo hace en el removeInternal y removeExternal
	          lo mismo ocurre con el checkPosition para ver que la posicion no sea nula.*/
	        	        
	        if(isInternal(p))
	        	 removeInternalNode(p);
	        else removeExternalNode(p);
	        
}



public E replace(Position<E>pos, E elem)throws InvalidPositionException{
	     TNodo<E>nodo=checkPosition(pos);
	     E salida=nodo.element();
	     nodo.setElement(elem);
return salida;}



public Iterable<Position<E>> positions(){
	           PositionList<Position<E>>list=new DoubleLinkedList<Position<E>>();
	           if(!isEmpty())
	              pre(root,list);
return list;}

private void pre(TNodo<E>n,PositionList<Position<E>>list){
	   
             list.addLast(n);
             for(TNodo<E>nod: n.getChildren())
                 pre(nod,list);}



public Iterator<E> iterator(){
	               PositionList<E>list=new DoubleLinkedList<E>();
	               for(Position<E>pos: positions())
	            		   list.addLast(pos.element());
	               try{
	            	   return new ElementIterator<E>(list);
	                  }
	               catch(EmptyListException e){e.printStackTrace();}
return null;}


/**
 * Checkea que una posicion del árbol no sea nula y que el mismo no esté vacio.
 * @param pos posicion a chequear.
 * @return Posicion no nula.
 * @throws InvalidPositionException lanza dicha excepcion si la posicion es nula.
 */
private TNodo<E> checkPosition(Position<E>pos)throws InvalidPositionException{
	             if(pos==null)
	            	 throw new InvalidPositionException("la posicion es nula::::::Arbol.checkPosition(pos)");
	             if(isEmpty())
	            	 throw new InvalidPositionException("el arbol esta vacio::::::Arbol.checkPosition(pos)");
	       try{
	             return (TNodo<E>)pos;
	          }
	       catch(ClassCastException e){new InvalidPositionException("la posicion no corresponde a una posicion de un arbol:::::Arbol.checkPosition(pos)");}
	       
return null;}

}
