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

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * InputFileReader takes in a single file, parsing the data of said file into
 * fields of the Influencer and Report Classes. It will then make an
 * InfluencerCalculator and StatWindow to interact and display the data
 * 
 * @author Zander Smith
 * @author Joseph Kim
 * @version Nov 18, 2025
 */
public class InputFileReader
{
    // ~ Fields ................................................................
    private LinkedList<Influencer> influencers;

    /**
     * A constant designating that each line of the file MUST have 10 fields in
     * total
     */
    public static final int NUM_FIELDS = 10;

    // ~ Constructors ..........................................................
    /**
     * Construct an InputFileReader
     * 
     * @param fileName
     *            the name of the file we are parsing from
     * @throws FileNotFoundException
     *             if the file does not exist
     */
    public InputFileReader(String fileName)
        throws FileNotFoundException
    {
        influencers = readFile(fileName);
        System.out.println(influencers.toString());
        StatWindow window = new StatWindow(influencers);
    }
    // ~Public Methods ........................................................


    // ----------------------------------------------------------
    /**
     * For the parsing of the file: Tokens[1, 2 , and 3] determine the identity
     * of the Influencer. Tokens[0, 4 --> 9] determine the fields of a
     * MonthlyReport. We do not always need to make a new Influencer but we do
     * have to make a new MonthlyReport.
     * 
     * @param fileName
     *            the file we wish to parse
     * @return a Linked List of Influencers
     * @throws FileNotFoundException
     *             if the file is somehow unreachable
     */
    public LinkedList<Influencer> readFile(String fileName)
        throws FileNotFoundException
    {
        // list of influencers that will be returned
        LinkedList<Influencer> list = new LinkedList<Influencer>();
        File newFile = new File(fileName);
        @SuppressWarnings("resource")
        Scanner file = new Scanner(newFile);
        // to have an index for ParseException message
        int index = 0;
        // keeps track of the influencer names
        LinkedList<String> influencerNames = new LinkedList<String>();
        file.nextLine();
        while (file.hasNextLine())
        {
            String read = file.nextLine();
            read.replace(" ", "");
            // info contains name, month, country, etc in separate indexes.
            String[] info = read.split(",");
            // if 1 item is missing or if there are extra values
            if (info.length != NUM_FIELDS)
            {
                continue;
            }
            // MonthlyR of the line got.
            MonthlyReport mr = new MonthlyReport(
                info[0],
                Integer.parseInt(info[5]),
                Integer.parseInt(info[6]),
                Integer.parseInt(info[7]),
                Integer.parseInt(info[8]),
                Integer.parseInt(info[9]));
            // if the influencer has already appeared in the list before
            if (influencerNames.contains(info[1]))
            {
                // searches through list and finds influencer in list that
                // matches.
                for (int i = 0; i < 4; i++)
                {
                    if (list.getDataAtIndex(i).getUsername().equals(info[1]))
                    {
                        // adds the monthly report to that influencer
                        list.getDataAtIndex(i).getFullReport()
                            .updateFullReport(mr);
                    }
                }
            }
            // if this is a new influencer
            else
            {
                FullReport fr = new FullReport();
                fr.updateFullReport(mr);
                Influencer i =
                    new Influencer(info[1], info[2], info[3], info[4], fr);
                list.add(i);
                influencerNames.add(info[1]);
            }
            index++;
        }
        return list;
    }
}
