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

/**
 * Tests the MonthlyReport class
 * 
 * @author Christian Chung
 * @version Nov 19, 2025
 */
public class MonthlyReportTest
    extends TestCase
{

    private MonthlyReport monthlyReport;
    private MonthlyReport emptyMonthlyReport;

    /**
     * Sets up an example monthly report and empty monthly report to test
     */
    public void setUp()
    {
        monthlyReport = new MonthlyReport("July", 1000, 20, 1000, 2000, 5000);
        emptyMonthlyReport = new MonthlyReport();
    }


    /**
     * Tests the getter methods
     */
    public void testGetters()
    {
        // Tests the getters for the monthly report
        assertEquals("July", monthlyReport.getMonth());
        assertEquals(1000, monthlyReport.getMonthlyLikes());
        assertEquals(20, monthlyReport.getMonthlyPosts());
        assertEquals(1000, monthlyReport.getMonthlyFollowers());
        assertEquals(2000, monthlyReport.getMonthlyComments());
        assertEquals(5000, monthlyReport.getMonthlyViews());

        // Tests the getters for the empty monthly report
        assertEquals("Unknown", emptyMonthlyReport.getMonth());
        assertEquals(0, emptyMonthlyReport.getMonthlyLikes());
        assertEquals(0, emptyMonthlyReport.getMonthlyPosts());
        assertEquals(0, emptyMonthlyReport.getMonthlyFollowers());
        assertEquals(0, emptyMonthlyReport.getMonthlyComments());
        assertEquals(0, emptyMonthlyReport.getMonthlyViews());
    }


    /**
     * Tests the toString() method
     */
    public void testToString()
    {
        // Tests the toString() method for the monthly report
        assertEquals(
            "July\n" + "1000\n" + "20\n" + "1000\n" + "2000\n" + "5000\n",
            monthlyReport.toString());
        // Tests the toString() method for the empty monthly report
        assertEquals(
            "Unknown\n" + "0\n" + "0\n" + "0\n" + "0\n" + "0\n",
            emptyMonthlyReport.toString());
    }

}
