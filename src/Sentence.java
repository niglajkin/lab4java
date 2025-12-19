import java.util.ArrayList;
import java.util.List;

/**
 * Represents a sentence as an ordered list of elements (words and punctuation marks).
 */
public final class Sentence
{
    private final SentenceElement[] elements;

    /**
     * Creates a sentence.
     *
     * @param elements sentence elements (words/punctuation)
     * @throws IllegalArgumentException if elements is null
     */
    public Sentence(SentenceElement[] elements)
    {
        if (elements == null)
        {
            throw new IllegalArgumentException("elements must not be null");
        }
        this.elements = elements;
    }

    /**
     * @return sentence elements in original order
     */
    public SentenceElement[] getElements()
    {
        return elements;
    }

    /**
     * Extracts only {@link Word} elements from this sentence.
     *
     * @return list of words
     */
    public List<Word> getWords()
    {
        List<Word> words = new ArrayList<>();

        for (SentenceElement el : elements)
        {
            if (el instanceof Word)
            {
                words.add((Word) el);
            }
        }

        return words;
    }
}
