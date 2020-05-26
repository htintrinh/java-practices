package ranprob;

import java.util.Arrays;

public class FindDupArray {

  public static int findDuplicateArray(int[] arr) {
    int tortoise = arr[0];
    int hare = arr[0];
    while (true) {
      tortoise = arr[tortoise];
      hare = arr[arr[hare]];

      if (tortoise == hare) {
        break;
      }
    }

    int p1 = arr[0];
    int p2 = tortoise;
    while (p1 != p2) {
      p1 = arr[p1];
      p2 = arr[p2];
    }

    return p1;
  }

  public static void main(String[] args) {

    int dup = findDuplicateArray(new int[]{4, 4, 3, 1, 2});
    System.out.println(dup);
    int[] myArray = new int[]{1, 2, 3, 34, 12, 33};
    Arrays.sort(myArray);
    for (int c : myArray) {
      System.out.println(c);
    }

  }
}
