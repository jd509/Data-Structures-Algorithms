import java.util.NoSuchElementException;

/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the front of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null)
        {
            throw new IllegalArgumentException("data cannot be null");
        }
        else
        {
            SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(data);
            if (size == 0)
            {
                head = newNode;
                tail = newNode;
            }
            else
            {
                newNode.setNext(head);
                head = newNode;
            }
            size ++;
        }
    }

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null)
        {
            throw new IllegalArgumentException("data cannot be null");
        }
        else
        {
            SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(data);
            if (size == 0)
            {
                head = newNode;
                tail = newNode;
            }
            else if(size == 1)
            {
                head.setNext(newNode);
                tail = newNode;
            }
            else
            {
                tail.setNext(newNode);
                tail = newNode;
            }
            size ++;
        }
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        T data = null;

        if (size == 0)
        {
            throw new NoSuchElementException("list is empty");
        }
        else if(size == 1)
        {
            data = head.getData();
            head = null;
            tail = null;
            size--;
        }
        else
        {
            data = head.getData();
            head = head.getNext();
            size--;
        }
        return data;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        T data = null;

        if (size == 0)
        {
            throw new NoSuchElementException("list is empty");
        }
        else if(size == 1)
        {
            data = tail.getData();
            head = null;
            tail = null;
            size--;
        }
        else
        {
            SinglyLinkedListNode<T> curr = head;
            data = tail.getData();

            while(curr.getNext().getNext() != null)
            {
                curr = curr.getNext();
            }
            tail = curr;
            tail.setNext(null);
            size--;
        }
        return data;
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
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
    public void printSll(){
        if(head != null)
        {
            SinglyLinkedListNode<T> curr = head;
            while(curr != null)
            {
                System.out.println(curr.getData());
                curr = curr.getNext();
            }
        }
        else
        {
            System.out.println("List is empty");
        }
    }
}