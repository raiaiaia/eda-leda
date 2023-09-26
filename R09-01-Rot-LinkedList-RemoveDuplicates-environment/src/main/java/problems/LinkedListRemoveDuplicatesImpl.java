package problems;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListRemoveDuplicatesImpl<T> implements LinkedListRemoveDuplicates<T>{

    /**
     * Restricoes extras:
     * - Você NÃO pode usar recursão
     * - Você pode criar métodos auxiliares se achar necessário, desde que sejam criados
     *   nesta classe
     */
    public void removeDuplicates(SingleLinkedListNode<T> node){
        SingleLinkedListNode<T> aux1 = (SingleLinkedListNode<T>) node.getData();
        SingleLinkedListNode<T> aux2 = (SingleLinkedListNode<T>) node.getNext().getData();
        
        while(!aux1.isNIL()){
            while(!aux2.isNIL()){
                if(aux2.equals(aux1)){
                    aux2.setData(aux2.getNext().getData());
                    aux2.setNext(aux2.getNext().getNext());
                } else {
                    aux2 = aux2.getNext();
                }
            }
            aux1 = aux1.getNext();
        }
    }
}