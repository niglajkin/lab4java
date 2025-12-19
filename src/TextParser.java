import java.util.ArrayList;
import java.util.List;

/**
 * Parser utilities for converting a plain text string into a composition model:
 * Text → Sentence[] → SentenceElement[] (Word / Punctuation).
 */
public final class TextParser
{
    private TextParser()
    {
    }

    /**
     * Replaces any sequence of spaces and tabs with a single space and trims
     * leading/trailing whitespace.
     *
     * @param input raw input text
     * @return normalized text with single spaces
     * @throws IllegalArgumentException if input is null
     */
    public static String normalizeSpacesAndTabs(String input)
    {
        if (input == null)
        {
            throw new IllegalArgumentException("input must not be null");
        }

        return input.replaceAll("[\\t ]+", " ").trim();
    }

    /**
     * Parses normalized English text into a {@link Text} instance.
     *
     * <p>Rules:</p>
     * <ul>
     *   <li>Letters (A–Z/a–z) build words</li>
     *   <li>Spaces are separators</li>
     *   <li>Any non-letter character (except space) is stored as punctuation</li>
     *   <li>'.', '!' or '?' finalize a sentence</li>
     * </ul>
     *
     * @param normalizedText text that should already be normalized (single spaces)
     * @return parsed {@link Text} object
     * @throws IllegalArgumentException if normalizedText is null
     */
    public static Text parse(String normalizedText)
    {
        if (normalizedText == null)
        {
            throw new IllegalArgumentException("normalizedText must not be null");
        }

        List<Sentence> sentences = new ArrayList<>();
        List<SentenceElement> currentSentenceElements = new ArrayList<>();
        List<Letter> currentWordLetters = new ArrayList<>();

        for (int i = 0; i < normalizedText.length(); i++)
        {
            char c = normalizedText.charAt(i);

            if (Character.isLetter(c))
            {
                currentWordLetters.add(new Letter(c));
                continue;
            }

            if (!currentWordLetters.isEmpty())
            {
                currentSentenceElements.add(new Word(currentWordLetters.toArray(new Letter[0])));
                currentWordLetters.clear();
            }

            if (c == ' ')
            {
                continue;
            }

            currentSentenceElements.add(new Punctuation(c));

            if (c == '.' || c == '!' || c == '?')
            {
                sentences.add(new Sentence(currentSentenceElements.toArray(new SentenceElement[0])));
                currentSentenceElements.clear();
            }
        }

        if (!currentWordLetters.isEmpty())
        {
            currentSentenceElements.add(new Word(currentWordLetters.toArray(new Letter[0])));
            currentWordLetters.clear();
        }

        if (!currentSentenceElements.isEmpty())
        {
            sentences.add(new Sentence(currentSentenceElements.toArray(new SentenceElement[0])));
            currentSentenceElements.clear();
        }

        return new Text(sentences.toArray(new Sentence[0]));
    }
}
