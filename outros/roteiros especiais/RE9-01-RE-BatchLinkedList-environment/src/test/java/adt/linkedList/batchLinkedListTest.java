package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.linkedList.batch.BatchLinkedListImpl;
import util.GenericException;

public class batchLinkedListTest {

    DoubleLinkedListNode<Integer> node1;
    DoubleLinkedListNode<Integer> node2;
    DoubleLinkedListNode<Integer> node3;
    DoubleLinkedListNode<Integer> node4;
    DoubleLinkedListNode<Integer> nilNode;

    private BatchLinkedListImpl<Integer> impl;

    Integer[] listaElementos;

    @Before
    public void setUp(){
        getImplementations();

        node1.setData(3);
        node1.setNext(node2);
        node1.setPrevious(nilNode);

        impl.setHead(node1);

        node2.setData(9);
        node2.setNext(node3);
        node2.setPrevious(node1);

        node3.setData(4);
        node3.setNext(node4);
        node3.setPrevious(node2);

        node4.setData(2);
        node4.setNext(nilNode);
        node4.setPrevious(node3);
        impl.setLast(nilNode);
    }

    private void getImplementations(){
        node1 = new DoubleLinkedListNode<Integer>();
        node2 = new DoubleLinkedListNode<Integer>();
        node3 = new DoubleLinkedListNode<Integer>();
        node4 = new DoubleLinkedListNode<Integer>();
        nilNode = new DoubleLinkedListNode<Integer>();

        impl = new BatchLinkedListImpl<>();

        listaElementos = new Integer[] { 15, 28, 7, 11 };
    }


    @Test
    public void test01() throws GenericException{
        DoubleLinkedListNode<Integer> aux = (DoubleLinkedListNode<Integer>) impl.getHead();
        impl.inserirEmBatch(2, listaElementos);

        Assert.assertTrue(aux.getData() == 3);
        Assert.assertTrue(aux.getNext().getData() == 9);
        Assert.assertTrue(aux.getNext().getNext().getData() == 15);
        
        for(int i=0; i < 2; i++) {
            System.out.println(aux.getData());
            aux = (DoubleLinkedListNode<Integer>) aux.getNext();
        }

        Assert.assertTrue(aux.getData() == 15);
        Assert.assertTrue(impl.getHead().getData() == 3);
        Assert.assertTrue(impl.getLast().getData() == null);
    }
}