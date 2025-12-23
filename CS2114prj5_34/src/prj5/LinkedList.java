// Project 5 Fall 2025
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Zander Smith (906778164)
// LLM Statement:
// I have not used any assistance for the assignment beyond course resources and
// staff.
package prj5;

// -------------------------------------------------------------------------
/**
 * This is an implementation of a LinkedList data Structure with additional
 * private static classes LinkedListIterator and Node<T>. This will be used by
 * both the InfluencerCalculator to store Influencers, and the InFluencer to
 * store all MonthlyReports.
 * 
 * @param <T>
 * @author Zander Smith
 * @version Nov 16, 2025
 */
public class LinkedList<T>
{
    // ~ Fields ................................................................
    private int size;
    private Node<T> head;
    private Node<T> tail;

    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Create a new DLinkedList object with an initial size of zero and two
     * sentinel node head and tail.
     */
    public LinkedList()
    {
        size = 0;
        head = new Node<T>(null);
        tail = new Node<T>(null);
        head.setNext(tail);
    }


    // ----------------------------------------------------------
    /**
     * Returns head.
     * 
     * @return head
     */
    public Node<T> getHead()
    {
        return head;
    }


    // ----------------------------------------------------------
    /**
     * Returns tail.
     * 
     * @return tail
     */
    public Node<T> getTail()
    {
        return tail;
    }


    /**
     * Gets the current size of the list
     * 
     * @return the int value of the list's current occupancy
     */
    public int size()
    {
        return size;
    }


    // ----------------------------------------------------------
    /*
     * /** Create a new LinkedListIterator, which will assist in sorting
     * alongside the comparators
     * @return an iterator to be used for sorting public Iterator<T> iterator()
     * { return new LinkedListIterator<T>(); }
     */
    // ----------------------------------------------------------
    /**
     * Adds a new Node to the front of the list after head, then increases size
     * 
     * @param anEntry
     *            the data that will go into the new Node
     */
    public void add(T anEntry)
    {
        Node<T> newNode = new Node<T>(anEntry);
        newNode.setNext(head.getNext());
        head.setNext(newNode);
        size++;
    }


    // ----------------------------------------------------------
    /**
     * Affirm that the only two nodes in the list are head and tail
     * 
     * @return true if there are no nodes in the list besides head and tail
     */
    public boolean isEmpty()
    {
        return head.getNext() == tail;
    }


    // ----------------------------------------------------------
    /**
     * Finds the reference to a node at the given index
     * 
     * @precondition list is not empty
     * @param index
     *            the spot on the list we wish to retrieve the node
     * @return the data in the node at index if the list is not empty and the
     *             index is no greater than size. Return the head otherwise
     */
    public T getDataAtIndex(int index)
    {
        Node<T> temp = head.next;
        if (!isEmpty() && size >= index)
        {
            for (int i = 0; i < index; i++)
            {
                temp = temp.getNext();
            }
        }
        return temp.getData();
    }


    // ----------------------------------------------------------
    /**
     * Uses StringBuilder to show the contents of the list in order from head to
     * tail.
     * 
     * @return the String representation of the list in "{lastAdd -> firstAdd}"
     *             format where head and tail represent the brackets
     */
    public String toString()
    {
        StringBuilder str = new StringBuilder("{");
        if (!isEmpty())
        {
            Node<T> temp = head.getNext();
            while (temp != tail)
            {
                T element = temp.getData();
                str.append(element.toString());
                if (temp.getNext() != tail)
                {
                    str.append(", ");
                }
                temp = temp.getNext();
            }
        }
        str.append("}");
        return str.toString();
    }


    // ----------------------------------------------------------
    /**
     * Searches the list from head to tail for the given data
     * 
     * @precondition list is not empty
     * @param anEntry
     *            the data we're looking for
     * @return true if the desired data is within the list
     */
    public boolean contains(T anEntry)
    {
        return getIndexOf(anEntry) > 0;
    }


    /**
     * get the index of a node with the desired data
     * 
     * @precondition list is not empty
     * @param anEntry
     *            the data we want to get
     * @return the index of the entry
     */
    private int getIndexOf(T anEntry)
    {
        int confirm = -1;
        int index = 1;
        Node<T> temp = head.getNext();
        while (temp != tail)
        {
            if (temp.getData().equals(anEntry))
            {
                confirm = index;
            }
            temp = temp.getNext();
            index++;
        }
        return confirm;
    }

    /**
     * This represents a node in a singly linked list. This node stores data and
     * a pointer to the node after it in the list
     * 
     * @param <T>
     * @author Zander Smith
     * @version Nov 16, 2025
     */
    static class Node<T>
    {
        // Fields
        private T data;
        private Node<T> next;

        // Constructors
        /**
         * Constructor for when (size >= 1). Sets the data value and the
         * subsequent node.
         * 
         * @param entry
         *            the data that is stored in the node
         * @param subsequent
         *            the node after this node in the list
         */
        public Node(T entry, Node<T> subsequent)
        {
            setData(entry);
            setNext(subsequent);
        }


        /**
         * default constructor of a node for head and tail. Has no prev or next
         * reference
         * 
         * @param entry
         *            the value we are setting the data
         */
        public Node(T entry)
        {
            this(entry, null);
        }


        // Public Methods
        /**
         * changes the value of data to a new value
         * 
         * @param data
         *            the new value of the data field
         */
        public void setData(T data)
        {
            this.data = data;
        }


        /**
         * changes the designation of this node's subsequent node
         * 
         * @param newNext
         *            the new node that this node is placed before
         */
        public void setNext(Node<T> newNext)
        {
            this.next = newNext;
        }


        /**
         * getter for the values stored within a node
         * 
         * @return data, the Influencer in this node
         */
        public T getData()
        {
            return data;
        }


        /**
         * getter for the subsequent node in the chain
         * 
         * @return next, the node after this node
         */
        public Node<T> getNext()
        {
            return next;
        }
    }
}
