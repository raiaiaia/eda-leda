package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	private void empilha(Stack<T> stack1, Stack<T> stack2) throws StackUnderflowException, StackOverflowException {
		while(!this.stack1.isEmpty()){
			T actual = this.stack1.pop();
			this.stack2.push(actual);
		}
	}

	private void desempilha(Stack<T> stack1, Stack<T> stack2) throws StackUnderflowException, StackOverflowException {
		while(!this.stack2.isEmpty()){
			T actual = this.stack2.pop();
			this.stack1.push(actual);
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()) throw new QueueOverflowException();
		try{
			this.stack1.push(element);
		}catch(StackOverflowException e){
			e.printStackTrace();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T resp = null;
		if(isEmpty()) throw new QueueUnderflowException();
		try{
			empilha(stack1, stack2);
			resp = this.stack2.pop();
			desempilha(stack1, stack2);
		}catch(StackOverflowException | StackUnderflowException e){
			e.printStackTrace();
		}
		return resp;
	}

	@Override
	public T head() {
		T resp = null;
		if(!this.isEmpty()){
			try{
				empilha(stack1, stack2);
				resp = this.stack2.top();
				desempilha(stack1, stack2);
			}catch(StackOverflowException | StackUnderflowException e){
				e.printStackTrace();
			}
		}
		return resp;
	}

	@Override
	public boolean isEmpty() {
		return this.stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.stack1.isFull();
	}

}
