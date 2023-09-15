package adt.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentCircularQueueTest {

    public CircularQueue<Integer> queue1;
	public CircularQueue<Integer> queue2;
	public CircularQueue<Integer> queue3;

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
		queue1 = new CircularQueue<>(4);
		queue2 = new CircularQueue<>(2);
		queue3 = new CircularQueue<>(0);
	}

    
    
}