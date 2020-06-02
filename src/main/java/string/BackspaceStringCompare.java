package string;

public class BackspaceStringCompare {

  public boolean backspaceCompare(String S, String T) {
    int backspaceNumOfS = 0;
    int backspaceNumOfT = 0;
    int lastIndexOfS = S.length() - 1;
    int lastIndexOfT = T.length() - 1;
    while (lastIndexOfS >= 0 || lastIndexOfT >= 0) {
      while (lastIndexOfS >= 0) {
        if (S.charAt(lastIndexOfS) == '#') {
          backspaceNumOfS++;
          lastIndexOfS--;
        } else if (backspaceNumOfS > 0) {
          backspaceNumOfS--;
          lastIndexOfS--;
        } else {
          break;
        }
      }
      while (lastIndexOfT >= 0) {
        if (T.charAt(lastIndexOfT) == '#') {
          backspaceNumOfT++;
          lastIndexOfT--;
        } else if (backspaceNumOfT > 0) {
          backspaceNumOfT--;
          lastIndexOfT--;
        } else {
          break;
        }
      }
      if ((lastIndexOfS < 0) != (lastIndexOfT < 0)) {
        return false;
      }
      if (lastIndexOfS >= 0 && lastIndexOfT >= 0 && S.charAt(lastIndexOfS) != T
          .charAt(lastIndexOfT)) {
        return false;
      }
      lastIndexOfS--;
      lastIndexOfT--;
    }
    return true;
  }

  public static void main(String[] args) {
    BackspaceStringCompare compare = new BackspaceStringCompare();
    compare.backspaceCompare("a#c", "b");
  }

}
