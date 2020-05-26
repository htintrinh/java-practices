package ranprob;

import java.util.ArrayList;
import java.util.List;

public class GenerateBracket {

  public static void main(String[] args) {
    System.out.println(new GenerateBracket().generateParenthesis(5));
    System.out.println(new GenerateBracket().generateParenthesis2(5));
  }

  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<String>();

    recursiveGenBracket(result, 0, 0, "", n);
    return result;
  }

  public List<String> generateParenthesis2(int n) {
    List<String> ans = new ArrayList<String>();
    if (n == 0) {
      ans.add("");
      return ans;
    }
    for (int c = 0; c < n; c++) {
      for (String left : generateParenthesis2(c)) {
        for (String right : generateParenthesis(n - c - 1)) {
          ans.add("(" + left + ")" + right);
        }
      }
    }
    return ans;
  }

  private void recursiveGenBracket(List<String> result, int open, int close, String curr, int max) {
    if (open == close && open == max) {
      result.add(curr);
      return;
    }

    if (open < max) {
      recursiveGenBracket(result, open + 1, close, curr + "(", max);
    }
    if (close < open) {
      recursiveGenBracket(result, open, close + 1, curr + ")", max);
    }
  }

}
