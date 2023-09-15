package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		T resp;
		if(isEmpty()) resp = null;	
		else resp = this.array[0];
		return resp;
	}

	@Override
	public boolean isEmpty() {
		return tail == -1;
	}

	@Override
	public boolean isFull() {
		int size = this.array.length;
		return tail == (size-1);
	}

	private void shiftLeft() {
		for(int i=0; i <= tail; i++){
			this.array[i] = this.array[i+1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(this.isFull()){
			throw new QueueOverflowException();
		}else if (!this.isFull() && element != null){
			this.array[++this.tail] = element;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T resp;
		if(this.isEmpty()){
			throw new QueueUnderflowException();
		}else{
			resp = this.array[0];
			this.array[0] = null;
			this.shiftLeft();
		}
		return resp;
	}
}