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
 * Tests the methods inside PlaylistCalculator.
 * 
 * @author Jo
 * @version Nov 11, 2025
 */
public class PlaylistCalculatorTest
    extends TestCase
{
    private PlaylistCalculator calc;
    private Playlist[] pl;
    private ArrayQueue<Song> aq;

    // ----------------------------------------------------------
    /**
     * Makes a playlist of size 3, an arrayQueue, and a PlaylistCalculator with
     * those two as values.
     */
    public void setUp()
    {
        pl = new Playlist[PlaylistCalculator.NUM_PLAYLISTS];
        aq = new ArrayQueue<Song>();

    }


    // ----------------------------------------------------------
    /**
     * Tests when the arrayQueue in playlist calculator is null.
     */
    public void testNullArrayQueue()
    {
        Exception thrown = null;
        try
        {
            calc = new PlaylistCalculator(null, pl);
        }
        catch (IllegalArgumentException e)
        {
            thrown = e;
        }
        assertNotNull(thrown);
    }


    // ----------------------------------------------------------
    /**
     * Tests getPlaylistForSong and getPlaylistWithMaximumCapacity because its
     * in it. Tests: if the song is not null. if the suggested playlist's name
     * is not null. if the playlist is found. if the playlist found is full. if
     * the playlist found is not qualified. if maxcap is null because playlists
     * is full or not qualified or if it returns the correct playlist
     */
    public void testGetPlaylistSongMaxCap()
    {
        Song s = new Song("name null", 30, 30, 30, null);
        Song found = new Song("found", 30, 30, 30, "playlist1");
        Song notFound = new Song("not found", 30, 30, 30, "playlist2");
        calc = new PlaylistCalculator(aq, pl);
        // playlist is not found
        assertNull(calc.getPlaylistForSong(notFound));
        Song outOfRange = new Song("out of range", 50, 50, 50, "playlist1");
        Playlist p = new Playlist("playlist1", 20, 20, 20, 40, 40, 40, 2);
        pl[0] = p;
        calc = new PlaylistCalculator(aq, pl);
        // song is null
        assertNull(calc.getPlaylistForSong(null));
        // song playlist name is null
        assertNull(calc.getPlaylistForSong(s));
        // playlist is found, not full, and qualified
        assertEquals(calc.getPlaylistForSong(found), p);
        // playlist found is full
        p.addSong(new Song("filler1", 30, 30, 30, "playlist1"));
        p.addSong(new Song("filler2", 30, 30, 30, "playlist1"));
        calc = new PlaylistCalculator(aq, pl);
        assertNull(calc.getPlaylistForSong(found));
        // playlist found is not qualified
        p = new Playlist("playlist1", 20, 20, 20, 40, 40, 40, 2);
        calc = new PlaylistCalculator(aq, pl);
        assertNull(calc.getPlaylistForSong(outOfRange));
        // max capacity playlist is ok
        Playlist max = new Playlist("max cap", 20, 20, 20, 40, 40, 40, 3);
        Song m = new Song("max song", 30, 30, 30, "idk");
        pl[1] = max;
        assertEquals(calc.getPlaylistForSong(m), max);
    }


    // ----------------------------------------------------------
    /**
     * Tests addSongToPlaylist.
     */
    public void testAddSongPlaylist()
    {
        //songQueue is empty
        calc = new PlaylistCalculator(aq, pl);
        assertFalse(calc.addSongToPlaylist());
        //playlist of song at front is null
        Song s = new Song("name null", 30, 30, 30, null);
        calc.getQueue().enqueue(s);
        assertFalse(calc.addSongToPlaylist());
        //neither, true
        pl[0] = new Playlist("playlist1", 20, 20, 20, 40, 40, 40, 2);
        Song found = new Song("found", 30, 30, 30, "playlist1");
        calc.getQueue().dequeue();
        calc.getQueue().enqueue(found);
        assertTrue(calc.addSongToPlaylist());
    }


    // ----------------------------------------------------------
    /**
     * Tests reject.
     */
    public void testReject()
    {
        Playlist p = new Playlist("playlist1", 20, 20, 20, 40, 40, 40, 2);
        pl[0] = p;
        Song s = new Song("filler1", 30, 30, 30, "playlist1");
        calc = new PlaylistCalculator(aq, pl);
        calc.getQueue().enqueue(s);
        calc.reject();
        assertTrue(calc.getRejectedTracks().contains(s));
    }


    // ----------------------------------------------------------
    /**
     * Tests getPlaylistIndex, getQueue, getPlaylists, and getRejectedTracks
     */
    public void testOtherGetters()
    {
        pl[0] = new Playlist("test", 20, 20, 20, 40, 40, 40, 10);
        aq.enqueue(new Song("song", 30, 30, 30, "suggested"));
        calc = new PlaylistCalculator(aq, pl);
        assertEquals(calc.getPlaylistIndex("test"), 0);
        assertEquals(calc.getPlaylistIndex("test2"), -1);
        assertEquals(calc.getPlaylists(), pl);
        assertEquals(calc.getQueue(), aq);
        assertNotNull(calc.getRejectedTracks());
    }
}
