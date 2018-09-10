public class MaximumSumofThreeNonOverlappingSubarrays {

    public static void main(String a[]){

        int nums[] = {1,2,1,2,6,7,5,1};
        int k = 2;

        int ans[] = maxSumOfThreeSubarrays(nums,k);
        for (int x:
             ans) {
            System.out.print(x+"    ");
        }

    }

    private static int[] maxSumOfThreeSubarrays(int nums[],int k){

        int ans[] = new int[3];
        int n = nums.length;
        int maxSum = 0;
        int sum[] = new int[n+1];
        int posLeft[] = new int[n];
        int posRight[] = new int[n];

        for(int i=0;i<n;i++){
            sum[i+1] = sum[i]+nums[i];
        }

        for (int i=k,tot = sum[k] - sum[0];i<n;i++){

            if(sum[i] - sum[i+1-k] > tot){
                posLeft[i] = i+1-k;
                tot = sum[i] - sum[i+1-k];
            }
            else {
                posLeft[i] = posLeft[i-1];
            }

        }

        posRight[n-k] = n-k;
        for (int i=n-k-1,tot = sum[n] - sum[n-k];i>=0;i--){

            if(sum[i+k] - sum[i] >= tot){
                posRight[i] = i;
                tot = sum[i+k] - sum[i];
            }
            else {
                posRight[i] = posRight[i+1];
            }

        }

        for (int i=k;i<=n-2*k;i++){

            int l = posLeft[i-1];
            int r = posRight[i+k];
            int tot = (sum[i+k] - sum[i])+(sum[l+k]-sum[l])+(sum[r+k]-sum[r]);

            if(tot>maxSum){
                maxSum = tot;
                ans[0] = l;
                ans[1] = i;
                ans[2] = r;
            }

        }


        return ans;

    }

}
