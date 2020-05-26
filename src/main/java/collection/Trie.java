package collection;

public class Trie {

  public static void main(String[] args) {
    Node node = new Node();
    node.add("hello");

    System.out.println(node.findCount("hello", 0));

  }

  public static class Node {

    private int NUMBER_OF_CHAR = 26;
    Node[] children = new Node[NUMBER_OF_CHAR];
    private int size = 0;

    private int getCharIndex(char c) {
      return c - 'a';
    }

    public Node getNode(char c) {
      return children[getCharIndex(c)];
    }

    public void setNode(char c, Node node) {
      children[getCharIndex(c)] = node;
    }

    public void add(String s) {
      add(s, 0);
    }

    public void add(String s, int index) {
      size++;
      if (s.length() == index) {
        return;
      }
      Node child = getNode(s.charAt(index));
      if (child == null) {
        child = new Node();
        setNode(s.charAt(index), child);
      }

      child.add(s, index + 1);
    }

    public int findCount(String s, int index) {
      if (index == s.length()) {
        return size;
      }
      Node child = getNode(s.charAt(index));
      if (child == null) {
        return 0;
      }

      return child.findCount(s, index + 1);
    }
  }

}
