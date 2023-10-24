package orderStatistics;

import static org.junit.Assert.*;
import org.junit.*;
import adt.heap.*;
import orderStatistic.OrderStatisticsHeapImpl;

public class orderStatisticsTest {

    HeapImpl<Integer> heap;
    OrderStatisticsHeapImpl<Integer> order;

    @Before
    public void setUp() {
        order = new OrderStatisticsHeapImpl<Integer>();
    }
    
    @Test
    public void testOrderStatistics(){
        assertEquals(6, order.getOrderStatistics(new Integer[] { 82, 6, 99, 12, 34, 64, 58, 1 }, 2), 0);
        assertEquals(12, order.getOrderStatistics(new Integer[] { 82, 6, 99, 12, 34, 64, 58, 1 }, 3), 0);
        assertEquals(99, order.getOrderStatistics(new Integer[] { 82, 6, 99, 12, 34, 64, 58, 1 }, 8), 0);
        assertEquals(1, order.getOrderStatistics(new Integer[] { 82, 6, 99, 12, 34, 64, 58, 1 }, 1), 0);
        assertNull(order.getOrderStatistics(new Integer[] { 82, 6, 99, 12, 34, 64, 58, 1 }, 10));
    }
}