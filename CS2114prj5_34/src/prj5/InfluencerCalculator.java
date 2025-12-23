// Project 5 Fall 2025
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Christian Chung (906793112) & Ryan Li (ryanli25)

// LLM Statement:

// I have not used any assistance for the assignment beyond course resources and
// staff.
package prj5;

import java.util.Comparator;

/**
 * Calculates and manages the list of influencers, providing sorting methods.
 * 
 * @author Christian Chung
 * @author Zander Smith
 * @version Nov 20, 2025
 */
public class InfluencerCalculator
{
    private LinkedList<Influencer> influencers;

    // ----------------------------------------------------------
    /**
     * Create a new InfluencerCalculator object.
     * 
     * @param influencers
     *            The list of all influencers loaded from the file.
     */
    public InfluencerCalculator(LinkedList<Influencer> influencers)
    {
        this.influencers = influencers;
    }


    // ----------------------------------------------------------
    /**
     * Gets the list of influencers.
     * 
     * @return The LinkedList of Influencer objects.
     */
    public LinkedList<Influencer> getInfluencers()
    {
        return influencers;
    }


    // ----------------------------------------------------------
    /**
     * Sorts the LinkedList of Influencer objects using the provided comparator
     * and a simple Insertion Sort algorithm.
     * 
     * @param nodeToInsert
     *            The node that will be sorted.
     * @param comp
     *            The Comparator to use for sorting (L1, L2, or Channel Name).
     */
    private void insertInOrder(
        LinkedList.Node<Influencer> nodeToInsert,
        Comparator<Influencer> comp)
    {
        LinkedList.Node<Influencer> head = influencers.getHead();
        LinkedList.Node<Influencer> tail = influencers.getTail();

        Influencer item = nodeToInsert.getData();
        if (item == null)
        {
            throw new IllegalStateException(
                "Influencer is null in insertInOrder()");
        }

        LinkedList.Node<Influencer> previous = head;
        LinkedList.Node<Influencer> current = head.getNext();

        while (current != tail && comp.compare(item, current.getData()) > 0)
        {
            previous = current;
            current = current.getNext();
        }

        nodeToInsert.setNext(current);
        previous.setNext(nodeToInsert);
    }


    // ----------------------------------------------------------
    /**
     * Sorts the LinkedList of Influencer objects using the provided comparator
     * and a simple Insertion Sort algorithm by month.
     * 
     * @param comp
     *            The Comparator to use for sorting (L1, L2, or Channel Name).
     * @param nodeToInsert
     *            The node that will be sorted.
     * @param month
     *            The month that is being sorted by.
     * @param o
     *            An int that will determine if it will be sorted by reach or
     *            engagement.
     */
    private void insertInOrderByMonth(
        LinkedList.Node<Influencer> nodeToInsert,
        Comparator<Influencer> comp,
        String month,
        int o)
    {
        LinkedList.Node<Influencer> head = influencers.getHead();
        LinkedList.Node<Influencer> tail = influencers.getTail();

        Influencer item = nodeToInsert.getData();
        if (item == null)
        {
            throw new IllegalStateException(
                "Influencer is null in insertInOrder()");
        }

        LinkedList.Node<Influencer> previous = head;
        LinkedList.Node<Influencer> current = head.getNext();
        if (o == 1)
        {
            while (current != tail && ((L1Comparator)comp)
                .compareByMonth(item, current.getData(), month) > 0)
            {
                previous = current;
                current = current.getNext();
            }
        }
        else if (o == -1)
        {
            while (current != tail && ((L2Comparator)comp)
                .compareByMonth(item, current.getData(), month) > 0)
            {
                previous = current;
                current = current.getNext();
            }
        }
        nodeToInsert.setNext(current);
        previous.setNext(nodeToInsert);
    }


    // ----------------------------------------------------------
    /**
     * Calls the insertInOrder method until the entire list is sorted.
     * 
     * @param comp
     *            The Comparator to use for sorting (L1, L2, or Channel Name).
     */
    public void insertionSort(Comparator<Influencer> comp)
    {
        LinkedList.Node<Influencer> head = influencers.getHead();
        LinkedList.Node<Influencer> tail = influencers.getTail();

        if (head.getNext() == tail || head.getNext().getNext() == tail)
        {
            return;
        }

        LinkedList.Node<Influencer> sorted = head.getNext();
        LinkedList.Node<Influencer> unsorted = sorted.getNext();

        sorted.setNext(tail);

        while (unsorted != tail)
        {
            LinkedList.Node<Influencer> nodeToInsert = unsorted;
            unsorted = unsorted.getNext();

            nodeToInsert.setNext(null);

            insertInOrder(nodeToInsert, comp);
        }
    }


