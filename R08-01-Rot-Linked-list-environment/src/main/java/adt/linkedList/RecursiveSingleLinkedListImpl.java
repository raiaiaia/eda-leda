package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		return this.getData() == null;
	}

	@Override
	public int size() {
		int out = 0;
		if(!this.isEmpty()) out = 1 + this.getNext().size();
		return out;
	}

	@Override
	public T search(T element) {
		T out = null;
		if(!this.isEmpty() && element != null){
			if(this.data.equals(element)) out = element;
			else out = this.getNext().search(element);
		}
		return out;
	}

	@Override
	public void insert(T element) {
		if(element != null){
			if(this.isEmpty()){
				this.setData(element);
				this.setNext(new RecursiveSingleLinkedListImpl<>());
			}else this.getNext().insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if(!this.isEmpty() && element != null){
			if(this.getData().equals(element)){
				this.setData(null);
				this.setNext(next);
			} else this.getNext().remove(element); 
		}
	}

	@Override
	public T[] toArray() {
		T[] out = (T[]) new Comparable[this.size()];
		toArrayRecursive(out, 0);
		return out;
	}

	private void toArrayRecursive(T[] result, int index){
		if(!this.isEmpty()){
			result[index] = this.getData();
			this.getNext().toArrayRecursive(result, ++index);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}
}