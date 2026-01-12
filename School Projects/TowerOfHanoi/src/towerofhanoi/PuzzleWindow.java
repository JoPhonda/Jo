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
//
// Project 3 Spring 2025
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Name (pid)

import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * The main front-end work and the view for the Tower of Hanoi puzzle
 *
 * @author Name
 * @version Date
 */
public class PuzzleWindow implements Observer {

    private HanoiSolver game;
    private Shape left;
    private Shape center;
    private Shape right;
    private Window window;
    /**
     * A factor in which the width of the disks are multiplied by
     */
    public static final int WIDTH_FACTOR = 12;
    /**
     * The vertical gap between each disk on the tower
     */
    public static final int DISK_GAP = 2;
    /**
     * The height of each disk on the tower
     */
    public static final int DISK_HEIGHT = 15;


    /**
     * Creates a new PuzzleWindow view for a given HanoiSolver game
     *
     * @param g The game to create a view for
     */
    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);
        window = new Window("Tower of Hanoi");
        window.setSize(700, 400);
      //The height and Y location of each pole are the same
        int poleHeight = 200;
        int poleY = (window.getGraphPanelHeight() / 2) - (poleHeight / 2);
        left = new Shape((200 - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));
        center = new Shape(((window.getGraphPanelWidth() / 2) - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));
        right = new Shape(((window.getGraphPanelWidth() - 200) - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));
        for (int width = (game.disks() + 1) * WIDTH_FACTOR;
            width > WIDTH_FACTOR;
            width -= WIDTH_FACTOR) {
            Disk d = new Disk(width);
            window.addShape(d);
            game.getTower(Position.LEFT).push(d);
            moveDisk(Position.LEFT);
        }
        window.addShape(left);
        window.addShape(center);
        window.addShape(right);
        Button b = new Button("Solve");
        b.onClick(this, "clickedSolve");
        window.addButton(b, WindowSide.SOUTH);
    }
    
    /**
     * Moves the current disk to whatever position is input.
     */
    private void moveDisk(Position position) {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole = null;
        if (position == Position.LEFT) {
            currentPole = left;
        }
        else if (position == Position.RIGHT) {
            currentPole = right;
        }
        else if (position == Position.CENTER) {
            currentPole = center;
        }
        if (currentPole != null) {
            currentDisk.moveTo(currentPole.getX() - (currentDisk.getWidth() - 
            currentPole.getWidth()) / 2, 
            currentPole.getY() + currentPole.getHeight() - DISK_HEIGHT * 
            (game.getTower(position).size()));
        }
    }

    /**
     * Updates the view whenever a disk is moved in the back-end
     *
     * @param o   The observable that triggered the update
     * @param arg arguments sent by the game; should be a position
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            Position position = (Position)arg;
            moveDisk(position);
            sleep();
        }
    }

    /**
     * Runs when the Solve button is clicked, tells the puzzle to start solving
     *
     * @param button the button that was clicked
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }

    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }
}
