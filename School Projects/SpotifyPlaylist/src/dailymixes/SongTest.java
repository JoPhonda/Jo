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
 * Tests the Song class.
 * 
 * @author Jo
 * @version Nov 9, 2025
 */
public class SongTest
    extends TestCase
{

    private Song song;
    private Song same;
    private Song name;
    private Song suggested;
    private Song genre;

    // ----------------------------------------------------------
    /**
     * Creates three new Song objects.
     */
    public void setUp()
    {
        song = new Song("test", 30, 30, 30, "suggested");
        same = new Song("test", 30, 30, 30, "suggested");
        name = new Song("test2", 30, 30, 30, "suggested");
        suggested = new Song("test", 30, 30, 30, "suggested2");
        genre = new Song("test", 40, 40, 40, "suggested");

    }


    // ----------------------------------------------------------
    /**
     * Checks that getting the name, playlist name, and genre set returns
     * correctly.
     */
    public void testGetters()
    {
        assertEquals("test", song.getName());
        assertEquals("suggested", song.getPlaylistName());
        assertNotNull(song.getGenreSet());
    }


    // ----------------------------------------------------------
    /**
     * Checks that song equals another song when all attributes are the same,
     * and false if one is different.
     */
    public void testEquals()
    {
        assertTrue(song.equals(same));
        assertFalse(song.equals(name));
        assertFalse(song.equals(suggested));
        assertFalse(song.equals(genre));
    }


    // ----------------------------------------------------------
    /**
     * Checks that the toString method works, and when there is no suggested
     * playlist, contains No-Playlist.
     */
    public void testToString()
    {
        assertEquals(
            song.toString(),
            "[test Pop:30 Rock:30 Country:30 Suggested: suggested]");
        Song noPlaylist = new Song("other", 10, 10, 10, "");
        assertEquals(
            noPlaylist.toString(),
            "[No-Playlist other Pop:10 Rock:10 Country:10]");
    }
}
