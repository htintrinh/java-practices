package collection;


import java.util.concurrent.ThreadLocalRandom;

public class MiddleLinkList {

  static class NodeList {

    private int value;
    private NodeList next;

    public NodeList(int value, NodeList next) {
      this.value = value;
      this.next = next;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public NodeList getNext() {
      return next;
    }

    public void setNext(NodeList next) {
      this.next = next;
    }
  }

  public static boolean isLasNode(NodeList node) {
    if (node == null || node.next == null) {
      return true;
    }

    return false;
  }

  public static NodeList getMidNode(NodeList head) {
    if (head == null) {
      return null;
    }

    NodeList first = head;
    NodeList second = head;

    while (second.getNext() != null) {
      first = first.getNext();
      second = second.getNext().getNext();

      if (isLasNode(second)) {
        return first;
      }
    }

    return first;
  }

  public static NodeList genRandomNodeList(int length) {
    NodeList head = new NodeList(ThreadLocalRandom.current().nextInt(), null);
    NodeList tail = head;
    for (int i = 0; i < length; i++) {
      tail.setNext(new NodeList(ThreadLocalRandom.current().nextInt(), null));
      tail = tail.getNext();
    }
    return head;
  }

  public static void printNodeList(NodeList head) {
    if (head == null) {
      System.out.println("null");
    }
    while (head != null) {
      System.out.printf("%s → ", head.getValue());
      head = head.getNext();
    }

    System.out.println();
  }

  public static void main(String[] args) {
    NodeList head = genRandomNodeList(9);
    printNodeList(head);

    NodeList midNode = getMidNode(head);
    System.out.println(midNode.getValue());
  }
}
