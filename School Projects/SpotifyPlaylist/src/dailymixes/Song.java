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
 * A Song contains a name, a GenreSet, and the name of a suggested play list.
 * 
 * @author Jo
 * @version Nov 4, 2025
 */
public class Song
{
    private String name;
    private String suggestedPlaylist;
    private GenreSet genreSet;

    // ----------------------------------------------------------
    /**
     * Create a new Song object.
     * 
     * @param name
     *            the name of this Song
     * @param pop
     *            percentage this song matches the pop category.
     * @param rock
     *            percentage this song matches the rock category.
     * @param country
     *            percentage this song matches the country category.
     * @param suggested
     *            name of a suggested playlist
     */
    public Song(String name, int pop, int rock, int country, String suggested)
    {
        this.name = name;
        suggestedPlaylist = suggested;
        genreSet = new GenreSet(pop, rock, country);
    }


    // ----------------------------------------------------------
    /**
     * Returns the name of a suggested Playlist.
     * 
     * @return suggestedPlaylist
     */
    public String getPlaylistName()
    {
        return suggestedPlaylist;
    }


    // ----------------------------------------------------------
    /**
     * Returns the name of this Song.
     * 
     * @return name
     */
    public String getName()
    {
        return name;
    }


    // ----------------------------------------------------------
    /**
     * Returns the GenreSet of this Song.
     * 
     * @return genreSet
     */
    public GenreSet getGenreSet()
    {
        return genreSet;
    }


    // ----------------------------------------------------------
    /**
     * Returns true if the name, suggestedPlaylist, and GenreSet of this Song
     * matches the song of another Song object.
     * 
     * @param o
     *            the other Song, casted from an object.
     * @return true if they match values, false otherwise.
     */
    public boolean equals(Object o)
    {
        Song s = (Song)o;
        return name == s.name && suggestedPlaylist == s.suggestedPlaylist
            && genreSet.equals(s.genreSet);
    }


    // ----------------------------------------------------------
    /**
     * Returns a string value of the name, GenreSet, and suggestedPlaylist.
     * 
     * @return string value of this song
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder("[");
        if (suggestedPlaylist.length() == 0)
        {
            s.append("No-Playlist ");
        }
        s.append(name + " ");
        s.append(genreSet.toString());
        if (suggestedPlaylist.length() > 0)
        {
            s.append(" Suggested: " + suggestedPlaylist);
        }

        return s + "]";
    }
}
