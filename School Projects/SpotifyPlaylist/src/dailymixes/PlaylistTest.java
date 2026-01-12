// Project 4 Fall 2025
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Joseph Kim (906678863)
package dailymixes;

import org.junit.Assert.*;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests the Playlist class.
 * 
 * @author Jo
 * @version Nov 9, 2025
 */
public class PlaylistTest
    extends TestCase
{
    private Playlist playlist;
    private Playlist same;
    private Playlist name;
    private Playlist capacity;
    private Playlist min;
    private Playlist max;

    // ----------------------------------------------------------
    /**
     * Creates three new Playlist objects, 1 equal to the first and the other
     * with 15 instead of 10 at the last value.
     */
    public void setUp()
    {
        playlist = new Playlist("test", 20, 20, 20, 30, 30, 30, 10);
        same = new Playlist("test", 20, 20, 20, 30, 30, 30, 10);
        name = new Playlist("test2", 20, 20, 20, 30, 30, 30, 10);
        capacity = new Playlist("test", 20, 20, 20, 30, 30, 30, 50);
        min = new Playlist("test", 10, 10, 10, 30, 30, 30, 10);
        max = new Playlist("test", 20, 20, 20, 40, 40, 40, 10);

    }


    // ----------------------------------------------------------
    /**
     * Checks that compareTo returns 1 or -1 depending on which capacity is
     * bigger. Checks that compareTo returns 1 or -1 depending on which has the
     * bigger amount of free spaces after 1 is added. Checks that compareTo
     * returns 1 or -1 depending on which has the bigger minCapacity. Checks
     * that compareTo returns 1 or -1 depending on which has the bigger
     * maxCapacity. Checks that compareTo returns 1 or -1 depending on which has
     * the longer name.
     */
    public void testCompareTo()
    {
        assertEquals(playlist.compareTo(name), -1);
        assertEquals(playlist.compareTo(capacity), -1);
        assertEquals(capacity.compareTo(playlist), 1);
        assertEquals(playlist.compareTo(same), 0);
        same.addSong(new Song("test", 25, 25, 25, "other"));
        assertEquals(playlist.compareTo(same), 1);
        assertEquals(same.compareTo(playlist), -1);
        assertEquals(playlist.compareTo(min), 1);
        assertEquals(playlist.compareTo(max), -1);
    }


    // ----------------------------------------------------------
    /**
     * Checks that the spaces left in playlist is 10. Checks that playlist is
     * not full. Adds songs until full and checks that isFull is true.
     */
    public void testGetSpacesLeftAndFull()
    {
        assertEquals(10, playlist.getSpacesLeft());
        assertFalse(playlist.isFull());
        for (int i = 0; i < 10; i++)
        {
            playlist.addSong(new Song("test", 25, 25, 25, "other"));
        }
        assertTrue(playlist.isFull());
    }


    // ----------------------------------------------------------
    /**
     * Checks that a song with values between playlist's min and max is
     * qualified to be added. Checks that that song has been added. Checks that
     * trying to add a song and testing qualifications of a song that doesn't
     * fit the max or min genre set returns false. Adds songs until full, then
     * checks that adding another song returns false.
     */
    public void testAddSongAndIsQualified()
    {
        Song s1 = new Song("song", 25, 25, 25, "test");
        Song s2 = new Song("song", 10, 10, 10, "test");
        Song s3 = new Song("song", 50, 50, 50, "test");
        assertTrue(playlist.isQualified(s1));
        assertTrue(playlist.addSong(s1));
        assertFalse(playlist.isQualified(s2));
        assertFalse(playlist.isQualified(s3));
        assertFalse(playlist.addSong(s2));
        for (int i = 0; i < 10; i++)
        {
            same.addSong(new Song("test", 25, 25, 25, "other"));
        }
        assertFalse(same.addSong(s2));
    }


    // ----------------------------------------------------------
    /**
     * Checks that playlist equals returns true when all attributes are the
     * same, and false if one is different. Checks that toString returns
     * correctly.
     */
    public void testEqualsAndToString()
    {
        assertTrue(playlist.equals(same));
        assertFalse(playlist.equals(name));
        assertFalse(playlist.equals(max));
        assertFalse(playlist.equals(min));
        assertFalse(playlist.equals(capacity));
        same.addSong(new Song("test", 25, 25, 25, "other"));
        assertFalse(playlist.equals(same));
        String str = playlist.toString();
        assertTrue(str.contains("Playlist: test"));
    }
}
