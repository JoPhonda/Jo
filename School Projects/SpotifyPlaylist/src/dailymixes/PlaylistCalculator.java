// Project 4 Fall 2025
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Joseph Kim (906678863)
package dailymixes;

import list.AList;

// -------------------------------------------------------------------------
/**
 * PlaylistCalculator handles the accept and addSongToPlaylist logic as well as
 * the reject song logic, and it contains the queue of songs and the Playlist
 * objects.
 * 
 * @author Jo
 * @version Nov 10, 2025
 */
public class PlaylistCalculator
{
    /**
     * Number of playlists that can be made.
     */
    public static final int NUM_PLAYLISTS = 3;
    /**
     * Minimum percentage that a playlist can have.
     */
    public static final int MIN_PERCENT = 0;
    /**
     * Maximum percentage that a playlist can have.
     */
    public static final int MAX_PERCENT = 100;
    private Playlist[] playlists;
    private AList<Song> rejectedTracks;
    private ArrayQueue<Song> songQueue;

    // ----------------------------------------------------------
    /**
     * This class does the major calculations for the program. It handles the
     * accept and addSongToPlaylist logic as well as the reject song logic, and
     * it contains the queue of songs and the Playlist objects.
     * 
     * @param aq
     *            the queue of songs
     * @param pl
     *            the array of playlists
     */
    public PlaylistCalculator(ArrayQueue<Song> aq, Playlist[] pl)
    {
        if (aq == null)
        {
            throw new IllegalArgumentException();
        }
        songQueue = aq;
        playlists = pl;
        rejectedTracks = new AList<Song>();
    }


    // ----------------------------------------------------------
    /**
     * This method will determine if the next song can be added to a playlist
     * depending on: if the song is not null. if the suggested playlist's name
     * is not null. if there is a playlist with the same name as the suggested
     * playlist in playlists. if the playlist found is not full. if the playlist
     * found is qualified. otherwise, it will call
     * getPlaylistWithMaximumCapacity.
     * 
     * @param nextSong
     *            the song that will be chosen to be added or not.
     * @return the playlist if it can be added, null otherwise
     */
    public Playlist getPlaylistForSong(Song nextSong)
    {
        if (nextSong == null || nextSong.getPlaylistName() == null)
        {
            return null;
        }
        Playlist p = null;
        for (int i = 0; i < playlists.length; i++)
        {
            if (playlists[i] != null
                && playlists[i].getName().equals(nextSong.getPlaylistName()))
            {
                p = playlists[i];

            }
        }
        if (p != null
            && !p.isFull()
            && p.isQualified(nextSong))
        {
            return p;
        }
        return getPlaylistWithMaximumCapacity(nextSong);
    }


    // ----------------------------------------------------------
    /**
     * This is a private helper method that will help you determine the playlist
     * with the greatest capacity that a song can be added while still
     * fulfilling its requirements.
     * 
     * @param nextSong
     *            the song that will be compared to playlists
     * @return the playlist with the maximum capacity that nextSong can be added
     *             to.
     */
    private Playlist getPlaylistWithMaximumCapacity(Song nextSong)
    {
        Playlist maxPlaylist = null;
        int maxCapacity = 0;

        for (Playlist p : playlists)
        {
            if (p != null && !p.isFull() 
                && p.isQualified(nextSong)
                && p.getCapacity() > maxCapacity)
            {
                maxCapacity = p.getCapacity();
                maxPlaylist = p;

            }
        }

        return maxPlaylist;
    }


    // ----------------------------------------------------------
    /**
     * This method will attempt to add the next song.
     * 
     * @return true if song can be added, false otherwise.
     */
    public boolean addSongToPlaylist()
    {
        if (!songQueue.isEmpty()
            && getPlaylistForSong(songQueue.getFront()) != null)
        {
            getPlaylistForSong(songQueue.getFront())
                .addSong(songQueue.dequeue());
            return true;

        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * When reject is called, the next song in line should be put on the list of
     * rejected tracks.
     */
    public void reject()
    {
        rejectedTracks.add(songQueue.dequeue());
    }


    // ----------------------------------------------------------
    /**
     * Return the int representation for the given String (playlist name). If
     * the given String is not a name for any of the three playlists, return -1.
     * 
     * @param playlist
     *            the playlist that we are getting the index of
     * @return the index of playlist
     */
    public int getPlaylistIndex(String playlist)
    {
        for (int i = 0; i < playlists.length; i++)
        {
            if (playlists[i] != null 
                && playlists[i].getName().equals(playlist))
            {
                return i;
            }
        }
        return -1;
    }


    // ----------------------------------------------------------
    /**
     * This method should return the ArrayQueue of songs.
     * 
     * @return songQueue
     */
    public ArrayQueue<Song> getQueue()
    {
        return songQueue;
    }


    // ----------------------------------------------------------
    /**
     * This method should return the array of playlists.
     * 
     * @return playlists
     */
    public Playlist[] getPlaylists()
    {
        return playlists;
    }


    // ----------------------------------------------------------
    /**
     * This method should return the AList of rejected tracks.
     * 
     * @return rejectedTracks
     */
    public AList<Song> getRejectedTracks()
    {
        return rejectedTracks;
    }
}
