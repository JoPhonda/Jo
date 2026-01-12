// Project 1 Fall 2025
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Joseph Kim (906687763)

// LLM Statement:
//I have not used any assistance for the assignment beyond course resources and
// staff.
package game;

import bag.SimpleBagInterface;
import student.TestableRandom;

// -------------------------------------------------------------------------
/**
 *  Array Bag that can be used to hold objects of any type using an array.
 *  @param <T> a generic of any type
 * 
 *  @author Jo
 *  @version Sep 28, 2025
 */
public class SimpleArrayBag<T>
    implements SimpleBagInterface<T>
{
    private T[] bag;
    private static final int MAX = 18;
    private int numberOfEntries;
    // ----------------------------------------------------------
    /**
     * Create a new SimpleArrayBag object and set numberOfEntries to 0.
     */
    @SuppressWarnings("unchecked")
    public SimpleArrayBag() {
        bag = (T[]) new Object[MAX];
        numberOfEntries = 0;
    }
    @Override
    // ----------------------------------------------------------
    /**
     * Adds an Object to the end of the bag if the bag is not full.
     * @return True unless bag is full or Object is null.
     */
    public boolean add(T anEntry)
    {
        if (numberOfEntries >= MAX || anEntry == null) {
            return false;
        }
        bag[numberOfEntries] = anEntry;
        numberOfEntries++;
        return true;
    }

    @Override
    // ----------------------------------------------------------
    /**
     * Returns the size of the bag.
     * @return Current size.
     */
    public int getCurrentSize()
    {
        return numberOfEntries;
    }

    @Override
    // ----------------------------------------------------------
    /**
     * Checks if the bag is empty.
     * @return If it was empty, boolean.
     */
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }

    @Override
    // ----------------------------------------------------------
    /**
     * Picks a random object in the bag.
     * @return The object.
     */
    public T pick()
    {
        if (isEmpty()) {
            return null;
        }
        TestableRandom generator = new TestableRandom();
        int index = generator.nextInt(numberOfEntries);
        return bag[index];
    }
    // ----------------------------------------------------------
    /**
     * Removes the entry by setting it to the last entry and setting last to
     * null.
     * @param anEntry The entry that was removed.
     * @return True if removed, false if not found.
     */
    @Override
    public boolean remove(T anEntry)
    {
        int index = getIndexOf(anEntry);
        if (index <= -1) {
            return false;
        }
        bag[index] = null;
        bag[index] = bag[numberOfEntries - 1];
        bag[numberOfEntries] = null;
        numberOfEntries--;
        return true;
    }
    // ----------------------------------------------------------
    /**
     * Returns the index of a given T Object.
     * @param index The T Object.
     * @return The index.
     */
    private int getIndexOf(T index) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(index)) {
                return i;
            }
        }
        return -1;
    }
}
