public class BestTimeToBuyAndSell1 {

    public static void main(String args[]){

        int nums[] = {7,1,5,3,6,4};

        int ans = maxProfit(nums);
        System.out.println(ans);
    }

    private static int maxProfit(int[] nums){

        int max = 0;
        if (nums == null || nums.length == 0)
            return 0;

        int minimumBuyPrice = nums[0];          // we cannot sell the stock on the first day.
        for (int i=1;i<nums.length;i++){
            if(nums[i] < minimumBuyPrice){      //we keep checking for the minimum buying price.
                minimumBuyPrice = nums[i];
            }
            else {
                if(nums[i] - minimumBuyPrice > max)     // if we don't find any minimum price then we look for maximizing the profit.
                    max = nums[i] - minimumBuyPrice;
            }
        }

        return max;

    }

}
