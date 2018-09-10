public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String a[]){

        int nums[] = {0,0,1,1,1,1,2,3,3};

        int ans = removeDuplicates(nums);
        System.out.println(ans);
    }

    private static int removeDuplicates(int[] nums){

        int i = 0;

        for (int n: nums) {

            if(i<2 || n>nums[i-2]){
                nums[i++] = n;
            }
        }

        return i;
    }

}
