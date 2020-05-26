package sort;

public class Sort {

  public static void quickSort(int[] arr) {

  }

  public static void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }

  public static void quickSortRecursive(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }
    int index = partition(arr, left, right);
    quickSortRecursive(arr, left, index - 1);
    quickSortRecursive(arr, index + 1, right);
  }

  public static int partition(int[] arr, int left, int right) {
    int pivotIdx = left;
    while (left < right) {
      while (arr[left] < arr[pivotIdx]) {
        left++;
      }
      while (arr[right] > arr[pivotIdx]) {
        right--;
      }

      if (left < right) {
        swap(arr, left, right);
      }
    }
    swap(arr, pivotIdx, right);
    return right;
  }

  public static void simpleMergeSort(int[] arr) {
    recursiveMergeSort(arr, new int[arr.length], 0, arr.length - 1);
  }

  public static void recursiveMergeSort(int[] arr, int[] temp, int startLeft, int endRight) {
    if (startLeft >= endRight) {
      return;
    }
    int middle = (startLeft + endRight) / 2;
    recursiveMergeSort(arr, temp, startLeft, middle);
    recursiveMergeSort(arr, temp, middle + 1, endRight);
    simpleMerge(arr, temp, startLeft, endRight);
  }

  public static void simpleMerge(int[] arr, int[] temp, int startLeft, int endRight) {
    int endLeft = (startLeft + endRight) / 2;
    int startRight = endLeft + 1;

    int left = startLeft;
    int right = startRight;
    int index = startLeft;

    while (left <= endLeft && right <= endRight) {
      if (arr[left] < arr[right]) {
        temp[index] = arr[left];
        left++;
      } else {
        temp[index] = arr[right];
        right++;
      }
      index++;
    }

    System.arraycopy(arr, left, temp, index, endLeft - left + 1);
    System.arraycopy(arr, right, temp, index, endRight - right + 1);
    System.arraycopy(temp, startLeft, arr, startLeft, endRight - startLeft + 1);
  }

  public static int[] mergeSort(int[] arr) {
    if (arr.length < 2) {
      return arr;
    }
    int m = arr.length / 2;
    int[] left = new int[m];
    int[] right = new int[arr.length - m];

    System.arraycopy(arr, 0, left, 0, m);
    System.arraycopy(arr, m, right, 0, arr.length - m);
    int[] sortedLeft = mergeSort(left);
    int[] sortedRight = mergeSort(right);

    return merge(sortedLeft, sortedRight);
  }

  public static int[] merge(int[] left, int[] right) {
    int mergeLength = left.length + right.length;
    int[] mergeList = new int[left.length + right.length];
    int leftIdx = 0;
    int rightIdx = 0;
    int mergeIdx = 0;

    while (leftIdx < left.length && rightIdx < right.length) {
      if (left[leftIdx] < right[rightIdx]) {
        mergeList[mergeIdx] = left[leftIdx];
        leftIdx++;
      } else {
        mergeList[mergeIdx] = right[rightIdx];
        rightIdx++;
      }
      mergeIdx++;
    }
    if (leftIdx < left.length) {
      System.arraycopy(left, leftIdx, mergeList, mergeIdx, mergeLength - mergeIdx);
    }
    if (rightIdx < right.length) {
      System.arraycopy(right, rightIdx, mergeList, mergeIdx, mergeLength - mergeIdx);
    }

    return mergeList;
  }

  public static void main(String[] args) {
//    int[] merge = merge(new int[]{1, 3, 4, 6, 8}, new int[]{23, 24, 35, 67});
//    for (int val : merge) {
//      System.out.println(val);
//    }
    int[] list = new int[]{23, 4, 1, 45, 6, 34, 234, 2, 5};
//    int[] sortedList = mergeSort(list);
//    for (int num : sortedList) {
//      System.out.println(num);
//    }

    quickSortRecursive(list, 0, list.length - 1);
    for (int num : list) {
      System.out.println(num);
    }
  }


}
