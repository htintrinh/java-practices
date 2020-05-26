package ranprob;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {

  private static final int NUMBER_CHARACTERS = 26;

  private static int[] getCounts(String s) {
    int[] counts = new int[NUMBER_CHARACTERS];
    for (char c : s.toCharArray()) {
      counts[c - 'a'] += 1;
    }

    return counts;
  }

  private static int getDelta(int[] first, int[] second) {
    if (first.length != second.length) {
      return -1; // todo: handling error
    }

    int delta = 0;
    for (int i = 0; i < first.length; i++) {
      delta += Math.abs(first[i] - second[i]);
    }

    return delta;
  }

  public static int anagramSolver(String first, String second) {
    int[] firstCounts = getCounts(first);
    int[] secondCounts = getCounts(second);

    return getDelta(firstCounts, secondCounts);
  }

  public static boolean isAnagram(String a, String b) {
    char[] firstStringChar = a.toCharArray();
    char[] secondStringChar = b.toCharArray();

    Arrays.sort(firstStringChar);
    Arrays.sort(secondStringChar);

    return Arrays.equals(firstStringChar, secondStringChar);

  }


  public static List<List<String>> groupAnagram(String[] words) {
    Map<String, List<String>> anaGramMap = new HashMap<>();
    for (String word : words) {
      boolean isFoundMatchKey = false;
      for (String key : anaGramMap.keySet()) {
        if (isAnagram(key, word)) {
          List<String> anagramList = anaGramMap.get(key);
          anagramList.add(word);
          isFoundMatchKey = true;
          break;
        }
      }
      if (!isFoundMatchKey) {
        anaGramMap.put(word, new ArrayList<>(Collections.singletonList(word)));
      }
    }

    return new ArrayList<>(anaGramMap.values());
  }

  public static void main(String[] args) throws IOException {
//    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    String str1 = reader.readLine();
//    String str2 = reader.readLine();
//
//    System.out.println(anagramSolver(str1, str2));

    String[] words = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(groupAnagram(words));

  }

  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs.length == 0) {
      return new ArrayList<List<String>>();
    }

    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      int[] counts = new int[26];
      Arrays.fill(counts, 0);
      for (char c : str.toCharArray()) {
        counts[c - 'a']++;
      }
      StringBuilder sb = new StringBuilder();
      for (int count : counts) {
        sb.append(count);
        sb.append("#");
      }
      String representKey = sb.toString();

      if (map.containsKey(representKey)) {
        map.get(representKey).add(str);
      } else {
        map.put(representKey, new ArrayList<String>(Collections.singletonList(str)));
      }

    }

    return new ArrayList<>(map.values());
  }

}
