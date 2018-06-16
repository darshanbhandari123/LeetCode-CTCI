public class BestTimeToBuyAndSell2 {

    public static void main(String args[]){

        int nums[] = {7,1,3,5,2,4};             //one must sell the stock once it is bought before buying any other stock, basically we cannot buy multiple stocks at once

        int ans = maxProfit(nums);
        System.out.print(ans);

    }

    private static int maxProfit(int prices[]) {

        int maxProfit = 0;
        int i=0;

        while (i < prices.length){

            while (i < prices.length - 1 && prices[i+1]<=prices[i]){        //we find local minimum and mark it as the buying point.
                i++;
            }

            int min = prices[i];                                            //the minimum is found and i is incremented
            i++;

            while (i < prices.length - 1 && prices[i+1]>=prices[i]){        //we find the local maximum and mark it as selling point.
                i++;
            }

            if (i < prices.length){                                         // we compute the maximum profit by subtracting the cost while buying from the cost while selling.
                int max = prices[i];
                maxProfit += max-min;
            }

            i++;
        }

        return maxProfit;
    }

}
