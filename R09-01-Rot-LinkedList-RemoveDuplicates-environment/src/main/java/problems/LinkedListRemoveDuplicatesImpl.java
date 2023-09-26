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
        SingleLinkedListNode<T> aux1 = node;
        SingleLinkedListNode<T> aux2 = node;
        
        while(!aux1.isNIL()){
            aux2 = aux1.getNext();
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