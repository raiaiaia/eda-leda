package problems;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListMergeImpl<T extends Comparable<T>> implements LinkedListMerge<T> {

	public SingleLinkedListNode<T> merge(SingleLinkedListNode<T> node1, SingleLinkedListNode<T> node2) {
		SingleLinkedListNode<T> aux1 = node1;
		SingleLinkedListNode<T> aux2 = node2;
		SingleLinkedListNode<T> res = new SingleLinkedListNode<>();
		
		if(!node1.isNIL() || !node2.isNIL()){
			while(!aux1.isNIL() && !aux2.isNIL()){
				//node from the first list is bigger than the second list
				if(aux1.getData().compareTo(aux2.getData()) > 0){
					SingleLinkedListNode<T> auxTemp = aux2.getNext();
					node2.setNext(node1);
					res = node2;
					//node1.setNext(auxTemp);
				}
				//node from the first list is smaller than the second list
				if(aux1.getData().compareTo(aux2.getData()) < 0){
					SingleLinkedListNode<T> auxTemp = aux1.getNext();
					node1.setNext(node2);
					res = node2;
				}
				aux1 = aux1.getNext();
				aux2 = aux2.getNext();
			}
		}
		return res;
	}
}


// 2 4 6 8 10
// 1 3 5 7 9

// 1 3 5 7 9
// 2 4 6 8 10


//1 2  