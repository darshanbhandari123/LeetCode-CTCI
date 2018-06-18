public class HouseRobber {

    public static void main(String args[]){

        int nums[] = {2,7,9,3,1};

        int max = rob(nums);        // we solve the problem using dp. (the basic idea is that a house will be robbed or will not be robbed.)
        System.out.print(max);
    }

    private static int rob(int[] nums){

        int dp[][] = new int[nums.length+1][2];         //we use a 2 dp matrix for the cases:- 0th column stands for the house not being robbed, 1st stands for when the house is robbed.

        for (int i=1;i<dp.length;i++){                  //here i=1 means first house.

            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);  // (when a house is not robbed, it does not matter if the previous house is robbed or not (it should just be the maximum choice))
            dp[i][1] = nums[i-1] + dp[i-1][0];           //  however, when a house is robbed it is a must that the previous house is not robbed.  (else alarm will be raised)
        }

        return Math.max(dp[nums.length][0],dp[nums.length][1]);     // return the maximum from the last dp entry.  i.e. if the last house is robbed or not.
    }

}
