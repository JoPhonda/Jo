// Project 4 Fall 2025
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Joseph Kim (906678863)
package dailymixes;

// -------------------------------------------------------------------------
/**
 * Playlist is a list of Songs alonside a max GenreSet and minimum GenreSet
 * depending on what you want on a playlist.
 * 
 * @author Jo
 * @version Nov 4, 2025
 */
public class Playlist
    implements Comparable<Playlist>
{
    private String name;
    private GenreSet minGenreSet;
    private GenreSet maxGenreSet;
    private Song[] songs;
    private int capacity;
    private int numberOfSongs;

    // ----------------------------------------------------------
    /**
     * Create a new Playlist object.
     * 
     * @param playlistName
     *            name of this playlist
     * @param minPop
     *            minimum value of pop for minGenreSet
     * @param minRock
     *            minimum value of rock for minGenreSet
     * @param minCountry
     *            minimum value of country for minGenreSet
     * @param maxPop
     *            maximum value of pop for maxGenreSet
     * @param maxRock
     *            maximum value of rock for maxGenreSet
     * @param maxCountry
     *            maximum value of country for maxGenreSet
     * @param playlistCap
     *            capacity of this playlist
     */
    public Playlist(
        String playlistName,
        int minPop,
        int minRock,
        int minCountry,
        int maxPop,
        int maxRock,
        int maxCountry,
        int playlistCap)
    {
        name = playlistName;
        minGenreSet = new GenreSet(minPop, minRock, minCountry);
        maxGenreSet = new GenreSet(maxPop, maxRock, maxCountry);
        capacity = playlistCap;
        numberOfSongs = 0;
        songs = new Song[capacity];
    }


    // ----------------------------------------------------------
    /**
     * Sets name.
     * 
     * @param s
     *            name
     */
    public void setName(String s)
    {
        name = s;
    }


    // ----------------------------------------------------------
    /**
     * Returns name.
     * 
     * @return name
     */
    public String getName()
    {
        return name;
    }


    // ----------------------------------------------------------
    /**
     * Returns spaces left.
     * 
     * @return max capacity minus the number of songs
     */
    public int getSpacesLeft()
    {
        return capacity - numberOfSongs;
    }


    // ----------------------------------------------------------
    /**
     * Returns minimum genre set.
     * 
     * @return minGenreSet
     */
    public GenreSet getMinGenreSet()
    {
        return minGenreSet;
    }


    // ----------------------------------------------------------
    /**
     * Returns maximum genre set.
     * 
     * @return maxGenreSet
     */
    public GenreSet getMaxGenreSet()
    {
        return maxGenreSet;
    }


    // ----------------------------------------------------------
    /**
     * Returns number of songs.
     * 
     * @return numberOfSongs
     */
    public int getNumberOfSongs()
    {
        return numberOfSongs;
    }


    // ----------------------------------------------------------
    /**
     * Returns the Song array.
     * 
     * @return songs
     */
    public Song[] getSongs()
    {
        return songs;
    }


    // ----------------------------------------------------------
    /**
     * Returns max capacity.
     * 
     * @return capacity
     */
    public int getCapacity()
    {
        return capacity;
    }


    // ----------------------------------------------------------
    /**
     * Returns true if numberOfSongs equals capacity.
     * 
     * @return true if full
     */
    public boolean isFull()
    {
        return numberOfSongs == capacity;
    }


    // ----------------------------------------------------------
    /**
     * Returns true if playlist is not full and the new song is qualified.
     * 
     * @param newSong
     *            the song to be added
     * @return true if added or false
     */
    public boolean addSong(Song newSong)
    {
        if (!isFull() && isQualified(newSong))
        {
            songs[numberOfSongs] = newSong;
            numberOfSongs++;
            return true;
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * Returns in order: playlist, number songs, percentages of all 3 genres.
     * 
     * @return to string in specified order
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder("[");
        s.append("Playlist: " + name);
        s.append(" # of songs: " + numberOfSongs);
        s.append(
            " Requires: Pop:" + minGenreSet.getPop() + "%-"
                + maxGenreSet.getPop() + "%");
        s.append(
            " Rock:" + minGenreSet.getRock() + "%-" + maxGenreSet.getRock()
                + "%");
        s.append(
            " Country:" + minGenreSet.getCountry() + "%-"
                + maxGenreSet.getCountry() + "%");
        return s + "]";
    }


    // ----------------------------------------------------------
    /**
     * Returns true if all attributes match plus toString.
     * 
     * @param object
     *            compared to object
     * @return true if match, or false
     */
    public boolean equals(Object object)
    {
        Playlist p = (Playlist)object;
        return name.equals(p.getName())
            && maxGenreSet.equals(p.getMaxGenreSet())
            && minGenreSet.equals(p.getMinGenreSet())
            && capacity == p.getCapacity()
            && this.toString().equals(p.toString());
    }


    // ----------------------------------------------------------
    /**
     * A playlist with more capacity will be greater than one with less. In the
     * event that 2 playlists have equal capacities, then they will be ordered
     * based on spaces left. A playlist with more spaces left will be greater
     * than one with less.In the event that the 2 playlists also have an equal
     * number of slots available, then they will be ordered based on MinGenreSet
     * (see compareTo for GenreSet). If 2 playlists have all three of those
     * attributes the same, then they will be ordered based on MaxGenreSet.
     * Playlists that have all of the aforementioned attributes in common will
     * be ordered based on name.
     * 
     * @param o
     *            compared to playlist
     * @return positive or negative depending on values
     */
    @Override
    public int compareTo(Playlist o)
    {
        if (capacity != o.capacity)
        {
            if (capacity > o.capacity)
            {
                return 1;
            }
            return -1;
        }
        if (getSpacesLeft() != o.getSpacesLeft())
        {
            if (getSpacesLeft() > o.getSpacesLeft())
            {
                return 1;
            }
            return -1;
        }
        int minCompare = minGenreSet.compareTo(o.minGenreSet);
        if (minCompare != 0)
        {
            return minCompare;
        }
        int maxCompare = maxGenreSet.compareTo(o.maxGenreSet);
        if (maxCompare != 0)
        {
            return maxCompare;
        }
        return name.compareTo(o.name);
    }


    // ----------------------------------------------------------
    /**
     * Returns true if over min and under max.
     * 
     * @param s
     *            song to compare to
     * @return true if fits or false
     */
    public boolean isQualified(Song s)
    {
        return maxGenreSet.compareTo(s.getGenreSet()) >= 0
            && minGenreSet.compareTo(s.getGenreSet()) <= 0;
    }
}
