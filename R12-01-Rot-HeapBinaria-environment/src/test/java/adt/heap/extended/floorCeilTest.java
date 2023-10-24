package adt.heap.extended;

import static org.junit.Assert.*;
import java.util.Comparator;
import org.junit.*;
import adt.heap.ComparatorMaxHeap;
import adt.heap.ComparatorMinHeap;


public class floorCeilTest {
    
    FloorCeilHeapImpl test1;
    FloorCeilHeapImpl test2;

    @Before
    public void setUp() {
		Comparator<Integer> comparator = new ComparatorMaxHeap<Integer>();
        Comparator<Integer> comparator2 = new ComparatorMinHeap<Integer>();
        test1 = new FloorCeilHeapImpl(comparator);
        test2 = new FloorCeilHeapImpl(comparator2);
    }

    @Test
    public void testFloor() {
        Integer[] arrayTest = new Integer[] { 82, 6, 99, 12, 34, 64, 58, 1 };
        Integer[] arrayNull = null;
        assertEquals(6, test1.floor(arrayTest, 11), 0);
        assertEquals(82, test1.floor(arrayTest, 98), 0);
        assertEquals(null, test1.floor(arrayTest, -1));
        assertEquals(99, test1.floor(arrayTest, 100), 0);
        assertEquals(99, test1.floor(arrayTest, 500), 0);
        assertEquals(null, test1.floor(arrayTest, -10));
        assertEquals(34, test1.floor(arrayTest, 36), 0);
        assertEquals(34, test1.floor(arrayTest, 35), 0);
        assertEquals(null, test1.floor(arrayNull, 6));


        assertEquals(6, test2.floor(arrayTest, 10), 0);
        assertEquals(82, test2.floor(arrayTest, 98), 0);
        assertEquals(null, test2.floor(arrayTest, -500));
        assertEquals(99, test2.floor(arrayTest, 100), 0);
        assertEquals(99, test2.floor(arrayTest, 500), 0);
        assertEquals(null, test2.floor(arrayTest, -10));
        assertEquals(34, test2.floor(arrayTest, 36), 0);
        assertEquals(34, test2.floor(arrayTest, 35), 0);
        assertEquals(null, test2.floor(arrayNull, 6));
    }

    @Test
    public void ceil() {
        Integer[] arrayTest = new Integer[] { 82, 6, 99, 12, 34, 64, 58, 1 };
        Integer[] arrayNull = null;
        assertEquals(1, test1.ceil(arrayTest, 1), 0);
        assertEquals(null, test1.ceil(arrayNull, 6));
        assertEquals(null, test1.ceil(arrayTest, 100));
        assertEquals(6, test1.ceil(arrayTest, 2), 0);
        assertEquals(99, test1.ceil(arrayTest, 98), 0);

        assertEquals(null, test2.ceil(arrayNull, 6));
        assertEquals(null, test2.ceil(arrayTest, 100));
        assertEquals(6, test2.ceil(arrayTest, 5), 0);
        assertEquals(99, test2.ceil(arrayTest, 98), 0);
        
    }
}