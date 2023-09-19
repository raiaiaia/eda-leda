package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(this.isFull()) throw new QueueOverflowException();
		if(isEmpty()){
			this.head = 0;
			this.tail = 0;
			this.array[0] = element;
		}
		if(!isFull()){
			int size = this.array.length;
			this.tail = (this.tail + 1) % size;
			this.array[this.tail] = element;
			this.elements++;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T resp;
		if(this.isEmpty()){
			throw new QueueUnderflowException();
		}else{
			resp = this.array[this.head];
			int size = this.array.length;
			this.head = (this.head + 1) % size;
			this.elements--;
		}
		return resp;
	}

	@Override
	public T head() {
		T resp;
		if(this.isEmpty()){
			resp = null;
		}else{
			int size = this.array.length-1;
			resp = this.array[(this.head + 1) % size];
		} 
		return resp;
	}

	@Override
	public boolean isEmpty() {
		return this.elements == 0;
	}

	@Override
	public boolean isFull() {
		return this.elements == this.array.length;
	}
}	