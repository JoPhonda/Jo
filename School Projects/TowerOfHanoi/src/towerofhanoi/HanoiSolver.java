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
import java.util.Observable;

// -------------------------------------------------------------------------
/**
 *  Contains the methods used to recursively solve the tower by moving disks
 *  onto different towers.
 * 
 *  @author Jo
 *  @version Oct 21, 2025
 */
public class HanoiSolver extends Observable
{
    private Tower left;
    private Tower right;
    private Tower center;
    private int numDisks;
    // ----------------------------------------------------------
    /**
     * Create a new HanoiSolver object.
     * @param n Number of disks.
     */
    public HanoiSolver(int n) {
        numDisks = n;
        left = new Tower(Position.LEFT);
        center = new Tower(Position.CENTER);
        right = new Tower(Position.RIGHT);
    }
    // ----------------------------------------------------------
    /**
     * Returns the number of disks.
     * @return Number of disks.
     */
    public int disks() {
        return numDisks;
    }
    // ----------------------------------------------------------
    /**
     * Returns the tower object based on a position given.
     * @param pos The position object of the tower.
     * @return The tower at that given position. Returns center by default.
     */
    public Tower getTower(Position pos) {
        switch(pos) {
            case LEFT:
                return left;
            case RIGHT:
                return right;
            case CENTER:
                return center;
            default:
                return center;
        }
    }
    // ----------------------------------------------------------
    /**
     * Removes the start tower disk and places it on the end tower disk.
     * @param start Starting tower
     * @param end Destination tower
     */
    public void move(Tower start, Tower end) {
        Disk moved = start.pop();
        end.push(moved);
        setChanged();
        notifyObservers(end.position());
    }
    // ----------------------------------------------------------
    /**
     * Algorithm to recursively solve the tower.
     * @param currDisks Current amount of disks
     * @param start Node to start
     * @param temp Node to temporarily hold
     * @param end Node to end up at
     */
    public void solveTowers(int currDisks, Tower start, Tower temp, Tower end) {
        if (currDisks == 1) {
            move(start, end);
            return;
        }
        solveTowers(currDisks - 1, start, end, temp);
        move(start, end);
        solveTowers(currDisks - 1, temp, start, end);
    }
    // ----------------------------------------------------------
    /**
     * Calls solveTowers with the values in this class.
     */
    public void solve() {
        solveTowers(numDisks, left, center, right);
    }
 // ----------------------------------------------------------
    /**
     * Returns each tower's toString method together.
     * @return All towers as strings
     */
    public String toString() {
        return left.toString() + center.toString() + right.toString();
    }
}
