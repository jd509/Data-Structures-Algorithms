import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayListJUnit {
    @Test
    public void testAddToBackNullData()
    {
        Throwable exception = assertThrows(
            IllegalArgumentException.class, ()-> {
                ArrayList<Integer> testArrayNull = new ArrayList<Integer>();
                testArrayNull.addToBack(null);
            }
        );

        assertEquals("data cannot be null", exception.getMessage());
    }

    @Test
    public void testAddToBackWithoutResize()
    {
        ArrayList<Integer> testArray = new ArrayList<Integer>();
        for(int i = 0; i < testArray.getInitialSizeOfList(); i++)
        {
            testArray.addToBack(i);
        }
        for(int i = 0; i < testArray.getInitialSizeOfList(); i++)
        {
            assertEquals(i, (int) testArray.getElementOfBackingArray(i));
        }
        assertEquals(testArray.getLengthOfBackingArray(), testArray.getInitialSizeOfList());
        assertEquals(testArray.size(), testArray.getInitialSizeOfList());
    }

    @Test
    public void testAddToBackWithResize()
    {
        ArrayList<Integer> testArray = new ArrayList<Integer>();
        int sizeAboveCapacity = 3;

        for(int i = 0; i < testArray.getInitialSizeOfList() + sizeAboveCapacity; i++)
        {
            testArray.addToBack(i);
        }
        for(int i = 0; i < testArray.getLengthOfBackingArray(); i++)
        {
            if (i < testArray.getInitialSizeOfList() + sizeAboveCapacity)
            {
                assertEquals(i, (int) testArray.getElementOfBackingArray(i));
            }
            else
            {
                assertEquals(null, testArray.getElementOfBackingArray(i));
            }
        }
        assertEquals(testArray.getLengthOfBackingArray(), testArray.getInitialSizeOfList() * 2);
        assertEquals(testArray.size(), testArray.getInitialSizeOfList() + sizeAboveCapacity);
    }

    @Test
    public void testAddToFrontNullData()
    {
        Throwable exception = assertThrows(
            IllegalArgumentException.class, ()-> {
                ArrayList<Integer> testArrayNull = new ArrayList<Integer>();
                testArrayNull.addToFront(null);
            }
        );

        assertEquals("data cannot be null", exception.getMessage());
    }

    @Test
    public void testAddToFrontWithoutResize()
    {
        ArrayList<Integer> testArray = new ArrayList<Integer>();
        for(int i = 0; i < testArray.getInitialSizeOfList(); i++)
        {
            testArray.addToFront(i);
        }
        for(int i = 0; i < testArray.getInitialSizeOfList(); i++)
        {
            assertEquals(testArray.getInitialSizeOfList()-i-1, (int) testArray.getElementOfBackingArray(i));
        }
        assertEquals(testArray.getLengthOfBackingArray(), testArray.getInitialSizeOfList());
        assertEquals(testArray.size(), testArray.getInitialSizeOfList());
    }

    @Test
    public void testAddToFrontWithResize()
    {
        ArrayList<Integer> testArray = new ArrayList<Integer>();
        int sizeAboveCapacity = 3;

        for(int i = 0; i < testArray.getInitialSizeOfList() + sizeAboveCapacity; i++)
        {
            testArray.addToFront(i);
        }
        for(int i = 0; i < testArray.getLengthOfBackingArray(); i++)
        {
            if (i < testArray.getInitialSizeOfList() + sizeAboveCapacity)
            {
                assertEquals(testArray.getInitialSizeOfList() + sizeAboveCapacity - i - 1, (int) testArray.getElementOfBackingArray(i));
            }
            else
            {
                assertEquals(null, testArray.getElementOfBackingArray(i));
            }
        }
        assertEquals(testArray.getLengthOfBackingArray(), testArray.getInitialSizeOfList() * 2);
        assertEquals(testArray.size(), testArray.getInitialSizeOfList() + sizeAboveCapacity);
    }

    @Test
    public void testRemoveFromFrontNullData()
    {
        Throwable exception = assertThrows(
            java.util.NoSuchElementException.class, ()-> {
                ArrayList<Integer> testArrayNull = new ArrayList<Integer>();
                int data = testArrayNull.removeFromFront();
            }
        );

        assertEquals("list is empty", exception.getMessage());
    }

    @Test
    public void testRemoveFromFront()
    {
        ArrayList<Integer> testArray = new ArrayList<Integer>();
        for(int i = 0; i < testArray.getInitialSizeOfList(); i++)
        {
            testArray.addToBack(i);
        }

        for(int i = 0; i < testArray.getInitialSizeOfList(); i++)
        {
            int data = testArray.removeFromFront();
            assertEquals(i, data);
        }
        assertEquals(0, testArray.size());

        for(int i = 0; i < testArray.getInitialSizeOfList() - 1; i++)
        {
            testArray.addToBack(i);
        }
        int initialSize = testArray.size();
        int firstElement = testArray.removeFromFront();        
        assertEquals(0, firstElement);
        assertEquals(initialSize-1, testArray.size());

        while(testArray.size() != 0)
        {
            assertNotEquals(null, testArray.removeFromFront());
        }
        int sizeAboveCapacity = 3;
        for(int i = 0; i < testArray.getInitialSizeOfList() + sizeAboveCapacity; i++)
        {
            testArray.addToBack(i);
        }
        for(int i = 0; i < testArray.getInitialSizeOfList(); i++)
        {
            int data = testArray.removeFromFront();
            assertEquals(i, data);
        }
        assertEquals(sizeAboveCapacity, testArray.size());
        testArray.addToBack(12);
        assertEquals(sizeAboveCapacity + 1, testArray.size());
    }

    @Test
    public void testRemoveFromBackNullData()
    {
        Throwable exception = assertThrows(
            java.util.NoSuchElementException.class, ()-> {
                ArrayList<Integer> testArrayNull = new ArrayList<Integer>();
                int data = testArrayNull.removeFromBack();
            }
        );

        assertEquals("list is empty", exception.getMessage());
    }

    @Test
    public void testRemoveFromBack()
    {
        ArrayList<Integer> testArray = new ArrayList<Integer>();
        for(int i = 0; i < testArray.getInitialSizeOfList(); i++)
        {
            testArray.addToBack(i);
        }

        for(int i = 0; i < testArray.getInitialSizeOfList(); i++)
        {
            int data = testArray.removeFromBack();
            assertEquals(testArray.getInitialSizeOfList() - i - 1, data);
        }
        assertEquals(0, testArray.size());

        for(int i = 0; i < testArray.getInitialSizeOfList() - 1; i++)
        {
            testArray.addToBack(i);
        }
        int initialSize = testArray.size();
        int lastElement = testArray.removeFromBack();        
        assertEquals(testArray.getInitialSizeOfList() - 2, lastElement);
        assertEquals(initialSize-1, testArray.size());

        while(testArray.size() != 0)
        {
            assertNotEquals(null, testArray.removeFromBack());
        }
        int sizeAboveCapacity = 3;
        for(int i = 0; i < testArray.getInitialSizeOfList() + sizeAboveCapacity; i++)
        {
            testArray.addToBack(i);
        }
        for(int i = 0; i < testArray.getInitialSizeOfList(); i++)
        {
            int data = testArray.removeFromBack();
            assertEquals(testArray.getInitialSizeOfList() + sizeAboveCapacity - i - 1, data);
        }
        assertEquals(sizeAboveCapacity, testArray.size());
        testArray.addToBack(12);
        assertEquals(sizeAboveCapacity + 1, testArray.size());
    }
}
