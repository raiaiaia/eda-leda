package adt.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentQueueUsingStackTest {

    public QueueUsingStack<Integer> queue1;
	public QueueUsingStack<Integer> queue2;
	public QueueUsingStack<Integer> queue3;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);

	}

	private void getImplementations() {
		queue1 = new QueueUsingStack<>(4);
		queue2 = new QueueUsingStack<>(2);
		queue3 = new QueueUsingStack<>(0);
	}

    @Test
	public void testHead(){
		assertEquals(new Integer(1), queue1.head()); 
	}
	
	@Test
	public void testHead02() throws QueueUnderflowException{
		queue1.dequeue();
		assertEquals(new Integer(2), queue1.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
	}

	@Test
	public void testIsFull02(){
		assertTrue(queue2.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			fail("Não deveria lançar exceção");
		}
	}

	@Test
	public void testEnqueue02() throws QueueUnderflowException{
		try{
			queue2.dequeue();
			queue2.enqueue(new Integer(5));
		}catch (QueueUnderflowException | QueueOverflowException e){
			fail("Não deveria lançar exceção");
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue1.enqueue(new Integer(4));
		queue1.enqueue(new Integer(5));
										
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			fail("Não deveria lançar exceção");
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue3.dequeue()); 
	}
}