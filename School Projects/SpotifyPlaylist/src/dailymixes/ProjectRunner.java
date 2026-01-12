package dailymixes;

import bsh.ParseException;
import java.io.FileNotFoundException;

// -------------------------------------------------------------------------
/**
 * Runs the Spotify Playlist simulator.
 * 
 * @author Jo
 * @version Nov 10, 2025
 */
public class ProjectRunner
{

    // ----------------------------------------------------------
    /**
     * Sets the playlistReader based on what is in args
     * 
     * @param args
     *            input, followed by playlists
     */
    public static void main(String[] args)
    {

        try
        {
            if (args.length < 2)
            {
                System.out.println("Usage: java ProjectRunner <songsFile> <playlistsFile>");
                return;
            }

            String songsFile = args[0];
            String playlistsFile = args[1];

            PlaylistReader reader = new PlaylistReader(songsFile, playlistsFile);
        }
        catch (java.text.ParseException e)
        {
            System.out.println("Error parsing file: " + e.getMessage());
        }
        catch (DailyMixDataException e)
        {
            System.out.println("Invalid data in input: " + e.getMessage());
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
