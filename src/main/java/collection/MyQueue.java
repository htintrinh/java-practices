package collection;

import java.util.Stack;
import java.util.stream.IntStream;

public class MyQueue<T> {

  private Stack<T> stack1 = new Stack<>();
  private Stack<T> stack2 = new Stack<>();

  public static void main(String[] args) {
    MyQueue<String> myQueue = new MyQueue<>();
    myQueue.enqueue("Test1");
    myQueue.enqueue("Test2");
    myQueue.enqueue("Test3");
    myQueue.enqueue("Test4");
    IntStream.range(1, 5).forEach((i) -> {
      System.out.println(myQueue.dequeue());
    });
  }

  public void enqueue(T elem) {
    stack1.push(elem);
  }

  public T peek() {
    shiftStack();
    return stack2.peek();
  }

  private void shiftStack() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
  }

  public T dequeue() {
    shiftStack();
    return stack2.pop();
  }
}
