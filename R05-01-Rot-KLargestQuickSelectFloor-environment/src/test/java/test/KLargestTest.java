package test;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

import orderStatistic.KLargestOrderStatisticsImpl;

public class KLargestTest<T> {
 
    public KLargestOrderStatisticsImpl<Integer> kLargest;
    private Integer[] array;
    
    @Before
    public void setUp(){
        this.kLargest = new KLargestOrderStatisticsImpl<Integer>();
		this.array = new Integer[] { 9, 1, -1, 3, 2, 10, 20, 5 };
    }

    @Test
    public void test01(){
       assertArrayEquals(this.kLargest.getKLargest(this.array, 1), new Integer[] { 20 });
    }

    @Test
    public void test02(){
        assertArrayEquals(this.kLargest.getKLargest(this.array, 2), new Integer[] { 20, 10 });
    }

    @Test
    public void test03(){
        assertArrayEquals(this.kLargest.getKLargest(this.array, 4), new Integer[]{ 5, 9, 20, 10 });
    }

    @Test
    public void test04(){
        assertArrayEquals(this.kLargest.getKLargest(this.array,10), new Integer[]{ });
    }

    @Test
    public void test05(){
        assertArrayEquals(this.kLargest.getKLargest(array,-1), new Integer[]{ });
    }

    @Test
    public void test06(){
        assertArrayEquals(this.kLargest.getKLargest(this.array, 8), new Integer[] { -1, 1, 2, 3, 5, 9, 20, 10 } );
    }
}