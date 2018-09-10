public class BestTimeToBuyAndSellWithCooldown {

    public static void main(String a[]) {

        int[] prices = {1, 2, 3, 0, 2};

        int ans = maxProfit(prices);
        System.out.println(ans);
    }

    private static int maxProfit(int[] prices) {

        int maxProfit = 0;

        if (prices.length < 2)
            return maxProfit;

        int has0_doNothing = 0;
        int has0_Buy = -prices[0];
        int has1_doNothing = -prices[0];
        int has1_Sell = 0;

        for (int i = 1; i < prices.length; i++) {

            int a = has0_Buy;
            int b = has0_doNothing;
            int c = has1_doNothing;
            int d = has1_Sell;

            has0_Buy = b - prices[i];
            has0_doNothing = Math.max(b,d);
            has1_doNothing = Math.max(a,c);
            has1_Sell = Math.max(a,c) + prices[i];

        }

        if(has0_doNothing > has1_Sell){
            maxProfit = has0_doNothing;
        }
        else {
            maxProfit = has1_Sell;
        }

        return maxProfit;

    }
}
