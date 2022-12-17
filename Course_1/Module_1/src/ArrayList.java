/**
 * Your implementation of an ArrayList.
 */
public class ArrayList<T> {
    /*
     * The initial capacity of the ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayList.
     * 
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayList() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the front of the list.
     *
     * This add may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null)
        {
            throw new java.lang.IllegalArgumentException("data cannot be null");
        }
        else
        {
            // Check if array limit is reached
            if (size == (backingArray.length))
            {
                T[] newbackingArray = (T[]) new Object[backingArray.length * 2];
                for(int i = 0; i < newbackingArray.length; ++i)
                {
                    if(i == 0)
                    {
                        newbackingArray[i] = data;
                        size++;
                    }
                    else if((i-1) < backingArray.length)
                    {
                        newbackingArray[i] = backingArray[i - 1];
                    }
                    else
                    {
                        newbackingArray[i] = null;
                    }
                }
                backingArray = newbackingArray;
            }
            else
            {
                T[] newbackingArray = (T[]) new Object[backingArray.length];
                for(int i = 0; i < newbackingArray.length; ++i)
                {
                    if(i == 0)
                    {
                        newbackingArray[i] = data;
                        size++;
                    }
                    else
                    {
                        newbackingArray[i] = backingArray[i-1];
                    }
                }
                backingArray = newbackingArray;
            }
        }
    }

    /**
     * Adds the data to the back of the list.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null)
        {
            throw new java.lang.IllegalArgumentException("data cannot be null");
        }         
        else
        {
            // Check if array limit reached
            if (size == (backingArray.length))
            {
                // Resize and add data
                T[] newbackingArray = (T[]) new Object[backingArray.length * 2];
                for(int i = 0; i < newbackingArray.length; ++i)
                {
                    if (i < backingArray.length)
                    {
                        newbackingArray[i] = backingArray[i];
                    }
                    else if(i == backingArray.length)
                    {
                        newbackingArray[i] = data;
                        size++;
                    }
                    else
                    {
                        newbackingArray[i] = null;
                    }
                }
                backingArray = newbackingArray;
            }
            else
            {
                // Add data at index size
                backingArray[size] = data;
                size ++;
            }
        }
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Do not shrink the backing array.
     *
     * This remove may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        T data = null;

        if(size == 0)
        {
            throw new java.util.NoSuchElementException("list is empty");
        }
        else
        {
            size--;
            data = backingArray[0];

            for(int i = 0; i < backingArray.length; ++i)
            {
                if(i < size)
                {
                    backingArray[i] = backingArray[i + 1];
                }
                else
                {
                    backingArray[i] = null;
                }
            }
        }

        return data;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Do not shrink the backing array.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        T data = null;

        if(size == 0)
        {
            throw new java.util.NoSuchElementException("list is empty");
        }
        else
        {
            size--;
            data = backingArray[size];
            backingArray[size] = null;
        }

        return data;
    }

    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    /**
     * Prints the elements of the list.
     * 
     * For JUnit Testing Purpose Only. Not to be submitted.
     * 
     * @return void
     */
    public void printBackingArray(){
        for(int i = 0; i < backingArray.length; i++)
        {
            System.out.println(backingArray[i]);
        }
    }

    /**
     * Returns size of backing array
     * 
     * For JUnit Testing Purpose Only. Not to be submitted.
     * 
     * @return length of backing array of list
     */
    public int getLengthOfBackingArray(){
        return backingArray.length;
    }

    /**
     * Returns an element of backing array at index pos
     * 
     * For JUnit Testing Purpose Only. Not to be submitted.
     * 
     * @param pos index to retrieve value from
     * @return data at element pos in the backing array
     */
    public T getElementOfBackingArray(int pos){
        T data = null;
        if(pos < backingArray.length)
        {
            data = backingArray[pos];
        }
        return data;
    }

    /**
     * Returns initial size of list
     * 
     * For JUnit Testing Purpose Only. Not to be submitted.
     * 
     * @return initial length of list
     */
    public int getInitialSizeOfList(){
        return INITIAL_CAPACITY;
    }
}