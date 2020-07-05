package linklist;

import java.util.ArrayList;
import java.util.Random;

public class SwapTwoConsecutiveNode {

  static class Node {

    private Node() {
    }

    public static Node of(int value) {
      Node node = new Node();
      node.setValue(value);
      return node;
    }

    private int value;
    private Node next;

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public Node getNext() {
      return next;
    }

    public void setNext(Node next) {
      this.next = next;
    }
  }

  public static Node initRandomLinkList(int size) {
    Random random = new Random();
    Node firstNode = Node.of(random.nextInt(200));
    Node currentNode = firstNode;
    for (int i = 0; i < size - 1; i++) {
      currentNode.setNext(Node.of(random.nextInt(200)));
      currentNode = currentNode.getNext();
    }

    return firstNode;
  }

  public static void printAllNode(Node node) {
    while (node != null) {
      System.out.println(node.getValue());
      node = node.getNext();
    }
  }

  public static ArrayList<Integer> linkListToArray(Node node) {
    ArrayList<Integer> arrayList = new ArrayList<>();

    while (node != null) {
      arrayList.add(node.getValue());
      node = node.getNext();
    }

    return arrayList;
  }


  public static void main(String[] args) {
    Node listNode = initRandomLinkList(9);
    printAllNode(listNode);

    System.out.println("After swap first pair");
    Node newHead = swapConsecutiveElementLinkList(listNode);
    printAllNode(newHead);
  }

  public static Node swapConsecutiveElementLinkList(Node node) {
    if (node == null) {
      return null;
    }

    if (node.getNext() == null) {
      return node;
    }

    Node preHead = null;
    Node headNode = node;
    Node tailNode = node.getNext();
    Node newHead = tailNode;

    // first swap
    headNode.setNext(tailNode.getNext());
    tailNode.setNext(headNode);

    preHead = headNode;
    headNode = headNode.getNext();

    // in middle, head not null, tail not null
    while (headNode != null) {
      tailNode = headNode.getNext();

      if (tailNode != null) {
        preHead.setNext(tailNode);
        headNode.setNext(tailNode.getNext());
        tailNode.setNext(headNode);

        preHead = headNode;
        headNode = headNode.getNext();
      } else {
        headNode = null;
      }
    }

    return newHead;
  }
}
