package TDAPILA;

public class LinkedStack<E> implements Stack<E> {
	
	private int size;
	private Nodo<E>last;

	public LinkedStack(){
		size=0;
		last=null;}

	public boolean isEmpty(){
		return size==0;}

	public int size(){
		return size;}

	public void push(E elem){
		Nodo<E>nuevo=new Nodo<E>(elem,last);
		last=nuevo;
		size++;}


	public E top()throws EmptyStackException{
		 if(isEmpty())
	      throw new EmptyStackException("la pila esta vacia:::::::Pila.top");
		 return last.getElemento();}

	public E pop()throws EmptyStackException{
		if(isEmpty())
		      throw new EmptyStackException("la pila esta vacia:::::::Pila.pop");
		E salida=last.getElemento();
		last=last.getSiguiente();
		size--;
		return salida;}	
	

}
