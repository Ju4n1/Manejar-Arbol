package Programa;

import TDAMapeo.*;
import TDAArbol.*;
import TDALista.*;
import TDACola.*;
import TDAPILA.*;


import java.util.Iterator;

/**
 * Clase Aplicacion Modela una alpicacion requerida para el proyecto de Estructuras de datos Uns.
 * 
 * @author Juan Cruz Feuilles.
 *
 */
public class Aplicacion {
/**
 * Atributo de clase.
 */
private Tree<Integer> t1;
/**
 * crea un nuevo árbol, con su raíz.	
 * @param root raíz.
 */
public Aplicacion(int root){
	  t1=new Arbol<Integer>();
      try{
    	 t1.createRoot(root); 
         }
      catch(InvalidOperationException e){System.out.println(e.getMessage());}
}


/**
 * Retorna el arbol que usa la aplicacion.
 * @return
 */
public Tree<Integer> getTree(){
	return t1;}

/**
 * Retorna un String con los elementos que pertenecen al árbol siguiendo un recorrido en Prerden.
 * @return String en prerden.
 */

public String preOrd(Tree<Integer>t){
	       
	       String salida="Preorden:";
	        
            for(Position<Integer>pos: t.positions())
            	      salida=salida+" "+pos.element();
	        
	        return salida;}

/**
 * Retorna un String que contiene los elementos del a´rbol siguiendo un recorrido en Posorden a partir de una lista.
 * @return String en posorden.
 */
public String posOrd(Tree<Integer>t){
	 
	  PositionList<Integer>list=new DoubleLinkedList<Integer>();
     try{
	  posAux(t,t.root(),list);}
     catch(EmptyTreeException e1){}
 
     String salida="Pos Orden: ";
     
     for(Integer pos: list)
    	 salida=salida+" "+pos;
     
return salida;}


/**
 * Ordena los elemento del árbol en una lista en posorden.
 * @param pos posicion en la cual inicia el recorrido, (la raiz).
 * @param list lista donde se almacenan los elemento es posorden.
 */
private void posAux(Tree<Integer>t,Position<Integer>pos,PositionList<Integer>list){
	    try{     
	        for(Position<Integer>p: t.children(pos))
	                  posAux(t,p,list);
	              list.addLast(pos.element()); 
	       }
	       
	    catch(InvalidPositionException e1){System.out.println(e1.getMessage());}
	                                                         }

/**
 * Retorna un sgring que contiene los elementos del árbol organizado en niveles.
 * @return String por niveles.
 */
public String nivel(Tree<Integer>t){
	    String salida="";
       
	    Queue<Position<Integer>>cola=new CircularQueue<Position<Integer>>();
	    try{
	    	cola.enqueue(t.root());
	    	cola.enqueue(null);
	    	Position<Integer> p=null;
	    	while(!cola.isEmpty()){
	    		   p=cola.dequeue();
	    		   if(p!=null)
	    		      {
	    			   salida=salida+" "+p.element();
	    		       for(Position<Integer>h: t.children(p))
	    		               cola.enqueue(h);}
	    		  else{
	    			   salida=salida+"\n";
	    		       if(!cola.isEmpty())
	    		    	   cola.enqueue(null);
	    		       } 
	    	                       }
	    	       
	    	   }
	    catch(EmptyTreeException e1){System.out.println(e1.getMessage());}
	    catch(EmptyQueueException e2){System.out.println(e2.getMessage());}
	    catch(InvalidPositionException e3){System.out.println(e3.getMessage());}
	    
	    
return salida;}


/**
 * Inserta un nuevo elemento al arbol.
 * @param rotP padre del elemento nuevo.
 * @param rotN rotulo del nuevo elemento, agregado como ultimo hijo del elemento de rotulo rotP.
 * @return verdadero si se puede agregar elemento y falso si no se puedo agregar el elemento al arbol.
 */

public void insertar(Integer rotP, Integer rotN)throws InvalidPositionException{
	           
	           Position<Integer>pos=getPosition(rotP);
               
	           if(pos==null)
                   throw new InvalidPositionException("La posicion no pertenece al arbol");
	          
	        
               t1.addLastChild(pos, rotN);
	        
}



/**
 * Dado un arbol retorna otro árbol correspondiente a su espejo multiplicado por un entero, este es un metodo del tipo cascarón, el problemas se resuelve en el metodo privado invocado dentro del mismo.
 * @param me enterpo por el cual se multiplican los rotulos.
 * @return nuevo arbol espejo multiplicado por me.
 */

public Tree<Integer> espejo(Integer me){
	Tree<Integer>t2= t2=new Arbol<Integer>();

	if(!t1.isEmpty())
	try{
	    
	       t2.createRoot(t1.root().element()*me);
          
		   espejoAux(me,t1,t2,t1.root(),t2.root());
	   }
	catch(EmptyTreeException e1){System.out.println(e1.getMessage());}
    catch(InvalidOperationException e2){System.out.println(e2.getMessage());}
		   
	    	
return t2;}	



/**
 * Metodo privado crea un nuevo arbol espejo cuyos rotulos son multiplos del entero me.
 * @param me entero por el cual se multiplican los rotulo del arbol t1.
 * @param t1 arbol original sobre el cual se quiere realizar el espejo multiplicado.
 * @param t2 nuevo arbol espejo multiplo (inicialmente vacio).
 * @param pos1 posicion del arbol original (inicialmente su raiz).
 * @param pos2 posicion del arbol nuevo(inicialmente su raiz).
 */
private void espejoAux(Integer me, Tree<Integer>t1,Tree<Integer>t2, Position<Integer>hT1,Position<Integer>hT2){
	       try{  
	    	   for(Position<Integer>p: t1.children(hT1)){
	    		     Position<Integer>hijo=  t1.addFirstChild(hT2,p.element()*me);
	    		      espejoAux(me,t1,t2,p,hijo);}
	    	   
	           }
	       catch(InvalidPositionException e1){System.out.println(e1.getMessage());}
	  
	       }



/**
 * Dados dos elementos del arbol se retorna su ancestro comun.
 * @param rot1 uno elementos del cual se quiere saber el ancestro comun.
 * @param rot2 uno elementos del cual se quiere saber el ancestro comun.
 * @return entero correspondiente al ancestro comun.
 * @throws InvalidPositionException se lanza en el caso de que algunos de los dos elementos no este en el arbol.
 */
public Integer AncestroComun(Integer rot1, Integer rot2)throws InvalidPositionException{
	           
	           Stack<Integer>pila1=new LinkedStack<Integer>();
	           Stack<Integer>pila2=new LinkedStack<Integer>();
	           Position<Integer>pos1=getPosition(rot1);
	           Position<Integer>pos2=getPosition(rot2);
	           Position<Integer>aux=null;
	           int alturaAux=0;
	           int altura1=0;
	           int altura2=0;
	           int salida=0;
	           
	           if(pos1==null)
	        	   throw new InvalidPositionException("la posicion correspondiente al primer rotulo es nula::::::::::AncestroCmun(rot1,rot2)");
	           if(pos2==null)
	        	   throw new InvalidPositionException("la posicion correspondiente al segundo rotulo es nula::::::::::AncestroCmun(rot1,rot2)");
	        
	      try{     
	          if(rot1==t1.root().element()||rot2==t1.root().element()) 
	                salida=t1.root().element();
	          if(rot1==rot2&&rot1!=t1.root().element())
	              salida=t1.parent(pos1).element();
	           
	          else{ 
	                altura1=profundidadNodo(rot1);
	                altura2=profundidadNodo(rot2);
	           
	           
                  if(altura1!=altura2)
                       if(altura1>=altura2)//Seasegura que a posicion de menor altura sea la pos1 si es nesecario las intercambia lo mismo hace con rot1 y rot2 y las alturas
                           {aux=pos1;
                            pos1=pos2;
                            pos2=aux;
                            alturaAux=altura1;
                            altura1=altura2;
                            altura2=alturaAux;
                            alturaAux=rot1;
                            rot2=rot1;
                            rot1=alturaAux;}
                         while(altura2!=altura1){
                               pila2.push(pos2.element());
                               try{
                                   pos2=t1.parent(pos2);}
                               catch(BoundaryViolationException e1){System.out.println(e1.getMessage());}
                               
                               altura2--;
                                        
                         }//ahora pos1 y pos2 estan a la misma altura.
                
               try{
                   if(pos1==t1.root()&&pos2==t1.root())
                	  salida=t1.root().element();
                   else
                	   
                        while(pos1!=pos2){  //tanto pos1 como pos2 no es igual a la raiz asi que puedo pedir sus padres
                               pila1.push(pos1.element());	
                               pila2.push(pos2.element());
                               pos1=t1.parent(pos1);
                               pos2=t1.parent(pos2);
                                         }
                           salida=pos1.element();// podria ser salida=pos1.element() ya que pos1 y pos2 son iguales a estal altura por tratarse de la posicion de su ancestro comun.
                              
                	 
                	           }
	          
           
               catch(BoundaryViolationException e3){System.out.println(e3.getMessage());}
	          }
	      }catch(EmptyTreeException e2){System.out.println(e2.getMessage());}
	      catch(BoundaryViolationException e3){System.out.println(e3.getMessage());}
              
return salida;}



	  
                                         
/**
 * Mapea los elementos del árbol usando sus rotulos como clave y el valor es la altura y profundidad del mismo.         
 * @return Mapeo de rotulos y altura,profundidad.
 */
public String altYprof(){
	   
	       Map<Integer,PositionList<Integer>>map=new MapeoConHashAbierto<Integer,PositionList<Integer>>();
	       
	       String salida="\n Entradas del mapeo en el formato Entrada=<Rotulo:r ,<Altura:a ,Profundidad:p >> \n";
	       
	  for(Position<Integer>pos: t1.positions()){
	    
		  try{
			  
	        map.put(pos.element(),new DoubleLinkedList<Integer>());
	        map.get(pos.element()).addLast(alturaNodo(pos.element()));
	        map.get(pos.element()).addLast(profundidadNodo(pos.element()));
	        
	          }
	    catch(InvalidKeyException e){System.out.println(e.getMessage());}
	          }
	  
	  for(Entry<Integer,PositionList<Integer>>en :map.entries()){
		try{  
		    salida=salida+"\n"+"<Rotulo: "+en.getKey()+","+"<Altura: "+en.getValue().first().element()+", Profundidad: "+en.getValue().next(en.getValue().first()).element()+" >>";
		 
		 
		}
		
		catch(EmptyListException e1){System.out.println(e1.getMessage());}
		catch(InvalidPositionException e2){System.out.println(e2.getMessage());}
		catch(BoundaryViolationException e3){System.out.println(e3.getMessage());}
	  }
	  
return salida;}






/**
 * Dado un rotulo retorna la posicion en la que se encuentra.
 * @param rot a buscar posicion.
 * @return posicion el nodo con rotolo rot.
 */

private Position<Integer> getPosition(Integer rot)throws InvalidPositionException{
	            Iterator<Position<Integer>>it=t1.positions().iterator();
	            Position<Integer>pos=null;
	            boolean encontre=false;
	            while(it.hasNext()&&!encontre){
	            	    pos=it.next();
	            	    if(rot.equals(pos.element()))
	            	          encontre=true;
	                                           }
	            if(!encontre)
	            	throw new InvalidPositionException("la posicion no pertenece al arbol:::::arbol.getPosition(pos)");
	            
return pos;}

/**
 * retorna la altura deñ árbol.
 * @return entero correspondiente a la altura del árbol.
 */
private Integer alturaArbol(){ 
	int pAux=0;
                for(Position<Integer>pos: t1.positions()){
              try{ 
                	if(t1.isExternal(pos))
                	      if(pAux< profundidadNodo(pos.element()))
                	    	    pAux=profundidadNodo(pos.element());
             
                   }
              catch(InvalidPositionException e1){System.out.println("la posicion no es valida");}
                		                                } 
                return pAux;}

/**
 * retorna la altura de un nodo.
 * @param rot rotulo del nodo.
 * @return entero correspondiente a la altura del nodo.
 */
private Integer alturaNodo(Integer rot){
          return alturaArbol()-profundidadNodo(rot);//profundidad nodo nunca va a ser mayor a la altura del árbol, altura será a lo sumo 0 pero nunca negativa	
}


/**
 * Retorna la profundidad de una nodo.
 * @param rot rotulo del nodo.
 * @return entero correspondiente a la profundidad del nodo.
 */
private Integer profundidadNodo(Integer rot){
	   Position<Integer>pos=null; 
	   try{       
	     pos=getPosition(rot);
	       }
	    catch(InvalidPositionException e){System.out.println(e.getMessage());}
	return profAux(pos);}



/**
 * Realiza la operacion recursiva de calcula la profundidad de un nodo.
 * @param pos posicion del nodo.
 * @return entero correspondiente a la altura del nodo.
 */
private Integer profAux(Position<Integer>pos){
	        
	        try{                                                                                                                                       if(t1.root().equals(pos))
	    	         return 0;
	            else return profAux(t1.parent(pos))+1;
	        	  
	          }
	        catch(EmptyTreeException e1){System.out.println(e1.getMessage());}
	        catch(BoundaryViolationException e2){System.out.println(e2.getMessage());}
	        catch(InvalidPositionException e3){System.out.println(e3.getMessage());}
return 0;}



}
