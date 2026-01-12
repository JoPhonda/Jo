// Project 3 Fall 2025
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Joseph Kim (906687763)

// LLM Statement:
//I have not used any assistance for the assignment beyond course resources and
// staff.
package towerofhanoi;

import student.TestCase;
import org.junit.Assert.*;

// -------------------------------------------------------------------------
/**
 *  Tests the LinkedStack's methods, generic in this instance is Integer.
 * 
 *  @author Jo
 *  @version Oct 22, 2025
 */
public class LinkedStackTest extends TestCase
{
    private LinkedStack<Integer> stack;
    // ----------------------------------------------------------
    /**
     * Initializes the stack as a LinkedStack.
     */
    public void setUp() {
        stack = new LinkedStack<>();
    }
    
    // ----------------------------------------------------------
    /**
     * Checks that peeking an empty array throws an exception.
     */
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(10);
        assertFalse(stack.isEmpty());
    }

    // ----------------------------------------------------------
    /**
     * Checks that stack is empty.
     * Adds 2 items.
     * Checks that peek returns the correct item.
     * Checks that popping returns the correct item.
     * Checks that peek returns the next item.
     * Checks that size of the array returns 1.
     */
    public void testPushPopPeek() {
        assertTrue(stack.isEmpty());
        stack.push(10);
        stack.push(20);
        assertTrue(stack.peek().equals(20));
        assertTrue(stack.pop().equals(20));
        assertTrue(stack.peek().equals(10));
        assertEquals(stack.size(), 1);
    }

    // ----------------------------------------------------------
    /**
     * Checks that popping an empty array throws an exception.
     */
    public void testPopEmpty() {
        Exception thrown = null;
        try {
            stack.pop();
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
    }
    
    // ----------------------------------------------------------
    /**
     * Checks that peeking an empty array throws an exception.
     */
    public void testPeekEmpty() {
        Exception thrown = null;
        try {
            stack.peek();
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
    }

    // ----------------------------------------------------------
    /**
     * Adds 2 items.
     * Clears.
     * Checks that stack is now empty.
     * Checks that size is now 0.
     */
    public void testClear() {
        stack.push(1);
        stack.push(2);
        stack.clear();
        assertTrue(stack.isEmpty());
        assertEquals(stack.size(), 0);
    }

    // ----------------------------------------------------------
    /**
     * Adds 3 items.
     * Checks that the toString method returns the items in order 
     * in String form.
     */
    public void testToString() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals("[3, 2, 1]", stack.toString());
    }
}
