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

import bag.SimpleBagInterface;
import java.awt.Color;
import cs2.*;
import student.TestableRandom;

// -------------------------------------------------------------------------
/**
 * The actual whack a shape game: creates the bag, the UI, and initializes the
 * shapes.
 * 
 * @author Jo
 * @version Sep 28, 2025
 */
public class WhackAShape
{
    private static final String[] STRINGS =
        { "red circle", "blue circle", "red square", "blue square" };
    private SimpleBagInterface<Shape> bag;
    private Window window;
    private TestableRandom randomGenerator;
    private Button quitButton;

    // ----------------------------------------------------------
    /**
     * Creates a new WhackAShape object, initializing bag, window, quit,
     * random size and random shapes in the bag. It also sets the first shape
     * up with pick.
     */
    public WhackAShape()
    {
        bag = new SimpleLinkedBag<Shape>();
        window = new Window();
        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.SOUTH);
        randomGenerator = new TestableRandom();
        int size = randomGenerator.nextInt(9) + 6;
        for (int i = 0; i < size; i++)
        {
            Shape sh = buildShape(STRINGS[randomGenerator.nextInt(4)]);
            sh.onClick(this, "clickedShape");
            bag.add(sh);
        }
        window.addShape(bag.pick());
    }


    // ----------------------------------------------------------
    /**
     * Same as before, but with a manually input list of string shapes instead
     * of randomized.
     * @param str the list of strings that determine the shape types.
     */
    public WhackAShape(String[] str)
    {
        bag = new SimpleLinkedBag<Shape>();
        window = new Window();
        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.SOUTH);
        for(int i = 0; i < str.length; i++) {
            try {
                Shape sh = buildShape(str[i]);
                sh.onClick(this, "clickedShape");
                bag.add(sh);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        window.addShape(bag.pick());
    }


    // ----------------------------------------------------------
    /**
     * Returns the window object.
     * @return window
     */
    public Window getWindow()
    {
        return window;
    }


    // ----------------------------------------------------------
    /**
     * Returns the bag.
     * @return bag
     */
    public SimpleBagInterface<Shape> getBag()
    {
        return bag;
    }


    // ----------------------------------------------------------
    /**
     * Exits the program when the button is clicked.
     * @param b The quit button
     */
    public void clickedQuit(Button b)
    {
        System.exit(0);
    }


    // ----------------------------------------------------------
    /**
     * Removes current shape when clicked and moves to the next.
     * If no more shapes, returns the win message.
     * @param s The shape that was clicked.
     */
    public void clickedShape(Shape s)
    {
        window.removeShape(s);
        bag.remove(s);
        Shape nextShape = bag.pick();
        if (nextShape == null)
        {
            TextShape winText = new TextShape(0, 0, "You Win!");
            winText.setX((window.getGraphPanelWidth() / 2) 
                - (winText.getWidth() / 2));
            winText.setY((window.getGraphPanelHeight() / 2) 
                - (winText.getHeight() / 2));
            window.addShape(winText);
        }
        window.addShape(nextShape);
    }


    // ----------------------------------------------------------
    /**
     * Builds a new shape with a random size and location, and matches the
     * color and shape type by scanning the string inputed.
     * @param s The string input.
     * @return The string input as a Shape.
     */
    public Shape buildShape(String s)
    {
        TestableRandom generator = new TestableRandom();
        int size = generator.nextInt(101) + 100;
        int xIndex = generator.nextInt(window.getGraphPanelWidth() - size);
        int yIndex = generator.nextInt(window.getGraphPanelHeight() - size);
        if (s.contains("red"))
        {
            if (s.contains("circle"))
            {
                CircleShape currentShape =
                    new CircleShape(xIndex, yIndex, size, Color.red);
                return currentShape;
            }
            else if (s.contains("square"))
            {
                SquareShape currentShape =
                    new SquareShape(xIndex, yIndex, size, Color.red);
                return currentShape;
            }
            throw new IllegalArgumentException();
        }
        else if (s.contains("blue"))
        {
            if (s.contains("circle"))
            {
                CircleShape currentShape =
                    new CircleShape(xIndex, yIndex, size, Color.blue);
                return currentShape;
            }
            else if (s.contains("square"))
            {
                SquareShape currentShape =
                    new SquareShape(xIndex, yIndex, size, Color.blue);
                return currentShape;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }
}
