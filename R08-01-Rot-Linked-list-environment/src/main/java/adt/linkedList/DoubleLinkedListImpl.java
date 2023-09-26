package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	
	public DoubleLinkedListImpl(){
		super.head = new DoubleLinkedListNode<T>();
		this.last = new DoubleLinkedListNode<>();
	}

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> nilNode = new DoubleLinkedListNode<T>();
		DoubleLinkedListNode<T> node = new DoubleLinkedListNode<T>(element, nilNode, nilNode);
		DoubleLinkedListNode<T> headNode = (DoubleLinkedListNode<T>) this.getHead();
		if(element != null && headNode != null){
			if(this.isEmpty()) {
				this.setHead(node);
				this.setLast(node);
			} else {		
				headNode.setPrevious(node);
				node.setNext(headNode);
				this.setHead(node);
			}	
		}
	}

	@Override
	public void removeFirst() {
		if(!isEmpty()){
			DoubleLinkedListNode<T> nilNode = new DoubleLinkedListNode<T>();
			DoubleLinkedListNode<T> headNode = (DoubleLinkedListNode<T>) this.getHead();
			DoubleLinkedListNode<T> newHead = (DoubleLinkedListNode<T>) headNode.getNext();
			if(newHead != null){
				newHead.setPrevious(nilNode);
				this.setHead(newHead);
			} else {
				this.setHead(nilNode);
				this.setLast(nilNode);
			}
		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()){
			DoubleLinkedListNode<T> nilNode = new DoubleLinkedListNode<T>();
			DoubleLinkedListNode<T> lastNode = (DoubleLinkedListNode<T>) this.getLast();
			DoubleLinkedListNode<T> newLast = (DoubleLinkedListNode<T>) lastNode.getPrevious();
			if(newLast != null){
				newLast.setNext(nilNode);
				this.setLast(newLast);
			} else {
				this.setHead(nilNode);
				this.setLast(nilNode);
			}
		}
	}

	@Override
	public void insert(T element){
		DoubleLinkedListNode<T> nilNode = new DoubleLinkedListNode<T>();
		DoubleLinkedListNode<T> lastNode = this.getLast();
		DoubleLinkedListNode<T> node = new DoubleLinkedListNode<T>(element, nilNode, lastNode);
		if(element != null && lastNode != null){
			if(isEmpty()){
				this.insertFirst(element);
			} else {
				lastNode.setNext(node);
				node.setPrevious(lastNode);
				this.setLast(node);
			}
		}
	}

	@Override
	public void remove(T element){
		DoubleLinkedListNode<T> auxNode = (DoubleLinkedListNode<T>) this.getLast();
		if(!this.isEmpty()){
			while(auxNode != null){
				if(auxNode.getData() != null && auxNode.getData().equals(element)){
					DoubleLinkedListNode<T> previousNode = auxNode.getPrevious();
					DoubleLinkedListNode<T> nextNode = (DoubleLinkedListNode<T>) auxNode.getNext();
					if(previousNode != null) previousNode.setNext(nextNode);
					else setHead(nextNode);

					if(nextNode != null) nextNode.setPrevious(previousNode);
					else setLast(previousNode);
				}

				auxNode = auxNode.getPrevious();
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
