package problems;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListMergeImpl<T extends Comparable<T>> implements LinkedListMerge<T> {

	public SingleLinkedListNode<T> merge(SingleLinkedListNode<T> node1, SingleLinkedListNode<T> node2) {
		SingleLinkedListNode<T> pointer1 = node1;
		SingleLinkedListNode<T> pointer2 = node2;
		
		SingleLinkedListNode<T> res = new SingleLinkedListNode<>();
		SingleLinkedListNode<T> aux = res;
	
		while(!pointer1.isNIL() && !pointer2.isNIL()){
			if(pointer1.getData().compareTo(pointer2.getData()) < 0){
				aux.setNext(pointer1);
				pointer1 = pointer1.getNext();
			} else {
				aux.setNext(pointer2);
				pointer2 = pointer2.getNext();
			}

			aux = aux.getNext();
		}

		while(!pointer1.isNIL()){
			aux.setNext(pointer1);
			pointer1 = pointer1.getNext();
			aux = aux.getNext();
		}

		while(!pointer2.isNIL()){
			aux.setNext(pointer2);
			pointer2 = pointer2.getNext();
			aux = aux.getNext();
		}

		aux.setNext(new SingleLinkedListNode<T>());
		res = res.getNext();
		
		return res;
	}



	public static void main(String[] args) {

		/* 
		SingleLinkedListNode<Integer> node1 = new SingleLinkedListNode<Integer>(1, null);
		SingleLinkedListNode<Integer> node3 = new SingleLinkedListNode<Integer>(3, null);
		SingleLinkedListNode<Integer> node5 = new SingleLinkedListNode<Integer>(5, null);
		SingleLinkedListNode<Integer> node7 = new SingleLinkedListNode<Integer>(7, null);
		SingleLinkedListNode<Integer> node9 = new SingleLinkedListNode<Integer>(9, null);

		SingleLinkedListNode<Integer> node2 = new SingleLinkedListNode<Integer>(2, null);
		SingleLinkedListNode<Integer> node4 = new SingleLinkedListNode<Integer>(4, null);
		SingleLinkedListNode<Integer> node6 = new SingleLinkedListNode<Integer>(6, null);
		SingleLinkedListNode<Integer> node8 = new SingleLinkedListNode<Integer>(8, null);
		SingleLinkedListNode<Integer> node10 = new SingleLinkedListNode<Integer>(10, null);

		LinkedListMergeImpl<Integer> teste = new LinkedListMergeImpl<Integer>();

		node1.setNext(node3);
		node3.setNext(node5);
		node5.setNext(node7);
		node7.setNext(node9);
		
		node2.setNext(node4);
		node4.setNext(node6);
		node6.setNext(node8);
		node8.setNext(node10);

		SingleLinkedListNode<Integer> out;

		out = teste.merge(node1, node2);

		System.out.println(out);

		*/
	}
}  