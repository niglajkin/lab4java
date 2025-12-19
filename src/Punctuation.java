/**
 * Represents a punctuation mark as a sentence element.
 */
public final class Punctuation implements SentenceElement
{
    private final char mark;

    /**
     * Creates a punctuation element.
     *
     * @param mark punctuation character
     * @throws IllegalArgumentException if mark is a letter (not punctuation)
     */
    public Punctuation(char mark)
    {
        if (Character.isLetter(mark))
        {
            throw new IllegalArgumentException("Punctuation must not be a letter: '" + mark + "'");
        }
        this.mark = mark;
    }

    /**
     * @return punctuation character
     */
    public char toChar()
    {
        return mark;
    }

    @Override
    public String asString()
    {
        return String.valueOf(mark);
    }

    @Override
    public String toString()
    {
        return asString();
    }
}
