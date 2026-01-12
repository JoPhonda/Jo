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
import cs2.Shape;
import student.TestableRandom;
import java.awt.Color;
// -------------------------------------------------------------------------
/**
 *  The Disk object that goes on the tower. Contains a value of its size.
 *  Larger disk cannot go on top of a smaller disk.
 * 
 *  @author Jo
 *  @version Oct 21, 2025
 */
public class Disk extends Shape implements Comparable<Disk>
{

    // ----------------------------------------------------------
    /**
     * Create a new Disk object.
     * @param x The width of this disk.
     */
    public Disk(int x)
    {
        super(0, 0, x, 15);
        TestableRandom random = new TestableRandom();
        int color = random.nextInt(256);
        int color2 = random.nextInt(256);
        int color3 = random.nextInt(256);
        Color c = new Color(color, color2, color3);
        this.setBackgroundColor(c);
    }

    @Override
    public int compareTo(Disk o)
    {
        if (o == null) {
            throw new IllegalArgumentException();
        }
        return this.getWidth() - o.getWidth();
    }
 // ----------------------------------------------------------
    /**
     * Compare disks.
     * If object compared to is null, throws an Illegal Argument Exception.
     * returns true if the width of both disks match.
     * @param o The disk that this disk is comparing to.
     * @return True if size is equal, false if not.
     */
    public boolean equals(Object o) {
        if (o == null) {
            throw new IllegalArgumentException();
        }
        return this.getWidth() == ((Disk)o).getWidth();
    }
    // ----------------------------------------------------------
    /**
     * Returns a string of the disk's width.
     * @return A string of the width.
     */
    public String toString()
    {
        return "" + this.getWidth();
    }
}
