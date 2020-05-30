package ranprob;

import java.io.IOException;

public class FindPair {

  // Complete the sockMerchant function below.
  static int sockMerchant(int n, int[] ar) {
    int[] sockCounts = new int[100];
    for (int sock : ar) {
      sockCounts[sock - 1] += 1;
    }

    int numPairs = 0;
    for (int count : sockCounts) {
      numPairs += count / 2;
    }
    return numPairs;

  }


  // Complete the countingValleys function below.
  static int countingValleys(int n, String s) {
    int currentLevel = 0;
    int countValley = 0;
    boolean isDip = false;
    for (char c : s.toCharArray()) {
      if (c == 'U') {
        currentLevel++;
      }

      if (c == 'D') {
        currentLevel--;
      }

      if (currentLevel <= -2) {
        isDip = true;
      }

      if (currentLevel == 0 && c == 'U' && isDip) {
        countValley++;
        isDip = true;
      }

    }
    return countValley;
  }

  public static void main(String[] args) throws IOException {

    int[] ar = new int[]{1, 1, 3, 1, 2, 1, 3, 3, 3, 3};

    int result = sockMerchant(10, ar);
    int valleyNum = countingValleys(8, "UDUDUDUD");

    System.out.println(valleyNum);

  }
}
