package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(this.isFull()) throw new QueueOverflowException();		
		if(element != null)this.list.insert(element);
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T out = null;
		if(this.isEmpty()) throw new QueueUnderflowException();
		else{
			out = this.head();
			this.list.removeFirst();
		}
		return out;
	}

	@Override
	public T head() {
		T res = null;
		if(!isEmpty()) res = ((DoubleLinkedListImpl<T>) this.list).getHead().getData();
		return res;
	}

	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.list.size() == size;
	}

}
