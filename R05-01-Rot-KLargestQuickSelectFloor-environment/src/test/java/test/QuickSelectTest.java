package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import orderStatistic.QuickSelect;

public class QuickSelectTest {

    public QuickSelect<Integer> quickTest;
    private Integer[] array;
    
    @Before
    public void setUp(){
        this.quickTest = new QuickSelect<>();
		populaVetor(new Integer[] { 9, 1, -1, 3, 2, 10, 20, 5 });
    }

    public void populaVetor(Integer[] arrayPadrao) {
		this.array = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

    @Test
    public void test01(){
        assertEquals(1, quickTest.quickSelect(array, 2), 0);
    }
}