package net.transformtorhuis.junit.agilejava;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author cyberroadie
 */
public class WordCount {

    public final String firstSentence = 
            "Create a String literal using the first two sentences of this " +
            "exercise.";
    public final String secondSentence =
            "You will create a WordCount class to parse through the text and " +
            "count the number of instances of each word";

    Map<String, Integer> wordCount = new HashMap<String, Integer>();

    public WordCount() {
        this.countWords(firstSentence);
        this.countWords(secondSentence);
    }

    private void countWords(String sentence) {
        String[] wordArray = sentence.split("\\W+");
        for (String string : wordArray) {
            Integer count = wordCount.get(string.toLowerCase());
            if(count == null) {
                wordCount.put(string.toLowerCase(), 1);
            } else {
                wordCount.put(string, count + 1);
            }
        }
    }

    public Map<String, Integer> getWordCount() {
        return wordCount;
    }
}
