import java.util.ArrayList;
import java.util.List;

/**
 * Represents a whole text as an array of sentences.
 */
public final class Text
{
    private final Sentence[] sentences;

    /**
     * Creates a text instance.
     *
     * @param sentences array of sentences
     * @throws IllegalArgumentException if sentences is null
     */
    public Text(Sentence[] sentences)
    {
        if (sentences == null)
        {
            throw new IllegalArgumentException("sentences must not be null");
        }
        this.sentences = sentences;
    }

    /**
     * @return sentences of this text
     */
    public Sentence[] getSentences()
    {
        return sentences;
    }

    /**
     * Collects all words from all sentences.
     *
     * @return list of words in text order
     */
    public List<Word> getAllWords()
    {
        List<Word> result = new ArrayList<>();

        for (Sentence sentence : sentences)
        {
            result.addAll(sentence.getWords());
        }

        return result;
    }
}
