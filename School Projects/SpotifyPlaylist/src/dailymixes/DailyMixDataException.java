package dailymixes;

// -------------------------------------------------------------------------
/**
 * This is a unique Exception that is called when data is incorrect in the input
 * files.
 * 
 * @author Jo
 * @version Nov 9, 2025
 */
public class DailyMixDataException
    extends Exception
{
    // ----------------------------------------------------------
    /**
     * This constructor calls the superclass, Exception, and passes a string.
     * 
     * @param string
     *            The string message that is passed to Exception
     */
    public DailyMixDataException(String string)
    {
        super(string);
    }

}
