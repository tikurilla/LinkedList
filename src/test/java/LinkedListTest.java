import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

import static org.junit.Assert.*;


public class LinkedListTest {
    @Test
    public void testSizeWhenSizeIs0() throws Exception {
        final Collection<Integer> testInstance = new LinkedList<>();
        assertEquals(0, testInstance.size());
    }

    @Test
    public void testAdd() throws Exception {
        final Collection<Integer> testInstance = new LinkedList<>();
        testInstance.add(1);
        testInstance.add(1);

        assertEquals(2, testInstance.size());
        assertFalse(testInstance.isEmpty());
    }

    @Test
    public void testContains() throws Exception {
        final Collection<Integer> testInstance = new LinkedList<>();
        testInstance.add(1);
        testInstance.add(2);

        assertTrue(testInstance.contains(1));
        assertFalse(testInstance.contains(0));
    }

    @Test
    public void testRemoveFirstElement() throws Exception {
        final Collection<Integer> testInstance = new LinkedList<>();
        testInstance.add(1);
        testInstance.add(2);
        testInstance.remove(1);

        assertEquals(1, testInstance.size());
        assertFalse(testInstance.isEmpty());
    }

    @Test
    public void testRemoveLastElement() throws Exception {
        final Collection<Integer> testInstance = new LinkedList<>();
        testInstance.add(1);
        testInstance.add(2);
        testInstance.remove(2);

        assertEquals(1, testInstance.size());
        assertFalse(testInstance.isEmpty());
    }

    @Test
    public void testRemove() throws Exception {
        final Collection<Integer> testInstance = new LinkedList<>();
        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);
        testInstance.add(4);
        testInstance.add(5);
        testInstance.remove(3);

        assertEquals(4, testInstance.size());
        assertFalse(testInstance.isEmpty());
        assertFalse(testInstance.contains(3));
    }

    @Test
    public void testClear() throws Exception {
        final Collection<Integer> testInstance = new LinkedList<>();
        testInstance.add(1);
        testInstance.add(1);

        testInstance.clear();

        assertTrue(testInstance.isEmpty());
        assertFalse(testInstance.contains(1));
        assertEquals(0, testInstance.size());
    }
}
