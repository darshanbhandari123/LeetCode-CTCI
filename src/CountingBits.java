public class CountingBits {

    public static void main(String args[]){

        int n=5;

        int ans[] = countBits(n);
        for (int x:
             ans) {
            System.out.print(x+"    ");
        }
    }

    private static int[] countBits(int n){
        int dp[] = new int[n+1];
        dp[0] = 0;
        for (int i=1;i<dp.length;i++){
            dp[i] = dp[i/2] + i%2;
        }
        return dp;
    }
}
