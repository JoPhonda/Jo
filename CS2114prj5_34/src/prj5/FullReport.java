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

/**
 * Represents a full report for an influencer
 * 
 * @author Christian Chung
 * @version Nov 19, 2025
 */
public class FullReport
{
    private int totalLikes;
    private int totalPosts;
    private int totalFollowers;
    private int totalComments;
    private int totalViews;
    private LinkedList<MonthlyReport> reportHistory;

    /**
     * Create a new FullReport object.
     * 
     * @param totalLikes
     *            Total likes the influencer has
     * @param totalPosts
     *            Total posts the influencer has
     * @param totalFollowers
     *            Total followers the influencer has
     * @param totalComments
     *            Total comments the influencer has
     * @param totalViews
     *            Total views the influencer has
     * @param reportHistory
     *            A list of all previous monthly reports for the influencer
     */
    public FullReport(
        int totalLikes,
        int totalPosts,
        int totalFollowers,
        int totalComments,
        int totalViews,
        LinkedList<MonthlyReport> reportHistory)
    {
        this.totalLikes = totalLikes;
        this.totalPosts = totalPosts;
        this.totalFollowers = totalFollowers;
        this.totalComments = totalComments;
        this.totalViews = totalViews;
        this.reportHistory = reportHistory;
    }


    /**
     * Creates a FullReport object
     */
    public FullReport()
    {
        totalLikes = 1;
        totalPosts = 1;
        totalFollowers = 1;
        totalComments = 1;
        totalViews = 1;
        reportHistory = new LinkedList<>();
    }


    /**
     * Updates the total attributes of the influencer by adding the attributes
     * of the provided monthly report to the totals. Also adds the monthly
     * report to the list of all previous monthly reports for the influencer
     * 
     * @param report
     *            The monthly report provided to update the full report
     *            attributes
     */
    public void updateFullReport(MonthlyReport report)
    {
        totalLikes += report.getMonthlyLikes();
        totalPosts += report.getMonthlyPosts();
        totalFollowers += report.getMonthlyFollowers();
        totalComments += report.getMonthlyComments();
        totalViews += report.getMonthlyViews();
        reportHistory.add(report);
    }


    // ----------------------------------------------------------
    /**
     * Searches through reportHistory and returns the monthlyReport that matches
     * the month given.
     * 
     * @param month
     *            The month given.
     * @return MonthlyReport that matches the month.
     */
    public MonthlyReport findByMonth(String month)
    {
        for (int i = 0; i < reportHistory.size(); i++)
        {
            if (reportHistory.getDataAtIndex(i).getMonth().equals(month))
            {
                return reportHistory.getDataAtIndex(i);
            }
        }
        return null;
    }


    /**
     * Gets the total likes for an influencer
     * 
     * @return the total likes for an influencer
     */
    public int getTotalLikes()
    {
        return totalLikes;
    }


    /**
     * Gets the total posts for an influencer
     * 
     * @return the total posts for an influencer
     */
    public int getTotalPosts()
    {
        return totalPosts;
    }


    /**
     * Gets the total followers for an influencer
     * 
     * @return the total followers for an influencer
     */
    public int getTotalFollowers()
    {
        return totalFollowers;
    }


    /**
     * Gets the total comments for an influencer
     * 
     * @return the total comments for an influencer
     */
    public int getTotalComments()
    {
        return totalComments;
    }


    /**
     * Gets the total views for an influencer
     * 
     * @return the total views for an influencer
     */
    public int getTotalViews()
    {
        return totalViews;
    }


    /**
     * Gets the list of all previous monthly reports for the influencer.
     * 
     * @return The LinkedList of MonthlyReport objects.
     */
    public LinkedList<MonthlyReport> getReportHistory()
    {
        return reportHistory;
    }


    /**
     * Displays all of the data from the full report as well as the data from
     * all previous monthly reports as a string
     * 
     * @return the string of all the data from the full report and all previous
     *             monthly reports
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(totalLikes + "\n");
        sb.append(totalPosts + "\n");
        sb.append(totalFollowers + "\n");
        sb.append(totalComments + "\n");
        sb.append(totalViews + "\n");
        sb.append("\n" + "Report History:" + "\n");
        for (int i = reportHistory.size() - 1; i >= 0; i--)
        {
            sb.append(reportHistory.getDataAtIndex(i).toString());
        }
        return sb.toString();
    }

}
