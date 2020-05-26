package ranprob;

public class PermutationPalindrome {

  public static boolean isPalindrome(String str) {
    int[] counts = new int[128]; // assumption
    char[] chars = str.toCharArray();
    for (char c : chars) {
      counts[c] += 1;
    }
    boolean isStringLengthOdd = str.length() % 2 != 0;
    int oddCount = 0;
    for (int count : counts) {
      if (count % 2 != 0) {
        oddCount++;
      }
    }

    if (isStringLengthOdd && oddCount != 1 || oddCount > 1) {
      return false;
    }

    return true;
  }

  // 0100 - 1 = 0011
  // 0100 & 0011 = 0000
  // 0101 - 1 = 0100
  // 0101 & 0100 = 0100
  public static boolean isOnlyOneBitOne(int bits) {
    return ((bits - 1) & bits) == 0;
  }

  public static int getBitMap(Character c) {
    int value = c - 'a';
    return 1 << value;
  }

  // Suppose that the string contain only characters from a to z
  public static boolean isPermutationPalindrome(String str) {
    int result = 0;
    for (Character c : str.toCharArray()) {
      // a => 0001, b=> 0010
      int bitMap = getBitMap(c);

      // toggle the bit at index c
      result = result ^ bitMap;
    }

    return result == 0 || isOnlyOneBitOne(result);
  }

  public static void main(String[] args) {
//    System.out.println(isPalindrome("aad"));
    System.out.println(isPermutationPalindrome("aabbcdcdde"));
  }

}
