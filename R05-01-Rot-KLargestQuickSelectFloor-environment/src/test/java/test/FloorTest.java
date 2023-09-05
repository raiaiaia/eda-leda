package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import problems.FloorBinarySearchImpl;

public class FloorTest {

    Integer[] vetorOrdenado;
    Integer[] vetorTest;
    Integer[] vetorNaoOrdenado;
    
    FloorBinarySearchImpl floorImpl;

    @Before
    public void setUp(){
        this.vetorOrdenado = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        this.vetorTest = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 10, 250};
        this.vetorNaoOrdenado = new Integer[]{10, 50, 30, 111, 20};
        this.floorImpl = new FloorBinarySearchImpl();
    }
    
    @Test
    public void testaFloor01(){
        assertEquals(9, floorImpl.floor(vetorOrdenado, 9), 0);
    }

    @Test
    public void testaFloor02(){
        assertNull(floorImpl.floor(vetorOrdenado, -1));
    }

    @Test
    public void testaFloor03(){
        assertEquals(8,floorImpl.floor(vetorTest, 9), 0);
    }

    @Test
    public void testaFloor04(){
        assertEquals(10, floorImpl.floor(vetorTest, 200), 0);
    }

    @Test
    public void testaFloor05(){
        assertNull(floorImpl.floor(vetorTest, -100));
    }

    @Test
    public void testaFloor06(){
        assertNull(floorImpl.floor(vetorNaoOrdenado, 9));
    }

    @Test
    public void testaFloor07(){
        assertEquals(10, floorImpl.floor(vetorNaoOrdenado, 19), 0);
    }

    @Test
    public void testaFloor08(){
        assertNull(floorImpl.floor(vetorNaoOrdenado, -1));
    }
}