    // ----------------------------------------------------------
    /**
     * Calls the insertInOrder method until the entire list is sorted by month.
     * 
     * @param comp
     *            The Comparator to use for sorting (L1, L2, or Channel Name).
     * @param month
     *            The month that is being sorted by.
     */
    public void insertionSortByMonth(Comparator<Influencer> comp, String month)
    {
        int o = 0;
        if (comp instanceof L1Comparator)
        {
            o = 1;
        }
        else if (comp instanceof L2Comparator)
        {
            o = -1;
        }
        LinkedList.Node<Influencer> head = influencers.getHead();
        LinkedList.Node<Influencer> tail = influencers.getTail();

        if (head.getNext() == tail || head.getNext().getNext() == tail)
        {
            return;
        }

        LinkedList.Node<Influencer> sorted = head.getNext();
        LinkedList.Node<Influencer> unsorted = sorted.getNext();

        sorted.setNext(tail);

        while (unsorted != tail)
        {
            LinkedList.Node<Influencer> nodeToInsert = unsorted;
            unsorted = unsorted.getNext();

            nodeToInsert.setNext(null);

            insertInOrderByMonth(nodeToInsert, comp, month, o);
        }
    }


    // ----------------------------------------------------------
    /**
     * Calculates the engagement rate (likes + comments) / followers * 100.
     * * @param influencer The influencer to calculate the rate for.
     * 
     * @return The engagement rate as a double.
     */
    public double calculateEngagementRateFollowers(Influencer influencer)
    {
        FullReport rep = influencer.getFullReport();
        int activity = rep.getTotalLikes() + rep.getTotalComments();
        int followers = rep.getTotalFollowers();

        if (followers == 0)
        {
            return 0.0;
        }

        return ((double)activity / followers) * 100.0;
    }


    // ----------------------------------------------------------
    /**
     * Calculates the engagement rate (likes + comments) / views * 100. *
     * 
     * @param influencer
     *            The influencer to calculate the rate for.
     * @return The engagement rate by reach as a double.
     */
    public double calculateEngagementRateReach(Influencer influencer)
    {
        FullReport rep = influencer.getFullReport();
        int activity = rep.getTotalLikes() + rep.getTotalComments();
        int views = rep.getTotalViews();

        if (views == 0)
        {
            return 0.0;
        }

        return ((double)activity / views) * 100.0;
    }


    // ----------------------------------------------------------
    /**
     * Calculates the engagement rate for a specific month. The rate is
     * calculated as: (monthly_likes + monthly_comments) / monthly_followers *
     * 100. *
     * 
     * @param influencer
     *            The influencer to calculate the rate for.
     * @param month
     *            The name of the month (e.g., "July").
     * @param compare
     *            An int that determines whether it is by engagement or reach.
     * @return The monthly engagement rate as a double, or 0.0 if not found.
     */
    public double calculateMonthlyEngagementRate(
        Influencer influencer,
        String month,
        int compare)
    {
        LinkedList<MonthlyReport> history =
            influencer.getFullReport().getReportHistory();
        int sum = 0;
        for (int i = 0; i < history.size(); i++)
        {
            MonthlyReport mr = history.getDataAtIndex(i);
            if (mr.getMonth().equals(month))
            {
                int activity = mr.getMonthlyLikes() + mr.getMonthlyComments();
                int followers = mr.getMonthlyFollowers();
                int views = mr.getMonthlyViews();
                if (followers != 0)
                {
                    if (compare == 1)
                    {
                        sum += ((double)activity / followers) * 100.0;
                    }
                    else if (compare == -1)
                    {
                        sum += ((double)activity / views) * 100.0;
                    }
                }
            }
        }
        return sum;
    }


    // ----------------------------------------------------------
    /**
     * This is the father method called by the StatWindow to calculate the
     * differnet engagement rates to be displayed in the UI.
     * 
     * @param inf
     *            the influencer we are getting the calculations from
     * @param whichMethod
     *            if this int is negative, calculate the engagement rate based
     *            on reach. If positive,calculate based on Followers. a value of
     *            zero activates the calculation based on months instead of the
     *            full report.
     * @param month
     *            if whichMethod is 0, this is the month that is being searched
     *            for in the report
     * @return the engagement rate of an influencer based upon the factors of
     *             the UI
     */
    public double calculate(Influencer inf, int whichMethod, String month)
    {
        if (whichMethod == 1)
        {
            return calculateEngagementRateFollowers(inf);
        }
        else if (whichMethod == -1)
        {
            return calculateEngagementRateReach(inf);
        }
        else if (whichMethod == 2)
        {
            return calculateMonthlyEngagementRate(inf, month, 1);
        }

        return calculateMonthlyEngagementRate(inf, month, -1);
    }
}
