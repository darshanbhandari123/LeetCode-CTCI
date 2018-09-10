public class LongestIncreasingSubsequenceNlogNsoln {

    public static void main(String a[]){

        int nums[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int ans = lis(nums);

        System.out.println(ans);

    }

    private static int lis(int[] nums){

        int ans[] = new int[nums.length];
        ans[0] = nums[0];
        int pos = 1;

        for (int i=1;i<nums.length;i++){

            if(nums[i] < nums[0]){
                nums[0] = nums[i];
            }
            else if(nums[i]>nums[pos-1]){
                nums[pos++] = nums[i];
            }
            else {
                int x = binarySearch(nums,0,pos-1,nums[i]);
                nums[x] = nums[i];
            }

        }

        return pos;

    }

    private static int binarySearch(int[] nums,int start,int end,int target){

        int mid = -1;
        while (start<=end){

            mid = (start+end)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                start = mid+1;
            }
            else {
                end = mid-1;
            }

        }

        return mid;

    }


}
