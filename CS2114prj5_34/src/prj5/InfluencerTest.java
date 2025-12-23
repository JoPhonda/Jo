// Project 5 Fall 2025
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Joseph Kim (906687763)
// LLM Statement:
// I have not used any assistance for the assignment beyond course resources and
// staff.
package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests the influencer method
 * 
 * @author Jo
 * @author Zander Smith
 * @version Nov 19, 2025
 */
public class InfluencerTest
    extends TestCase
{
    private Influencer i;
    private FullReport fr;
    private FullReport nr;

    // ----------------------------------------------------------
    /**
     * Makes an influencer object and sets its FullReport to a new MonthlyReport
     * example object.
     */
    public void setUp()
    {
        fr = new FullReport();
        i = new Influencer("name", "channel", "country", "topic", fr);
        fr.updateFullReport(new MonthlyReport("June", 10, 20, 30, 40, 100));
        nr = new FullReport();
    }


    // ----------------------------------------------------------
    /**
     * Tests the equals() method.
     */
    public void tests()
    {
        Influencer equal =
            new Influencer("name", "channel", "country", "topic", fr);
        Influencer name =
            new Influencer("test", "channel", "country", "topic", fr);
        Influencer channel =
            new Influencer("name", "test", "country", "topic", fr);
        Influencer country =
            new Influencer("name", "channel", "test", "topic", fr);
        Influencer topic =
            new Influencer("name", "channel", "country", "test", fr);
        Influencer report =
            new Influencer("name", "channel", "country", "topic", nr);
        assertTrue(i.equals(equal));
        assertFalse(i.equals(name));
        assertFalse(i.equals(channel));
        assertFalse(i.equals(country));
        assertFalse(i.equals(topic));
        assertFalse(i.equals(report));
        assertFalse(i.equals(null));
        assertFalse(i.equals(null));
    }


    /**
     * Tests the toString() method
     */
    public void testToString()
    {
        // System.out.println(i.toString());

        assertEquals(
            "name:\r\n" + "Channel Name: channel\r\n" + "Main Topic: topic\r\n"
                + "Country: country\r\n" + "Full Report:\r\n" + "11\r\n"
                + "21\r\n" + "31\r\n" + "41\r\n" + "101\r\n" + "\r\n"
                + "Report History:\r\n" + "June\r\n" + "10\r\n" + "20\r\n"
                + "30\r\n" + "40\r\n" + "100\r\n",
            i.toString());
    }
}
