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
 *  Tests the Tower class' methods.
 *  
 *  @author Jo
 *  @version Oct 22, 2025
 */
public class TowerTest extends TestCase
{
    private Tower tower;
    private Disk disk1;
    private Disk disk2;
    
    // ----------------------------------------------------------
    /**
     * Initializes a tower with position Right
     * Initializes 2 disks, one with size 30, one with size 25.
     */
    public void setUp() {
        tower = new Tower(Position.RIGHT);
        disk1 = new Disk(30);
        disk2 = new Disk(25);
    }

    // ----------------------------------------------------------
    /**
     * Checks that the tower position is Right.
     * Sets tower to be a new left tower.
     * Checks that the tower position is Left.
     */
    public void testPosition() {
        assertEquals(Position.RIGHT, tower.position());
        tower = new Tower(Position.LEFT);
        assertEquals(Position.LEFT, tower.position());
    }

    // ----------------------------------------------------------
    /**
     * Adds disk 1 to tower.
     * Checks that peeking the tower returns disk 1.
     * Adds disk 2 to tower.
     * Checks that peeking the tower returns disk 2.
     */
    public void testPush() {
        tower.push(disk1);
        assertTrue(tower.peek().equals(disk1));
        tower.push(disk2);
        assertTrue(tower.peek().equals(disk2));
    }
    
    // ----------------------------------------------------------
    /**
     * Adds disk 2 to tower.
     * Checks that adding a bigger disk throws an exception.
     * Checks that it throws an Illegal State Exception.
     */
    public void testPushLarger() {
        tower.push(disk2);
        Exception thrown = null;
        try {
            tower.push(disk1);
        } 
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
    }

    // ----------------------------------------------------------
    /**
     * Checks that adding null to a tower throws an Illegal Argument Exception.
     */
    public void testPushNull() {
        Exception thrown = null;
        try {
            tower.push(null);
        } 
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
    }
}
