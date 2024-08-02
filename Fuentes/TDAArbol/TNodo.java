package TDAArbol;

import TDALista.*;
/**
 * Calse TNodo implementa la Intefaz Position.
 * @author Juan cruz feuilles.
 *
 * @param <E> parámetro genérico de clase.
 */
public class TNodo<E> implements Position<E> {
/**
 * Atributos de clase.	
 */
protected TNodo<E> parent;
protected E rotulo;
protected PositionList<TNodo<E>>children;
/**
 * Crea un nuevo nodo.
 * @param item elemento asociado al nodo.
 * @param p padre del nodo creado.
 */
public TNodo(E item, TNodo<E>p){
	parent=p; rotulo=item;
	children=new DoubleLinkedList<TNodo<E>>();}
/**
 * Retorna el elmento asociado alnodo.
 * @return E rotulo del nodo
 */
public E element(){return rotulo;}

/**
 *Retorna un iterable de los hijos del nodo. 	
 * @return iterable de nodo hijos.
 */
public PositionList<TNodo<E>> getChildren(){return children;}

/**
 * Retorna el padre del nodo.
 * @return padre.
 */

public TNodo<E> getParent(){return parent;}
/**
 * Actualiza el rotulo del nodo.
 * @param item rotulo nuevo.
 */
public void setElement(E item){rotulo=item;}
/**
 * Actualiza el padre del nodo.
 * @param p padre nuevo.
 */
public void setParent(TNodo<E>p){parent=p;}

}