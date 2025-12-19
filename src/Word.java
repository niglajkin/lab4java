/**
 * Represents a word as an array of {@link Letter}.
 */
public final class Word implements SentenceElement
{
    private final Letter[] letters;

    /**
     * Creates a word.
     *
     * @param letters array of letters
     * @throws IllegalArgumentException if letters is null or empty
     */
    public Word(Letter[] letters)
    {
        if (letters == null)
        {
            throw new IllegalArgumentException("letters must not be null");
        }
        if (letters.length == 0)
        {
            throw new IllegalArgumentException("word must contain at least 1 letter");
        }
        this.letters = letters;
    }

    /**
     * @return number of letters in the word
     */
    public int length()
    {
        return letters.length;
    }

    /**
     * Checks whether this word starts with an English vowel (a, e, i, o, u, y).
     *
     * @return true if first letter is a vowel
     */
    public boolean startsWithVowel()
    {
        char first = Character.toLowerCase(letters[0].toChar());
        return first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u' || first == 'y';
    }

    /**
     * Returns sorting key for the "second letter" requirement.
     * If the word has no second letter, it will be sorted to the end.
     *
     * @return lowercase code of the second letter, or Integer.MAX_VALUE if length < 2
     */
    public int secondLetterKey()
    {
        if (letters.length < 2)
        {
            return Integer.MAX_VALUE;
        }
        return Character.toLowerCase(letters[1].toChar());
    }

    /**
     * Converts the word to a plain string.
     *
     * @return word text
     */
    @Override
    public String asString()
    {
        StringBuilder sb = new StringBuilder();

        for (Letter letter : letters)
        {
            sb.append(letter.toChar());
        }

        return sb.toString();
    }

    @Override
    public String toString()
    {
        return asString();
    }
}
