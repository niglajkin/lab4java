import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Laboratory Work №4 — Classes Composition (Text model).
 *
 * <p>Variant is based on the record book number 9085:</p>
 * <ul>
 *   <li>C3 = 9085 % 3 = 1 → String</li>
 *   <li>C17 = 9085 % 17 = 7 → Sort words starting with vowels by the second letter</li>
 * </ul>
 *
 * <p>Additionally (Lab4 requirement): replace any sequences of spaces/tabs with a single space.</p>
 *
 * <p>This class contains the entry point (main) and demonstrates the required text processing
 * using composition classes: Letter, Word, Sentence, Punctuation, Text.</p>
 */
public class Main
{
    /**
     * Program entry point.
     *
     * @param args command line arguments (not used, but required by JVM)
     */
    public static void main(String[] args)
    {
        try
        {
            final int recordBookNumber = 9085;

            final int c3 = recordBookNumber % 3;
            final int c17 = recordBookNumber % 17;

            System.out.println("C3 = " + c3);
            System.out.println("C17 = " + c17);
            System.out.println();

            final String rawText =
                    "An\t\t eager   owl observes  unusual events in ancient cities.  "
                            + "Every  idea\tis unique, and each outcome is interesting! "
                            + "Is it  easy\t to organize    everything? "
                            + "Under old umbrellas, a user enjoys elegant art.";

            final String normalized = TextParser.normalizeSpacesAndTabs(rawText);

            System.out.println("Normalized text:");
            System.out.println(normalized);
            System.out.println();

            Text text = TextParser.parse(normalized);

            List<Word> allWords = text.getAllWords();
            List<Word> vowelWords = new ArrayList<>();

            for (Word word : allWords)
            {
                if (word.startsWithVowel())
                {
                    vowelWords.add(word);
                }
            }

            vowelWords.sort(
                    Comparator.comparingInt(Word::secondLetterKey)
                            .thenComparing(w -> w.asString().toLowerCase())
            );

            System.out.println("Words that start with a vowel, sorted by the second letter:");
            for (Word word : vowelWords)
            {
                System.out.println(word.asString());
            }
        }
        catch (Exception e)
        {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
