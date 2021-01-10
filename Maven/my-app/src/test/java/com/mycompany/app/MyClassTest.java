package com.mycompany.app;

import com.mycompany.app.MyClass;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for MyClass
 */
public class MyClassTest
{
    @Test
    public void testKey()
    {
        MyClass myClass = new MyClass();

        myClass.setId(2);
        myClass.setSecret(3);
        myClass.setName("My Secret Key");

        assertEquals(myClass.calculateKey().intValue(), 6);
    }
}
