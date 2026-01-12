// Project 1 Fall 2025
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Joseph Kim (906687763)

// LLM Statement:
//I have not used any assistance for the assignment beyond course resources and
// staff.
package project1;
import bag.Bag;
import bag.BagInterface;
import cs2.TextShape;
import student.TestableRandom;
import cs2.Window;
import cs2.Button;
import cs2.WindowSide;
import java.awt.Color;
// -------------------------------------------------------------------------
/**
 *  runs the project
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author Jo
 *  @version Sep 15, 2025
 */
public class ProjectRunner
{
    // ----------------------------------------------------------
    /**
     * actually run the test
     * @param args idk what this means honestly
     */
    public static void main(String[] args) {
        DisplayCollection collection = new DisplayCollection();
        ShapeWindow window = new ShapeWindow(collection.getItemBag());
    }

}
