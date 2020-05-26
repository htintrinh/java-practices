package sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ArrayMedian {

  public static void addNumber(int number, PriorityQueue<Integer> lowers,
      PriorityQueue<Integer> uppers) {
    if (lowers.size() == 0) {
      lowers.add(number);
      return;
    }
    if (lowers.peek() > number) {
      lowers.add(number);
      return;
    }
    uppers.add(number);
  }

  public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> uppers) {
    PriorityQueue<Integer> biggers = lowers.size() > uppers.size() ? lowers : uppers;
    PriorityQueue<Integer> smallers = lowers.size() < uppers.size() ? lowers : uppers;

    if (biggers.size() - smallers.size() >= 2) {
      smallers.add(biggers.poll());
    }
  }

  public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> uppers) {
    if (lowers.size() == 0 && uppers.size() == 0) {
      return 0;
    }
    if (lowers.size() > uppers.size()) {
      return lowers.peek();
    } else if (lowers.size() < uppers.size()) {
      return uppers.peek();
    } else {
      return ((double) lowers.peek() + uppers.peek()) / 2;
    }
  }

  public static double[] solution(int[] arr) {
    PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return -1 * o1.compareTo(o2);
      }
    });
    PriorityQueue<Integer> uppers = new PriorityQueue<>();

    double[] medians = new double[arr.length];
    for (int i = 0; i < arr.length; i++) {
      addNumber(arr[i], lowers, uppers);
      rebalance(lowers, uppers);
      medians[i] = getMedian(lowers, uppers);
    }

    return medians;
  }

  public static void main(String[] args) {
    double[] medians = solution(new int[]{1, 2, 45, 56, 23, 1, 57, 4});
    for (double median : medians) {
      System.out.println(median);
    }
  }
}
