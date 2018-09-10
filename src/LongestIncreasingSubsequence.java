import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String a[]){

        int nums[] = {3,4,-1,0,6,2,3};

        int ans = lengthOfLIS(nums);
        System.out.println(ans);
    }

    private static int lengthOfLIS(int nums[]){

        int ans = 1;

        int dp[] = new int[nums.length];
        Arrays.fill(dp,1);

        for (int i=1;i<nums.length;i++){

            for (int j=0;j<i;j++){

                if(nums[j] < nums[i]){

                    if(dp[i] < dp[j]+1){

                        dp[i] = dp[j]+1;

                    }

                }

            }

        }
        int max = dp[0];
        for (int x:dp){
            if(x>max){
                max = x;
            }
        }

        ans = max;
        return ans;

    }

}
