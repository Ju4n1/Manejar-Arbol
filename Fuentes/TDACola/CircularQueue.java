package TDACola;
/**
 * Clase CirculaQueue implementa a la interfaz Queue usando un arreglo circular.
 * 
 * @author Juan Cruz Feuilles.
 *
 * @param <E> parámetro genérico de clase.
 */
public class CircularQueue<E> implements Queue<E> {
	/**
	 * Atributos de clase.
	 */
	private E[] cola;
	private int maxSize;
	private int rear;
	private int front;
	private int number;

/**
 * Crea una nueva cola usando un arreglo de una longitud expecifica.
 * @param maxSize tamaño máximo de arreglo.
 */
public CircularQueue(int maxSize){
	      this.maxSize=maxSize;
	      cola=(E[])new Object[maxSize];
	      number=0;
	      rear=0;
	      front=0;}
/**
 * Crea una nueva cola sin nesecidad de expecifica el tamañp.
 */
public CircularQueue(){
        	this(1000);}

public boolean isEmpty(){
	return number==0;}

public int size(){
	return number;}

public void enqueue(E item){
	if(number==cola.length)
		redimencionar();
	cola[rear]=item;
	rear=(rear+1)% cola.length;
	number++;}

public E front()throws EmptyQueueException{
	if(isEmpty())
		throw new EmptyQueueException("la cola esta vacia:::::::::::::cola.front()");
	return cola[front];}

public E dequeue()throws EmptyQueueException{
	if(isEmpty())
		throw new EmptyQueueException("la cola esta vacia::::::Cola.dequeue()");
	E salida=cola[front];
	cola[front]=null;
    front=(front+1)%cola.length;
    number--;
    return salida;}

/**
 * Redimenciona el arreglo que utiliza la cola circular.
 */
private void redimencionar(){
	   maxSize+=10;
	   E[]aux=(E[])new Object[maxSize];
	   for(int i=0;i<cola.length;i++)
		   aux[i]=cola[i];
	   cola=aux;
}

}



