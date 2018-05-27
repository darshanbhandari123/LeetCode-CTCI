public class CoinChangeII {

    public static void main(String args[])
    {
        int coins[] = {1,2,5};
        int total = 5;

        int dp[][] = new int[coins.length][total+1];
        for(int i=0;i<dp.length;i++)
            dp[i][0] = 1;

        for(int j=1;j<dp[0].length;j++)
        {
            if(j%coins[0]==0)
                dp[0][j] = 1;
            else
                dp[0][j] = 0;
        }

        for (int i=1;i<dp.length;i++)
        {
            for (int j=1;j<dp[0].length;j++)
            {
                if(j>=coins[i])
                {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[coins.length-1][total]);
    }
}
