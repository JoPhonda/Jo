// Project 5 Fall 2025
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Zander Smith (906778164)
// LLM Statement:
// I have not used any assistance for the assignment beyond course resources and
// staff.
package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author Zander Smith
 * @version Nov 18, 2025
 */
public class ProjectRunner
{

    /**
     * Main method of the project. Takes in a single csv file
     * 
     * @param args
     *            the file to be converted for Influencers and reports
     * @throws FileNotFoundException
     *             if args is empty
     */
    @SuppressWarnings("unused")
    public static void main(String[] args)
        throws FileNotFoundException
    {
        InputFileReader reader;
        if (args.length > 0)
        {
            reader = new InputFileReader(args[0]);
        }
        else
        {
            reader = new InputFileReader("SampleInput1_2023.csv");
        }
    }
}
