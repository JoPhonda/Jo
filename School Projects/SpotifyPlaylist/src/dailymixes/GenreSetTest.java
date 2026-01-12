// Project 4 Fall 2025
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Joseph Kim (906678863)
package dailymixes;

import org.junit.Assert.*;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests the GenreSet class.
 * 
 * @author Jo
 * @version Nov 9, 2025
 */
public class GenreSetTest
    extends TestCase
{
    private GenreSet genre;
    private GenreSet genreEqual;
    private GenreSet pop;
    private GenreSet rock;
    private GenreSet country;
    private GenreSet min;
    private GenreSet max;

    // ----------------------------------------------------------
    /**
     * Creates three new GenreSet objects.
     */
    public void setUp()
    {
        genre = new GenreSet(30, 30, 30);
        genreEqual = new GenreSet(30, 30, 30);
        pop = new GenreSet(50, 30, 30);
        rock = new GenreSet(30, 50, 30);
        country = new GenreSet(30, 30, 50);
        min = new GenreSet(20, 20, 20);
        max = new GenreSet(40, 40, 40);
    }


    // ----------------------------------------------------------
    /**
     * Checks that genre returns 0 if equal to another genre. Checks that genre
     * returns -1 if less than to another genre. Checks that genre returns 1 if
     * greater than another genre.
     */
    public void testCompareTo()
    {
        assertEquals(0, genre.compareTo(genreEqual));
        assertTrue(genre.compareTo(max) < 0);
        assertTrue(genre.compareTo(min) > 0);
    }


    // ----------------------------------------------------------
    /**
     * Checks that genre is equal to another genre with equal values. Checks
     * that genre is not equal to another genre if pop, rock, or country is
     * different.
     */
    public void testEquals()
    {
        assertTrue(genre.equals(genreEqual));
        assertFalse(genre.equals(pop));
        assertFalse(genre.equals(rock));
        assertFalse(genre.equals(country));
    }


    // ----------------------------------------------------------
    /**
     * Checks that isLessThanOrEqualTo returns false if any of the three
     * percentages is greater than one of genre's. Checks that it returns true
     * if they are all less than or equal to genre.
     */
    public void testIsLessThanOrEqualTo()
    {
        assertFalse(genre.isLessThanOrEqualTo(min));
        assertFalse(pop.isLessThanOrEqualTo(genre));
        assertFalse(rock.isLessThanOrEqualTo(genre));
        assertFalse(country.isLessThanOrEqualTo(genre));
        assertTrue(min.isLessThanOrEqualTo(genre));
    }


    // ----------------------------------------------------------
    /**
     * Checks that genre is within the range 20-40 for all values, and that if
     * one is greater or less than that range for either category, return false.
     */
    public void testIsWithinRange()
    {
        assertTrue(genre.isWithinRange(min, max));
        assertFalse(pop.isWithinRange(min, max));
        assertFalse(rock.isWithinRange(min, max));
        assertFalse(country.isWithinRange(min, max));
        pop = new GenreSet(10, 30, 30);
        rock = new GenreSet(30, 10, 30);
        country = new GenreSet(30, 30, 10);
        assertFalse(pop.isWithinRange(min, max));
        assertFalse(rock.isWithinRange(min, max));
        assertFalse(country.isWithinRange(min, max));
    }


    // ----------------------------------------------------------
    /**
     * Checks that the toString method returns in the correct order.
     */
    public void testToString()
    {
        String str = genre.toString();
        assertTrue(str.contains("Pop:30 Rock:30 Country:30"));
    }
}
