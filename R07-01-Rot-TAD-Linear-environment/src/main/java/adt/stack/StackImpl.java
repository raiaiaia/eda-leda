package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		T result = null;
		if(!this.isEmpty()){
			result = this.array[this.top];	
		}
		return result;
	}	

	@Override
	public boolean isEmpty() {
		return this.top == -1;
	}

	@Override
	public boolean isFull() {
		int size = this.array.length;
		return this.top == (size -1);
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(this.isFull()){
			throw new StackOverflowException();
		}else{
			this.top += 1;
			this.array[this.top] = element;
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		T result = null;
		if(!this.isEmpty()){
			result = this.array[this.top];
			this.array[this.top] = null;
			this.top -= 1;	
		}else{
			throw new StackUnderflowException();
		}
		return result;
	}

}
