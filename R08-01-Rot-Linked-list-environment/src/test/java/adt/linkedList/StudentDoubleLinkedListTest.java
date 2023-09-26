package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {

	private DoubleLinkedList<Integer> lista3;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		// Lista com 3 elementos.
		lista2.insert(3);
		lista2.insert(2);
		lista2.insert(1);
	}

	private void getImplementations() { 
		lista1 = new DoubleLinkedListImpl<Integer>();
		lista2 = new RecursiveDoubleLinkedListImpl<Integer>();
		lista3 = null;
	}

	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());


		((DoubleLinkedList<Integer>) lista2).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista2.toArray());
	}

	@Test
	public void testInsert(){
		((DoubleLinkedList<Integer>) lista1).insert(0);
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1, 0 }, lista1.toArray());

		((DoubleLinkedList<Integer>) lista2).insert(0);
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1, 0 }, lista2.toArray());
	}

	@Test
	public void testRemoveFirst() {
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());

		((DoubleLinkedList<Integer>) lista2).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista2.toArray());
	}

	@Test
	public void testRemoveLast() {
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());


		((DoubleLinkedList<Integer>) lista2).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista2.toArray());
	}
}