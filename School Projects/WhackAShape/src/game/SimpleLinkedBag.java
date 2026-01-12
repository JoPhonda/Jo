// Project 2 Fall 2025
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
import bag.Node;
import student.TestableRandom;

// -------------------------------------------------------------------------
/**
 *  Like SimpleArrayBag, SimpleLinkedBag can hold objects of any type, but
 *  with a Linked List and Nodes.
 *  @param <T> a generic of any type
 * 
 *  @author Jo
 *  @version Sep 28, 2025
 */
public class SimpleLinkedBag<T>
    implements SimpleBagInterface<T>
{
    private Node<T> firstNode;
    private int numberOfEntries;
    
    // ----------------------------------------------------------
    /**
     * Create a new SimpleLinkedBag object and set numberOfEntries to 0.
     */
    public SimpleLinkedBag() {
        firstNode = new Node<T>(null);
        numberOfEntries = 0;
    }
    // ----------------------------------------------------------
    /**
     * Adds an Object to the end of the bag.
     * @return True unless Object is null.
     */
    @Override
    public boolean add(T anEntry)
    {
        if (anEntry == null) {
            return false;
        }
        Node<T> newNode = new Node<T>(anEntry, firstNode);
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }
    // ----------------------------------------------------------
    /**
     * Returns the size of the bag.
     * @return Current size.
     */
    @Override
    public int getCurrentSize()
    {
        return numberOfEntries;
    }
    // ----------------------------------------------------------
    /**
     * Checks if the bag is empty.
     * @return If it was empty, boolean.
     */
    @Override
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }
    // ----------------------------------------------------------
    /**
     * Picks a random object in the bag.
     * @return The object.
     */
    @Override
    public T pick()
    {
        if (isEmpty()) {
            return null;
        }
        TestableRandom generator = new TestableRandom();
        int index = generator.nextInt(numberOfEntries);
        Node<T> currNode = firstNode;
        for (int i = 0; i < index; i++) {
            currNode = currNode.getNext();
        }
        return currNode.getData();
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
        if (getReferenceTo(anEntry) == null) {
            return false;
        }
        getReferenceTo(anEntry).setData(firstNode.getData());
        firstNode = firstNode.getNext();
        numberOfEntries--;
        return true;
    }
    // ----------------------------------------------------------
    /**
     * Returns the reference Node of a given T Object.
     * @param index The T Object.
     * @return The Node.
     */
    private Node<T> getReferenceTo(T anEntry) {
        boolean found = false;
        Node<T> currNode = firstNode;
        if (anEntry == null) {
            return null;
        }
        while (!found && currNode != null) {
            if (anEntry.equals(currNode.getData())) {
                found = true;
            }
            if (!found) {
                currNode = currNode.getNext();
            }
        }
        return currNode;
    }
}
