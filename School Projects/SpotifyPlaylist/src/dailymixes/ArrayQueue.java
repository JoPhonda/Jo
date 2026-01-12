// Project 4 Fall 2025
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Joseph Kim (906678863)
package dailymixes;

import queue.EmptyQueueException;
import queue.QueueInterface;

// -------------------------------------------------------------------------
/**
 * An ArrayQueue is a data structure that adds values at the end and removes
 * values from the front. Uses an array for its underlying structure.
 * 
 * @param <T>
 *            Generic value that is stored in ArrayQueue.
 * @author Jo
 * @version Nov 4, 2025
 */
public class ArrayQueue<T>
    implements QueueInterface<T>
{
    /**
     * Default Capacity is 20, represents the capacity if none is given in the
     * constructor.
     */
    public static final int DEFAULT_CAPACITY = 20;
    private T[] queue;
    private int dequeueIndex;
    private int size;
    private int enqueueIndex;

    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue()
    {
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        dequeueIndex = 0;
        enqueueIndex = 0;
        size = 0;
    }


    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     * 
     * @param c
     *            size of underlying queue array
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int c)
    {
        queue = (T[])new Object[c];
        dequeueIndex = 0;
        enqueueIndex = 0;
        size = 0;
    }


    // ----------------------------------------------------------
    /**
     * Takes in an index number and returns the next index. If index is the end,
     * returns 0.
     * 
     * @param index
     *            index inputed
     * @return the next index
     */
    private int incrementIndex(int index)
    {
        return ((index + 1) % queue.length);
    }


    // ----------------------------------------------------------
    /**
     * Doubles array length by adding all values into a new queue and setting
     * queue to the new one.
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity()
    {
        T[] newQueue = (T[])new Object[queue.length * 2];
        int oldIndex = dequeueIndex;
        for (int i = 0; i < queue.length; i++)
        {
            newQueue[i] = queue[oldIndex];
            oldIndex = incrementIndex(oldIndex);
        }
        queue = newQueue;
        dequeueIndex = 0;
        enqueueIndex = size;
    }


    // ----------------------------------------------------------
    /**
     * Removes the value at dequeueIndex, then moves dequeueIndex to the next
     * one.
     * 
     * @return the value removed
     */
    @Override
    public T dequeue()
    {
        if (size == 0)
        {
            throw new EmptyQueueException();
        }
        T item = queue[dequeueIndex];
        queue[dequeueIndex] = null;
        dequeueIndex = incrementIndex(dequeueIndex);
        size--;
        return item;
    }


    // ----------------------------------------------------------
    /**
     * Adds a value given, then increments size and enqueueIndex.
     * 
     * @param anEntry
     *            the value to be added
     */
    @Override
    public void enqueue(T anEntry)
    {
        if (isFull())
        {
            ensureCapacity();
        }
        queue[enqueueIndex] = anEntry;
        enqueueIndex = incrementIndex(enqueueIndex);
        size++;
    }


    // ----------------------------------------------------------
    /**
     * Returns the front, throws an EmptyQueueException if empty.
     * 
     * @return value at dequeueIndex
     */
    @Override
    public T getFront()
    {
        if (size == 0)
        {
            throw new EmptyQueueException();
        }
        return queue[dequeueIndex];
    }


    // ----------------------------------------------------------
    /**
     * Returns the size of the ArrayQueue.
     * 
     * @return size
     */
    public int getSize()
    {
        return size;
    }


    // ----------------------------------------------------------
    /**
     * Returns the length of the underlying array.
     * 
     * @return length of queue
     */
    public int getLengthOfUnderlyingArray()
    {
        return queue.length;
    }


    // ----------------------------------------------------------
    /**
     * Returns true if size is 0.
     * 
     * @return true if empty, false otherwise.
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }


    // ----------------------------------------------------------
    /**
     * Returns true if enqueue index is at the end.
     * 
     * @return true if full, false otherwise.
     */
    private boolean isFull()
    {
        return size == queue.length;
    }


    // ----------------------------------------------------------
    /**
     * Returns true if all values in the ArrayQueue is equal to the given
     * ArrayQueue.
     * 
     * @param obj
     *            the object compared to
     * @return true if all values of obj match, false otherwise.
     */
    public boolean equals(Object obj)
    {
        @SuppressWarnings("unchecked")
        ArrayQueue<T> a = (ArrayQueue<T>)obj;
        if (size != a.getSize() || size == 0)
        {
            return false;
        }
        int index = dequeueIndex;
        int otherIndex = a.dequeueIndex;
        for (int i = 0; i < size; i++)
        {
            if (!queue[index].equals(a.queue[otherIndex]))
            {
                return false;
            }
            index = incrementIndex(index);
            otherIndex = incrementIndex(otherIndex);
        }
        return true;
    }


    // ----------------------------------------------------------
    /**
     * Basically calls the constructor again.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear()
    {
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        dequeueIndex = 0;
        enqueueIndex = 0;
        size = 0;
    }


    // ----------------------------------------------------------
    /**
     * Returns an array representation of the underlying array.
     * 
     * @return string version of the array
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder("[");
        int index = dequeueIndex;
        for (int i = 0; i < size; i++)
        {
            s.append(queue[index]);
            if (index != enqueueIndex - 1)
            {
                s.append(", ");
                index = incrementIndex(index);
            }
        }
        return s + "]";
    }


    // ----------------------------------------------------------
    /**
     * Returns the underlying array non circularly.
     * 
     * @return underlying array normally
     */
    @SuppressWarnings("unchecked")
    public Object[] toArray()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        T[] array = (T[])new Object[size];
        int aIndex = 0;
        int index = dequeueIndex;
        while (index != enqueueIndex)
        {
            array[aIndex] = queue[index];
            index = incrementIndex(index);
            aIndex++;
        }
        return array;
    }
}
