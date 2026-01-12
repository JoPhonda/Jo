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
 *  the GUI interface for the window
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author Jo
 *  @version Sep 15, 2025
 */
public class ShapeWindow
{
    private Window window;
    private TextShape textShape;
    private Button quitButton;
    private Button chooseButton;
    private BagInterface<String> itemBag;
    // ----------------------------------------------------------
    /**
     * Create a new ShapeWindow object.
     * @param bag the actual bag that stores the objects
     */
    public ShapeWindow(BagInterface<String> bag) {
        window = new Window();
        window.setTitle("Project 1");
        itemBag = bag;
        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);
        chooseButton = new Button("Choose");
        chooseButton.onClick(this, "clickedChoose");
        window.addButton(chooseButton, WindowSide.SOUTH);
        textShape = new TextShape(0, 0, "");
        window.addShape(textShape);
    }
    // ----------------------------------------------------------
    /**
     * Exit out when quit is clicked
     * @param b the click button
     */
    public void clickedQuit(Button b) {
        System.exit(0);
    }
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param b
     */
    public void clickedChoose(Button b) {
        String removed = itemBag.remove();
        if (removed != null) {
            textShape.setText(removed);
        }
        else{
            textShape.setText("No more items.");
        }
        colorText();
        centerText();
    }
    // ----------------------------------------------------------
    /**
     * Color the text red or blue based on the shape
     */
    public void colorText() {
        if (textShape.getText().contains("red")) {
            textShape.setForegroundColor(Color.RED);
        }
        else if (textShape.getText().contains("blue")) {
            textShape.setForegroundColor(Color.BLUE);
        }
    }
    // ----------------------------------------------------------
    /**
     * Center the text always
     */
    public void centerText() {
        textShape.setX((window.getGraphPanelWidth()/2) - 
            (textShape.getWidth()/2));
        textShape.setY((window.getGraphPanelHeight()/2) - 
            (textShape.getHeight()/2));
    }
}