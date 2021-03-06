import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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

    @Test
    public void testRemoveByIndex() throws Exception {
        final LinkedList<String> testInstance = new LinkedList<>();
        testInstance.add("abc");
        testInstance.add("def");
        testInstance.add("ghi");
        testInstance.add("jkl");
        testInstance.add("mno");

        testInstance.remove(2);
        assertFalse(testInstance.isEmpty());
        assertTrue(testInstance.contains("abc"));
        assertTrue(testInstance.contains("def"));
        assertFalse(testInstance.contains("ghi"));
        assertTrue(testInstance.contains("jkl"));
        assertTrue(testInstance.contains("mno"));
        assertEquals(4, testInstance.size());
        testInstance.remove(1);
        assertTrue(testInstance.contains("abc"));
        assertFalse(testInstance.contains("def"));
        assertTrue(testInstance.contains("jkl"));
        assertTrue(testInstance.contains("mno"));
        assertEquals(3, testInstance.size());
    }

    @Test
    public void testSetFirstElement() throws Exception {
        final List<Integer> testInstance = new LinkedList<>();
        testInstance.add(20);
        testInstance.add(2);
        testInstance.add(3);
        testInstance.add(4);
        testInstance.add(5);

        assertEquals(20, (int)testInstance.set(0, 1));
        assertFalse(testInstance.isEmpty());
        assertFalse(testInstance.contains(20));
        for (int i = 1; i <= testInstance.size(); i++) {
            assertTrue(testInstance.contains(i));
        }
        assertFalse(testInstance.contains(6));
        assertEquals(1, (int)testInstance.get(0));

    }

    @Test
    public void testSetLastElement() throws Exception {
        final List<Integer> testInstance = new LinkedList<>();
        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);
        testInstance.add(4);
        testInstance.add(20);

        assertEquals(20, (int)testInstance.set(4, 5));
        assertFalse(testInstance.contains(20));
        assertFalse(testInstance.isEmpty());
        for (int i = 1; i <= testInstance.size(); i++) {
            assertTrue(testInstance.contains(i));
        }
        assertFalse(testInstance.contains(6));
        assertEquals(5, (int)testInstance.get(4));

    }

    @Test
    public void testSetVariousElement() throws Exception {
        final List<Integer> testInstance = new LinkedList<>();
        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(20);
        testInstance.add(4);
        testInstance.add(5);

        assertEquals(20, (int)testInstance.set(2, 3));
        assertFalse(testInstance.contains(20));
        assertFalse(testInstance.isEmpty());
        for (int i = 1; i <= testInstance.size(); i++) {
            assertTrue(testInstance.contains(i));
        }
        assertFalse(testInstance.contains(6));
        assertEquals(3, (int)testInstance.get(2));
    }

    @Test
    public void testSetWhenNeitherNextNorPreviousHaveBeenCalled() {
        final LinkedList<Integer> testInstance = new LinkedList<>();
        testInstance.add(1);

        final ListIterator<Integer> listIterator = testInstance.listIterator();

        try {
            listIterator.set(null);
            fail("set method do not throw IllegalStateException the if neither next nor previous have been called");
        } catch (final IllegalStateException e){}
    }

    @Test
    public void testSet() {
        final LinkedList<Integer> testInstance = new LinkedList<>();
        testInstance.add(1);

        final ListIterator<Integer> listIterator = testInstance.listIterator();
        listIterator.next();
        listIterator.set(2);
        assertEquals((Integer)2, testInstance.get(0));
    }

    @Test
    public void testPreviouseIndexWhenItEqualsTo1() {
        final LinkedList<Integer> testInstance = new LinkedList<>();
        testInstance.add(1);
        testInstance.add(1);

        final ListIterator<Integer> listIterator = testInstance.listIterator();
        listIterator.next();
        listIterator.next();

        assertEquals(1, listIterator.previousIndex());
    }

    @Test
    public void testPreviouseIndex() {
        final LinkedList<Integer> testInstance = new LinkedList<>();
        testInstance.add(1);

        final ListIterator<Integer> listIterator = testInstance.listIterator();
        listIterator.next();

        assertEquals(0, listIterator.previousIndex());
    }

    @Test
    public void testPreviouseIndexWhenEmptyCollection() {
        final LinkedList<Integer> testInstance = new LinkedList<>();

        final ListIterator<Integer> listIterator = testInstance.listIterator();

        assertEquals(-1, listIterator.previousIndex());
    }

    @Test
    public void testHasPreviouseWhenIteratorAtTheEndOfTheCollection() {
        final LinkedList<Integer> testInstance = new LinkedList<>();
        testInstance.add(1);
        testInstance.add(2);

        final ListIterator<Integer> listIterator = testInstance.listIterator();
        listIterator.next();

        assertTrue(listIterator.hasPrevious());
    }

    @Test
    public void testHasPreviouseWhenEmptyCollection() {
        final LinkedList<Integer> testInstance = new LinkedList<>();

        final ListIterator<Integer> listIterator = testInstance.listIterator();

        assertFalse(listIterator.hasPrevious());
    }

    @Test
    public void testPreviouseOnCollectionWithOneElement() {
        final LinkedList<Integer> testInstance = new LinkedList<>();
        testInstance.add(1);

        final ListIterator<Integer> listIterator = testInstance.listIterator();
        final Integer next = listIterator.next();
        final Integer previous = listIterator.previous();

        assertEquals(next, previous);
    }

    @Test
    public void testPreviouseWhenEmptyCollection() {
        final LinkedList<Integer> testInstance = new LinkedList<>();

        final ListIterator<Integer> listIterator = testInstance.listIterator();

        try {
            listIterator.previous();
            fail("list iterator do not throw the Exception when called previous method on empty collection");
        } catch (final java.util.NoSuchElementException e) {}
    }

    @Test
    public void testRemoveBeforeNext() throws Exception {
        final Collection<Integer> testInstance = new LinkedList<>();
        testInstance.add(2);

        final Iterator<Integer> iter = testInstance.iterator();
        try {
            iter.remove();
            fail("remove do not throw the Exception when called before next");
        } catch (final IllegalStateException e) {}
    }

    @Test
    public void testNextOnEmptyCollection() throws Exception {
        final Collection<Integer> testInstance = new LinkedList<>();
        testInstance.add(1);
        testInstance.add(2);

        final Iterator<Integer> iter = testInstance.iterator();
        iter.next();
        iter.remove();
        iter.next();
        iter.remove();
        try {
            iter.next();
            fail("next do not throw the Exception when no more ellements");
        } catch (final java.util.NoSuchElementException e) {}
    }

    @Test
    public void testRemoveTwoTimeInTheRow() throws Exception {
        final Collection<Integer> testInstance = new LinkedList<>();
        testInstance.add(1);
        testInstance.add(2);

        final Iterator<Integer> iter = testInstance.iterator();
        iter.next();
        iter.remove();
        assertEquals("Expected collection size is 1, however actual is not", 1, testInstance.size());
        try {
            iter.remove();
            fail("remove do not throw the Exception when called twice");
        } catch (final IllegalStateException e) {}
    }

    @Test
    public void testToArrayWhenInputArrayHaveSizeOne() throws Exception {
        final Collection<Integer> testInstance = new LinkedList<>();
        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);

        final Integer[] input = new Integer[1];

        final Integer[] result = testInstance.toArray(input);
        assertNotEquals(input, result);
        assertEquals((Integer)1, result[0]);
        assertEquals((Integer)2, result[1]);
        assertEquals((Integer)3, result[2]);
        assertEquals(3, result.length);
    }

    @Test
    public void testToArrayWhenInputArrayHaveCorrectSize() throws Exception {
        final Collection<Integer> testInstance = new LinkedList<>();
        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);

        final Integer[] input = new Integer[3];

        final Integer[] result = testInstance.toArray(input);
        assertEquals(input, result);
    }


}

