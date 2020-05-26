package ranprob;

import java.util.Stack;

public class BalanceParentheses {

  public static char[][] TOKENS = {{'(', ')'}, {'[', ']'}, {'{', '}'}};

  public static void main(String[] args) {
    String testString = "{{}{}}()[[[[]]]";

    System.out.println(isBalance(testString));
  }

  public static boolean isOpenBracket(Character c) {
    for (char[] tokens : TOKENS) {
      if (tokens[0] == c) {
        return true;
      }
    }
    return false;
  }

  public static boolean match(Character openBracket, Character closeBracket) {
    for (char[] tokens : TOKENS) {
      if (tokens[0] == openBracket && tokens[1] == closeBracket) {
        return true;
      }
    }
    return false;
  }

  public static boolean isBalance(String expression) {
    Stack<Character> stack = new Stack<>();
    for (Character c : expression.toCharArray()) {
      if (isOpenBracket(c)) {
        stack.push(c);
      } else {
        if (stack.isEmpty() || !match(stack.pop(), c)) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
