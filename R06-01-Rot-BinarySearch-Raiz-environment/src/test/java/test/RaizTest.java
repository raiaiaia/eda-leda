package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import problems.RaizImpl;

public class RaizTest {
    
    private RaizImpl impl;


    @Before
    public void setUp(){
        this.impl = new RaizImpl();
    }

    @Test
    public void test01(){
        int num = 2;
        double res = 1.4375;
        assertEquals(this.impl.raiz(num, 2, 0.1), res, 0);
    }

    @Test
    public void test02(){
        int num = 9;
        double res = 3.00146484375;
        assertEquals(this.impl.raiz(num, 2, 0.01), res, 0);
    }
}