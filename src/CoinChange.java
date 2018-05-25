import java.util.Arrays;

public class CoinChange {

    public static void main(String args[])
    {
        int coins[] = {186,419,83,408};
        int target = 6249;

        Arrays.sort(coins);

        int dp[][] = new int[coins.length][target+1];
        for(int k=0;k<dp[0].length;k++)
        {
            if(k%coins[0]==0) {
                dp[0][k] = k/coins[0];
            }
            else
            {
                dp[0][k] = Integer.MAX_VALUE;
            }
        }
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(j>=coins[i])
                {
                    if(dp[i][j-coins[i]] == Integer.MAX_VALUE)
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i]]+1);
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        if(dp[coins.length-1][target] == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(dp[coins.length-1][target]);
    }

}
