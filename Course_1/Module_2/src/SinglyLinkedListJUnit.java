import org.junit.Test;
import static org.junit.Assert.*;

public class SinglyLinkedListJUnit {
    @Test
    public void testAddToBackNullData()
    {
        Throwable exception = assertThrows(
            IllegalArgumentException.class, ()-> {
                SinglyLinkedList<Integer> testLinkedList = new SinglyLinkedList<Integer>();
                testLinkedList.addToBack(null);
            }
        );

        assertEquals("data cannot be null", exception.getMessage());
    }

    @Test
    public void testAddToBack()
    {
        SinglyLinkedList<Integer> testLinkedList = new SinglyLinkedList<Integer>();
        int linkedListCapacity = 10;
        for(int i = 0; i < linkedListCapacity; i++)
        {
            testLinkedList.addToBack(i);
        }
        assertEquals(linkedListCapacity, testLinkedList.size());
        assertEquals(0, (int) testLinkedList.getHead().getData());
        assertEquals(linkedListCapacity - 1, (int) testLinkedList.getTail().getData());
    }

    @Test
    public void testAddToFrontNullData()
    {
        Throwable exception = assertThrows(
            IllegalArgumentException.class, ()-> {
                SinglyLinkedList<Integer> testLinkedList = new SinglyLinkedList<Integer>();
                testLinkedList.addToFront(null);
            }
        );

        assertEquals("data cannot be null", exception.getMessage());
    }

    @Test
    public void testAddToFront()
    {
        SinglyLinkedList<Integer> testLinkedList = new SinglyLinkedList<Integer>();
        int linkedListCapacity = 10;
        for(int i = 0; i < linkedListCapacity; i++)
        {
            testLinkedList.addToFront(i);
        }
        assertEquals(linkedListCapacity, testLinkedList.size());
        assertEquals(linkedListCapacity - 1, (int) testLinkedList.getHead().getData());
        assertEquals(0, (int) testLinkedList.getTail().getData());
    }

    @Test
    public void testRemoveFromBackNullList()
    {
        Throwable exception = assertThrows(
            java.util.NoSuchElementException.class, ()-> {
                SinglyLinkedList<Integer> testLinkedList = new SinglyLinkedList<Integer>();
                testLinkedList.removeFromBack();
            }
        );

        assertEquals("list is empty", exception.getMessage());
    }

    @Test
    public void testRemoveFromBack()
    {
        SinglyLinkedList<Integer> testLinkedList = new SinglyLinkedList<Integer>();
        int linkedListCapacity = 0;
        int ret = Integer.MIN_VALUE;

        // Remove single element
        linkedListCapacity = 1;
        for(int i = 0; i < linkedListCapacity; i++)
        {
            testLinkedList.addToFront(i);
        }
        assertEquals(linkedListCapacity, testLinkedList.size());
        assertEquals(0, (int) testLinkedList.getHead().getData());
        assertEquals(0, (int) testLinkedList.getTail().getData());

        ret = testLinkedList.removeFromBack();
        assertEquals(0, ret);
        assertEquals(linkedListCapacity - 1, testLinkedList.size());

        // Remove multiple elements
        linkedListCapacity = 10;
        for(int i = 0; i < linkedListCapacity; i++)
        {
            if (i < linkedListCapacity / 2)
            {
                testLinkedList.addToBack(i);                
            }
            else
            {
                testLinkedList.addToFront(i);
            }
        }
        for(int i = 0; i < linkedListCapacity; i++)
        {
            ret = testLinkedList.removeFromBack();

            if (i < linkedListCapacity / 2)
            {
                assertEquals((linkedListCapacity / 2) - i - 1, ret);
            }
            else
            {
                assertEquals(i, ret);
            }
            assertEquals(linkedListCapacity - i - 1, testLinkedList.size());
        }
    }

    @Test
    public void testRemoveFromFrontNullList()
    {
        Throwable exception = assertThrows(
            java.util.NoSuchElementException.class, ()-> {
                SinglyLinkedList<Integer> testLinkedList = new SinglyLinkedList<Integer>();
                testLinkedList.removeFromFront();
            }
        );

        assertEquals("list is empty", exception.getMessage());
    }

    @Test
    public void testRemoveFromFront()
    {
        SinglyLinkedList<Integer> testLinkedList = new SinglyLinkedList<Integer>();
        int linkedListCapacity = 0;
        int ret = Integer.MIN_VALUE;

        // Remove single element
        linkedListCapacity = 1;
        for(int i = 0; i < linkedListCapacity; i++)
        {
            testLinkedList.addToFront(i);
        }
        assertEquals(linkedListCapacity, testLinkedList.size());
        assertEquals(0, (int) testLinkedList.getHead().getData());
        assertEquals(0, (int) testLinkedList.getTail().getData());

        ret = testLinkedList.removeFromFront();
        assertEquals(0, ret);
        assertEquals(linkedListCapacity - 1, testLinkedList.size());

        // Remove multiple elements
        linkedListCapacity = 10;
        for(int i = 0; i < linkedListCapacity; i++)
        {
            if (i < linkedListCapacity / 2)
            {
                testLinkedList.addToBack(i);                
            }
            else
            {
                testLinkedList.addToFront(i);
            }
        }
        for(int i = 0; i < linkedListCapacity; i++)
        {
            ret = testLinkedList.removeFromFront();
            
            if (i < linkedListCapacity / 2)
            {
                assertEquals(linkedListCapacity - i - 1, ret);
            }
            else
            {
                assertEquals(i - (linkedListCapacity / 2), ret);
            }
            assertEquals(linkedListCapacity - i - 1, testLinkedList.size());
        }
    }
}