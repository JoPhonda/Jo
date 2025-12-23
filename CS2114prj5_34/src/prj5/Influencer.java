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

// -------------------------------------------------------------------------
/**
 * influencer class
 * 
 * @author Jo
 * @author Zander Smith
 * @version Nov 19, 2025
 */
public class Influencer
{
    private String username;
    private String channelName;
    private String country;
    private String mainTopic;
    private FullReport fullReport;

    // ----------------------------------------------------------
    /**
     * Create a new Influencer object.
     * 
     * @param u
     *            username
     * @param cn
     *            channel name
     * @param c
     *            country
     * @param mt
     *            main topic
     * @param fr
     *            full report
     */
    public Influencer(String u, String cn, String c, String mt, FullReport fr)
    {
        username = u;
        channelName = cn;
        country = c;
        mainTopic = mt;
        fullReport = fr;
    }


    // ----------------------------------------------------------
    /**
     * returns username.
     * 
     * @return username
     */
    public String getUsername()
    {
        return username;
    }


    // ----------------------------------------------------------
    /**
     * returns channelName.
     * 
     * @return channelName
     */
    public String getChannelName()
    {
        return channelName;
    }


    // ----------------------------------------------------------
    /**
     * returns mainTopic.
     * 
     * @return mainTopic
     */
    public String getMainTopic()
    {
        return mainTopic;
    }


    // ----------------------------------------------------------
    /**
     * returns country.
     * 
     * @return country
     */
    public String getCountry()
    {
        return country;
    }


    // ----------------------------------------------------------
    /**
     * returns fullReport.
     * 
     * @return fullReport
     */
    public FullReport getFullReport()
    {
        return fullReport;
    }


    // ----------------------------------------------------------
    /**
     * returns the toString value
     * 
     * @return toString value
     */
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append(getUsername() + ":\n");
        str.append("Channel Name: " + getChannelName() + "\n");
        str.append("Main Topic: " + getMainTopic() + "\n");
        str.append("Country: " + getCountry() + "\n");
        str.append("Full Report:\n" + getFullReport());
        return str.toString();
    }


    // ----------------------------------------------------------
    /**
     * Compares all values of this influencer to the influencer taken in.
     * 
     * @param o
     *            other influencer
     * @return equals
     */
    @Override
    public boolean equals(Object o)
    {
        if (o == null)
        {
            return false;
        }
        Influencer i = (Influencer) o;
        return username.equals(i.getUsername())
            && channelName.equals(i.getChannelName())
            && mainTopic.equals(i.getMainTopic())
            && country.equals(i.getCountry())
            && fullReport.equals(i.getFullReport());
    }
}
