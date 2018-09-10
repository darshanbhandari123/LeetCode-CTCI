public class TwoSumII {

    public static void main(String a[]){

        int nums[] = {2,7,11,15};
        int target = 9;

        int start = 0;
        int end = nums.length-1;
        int[] ans = new int[2];

        while (start<end){
            if(nums[start]+nums[end]<target)
                start++;
            else if(nums[start]+nums[end]>target)
                end--;
            else{
                ans[0] = start+1;
                ans[1] = end+1;
                break;
            }
        }

        for (int x:
             ans) {
            System.out.print(x+"    ");
        }

    }

}
