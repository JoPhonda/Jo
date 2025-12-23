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
 * Tests the FullReport class
 * 
 * @author Christian Chung
 * @version Nov 19, 2025
 */
public class FullReportTest
    extends TestCase
{

    private MonthlyReport firstMonthlyReport;
    private MonthlyReport secondMonthlyReport;
    private MonthlyReport addMonthlyReport;
    private FullReport fullReport;
    private FullReport emptyFullReport;
    private LinkedList<MonthlyReport> previousReports;

    /**
     * Sets up an example empty full report, full report with two monthly
     * reports in it, and an example monthly report to add to the full report
     * for testing
     */
    public void setUp()
    {
        // Creating the test report history
        previousReports = new LinkedList<>();
        firstMonthlyReport =
            new MonthlyReport("July", 1000, 25, 1000, 3000, 6000);
        secondMonthlyReport =
            new MonthlyReport("August", 500, 15, 500, 1000, 3000);
        previousReports.add(firstMonthlyReport);
        previousReports.add(secondMonthlyReport);
        // The monthly report to add to the full report
        addMonthlyReport =
            new MonthlyReport("September", 1000, 20, 1000, 2000, 5000);
        // The test full report
        fullReport =
            new FullReport(1500, 40, 1500, 4000, 9000, previousReports);
        // The test empty full report
        emptyFullReport = new FullReport();
    }


    /**
     * Tests the updateFullReport() method
     */
    public void testUpdateFullReport()
    {
        // Tests the updateFullReport() method on the full report
        fullReport.updateFullReport(addMonthlyReport);
        assertEquals(2500, fullReport.getTotalLikes());
        assertEquals(60, fullReport.getTotalPosts());
        assertEquals(2500, fullReport.getTotalFollowers());
        assertEquals(6000, fullReport.getTotalComments());
        assertEquals(14000, fullReport.getTotalViews());

        // Tests the updateFullReport() method on the empty full report
        emptyFullReport.updateFullReport(addMonthlyReport);
        assertEquals(1001, emptyFullReport.getTotalLikes());
        assertEquals(21, emptyFullReport.getTotalPosts());
        assertEquals(1001, emptyFullReport.getTotalFollowers());
        assertEquals(2001, emptyFullReport.getTotalComments());
        assertEquals(5001, emptyFullReport.getTotalViews());
        
        // Tests that getReportHistory returns the reportHistory.
        assertEquals(previousReports, fullReport.getReportHistory());
    }


    /**
     * Tests the getter methods
     */
    public void testGetters()
    {
        // Testing the getters for the full report
        assertEquals(1500, fullReport.getTotalLikes());
        assertEquals(40, fullReport.getTotalPosts());
        assertEquals(1500, fullReport.getTotalFollowers());
        assertEquals(4000, fullReport.getTotalComments());
        assertEquals(9000, fullReport.getTotalViews());

        // Testing the getters for the empty full report
        assertEquals(1, emptyFullReport.getTotalLikes());
        assertEquals(1, emptyFullReport.getTotalPosts());
        assertEquals(1, emptyFullReport.getTotalFollowers());
        assertEquals(1, emptyFullReport.getTotalComments());
        assertEquals(1, emptyFullReport.getTotalViews());
    }
    
    // ----------------------------------------------------------
    /**
     * Tests the findByMonth() method
     */
    public void testFindByMonth() {
        assertEquals(firstMonthlyReport, fullReport.findByMonth("July"));
        assertNull(fullReport.findByMonth("December"));
    }

    /**
     * Tests the toString() method
     */
    public void testToString()
    {
        // Tests the toString() method on the full report
        assertEquals(
            "1500\n" + "40\n" + "1500\n" + "4000\n"
                + "9000\n\nReport History:\n" + firstMonthlyReport.toString()
                + secondMonthlyReport.toString(),
            fullReport.toString());

        // Tests the toString() method on the empty full report
        assertEquals(
            "1\n" + "1\n" + "1\n" + "1\n" + "1\n\nReport History:\n",
            emptyFullReport.toString());
    }

}
