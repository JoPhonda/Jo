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

import student.TestCase;
import student.TestableRandom;
import org.junit.Assert.*;

// -------------------------------------------------------------------------
/**
 *  Tests the SimpleLinkedBag's methods, generic in this instance is string.
 * 
 *  @author Jo
 *  @version Sep 28, 2025
 */
public class SimpleLinkedBagTest extends TestCase
{
    private SimpleLinkedBag<String> bag;
    // ----------------------------------------------------------
    /**
     * Initializes the bag as a SimpleLinkedBag.
     */
    public void setUp() {
        bag = new SimpleLinkedBag<String>();
    }
    // ----------------------------------------------------------
    /**
     * Checks that adding null returns false.
     * Checks that adding an object returns true.
     */
    public void testAdd() {
        assertFalse(bag.add(null));
        assertTrue(bag.add("test"));
    }
    // ----------------------------------------------------------
    /**
     * Adds an object.
     * Checks that bag size is 1.
     * Checks that bag size is 0.
     */
    public void testGetCurrentSize() {
        bag.add("test");
        assertEquals(bag.getCurrentSize(), 1);
        assertNotSame(bag.getCurrentSize(), 0);
    }
    // ----------------------------------------------------------
    /**
     * Checks that bag is empty.
     * Adds an Object.
     * Checks that bag is not empty.
     */
    public void testIsEmpty() {
        assertTrue(bag.isEmpty());
        bag.add("test");
        assertFalse(bag.isEmpty());
    }
    
    // ----------------------------------------------------------
    /**
     * Checks that pick returns null.
     * Adds 2 Objects.
     * Sets the next 2 picks to be in order.
     * Checks that pick returns each one.
     */
    public void testPick() {
        assertNull(bag.pick());
        bag.add("test");
        bag.add("test2");
        TestableRandom.setNextInts(0, 1);
        assertTrue(bag.pick().equals("test2"));
        assertTrue(bag.pick().equals("test"));
    }
    // ----------------------------------------------------------
    /**
     * Adds an Object.
     * Checks that removing a different Object returns false.
     * Checks that removing the Object returns true.
     * Checks that removing a null returns false.
     */
    public void testRemove() {
        bag.add("test");
        assertFalse(bag.remove("test2"));
        assertTrue(bag.remove("test"));
        assertFalse(bag.remove(null));
    }
}
