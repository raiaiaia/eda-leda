package problems;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListMergeImpl<T extends Comparable<T>> implements LinkedListMerge<T> {

	public SingleLinkedListNode<T> merge(SingleLinkedListNode<T> node1, SingleLinkedListNode<T> node2) {
		SingleLinkedListNode<T> res = new SingleLinkedListNode<T>();
		SingleLinkedListNode<T> aux = res;

		if(!node1.isNIL() && !node2.isNIL()){
			recursiveMerge(node1, node2, aux);
		}

		return res.getNext();
	}

	private void recursiveMerge(SingleLinkedListNode<T> node1, SingleLinkedListNode<T> node2, SingleLinkedListNode<T> aux) {		
		if (!node1.isNIL() && !node2.isNIL()) {
			SingleLinkedListNode<T> next = getNext(node1, node2);
			aux.setData(next.getData());
			aux.setNext(next.getNext());
			aux = aux.getNext();
			recursiveMerge(node1, node2, aux);
		}
	}

	private SingleLinkedListNode<T> getNext(SingleLinkedListNode<T> node1, SingleLinkedListNode<T> node2) {
		SingleLinkedListNode<T> res;
		if(node1.isNIL() && node2.isNIL()){
			res = new SingleLinkedListNode<T>();
		} else {
			res = null;
		}

		return res;
	}
}