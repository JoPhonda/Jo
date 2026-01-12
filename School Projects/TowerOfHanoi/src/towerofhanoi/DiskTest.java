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
import java.awt.Color;
import org.junit.Assert.*;

// -------------------------------------------------------------------------
/**
 *  Tests the Disk class' methods.
 * 
 *  @author Jo
 *  @version Oct 22, 2025
 */
public class DiskTest extends TestCase
{
    private Disk disk1;
    private Disk disk2;
    private Disk disk3;
    /**
     * Initializes 3 disks, two with size 10, one with size 20.
     */
    public void setUp() {
        disk1 = new Disk(10);
        disk2 = new Disk(20);
        disk3 = new Disk(10);
    }

    /**
     * Checks that disk 1 (10) is less than disk 2 (20).
     * Checks that same happens the other way around.
     * Checks that disk 1 and 3 are equal in weight.
     * Checks that comparing to a null object throws an exception.
     */
    public void testCompareTo() {
        assertNotSame(disk1.compareTo(disk2), 0);
        assertEquals(0, disk1.compareTo(disk3));
        Exception thrown = null;
        try {
            disk1.compareTo(null);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        
    }

    /**
     * Checks that disk 1 is equal to disk 3.
     * Checks that disk 1 is not equal to disk 2.
     * Checks that equals to null throws an exception.
     */
    public void testEquals() {
        assertTrue(disk1.equals(disk3));
        assertFalse(disk1.equals(disk2));
        Exception thrown = null;
        try {
            disk1.equals(null);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
    }

    /**
     * Checks that the toString of disk 1 returns "10" as a string.
     */
    public void testToString() {
        assertEquals("10", disk1.toString());
    }

    /**
     * Creates a color object based on disk 1's color.
     * Checks that the color is not null.
     */
    public void testGetBackgroundColor() {
        Color c = disk1.getBackgroundColor();
        assertNotNull(c);
    }
}
