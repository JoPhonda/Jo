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

import java.util.Comparator;

/**
 * Compares two influencers based on their engagement rate by reach
 * 
 * @author Christian Chung
 * @version Nov 19, 2025
 */
public class L2Comparator
    implements Comparator<Influencer>
{
    private double engagementRateByReach1;
    private double engagementRateByReach2;

    /**
     * Create a new L1Comparator object.
     */
    public L2Comparator()
    {
        this.engagementRateByReach1 = 0;
        this.engagementRateByReach2 = 0;
    }


    /**
     * Calculates the engagement rate by reach for both influencers given and
     * compares them to check if influencer1's rate is less than, equal to, or
     * greater than influencer2's rate
     * 
     * @param influencer1
     *            One of the influencers that is compared to the other
     * @param influencer2
     *            One of the influencers that is compared to the other
     * @return an integer value that is either negative, 0, or positive
     *             depending on whether the engagement rate by reach for
     *             influencer1 is less than, equal to, or greater than the
     *             engagement rate by reach for influencer 2
     */
    // Engagement Rate by reach = ( (comments + likes)/ views) x 100
    public int compare(Influencer influencer1, Influencer influencer2)
    {
        // Calculating the engagement rate for influencer1
        FullReport influencer1Report = influencer1.getFullReport();
        engagementRateByReach1 = (((double)influencer1Report.getTotalComments()
            + (double)influencer1Report.getTotalLikes())
            / (double)influencer1Report.getTotalViews()) * 100;

        // Calculating the engagement rate for influencer2
        FullReport influencer2Report = influencer2.getFullReport();
        engagementRateByReach2 = (((double)influencer2Report.getTotalComments()
            + (double)influencer2Report.getTotalLikes())
            / (double)influencer2Report.getTotalViews()) * 100;

        double difference = engagementRateByReach1 - engagementRateByReach2;
        if (difference > 0)
        {
            return 1;
        }
        else if (difference < 0)
        {
            return -1;
        }
        return 0;
    }


    /**
     * Calculates the engagement rate for both influencers given a specified
     * month and and compares them to check if influencer1's rate is less than,
     * equal to, or greater than influencer2's rate
     * 
     * @param influencer1
     *            One of the influencers that is compared to the other
     * @param influencer2
     *            One of the influencers that is compared to the other
     * @param month The month to be compared by.
     * @return an integer value that is either negative, 0, or positive
     *             depending on whether the engagement rate for influencer1 is
     *             less than, equal to, or greater than the engagement rate for
     *             influencer 2
     */
    public int compareByMonth(
        Influencer influencer1,
        Influencer influencer2,
        String month)
    {
        // Calculating the engagement rate for influencer1
        MonthlyReport influencer1Report =
            influencer1.getFullReport().findByMonth(month);
        engagementRateByReach1 =
            (((double)influencer1Report.getMonthlyComments()
                + (double)influencer1Report.getMonthlyLikes())
                / (double)influencer1Report.getMonthlyViews()) * 100;

        // Calculating the engagement rate for influencer2
        MonthlyReport influencer2Report =
            influencer2.getFullReport().findByMonth(month);
        engagementRateByReach2 =
            (((double)influencer2Report.getMonthlyComments()
                + (double)influencer2Report.getMonthlyLikes())
                / (double)influencer2Report.getMonthlyViews()) * 100;

        double difference = engagementRateByReach1 - engagementRateByReach2;

        if (difference > 0)
        {
            return 1;
        }
        else if (difference < 0)
        {
            return -1;
        }

        return 0;
    }

    // ----------------------------------------------------------
    /**
     * Returns engagementRateByReach1
     * @return engagementRateByReach1
     */
    public double getEngagementRateByReach1()
    {
        return engagementRateByReach1;
    }

    // ----------------------------------------------------------
    /**
     * Returns engagementRateByReach2
     * @return engagementRateByReach2
     */
    public double getEngagementRateByReach2()
    {
        return engagementRateByReach2;
    }

}
