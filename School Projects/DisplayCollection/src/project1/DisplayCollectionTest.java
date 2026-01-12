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
package project1;
import student.TestCase;
import static org.junit.Assert.*;
import java.util.*;
import student.TestableRandom;
//-------------------------------------------------------------------------
/**
*  tests the collections
*  Follow it with additional details about its purpose, what abstraction
*  it represents, and how to use it.
* 
*  @author Jo
*  @version Sep 15, 2025
*/
public class DisplayCollectionTest extends TestCase
{
    // ----------------------------------------------------------
    /**
     * nothing lol
     */
    public void setUp()
    {
        //left empty intentionally
    }
    // ----------------------------------------------------------
    /**
     * tests if the bag contains one of the 4 possible strings
     */
    public void testBagContents() {
        DisplayCollection dc = new DisplayCollection(); 
        for (int i = 0; i < dc.getItemBag().getCurrentSize(); i++) {
            Object removed = dc.getItemBag().remove();
            assertTrue(removed.equals("red circle") || 
                removed.equals("blue circle") || 
                removed.equals("red square") ||
                removed.equals("blue square"));
            assertNotNull(removed);
            assertFalse(removed.equals("other thing"));
        }
    }
    // ----------------------------------------------------------
    /**
     * tests if the bag size can be from 5 to 15
     */
    public void testBagSize()
    {
        for (int i = 5; i <= 15; i++) {
            TestableRandom.setNextInts(i - 5);
            DisplayCollection dc = new DisplayCollection();
            assertEquals(dc.getItemBag().getCurrentSize(), i);
        }
    }
}
