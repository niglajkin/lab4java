/**
 * Represents a single alphabetic letter.
 */
public final class Letter
{
    private final char value;

    /**
     * Creates a letter.
     *
     * @param value alphabetic character
     * @throws IllegalArgumentException if value is not a letter
     */
    public Letter(char value)
    {
        if (!Character.isLetter(value))
        {
            throw new IllegalArgumentException("Letter must be alphabetic: '" + value + "'");
        }
        this.value = value;
    }

    /**
     * @return stored character
     */
    public char toChar()
    {
        return value;
    }
}
