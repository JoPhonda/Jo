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
 *  File that runs the TowerOfHanoi solver.
 * 
 *  @author Jo
 *  @version Oct 22, 2025
 */
public class ProjectRunner
{
    // ----------------------------------------------------------
    /**
     * Runs Tower of Hanoi into the console.
     * @param args Can put a number inside to produce the number of disks on
     * the starting tower.
     */
    public static void main(String[] args){
        int disks = 5;
        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        PuzzleWindow w = new PuzzleWindow(new HanoiSolver(disks));
    }
}
