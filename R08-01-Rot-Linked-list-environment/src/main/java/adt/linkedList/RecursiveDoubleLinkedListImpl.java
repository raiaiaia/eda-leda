package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insertFirst(T element) {
		if(element != null){
			RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<T>();
			newNode.setData(element);
			
			if(!this.isEmpty()){
				newNode.setData(this.getData());
				this.setData(element);
				newNode.setNext(this.getNext());
				this.setNext(newNode);
				newNode.setPrevious(this);
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(newNode);
			} else {
				this.insert(element);
			}
		
		}
	}


	@Override
	public void insert(T element){
		if(element != null){
			if(this.isEmpty()){
				RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<T>();
				this.setData(element);
				this.setNext(newNode);
				newNode.setPrevious(this);
			} else {
				getNext().insert(element);
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			if (this.getNext() != null) {
				RecursiveDoubleLinkedListImpl<T> nextNode = (RecursiveDoubleLinkedListImpl<T>) this.getNext();
				this.setData(nextNode.getData());
				this.setNext(nextNode.getNext());
				if (nextNode.getNext() != null) {
					((RecursiveDoubleLinkedListImpl<T>) nextNode.getNext()).setPrevious(this);
				}
			} else {
				RecursiveDoubleLinkedListImpl<T> nilNode = new RecursiveDoubleLinkedListImpl<T>();
				this.setData(nilNode.getData());
			}
		}
	
	}

	@Override
	public void removeLast() {
		RecursiveDoubleLinkedListImpl<T> nilNode = new RecursiveDoubleLinkedListImpl<>();
		if (!this.isEmpty()) {
			RecursiveDoubleLinkedListImpl<T> nextNode = (RecursiveDoubleLinkedListImpl<T>) this.getNext();
			if (nextNode != null) {
				if (nextNode.getNext().getData() != null) {
					nextNode.removeLast();
				} else {
					this.setNext(nilNode);
					nextNode.setPrevious(nilNode);
				}
			} else {
				this.setData(nilNode.getData());
			}	
		}
	}

	@Override
	public void remove(T element){
		if(element != null && !this.isEmpty()){
			if(this.getData().equals(element)){
				RecursiveDoubleLinkedListImpl<T> nextNode = (RecursiveDoubleLinkedListImpl<T>) this.getNext();
				RecursiveDoubleLinkedListImpl<T> nodePrevious = (RecursiveDoubleLinkedListImpl<T>) this.getPrevious();	
				
				if (nodePrevious != null) nodePrevious.setNext(nextNode);
				if (nextNode != null) nextNode.setPrevious(nodePrevious);
				
			} else {
				getNext().remove(element);
			} 
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
