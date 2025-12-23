// Project 5 Fall 2025
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ryan Li (ryanli25)
// LLM Statement:
// I have not used any assistance for the assignment beyond course resources and
// staff.
package prj5;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.Comparator;

/**
 * Creates the GUI window to display influencer statistics using standard Java
 * Swing. This class replaces the use of proprietary student.window.* classes
 * with JFrame, JButton, and custom JPanel drawing logic. *
 * 
 * @author Ryan Li
 * @author Jo
 * @author Zander
 * @version Nov 21, 2025
 */
public class StatWindow
{
    // ~ Fields
    // ................................................................\
    private JFrame window;
    private DataDisplayPanel dataDisplayPanel;
    private LinkedList<Influencer> list;
    private L1Comparator comparator1;
    private L2Comparator comparator2;
    private InfluencerCalculator calculator;
    private int calcType;
    private int compType;
    private String month;

    // ~ Constructors ..........................................................

    /**
     * Creates a new StatWindow object to display influencer data.
     * 
     * @param influencerList
     *            The list of influencers to display.
     */
    public StatWindow(LinkedList<Influencer> influencerList)
    {
        list = influencerList;
        // 1. Setup the main JFrame (Replaces Window)
        window = new JFrame("Influencer Statistics Report");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Use BorderLayout for organization (Similar concept to WindowSide)
        window.setLayout(new BorderLayout());
        window.setMinimumSize(new Dimension(800, 600));

        // 2. Setup the main display area (Replaces the drawing surface)
        dataDisplayPanel = new DataDisplayPanel(influencerList);

        // 3. Add buttons (Replaces Button and WindowSide positioning)
        setupButtons();

        // Finalize and display the window
        window.pack();
        window.setLocationRelativeTo(null); // Center the window
        window.setVisible(true);
        // set up the comparators and Influencer Calculator
        calculator = new InfluencerCalculator(list);
        comparator1 = new L1Comparator();
        comparator2 = new L2Comparator();
        // keeps track of whether it's engagement or reach rate
        compType = 1;
    }

    // ~ Private Methods .......................................................


    /**
     * Initializes all buttons and their ActionListeners, and adds them to the
     * JFrame.
     */
    private void setupButtons()
    {
        JPanel buttonPanelTop = new JPanel();
        buttonPanelTop
            .setLayout(new BoxLayout(buttonPanelTop, BoxLayout.X_AXIS));

        JButton sortNameButton = new JButton("Sort by Name");
        // The ActionListener is how you handle clicks in Swing
        sortNameButton.addActionListener(
            e -> sortInfluencers(
                Comparator.comparing(Influencer::getUsername)));

        JButton sortL1Button = new JButton("Sort by Engagement Rate");
        sortL1Button.addActionListener(e -> sortInfluencers(comparator1));

        JButton sortL2Button = new JButton("Sort by Reach Rate");
        sortL2Button.addActionListener(e -> sortInfluencers(comparator2));

        buttonPanelTop.add(sortNameButton);
        buttonPanelTop.add(sortL1Button);
        buttonPanelTop.add(sortL2Button);

        // --- Bottom Buttons Panel (WindowSide.SOUTH equivalent) ---
        JPanel buttonPanelBottom = new JPanel();
        buttonPanelBottom
            .setLayout(new BoxLayout(buttonPanelBottom, BoxLayout.X_AXIS));

        JButton janButton = new JButton("January");
        janButton.addActionListener(e -> sortInfluencersByMonth("January"));

        JButton febButton = new JButton("February");
        febButton.addActionListener(e -> sortInfluencersByMonth("February"));

        JButton marButton = new JButton("March");
        marButton.addActionListener(e -> sortInfluencersByMonth("March"));

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> System.exit(0));

        buttonPanelBottom.add(quitButton);
        buttonPanelBottom.add(janButton);
        buttonPanelBottom.add(febButton);
        buttonPanelBottom.add(marButton);

        window.add(buttonPanelTop, BorderLayout.NORTH);
        window.add(dataDisplayPanel, BorderLayout.CENTER);
        window.add(buttonPanelBottom, BorderLayout.SOUTH);
    }


    /**
     * Sorts the list and redraws the visualization.
     */
    private void sortInfluencers(Comparator<Influencer> comparator)
    {

        if (comparator.getClass() == L1Comparator.class)
        {
            compType = 1;
            calcType = 1;
            month = "";
        }
        else if (comparator.getClass() == L2Comparator.class)
        {
            compType = -1;
            calcType = -1;
            month = "";
        }
        calculator.insertionSort(comparator);
        dataDisplayPanel.repaint();
    }


    /**
     * Sorts the list and redraws the visualization by month.
     */
    private void sortInfluencersByMonth(String m)
    {
        if (compType == 1)
        {
            calcType = 2;
            month = m;
            calculator.insertionSortByMonth(comparator1, m);

        }
        else if (compType == -1)
        {
            calcType = -2;
            month = m;
            calculator.insertionSortByMonth(comparator2, m);
        }
        dataDisplayPanel.repaint();
    }

    /**
     * A custom JPanel used to draw the bar charts and text (replacing TextShape
     * and the proprietary drawing canvas).
     */
    private class DataDisplayPanel
        extends JPanel
    {

        private LinkedList<Influencer> list;

        /**
         * Constructs a new DataDisplayPanel object.
         */
        public DataDisplayPanel(LinkedList<Influencer> influencerList)
        {
            this.list = influencerList;
            setBackground(Color.WHITE);
            setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }


        /**
         * The standard method for drawing custom graphics in Swing. The
         * Graphics object is what you use to draw shapes and text.
         */
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            int width = getWidth();
            int height = getHeight();
            int barWidth = 60;
            int spacing = 40;

            g.setColor(Color.BLACK);
            g.drawString("Influencer Data Visualization", width / 2 - 80, 20);

            Color[] barColors =
                { new Color(255, 150, 50), new Color(60, 100, 200),
                    new Color(40, 100, 100), new Color(60, 180, 80) };

            double maxRate = 0.2;

            int maxBarDisplayHeight = height - 510;
            double scaleFactor = maxBarDisplayHeight / maxRate;
            int xPos = 200;
            for (int i = 0; i < list.size(); i++)
            {
                Influencer inf = list.getDataAtIndex(i);

                double totalEngagement =
                    calculator.calculate(inf, calcType, month);
                int barHeight =
                    Math.min(300, (int)(totalEngagement * scaleFactor));

                int barY = height - 70 - barHeight;

                g.setColor(barColors[i % barColors.length]);

                g.fillRect(xPos, barY, barWidth, barHeight);

                DecimalFormat df = new DecimalFormat("#.0");
                String rateString = df.format(totalEngagement);

                g.setColor(Color.BLACK);
                g.drawString(
                    rateString,
                    (xPos + (barWidth / 2)
                        - g.getFontMetrics().stringWidth(rateString) / 2),
                    height - 40);

                String username = inf.getUsername();
                g.drawString(
                    username,
                    (xPos + (barWidth / 2)
                        - (g.getFontMetrics().stringWidth(username) / 2)),
                    height - 20);

                xPos += barWidth + spacing;

                if (xPos > width - barWidth)
                {
                    break;
                }
            }
        }
    }
}
