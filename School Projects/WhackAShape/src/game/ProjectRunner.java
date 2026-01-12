// Project 2 Fall 2025
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Joseph Kim (906687763)

// LLM Statement:
//I have not used any assistance for the assignment beyond course resources and
// staff.
package game;
// -------------------------------------------------------------------------
/**
 *  The file that runs the WhackAShape game.
 * 
 *  @author Jo
 *  @version Sep 29, 2025
 */
public class ProjectRunner
{
    // ----------------------------------------------------------
    /**
     * Runs Whack a Shape into the console.
     * @param args Can put values inside to produce specific shapes instead of
     * randomizing.
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            WhackAShape w = new WhackAShape(args);
        }
        else {
        WhackAShape w = new WhackAShape();
        }
    }
}
