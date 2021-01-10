package com.mycompany.app;

import com.mycompany.app.Lock;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for Lock
 */
public class LockTest
{
    @Test
    public void testLock()
    {
        Lock lock = new Lock(6);

        assertEquals(true, lock.isLocked());

        assertEquals(true, lock.unlock(6));
        assertEquals(false, lock.isLocked());

        lock.lock();
        assertEquals(true, lock.isLocked());

        assertEquals(false, lock.unlock(1));
        assertEquals(true, lock.isLocked());
    }
}
