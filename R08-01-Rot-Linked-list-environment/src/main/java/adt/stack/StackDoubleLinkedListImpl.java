package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(isFull()) throw new StackOverflowException();
		if(element != null) this.top.insert(element);
	}

	@Override
	public T pop() throws StackUnderflowException {
		T res = null;
		if(isEmpty()) throw new StackUnderflowException();
		else res = ((DoubleLinkedListImpl<T>) this.top).getLast().getData();
		
		return res;
	}

	@Override
	public T top() {
		T res = null;
		if(!isEmpty()) res = ((DoubleLinkedListImpl<T>) this.top).getLast().getData();
		return res;
	}

	@Override
	public boolean isEmpty() {
		return this.top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.top.size() == size;
	}

}
