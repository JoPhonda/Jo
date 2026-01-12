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
 * A GenreSet stores the percentage a song matches with three categories: pop,
 * rock, and country.
 * 
 * @author Jo
 * @version Nov 4, 2025
 */
public class GenreSet
    implements Comparable<GenreSet>
{
    private int pop;
    private int rock;
    private int country;

    // ----------------------------------------------------------
    /**
     * The GenreSet Constructor, sets all three percentages.
     * 
     * @param p
     *            pop music
     * @param r
     *            rock music
     * @param c
     *            country music
     */
    public GenreSet(int p, int r, int c)
    {
        pop = p;
        rock = r;
        country = c;
    }


    // ----------------------------------------------------------
    /**
     * Returns the percentage match with pop music.
     * 
     * @return pop
     */
    public int getPop()
    {
        return pop;
    }


    // ----------------------------------------------------------
    /**
     * Returns the percentage match with rock music.
     * 
     * @return rock
     */
    public int getRock()
    {
        return rock;
    }


    // ----------------------------------------------------------
    /**
     * Returns the percentage match with country music.
     * 
     * @return country
     */
    public int getCountry()
    {
        return country;
    }


    // ----------------------------------------------------------
    /**
     * Returns true if this pop is less than or equal to the compared pop, AND
     * the same for rock and country.
     * 
     * @param other
     *            the GenreSet this compares to
     * @return true if all match, false otherwise
     */
    public boolean isLessThanOrEqualTo(GenreSet other)
    {
        return pop <= other.pop && rock <= other.rock
            && country <= other.country;

    }


    // ----------------------------------------------------------
    /**
     * Returns true if this pop is less than or equal to the max provided, but
     * greater than or equal to the minimum GenreSet. AND the same for rock and
     * country.
     * 
     * @param minGenreSet
     *            the minimum values needed to be in range in GenreSet form.
     * @param maxGenreSet
     *            same as previous but for max
     * @return true if in range of minimum + max, false otherwise
     */
    public boolean isWithinRange(GenreSet minGenreSet, GenreSet maxGenreSet)
    {
        return minGenreSet.pop <= pop && pop <= maxGenreSet.pop
            && minGenreSet.rock <= rock && rock <= maxGenreSet.rock
            && minGenreSet.country <= country && country <= maxGenreSet.country;

    }


    // ----------------------------------------------------------
    /**
     * Returns true if this pop is equal to the compared pop, AND the same for
     * rock and country.
     * 
     * @param o
     *            compared to object, casted to GenreSet
     * @return true if all values equal, false otherwise
     */
    public boolean equals(Object o)
    {
        GenreSet g = (GenreSet)o;
        return pop == g.pop && rock == g.rock && country == g.country;
    }


    // ----------------------------------------------------------
    /**
     * Returns positive number if all three percentages combined is greater than
     * the max provided, negative otherwise, or 0 if they are the same.
     * 
     * @param other
     *            compared to GenreSet
     * @return positive if greater than other, negative otherwise.
     */
    @Override
    public int compareTo(GenreSet other)
    {
        int sum = pop + rock + country;
        int otherSum = other.pop + other.rock + other.country;
        if (sum > otherSum)
        {
            return 1;
        }
        else if (sum < otherSum)
        {
            return -1;
        }
        return 0;
    }


    // ----------------------------------------------------------
    /**
     * String value in this order: "Pop:10 Rock:20 Country:30"
     * 
     * @return string of all three values
     */
    public String toString()
    {
        return "Pop:" + pop + " Rock:" + rock + " Country:" + country;

    }

}
