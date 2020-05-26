package ranprob;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

  public static Map<String, Integer> buildWordFrequency(String[] words) {
    Map<String, Integer> wordFrequency = new HashMap<>();
    for (String word : words) {
      int currentWordCount = wordFrequency.getOrDefault(word, 0);
      wordFrequency.put(word, currentWordCount + 1);
    }

    return wordFrequency;
  }

  public static boolean canBuildRansomNote(String[] magazine, String[] ransomNote) {
    Map<String, Integer> magazineWordFrequency = buildWordFrequency(magazine);
    Map<String, Integer> ransomNoteWordFrequency = buildWordFrequency(ransomNote);

    for (String s : ransomNoteWordFrequency.keySet()) {
      if (ransomNoteWordFrequency.get(s) > magazineWordFrequency.getOrDefault(s, 0)) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    String[] magazine = new String[]{"Hello", "world", "test"};
    String[] ransomNote = new String[]{"Hello"};

    System.out.println(canBuildRansomNote(magazine, ransomNote));
  }
}
