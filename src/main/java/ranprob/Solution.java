package ranprob;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    Scanner scanner = new Scanner(System.in);
    String W = scanner.nextLine();
    String listWords = scanner.nextLine();
    String[] L = listWords.split(" ");
    Set<String> LSet = new HashSet<>(Arrays.asList(L));

    System.out.println(countSimilarWords(W, LSet));
  }

  public static int countSimilarWords(String word, Set<String> bagWords) {
    int similarCount = 0;
    Set<Character> setCharsOfWord = buildSetOfChars(word);

    for(String wordInBag: bagWords) {
      if (isSimilar(wordInBag, setCharsOfWord)) {
        similarCount++;
      }
    }
    return similarCount;
  }

  public static boolean isSimilar(String word, Set<Character> setOfChars) {
    for (char c: word.toCharArray()) {
      if (!setOfChars.contains(c)) {
        return false;
      }
    }

    return true;
  }

  public static Set<Character> buildSetOfChars(String word) {
    Set<Character> setCharsOfWord = new HashSet<Character>();
    for (char c: word.toCharArray()) {
      setCharsOfWord.add(c);
    }

    return setCharsOfWord;
  }
}
