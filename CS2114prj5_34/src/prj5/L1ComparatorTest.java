// Project 5 Fall 2025
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Christian Chung (906793112)

// LLM Statement:

// I have not used any assistance for the assignment beyond course resources and
// staff.
package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests that L1Comparator works
 * 
 * @author Christian Chung
 * @version Dec 4, 2025
 */
public class L1ComparatorTest
    extends TestCase
{
    private Influencer test1;
    private Influencer test2;
    private Influencer test3;
    private Influencer test4;
    private L1Comparator comp;
    private LinkedList<MonthlyReport> reportHistory;
    private LinkedList<MonthlyReport> reportHistory2;

    /**
     * set up the test
     */
    public void setUp()
    {
        reportHistory = new LinkedList<MonthlyReport>();
        reportHistory2 = new LinkedList<MonthlyReport>();
        test1 = new Influencer(
            "a",
            "b",
            "c",
            "d",
            new FullReport(5, 10, 20, 30, 50, new LinkedList<>()));
        test2 = new Influencer(
            "e",
            "f",
            "g",
            "h",
            new FullReport(10, 15, 25, 35, 55, new LinkedList<>()));
        test3 = new Influencer(
            "a",
            "b",
            "c",
            "d",
            new FullReport(5, 10, 20, 30, 50, reportHistory));
        test4 = new Influencer(
            "e",
            "f",
            "g",
            "h",
            new FullReport(10, 15, 25, 35, 55, reportHistory2));
        comp = new L1Comparator();
    }


    // ----------------------------------------------------------
    /**
     * tests that compare works
     */
    public void testComp1()
    {
        assertEquals(-1, comp.compare(test1, test2));
        assertEquals(1, comp.compare(test2, test1));
        assertEquals(0, comp.compare(test1, test1));
        assertEquals(175., comp.getEngagementRate1(), 0.1);
        assertEquals(175., comp.getEngagementRate2(), 0.1);
    }
    // ----------------------------------------------------------
    /**
     * tests that compareByMonth works
     */
    public void testCompByMonth()
    {
        reportHistory.add(new MonthlyReport("July", 1, 2, 3, 4, 5));
        reportHistory2.add(new MonthlyReport("July", 1, 2, 3, 4, 6));
        assertEquals(1, comp.compareByMonth(test3, test4, "July"));
        assertEquals(-1, comp.compareByMonth(test4, test3, "July"));
        assertEquals(0, comp.compareByMonth(test3, test3, "July"));
    }
}
