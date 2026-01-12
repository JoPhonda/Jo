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
import student.TestableRandom;
// -------------------------------------------------------------------------
/**
 *  the stuff in the bag
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author Jo
 *  @version Sep 15, 2025
 */
public class DisplayCollection
{
    /**
     * STRINGS
     */
    public static final String[] STRINGS = 
    {"red circle", "blue circle", "red square", "blue square"};
    private BagInterface<String> itemBag;
    // ----------------------------------------------------------
    /**
     * Create a new DisplayCollection object.
     */
    public DisplayCollection() {
        this.itemBag = new Bag<>();
        TestableRandom random = new TestableRandom();
        int count = random.nextInt(11) + 5;
        for (int i = 0; i < count; i++) {
            itemBag.add(DisplayCollection.STRINGS[random.nextInt(4)]);
        }
    }
    // ----------------------------------------------------------
    /**
     * returns the itemBag
     * @return BagInterface<String> itemBag
     */
    public BagInterface<String> getItemBag() {
        return itemBag;
    }
}
