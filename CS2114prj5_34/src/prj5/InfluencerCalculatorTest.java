// Project 5 Fall 2025

package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests the InfluencerCalculator class.
 * 
 * @author Jo
 * @version Dec 5, 2025
 */

public class InfluencerCalculatorTest
    extends TestCase
{
    private InfluencerCalculator ic;
    private LinkedList<Influencer> influencers;
    private Influencer inf1;
    private Influencer inf2;
    private Influencer inf3;
    private Influencer inf4;
    private L1Comparator comp1;
    private L2Comparator comp2;

    /**
     * Sets up an example InfluencerCalculator Object.
     */
    public void setUp()
    {
        influencers = new LinkedList<Influencer>();

        FullReport fr1 =
            new FullReport(1000, 20, 500, 500, 2000, new LinkedList<>());
        fr1.updateFullReport(new MonthlyReport("January", 100, 5, 50, 50, 200));
        fr1.updateFullReport(
            new MonthlyReport("February", 150, 6, 60, 60, 250));
        inf1 = new Influencer("ryan", "Ryan's Channel", "USA", "Tech", fr1);

        FullReport fr2 =
            new FullReport(800, 25, 1000, 400, 3000, new LinkedList<>());
        fr2.updateFullReport(new MonthlyReport("January", 80, 4, 100, 40, 300));
        fr2.updateFullReport(
            new MonthlyReport("February", 120, 5, 120, 50, 350));
        inf2 = new Influencer("ryan", "Ryan's World", "UK", "Gaming", fr2);

        FullReport fr3 =
            new FullReport(500, 15, 2000, 300, 5000, new LinkedList<>());
        fr3.updateFullReport(new MonthlyReport("January", 50, 3, 200, 30, 500));
        fr3.updateFullReport(
            new MonthlyReport("February", 70, 4, 250, 40, 600));
        inf3 = new Influencer("ryan", "Ryan's Vlog", "Canada", "Travel", fr3);

        FullReport fr4 =
            new FullReport(200, 10, 5000, 100, 10000, new LinkedList<>());
        fr4.updateFullReport(
            new MonthlyReport("January", 20, 2, 500, 10, 1000));
        fr4.updateFullReport(
            new MonthlyReport("February", 30, 3, 600, 15, 1200));
        inf4 = new Influencer("ryan", "Ryan's Daily", "Australia", "Food", fr4);

        influencers.add(inf1);
        influencers.add(inf2);
        influencers.add(inf3);
        influencers.add(inf4);

        ic = new InfluencerCalculator(influencers);
        comp1 = new L1Comparator();
        comp2 = new L2Comparator();
    }


    /**
     * Tests the getInfluencers method.
     */
    public void testGet()
    {
        assertEquals(influencers, ic.getInfluencers());
        assertEquals(4, ic.getInfluencers().size());
    }


    /**
     * Tests the insertInOrder, insertInOrderByMonth, insertionSort, and
     * insertionSortByMonth method.
     */
    public void testInsertions()
    {
        ic.insertionSort(comp1);

        assertEquals(
            "ryan",
            ic.getInfluencers().getDataAtIndex(0).getUsername());
        assertEquals(
            "ryan",
            ic.getInfluencers().getDataAtIndex(1).getUsername());
        assertEquals(
            "ryan",
            ic.getInfluencers().getDataAtIndex(2).getUsername());
        assertEquals(
            "ryan",
            ic.getInfluencers().getDataAtIndex(3).getUsername());

        influencers = new LinkedList<Influencer>();
        influencers.add(inf1);
        influencers.add(inf2);
        influencers.add(inf3);
        influencers.add(inf4);
        ic = new InfluencerCalculator(influencers);

        ic.insertionSort(comp2);

        assertNotNull(ic.getInfluencers().getDataAtIndex(0));

        influencers = new LinkedList<Influencer>();
        influencers.add(inf1);
        influencers.add(inf2);
        influencers.add(inf3);
        influencers.add(inf4);
        ic = new InfluencerCalculator(influencers);

        ic.insertionSortByMonth(comp1, "January");
        assertNotNull(ic.getInfluencers().getDataAtIndex(0));

        influencers = new LinkedList<Influencer>();
        influencers.add(inf1);
        influencers.add(inf2);
        influencers.add(inf3);
        influencers.add(inf4);
        ic = new InfluencerCalculator(influencers);

        ic.insertionSortByMonth(comp2, "February");
        assertNotNull(ic.getInfluencers().getDataAtIndex(0));

        LinkedList<Influencer> singleList = new LinkedList<Influencer>();
        singleList.add(inf1);
        InfluencerCalculator singleCalc = new InfluencerCalculator(singleList);
        singleCalc.insertionSortByMonth(comp1, "January");
        assertEquals(1, singleCalc.getInfluencers().size());

        LinkedList<Influencer> twoList = new LinkedList<Influencer>();
        twoList.add(inf1);
        twoList.add(inf2);
        InfluencerCalculator twoCalc = new InfluencerCalculator(twoList);
        twoCalc.insertionSortByMonth(comp2, "February");
        assertEquals(2, twoCalc.getInfluencers().size());
    }


    /**
     * Tests insertion sort with a single element list.
     */
    public void testInsertionSortSingleElement()
    {
        LinkedList<Influencer> singleList = new LinkedList<Influencer>();
        singleList.add(inf1);
        InfluencerCalculator singleCalc = new InfluencerCalculator(singleList);

        singleCalc.insertionSort(comp1);
        assertEquals(1, singleCalc.getInfluencers().size());
        assertEquals(
            "ryan",
            singleCalc.getInfluencers().getDataAtIndex(0).getUsername());
    }


    /**
     * Tests insertion sort with an empty list.
     */
    public void testInsertionSortEmpty()
    {
        LinkedList<Influencer> emptyList = new LinkedList<Influencer>();
        InfluencerCalculator emptyCalc = new InfluencerCalculator(emptyList);

        emptyCalc.insertionSort(comp1);
        assertEquals(0, emptyCalc.getInfluencers().size());
    }


    /**
     * Tests insertInOrderByMonth with multiple influencers to ensure the while
     * loops execute.
     */
    public void testInsertionSortByMonthMultiple()
    {
        FullReport fr5 =
            new FullReport(2000, 30, 800, 700, 3000, new LinkedList<>());
        fr5.updateFullReport(
            new MonthlyReport("January", 200, 10, 80, 70, 300));
        Influencer inf5 =
            new Influencer("ryan5", "Ryan's Gaming", "USA", "Gaming", fr5);

        FullReport fr6 =
            new FullReport(500, 10, 1500, 200, 4000, new LinkedList<>());
        fr6.updateFullReport(new MonthlyReport("January", 50, 5, 150, 20, 400));
        Influencer inf6 =
            new Influencer("ryan6", "Ryan's Tech", "UK", "Tech", fr6);

        FullReport fr7 =
            new FullReport(1500, 20, 1000, 500, 3500, new LinkedList<>());
        fr7.updateFullReport(
            new MonthlyReport("January", 150, 8, 100, 50, 350));
        Influencer inf7 =
            new Influencer("ryan7", "Ryan's Travel", "Canada", "Travel", fr7);

        LinkedList<Influencer> multiList = new LinkedList<Influencer>();
        multiList.add(inf5);
        multiList.add(inf6);
        multiList.add(inf7);

        InfluencerCalculator multiCalc = new InfluencerCalculator(multiList);
        multiCalc.insertionSortByMonth(comp1, "January");

        assertEquals(3, multiCalc.getInfluencers().size());
        assertNotNull(multiCalc.getInfluencers().getDataAtIndex(0));
        assertNotNull(multiCalc.getInfluencers().getDataAtIndex(1));
        assertNotNull(multiCalc.getInfluencers().getDataAtIndex(2));

        LinkedList<Influencer> multiList2 = new LinkedList<Influencer>();
        multiList2.add(inf5);
        multiList2.add(inf6);
        multiList2.add(inf7);

        InfluencerCalculator multiCalc2 = new InfluencerCalculator(multiList2);
        multiCalc2.insertionSortByMonth(comp2, "January");

        assertEquals(3, multiCalc2.getInfluencers().size());
        assertNotNull(multiCalc2.getInfluencers().getDataAtIndex(0));
        assertNotNull(multiCalc2.getInfluencers().getDataAtIndex(1));
        assertNotNull(multiCalc2.getInfluencers().getDataAtIndex(2));
    }


    /**
     * Tests that insertInOrderByMonth throws exception when encountering null.
     */
    public void testInsertionSortByMonthWithNull()
    {
        LinkedList<Influencer> nullList = new LinkedList<Influencer>();
        nullList.add(inf1);
        nullList.add(null);
        nullList.add(inf2);

        InfluencerCalculator nullCalc = new InfluencerCalculator(nullList);

        Exception exception = null;
        try
        {
            nullCalc.insertionSortByMonth(comp1, "January");
        }
        catch (IllegalStateException e)
        {
            exception = e;
        }

        assertNotNull(exception);
        assertTrue(exception instanceof IllegalStateException);
        assertEquals(
            "Influencer is null in insertInOrder()",
            exception.getMessage());
    }


    /**
     * Tests the calculateEngagementRateFollowers, calculateEngagementRateReach,
     * calculateMonthlyEngagementRate, and calculate method.
     */
    public void testCalculates()
    {
        int rate1 = (int)ic.calculateEngagementRateFollowers(inf1);
        assertEquals(rate1, 304);

        int rate2 = (int)ic.calculateEngagementRateFollowers(inf2);
        assertEquals(rate2, 122);

        int reach1 = (int)ic.calculateEngagementRateReach(inf1);
        assertEquals(reach1, 75);

        int reach2 = (int)ic.calculateEngagementRateReach(inf2);
        assertEquals(reach2, 40);

        int reach3 = (int)ic.calculateEngagementRateReach(inf3);
        assertEquals(reach3, 16);

        int reach4 = (int)ic.calculateEngagementRateReach(inf4);
        assertEquals(reach4, 3);

        FullReport frZero =
            new FullReport(100, 10, 0, 50, 1000, new LinkedList<>());
        Influencer infZero =
            new Influencer("zero", "Zero", "US", "Test", frZero);
        int rateZero = (int)ic.calculateEngagementRateFollowers(infZero);
        assertEquals(rateZero, 0);

        FullReport frZeroViews =
            new FullReport(100, 10, 500, 50, 0, new LinkedList<>());
        Influencer infZeroViews =
            new Influencer("zeroV", "ZeroV", "US", "Test", frZeroViews);
        int reachZero = (int)ic.calculateEngagementRateReach(infZeroViews);
        assertEquals(reachZero, 0);

        FullReport frZeroFollowersOnly =
            new FullReport(0, 0, 0, 0, 100, new LinkedList<>());
        Influencer infZeroFollowers =
            new Influencer("zeroF", "ZeroF", "US", "Test", frZeroFollowersOnly);
        int rateZeroFollowers =
            (int)ic.calculateEngagementRateFollowers(infZeroFollowers);
        assertEquals(rateZeroFollowers, 0);

        FullReport frZeroViewsOnly =
            new FullReport(100, 10, 500, 50, 0, new LinkedList<>());
        Influencer infZeroViewsOnly =
            new Influencer("zeroVO", "ZeroVO", "US", "Test", frZeroViewsOnly);
        int reachZeroViews =
            (int)ic.calculateEngagementRateReach(infZeroViewsOnly);
        assertEquals(reachZeroViews, 0);

        int monthlyRate1 =
            (int)ic.calculateMonthlyEngagementRate(inf1, "January", 1);
        assertEquals(monthlyRate1, 300);

        int monthlyReach1 =
            (int)ic.calculateMonthlyEngagementRate(inf1, "January", -1);
        assertEquals(monthlyReach1, 75);

        int nonExistent =
            (int)ic.calculateMonthlyEngagementRate(inf1, "December", 1);
        assertEquals(nonExistent, 0);

        int calc1 = (int)ic.calculate(inf1, 1, "");
        assertEquals(calc1, 304);

        int calc2 = (int)ic.calculate(inf1, -1, "");
        assertEquals(calc2, 75);

        int calc3 = (int)ic.calculate(inf1, 2, "January");
        assertEquals(calc3, 300);

        int calc4 = (int)ic.calculate(inf1, -2, "January");
        assertEquals(calc4, 75);
    }


    /**
     * Tests calculate method with multiple months for the same influencer.
     */
    public void testCalculateMultipleMonths()
    {
        double febRate = ic.calculate(inf1, 2, "February");
        double janRate = ic.calculate(inf1, 2, "January");

        assertTrue(febRate > 0);
        assertTrue(janRate > 0);
        assertTrue(Math.abs(janRate - febRate) > 0.01);
    }
}
