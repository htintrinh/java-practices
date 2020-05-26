package collection;

public class MinHeap {

  private int capacity = 10;
  int[] items = new int[capacity];
  private int size = 0;

  public static void main(String[] args) {
    MinHeap minHeap = new MinHeap();

    minHeap.add(10);
    minHeap.add(2);
    minHeap.add(20);
    minHeap.add(40);
    minHeap.add(1);

    int treeHeight = (int) Math.round(Math.log(5));
    for (int i = 0; i < minHeap.size; i++) {
      System.out.println(minHeap.items[i]);
    }
  }

  public void add(int num) {
    if (size >= capacity) {
      int[] newItems = new int[capacity * 2];
      System.arraycopy(items, 0, newItems, 0, capacity);
      capacity *= 2;
      items = newItems;
    }
    items[size] = num;
    bubbleUp(size);
    size++;

  }

  private void bubbleUp(int index) {
    if (index == 0) {
      return;
    }
    int parentIdx = (index - 1) / 2;
    if (items[parentIdx] > items[index]) {
      int temp = items[parentIdx];
      items[parentIdx] = items[index];
      items[index] = temp;
      bubbleUp(parentIdx);
    }
  }

  public int popHead() {
    if (size == 0) {
      throw new RuntimeException("There is no elem in heap yet");
    }
    int head = items[0];

    // swap the last element to the head
    items[0] = items[size - 1];
    items[size - 1] = 0;
    size--;

    bubbleDown(0);

    return head;
  }

  private void bubbleDown(int index) {
    int leftChildIndex = 2 * index + 1;
    if (leftChildIndex >= size) {
      return;
    }
    int swapIndex = index;
    if (items[swapIndex] > items[leftChildIndex]) {
      swapIndex = leftChildIndex;
    }

    int rightChildIndex = 2 * index + 2;
    if (rightChildIndex < size && items[swapIndex] < items[rightChildIndex]) {
      swapIndex = rightChildIndex;
    }

    int temp = items[index];
    items[index] = items[swapIndex];
    items[swapIndex] = temp;
    bubbleDown(swapIndex);
  }

}
