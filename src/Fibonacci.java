public class Fibonacci {

    public static void main(String args[]){

        int n = 10;
        int a = printNth(n);
        System.out.println(a);
    }

    private static int printNth(int n){

        int dp[] = new int[n/2];
        dp[0] = dp[1] = 1;
        for (int i=2;i<dp.length;i++){
            dp[i] = dp[i-2] + dp[i-1];
        }


        int iterations = n - dp.length;
        int i=0;
        int ans = 0;
        int last = dp[dp.length-1];
        int secondLast = dp[dp.length-2];
        int num1multiplier = 1;
        int num2multiplier = 1;

        while (i<iterations){

            ans = last*num1multiplier + secondLast*num2multiplier;
            int temp = num1multiplier;
            num1multiplier = num1multiplier+num2multiplier;
            num2multiplier = temp;
            i++;

        }


        return ans;
    }

}
