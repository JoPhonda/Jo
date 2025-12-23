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

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * The test class for a LinkedList object and its Nodes. Iterator will be tested
 * alongside the InfluencerCalculator. Please be aware that most of this code
 * was borrowed from the SinglyLinkedListTest.java file from lab 09
 * 
 * @author Zander Smith
 * @version Nov 17, 2025
 */
public class LinkedListTest
    extends TestCase
{
    // ~ Fields ................................................................
    private LinkedList<String> list1;
    private LinkedList<String> emptyList;

    // ~ Constructors ..........................................................
    /**
     * The set up to create an emty list and a list full of Strings
     */
    public void setUp()
    {
        list1 = new LinkedList<String>();
        list1.add("apple");
        list1.add("banana");
        list1.add("mango");
        list1.add("kiwi");

        emptyList = new LinkedList<String>();
    }
    // ~Public Methods ........................................................


    /**
     * Tests that toString prints the desired output
     */
    public void testToString()
    {
        assertEquals("{kiwi, mango, banana, apple}", list1.toString());
    }


    // ----------------------------------------------------------
    /**
     * Tests add without an index as said in the comments below
     */
    public void testAdd()
    {
        assertEquals(0, emptyList.size());
        assertFalse(emptyList.contains("hi"));
        assertEquals("{}", emptyList.toString());

        emptyList.add("hi");

        assertTrue(emptyList.contains("hi"));
        assertEquals(1, emptyList.size());
        assertEquals("{hi}", emptyList.toString());
        assertEquals("hi", emptyList.getDataAtIndex(0));
        assertEquals("banana", list1.getDataAtIndex(2));
    }


    // ----------------------------------------------------------
    /**
     * Test to see if the list is empty
     */
    public void testIsEmpty()
    {
        assertTrue(emptyList.isEmpty());
        assertFalse(list1.isEmpty());
        String head = list1.getHead().getData();
        String tail = list1.getTail().getData();
        assertEquals(list1.getHead().getData(), head);
        assertEquals(list1.getTail().getData(), tail);
    }


    // ----------------------------------------------------------
    /**
     * Test the index methods.
     */
    public void testIndex()
    {
        assertTrue(emptyList.isEmpty());
        assertFalse(list1.isEmpty());
        String head = list1.getHead().getData();
        String tail = list1.getTail().getData();
        assertEquals(list1.getHead().getData(), head);
        assertEquals(list1.getTail().getData(), tail);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getDataAtIndex() method
     */
    public void testGetDataAtIndex()
    {
        assertNull(emptyList.getDataAtIndex(2));
    }


    // ----------------------------------------------------------
    /**
     * Tests the getIndexOf() method
     */
    public void testGetIndexOf()
    {
        assertTrue(list1.contains("banana"));
        assertFalse(list1.contains("strawberry"));
    }
}
