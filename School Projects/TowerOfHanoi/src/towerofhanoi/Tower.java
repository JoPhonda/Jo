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
// -------------------------------------------------------------------------
/**
 *  Tower is basically what holds the disks which is built on a linkedStack.
 * 
 *  @author Jo
 *  @version Oct 22, 2025
 */
public class Tower extends LinkedStack<Disk>
{
    private Position position;
    // ----------------------------------------------------------
    /**
     * Create a new Tower object, which calls its super class (LinkedStack).
     * @param p The variable position.
     */
    Tower(Position p) {
        super();
        position = p;
    }
    
    // ----------------------------------------------------------
    /**
     * Returns the position of this tower.
     * @return position
     */
    public Position position() {
        return position;
    }
    
    @Override
    public void push(Disk d) {
        if (d == null) {
            throw new IllegalArgumentException();
        }
        if (!this.isEmpty() && this.peek().compareTo(d) < 0) {
            throw new IllegalStateException();
        }
        super.push(d);
    }
}
