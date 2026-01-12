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
 *  Tests the HanoiSolver's methods.
 * 
 *  @author Jo
 *  @version Oct 22, 2025
 */
public class HanoiSolverTest extends TestCase
{
    private HanoiSolver solver;
    private Position left = Position.LEFT;
    private Position center = Position.CENTER;
    private Position right = Position.RIGHT;
    // ----------------------------------------------------------
    /**
     * Initializes a HanoiSolver object with size 5.
     * Adds 5 disks with ascending size to the left tower.
     */
    public void setUp()
    {
        solver = new HanoiSolver(5);
        Tower leftT = solver.getTower(left);
        leftT.push(new Disk(50));
        leftT.push(new Disk(40));
        leftT.push(new Disk(30));
        leftT.push(new Disk(20));
        leftT.push(new Disk(10));
    }
    
    // ----------------------------------------------------------
    /**
     * Checks that disks returns the number of disks of 5.
     */
    public void testDisks() {
        assertEquals(5, solver.disks());
    }
    
    // ----------------------------------------------------------
    /**
     * Checks that left equals the left tower's getPosition.
     * Same for the other positions.
     */
    public void testGetTower() {
        Position pos = Position.DEFAULT;
        assertEquals(Position.LEFT, solver.getTower(left).position());
        assertEquals(Position.RIGHT, solver.getTower(right).position());
        assertEquals(Position.CENTER, solver.getTower(center).position());
        assertEquals(Position.CENTER, solver.getTower(pos).position());
    }
    
    // ----------------------------------------------------------
    /**
     * Checks that the left and right tower size is 0, 5 respectively.
     * Checks that after moving, the sizes are 1, 4 respectively.
     */
    public void testMove() {

        Tower leftT = solver.getTower(left);
        Tower rightT = solver.getTower(right);
        assertEquals(leftT.size(), 5);
        assertEquals(rightT.size(), 0);
        solver.move(leftT, rightT);
        assertEquals(leftT.size(), 4);
        assertEquals(rightT.size(), 1);
    }
    
    // ----------------------------------------------------------
    /**
     * Checks that solve runs correctly.
     * Checks that all tower sizes are 0 besides the destination (right).
     */
    public void testSolve() {
        solver.solve();
        assertEquals(0, solver.getTower(left).size());
        assertEquals(0, solver.getTower(center).size());
        assertEquals(5, solver.getTower(right).size());
    }
    
    // ----------------------------------------------------------
    /**
     * Checks that the toString is not null.
     * Checks that the toString equals the string.
     */
    public void testToString() {
        String string = solver.toString();
        assertNotNull(string);
        assertEquals(string, "[10, 20, 30, 40, 50][][]");
    }
}
