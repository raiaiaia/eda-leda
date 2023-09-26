package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.getData() == null;
	}

	@Override
	public int size() {
		int out = 0;
		if(!this.isEmpty()){
			SingleLinkedListNode<T> aux = getHead();
			while(!aux.isNIL()){
				out += 1;
				aux = aux.getNext();
			} 
		} 
		return out;
	}

	@Override
	public T search(T element) {
		T out = null;
		if(!this.isEmpty() && element != null){
			SingleLinkedListNode<T> aux = getHead();
			while(!aux.getNext().isNIL()){
				if(aux.getData().equals(element)) out = element;
				aux = aux.getNext();
			}
		}
		return out;
	}

	@Override
	public void insert(T element) {
		if(element != null){
			if(this.isEmpty()){
			this.head.setData(element);
			this.head.setNext(new SingleLinkedListNode<>());
			} else {
			SingleLinkedListNode<T> aux = getHead();
			while(!aux.getNext().isNIL()){
				aux = aux.getNext();
			}
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<>());
			aux.setNext(newNode);
			}
		}
	}

	@Override
	public void remove(T element) {
		if(!this.isEmpty() && element != null){
			SingleLinkedListNode<T> aux = getHead();

			//found element in single linked list
			int indexFound = -1;
			int j = 0;
			while(!aux.isNIL()){
				if(aux.getData().equals(element)){
					indexFound = j;
				}
				aux = aux.getNext();
				j++;
			}

			//element in first position
			if(indexFound == 0){
				if(this.size() == 1){
					this.head = new SingleLinkedListNode<T>();
				} else {
					this.head = aux.getNext();
				}	
			}

			//element in last position
			if(indexFound == this.size()-1) { 
				SingleLinkedListNode<T> node1 = getHead();
				int i = 0;
				while(i < this.size()-2){
					node1 = node1.getNext();
					i++;
				}										
				node1.setNext(new SingleLinkedListNode<>());

			} else {
				SingleLinkedListNode<T> node2 = getHead();
				int i = 0;
				while(i < indexFound){
					if(i == indexFound-1){
						node2.setNext(node2.getNext().getNext());
						node2.getNext().setNext(new SingleLinkedListNode<>());
					}
					node2 = node2.getNext();
					i++;
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] out = (T[]) new Comparable[this.size()];
		if(!this.isEmpty()){
			SingleLinkedListNode<T> aux = getHead();
			int index = 0;
			while(index < this.size()){
				out[index] = aux.getData();
				aux = aux.getNext();
				index++;
			}
		}
		return out;
	}

	public SingleLinkedListNode<T> getHead() {
		return this.head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}
}