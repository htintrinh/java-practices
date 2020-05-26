package ranprob;

public class Trading {

  public static void main(String[] args) {
    Trading trading = new Trading();
    int maxProfit = trading.maxProfit(new int[]{3, 3});
    System.out.println(maxProfit);
  }

  public int maxProfit(int[] prices) {
    // int maxProfit = 0;
    // for(int i = 1; i < prices.length; i++ ) {
    //     if (prices[i] > prices[i - 1]) {
    //         maxProfit += prices[i] - prices[i - 1];
    //     }
    // }
    // return maxProfit;
    int valley = 0;
    int peak = 0;
    int i = 0;
    int profit = 0;
    while (i < prices.length - 1) {
      while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
        i++;
      }
      valley = prices[i];
      while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
        i++;
      }
      peak = prices[i];

      profit += peak - valley;
    }

    return profit;
  }

}
