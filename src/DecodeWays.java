public class DecodeWays {

    public static void main(String args[])
    {
        String s = "225";
        int ans = findWays(s);

        System.out.print(ans);
    }

    private static int findWays(String s)
    {
        int dp [] = new int[s.length()+1];
        dp[0]=0;
        dp[1] = s.charAt(0)!='0'? 1:0;

        if(s.charAt(2)!='0')
            dp[2] = dp[1];

        int t = Integer.parseInt(s.substring(0,2));
        if(t>=10 && t<=26)
            dp[2]++;

        for (int i=3;i<dp.length;i++)
        {
             if(s.charAt(i-1)!='0')
                 dp[i] = dp[i-1];

             int num = Integer.parseInt(s.substring(i-2,i));
             if(num>=10 && num<=26)
                 dp[i] += dp[i-2];
        }

        return dp[s.length()];
    }
}
