package problems;

import adt.linkedList.SingleLinkedListNode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListRemoveDuplicatesTest {

    private SingleLinkedListNode<Integer> node1;
    private SingleLinkedListNode<Integer> node2;
    private SingleLinkedListNode<Integer> node3;
    private SingleLinkedListNode<Integer> node4;
    private SingleLinkedListNode<Integer> node5;
    private SingleLinkedListNode<Integer> node6;
    private SingleLinkedListNode<Integer> node7;
    private SingleLinkedListNode<Integer> nilNode;
    private SingleLinkedListNode<Integer> newNode;

    private LinkedListRemoveDuplicatesImpl<Integer> test;

    @Before
    public void setUp(){

        getImplementations();

        node1.setData(8);
        node1.setNext(node2);

        node2.setData(2);
        node2.setNext(node3);

        node3.setData(3);
        node3.setNext(node4);

        node4.setData(1);
        node4.setNext(node5);

        node5.setData(2);
        node5.setNext(node6);

        node6.setData(2);
        node6.setNext(node7);

        node7.setData(1);
        node7.setNext(nilNode);

        //8 2 3 1 2 2 1
        //8 2 3 1
    }

    public void getImplementations(){
        node1 = new SingleLinkedListNode<>();
        node2 = new SingleLinkedListNode<>();
        node3 = new SingleLinkedListNode<>();
        node4 = new SingleLinkedListNode<>();
        node5 = new SingleLinkedListNode<>();
        node6 = new SingleLinkedListNode<>();
        node7 = new SingleLinkedListNode<>();
        nilNode = new SingleLinkedListNode<>();

        test = new LinkedListRemoveDuplicatesImpl<>();
    }

    @Test
    public void testIsEmpty(){
        SingleLinkedListNode<Integer> aux = node1;
        boolean vazio = false;
        if(aux.isNIL()) vazio = true;
        Assert.assertFalse(vazio);
    }

    @Test
    public void testRemoveDuplicates(){
        SingleLinkedListNode<Integer> aux = node1;
        test.removeDuplicates(aux);    
        Assert.assertEquals(nilNode, node4.getNext());
    }

    @Test
    public void testNewNode(){
        SingleLinkedListNode<Integer> aux = node1;
        newNode = new SingleLinkedListNode<Integer>();

        newNode.setData(5);
        node7.setNext(newNode);
        newNode.setNext(nilNode);

        test.removeDuplicates(aux);
        Assert.assertEquals(newNode, node4.getNext());
    }
}