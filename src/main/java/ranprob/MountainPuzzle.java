package ranprob;

public class MountainPuzzle {

  public static boolean isValidMountain(int[] heights) {
    if (heights.length < 3) {
      return false;
    }
    boolean isUp = false;
    boolean isDown = false;

    int currentIdx = 0;
    while (currentIdx < heights.length - 1 && heights[currentIdx] < heights[currentIdx + 1]) {
      isUp = true;
      currentIdx++;
    }

    while (currentIdx < heights.length - 1 && heights[currentIdx] > heights[currentIdx + 1]) {
      isDown = true;
      currentIdx++;
    }

    return currentIdx == heights.length - 1 && isDown && isUp;
  }


  public static void main(String[] args) {
    int[] heights = new int[]{1, 3, 3, 5, 3, 2, 1};

    System.out.println(isValidMountain(heights));
  }
}
