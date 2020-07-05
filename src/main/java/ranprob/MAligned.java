package ranprob;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class MAligned {
  public int solution(int[] A, int M) {
    // write your code in Java SE 8
// let start with some naive algorithm
// brute force
    int sizeOfAlignByM = 1;

    for (int i = 0; i < A.length; i++) {
      for (int j = i + 1; j < A.length; j++ ) {
        if (Math.abs(A[j] - A[i]) % M == 0 ) {
          sizeOfAlignByM++;
          break;
        }
      }
    }


    return sizeOfAlignByM;
  }

  public static void main(String[] args) {
    MAligned aligned = new MAligned();

    int size = aligned.solution(new int[]{-3, -2, 1, 0, 8, 7, 1}, 3);
    System.out.println(size);

  }
}
