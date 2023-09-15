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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T head() {
		return this.array[this.head];
	}

	@Override
	public boolean isEmpty() {
		return this.head == -1;
	}

	@Override
	public boolean isFull() {
		int size = this.array.length;
		return tail == (size-1);
	}

}
