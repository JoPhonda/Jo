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
 * Represents a monthly report for an influencer
 * 
 * @author Christian Chung
 * @version Nov 19, 2025
 */
public class MonthlyReport
{
    private String month;
    private int monthlyLikes;
    private int monthlyPosts;
    private int monthlyFollowers;
    private int monthlyComments;
    private int monthlyViews;

    /**
     * Create a new MonthlyReport object.
     * 
     * @param month
     *            The month of the report
     * @param monthlyLikes
     *            The number of likes for the specific month
     * @param monthlyPosts
     *            The number of posts for the specific month
     * @param monthlyFollowers
     *            The number of followers for the specific month
     * @param monthlyComments
     *            The number of comments for the specific month
     * @param monthlyViews
     *            The number of views for the specific month
     */
    public MonthlyReport(
        String month,
        int monthlyLikes,
        int monthlyPosts,
        int monthlyFollowers,
        int monthlyComments,
        int monthlyViews)
    {
        this.month = month;
        this.monthlyLikes = monthlyLikes;
        this.monthlyPosts = monthlyPosts;
        this.monthlyFollowers = monthlyFollowers;
        this.monthlyComments = monthlyComments;
        this.monthlyViews = monthlyViews;
    }


    /**
     * Create a new MonthlyReport object.
     */
    public MonthlyReport()
    {
        month = "Unknown";
        monthlyLikes = 0;
        monthlyPosts = 0;
        monthlyFollowers = 0;
        monthlyComments = 0;
        monthlyViews = 0;
    }


    /**
     * Gets the month of the report
     * 
     * @return the month of the report
     */
    public String getMonth()
    {
        return month;
    }


    /**
     * Gets the monthly likes
     * 
     * @return the monthly likes
     */
    public int getMonthlyLikes()
    {
        return monthlyLikes;
    }


    /**
     * Gets the monthly posts
     * 
     * @return the monthly posts
     */
    public int getMonthlyPosts()
    {
        return monthlyPosts;
    }


    /**
     * Gets the monthly followers
     * 
     * @return the monthly followers
     */
    public int getMonthlyFollowers()
    {
        return monthlyFollowers;
    }


    /**
     * Gets the monthly comments
     * 
     * @return the monthly comments
     */
    public int getMonthlyComments()
    {
        return monthlyComments;
    }


    /**
     * Gets the monthly views
     * 
     * @return the monthly views
     */
    public int getMonthlyViews()
    {
        return monthlyViews;
    }


    /**
     * Displays all of the data from the monthly report as a string
     * 
     * @return the string of all the data from the monthly report
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(month + "\n");
        sb.append(monthlyLikes + "\n");
        sb.append(monthlyPosts + "\n");
        sb.append(monthlyFollowers + "\n");
        sb.append(monthlyComments + "\n");
        sb.append(monthlyViews + "\n");
        return sb.toString();
    }
}
