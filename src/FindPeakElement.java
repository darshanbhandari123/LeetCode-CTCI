public class FindPeakElement {

    public static void main(String a[]){

        int[] nums = {1,2,1,2,3,5,6,7,8};

        int ans = findPeakElement(nums);
        System.out.println(ans);

    }

    private static int findPeakElement(int[] nums){

        int start = 0;
        int end = nums.length-1;

        while (start < end){

            int mid = (start+end)/2;

            if(nums[mid] < nums[mid+1]){        // seems very easy but work out for input array and check, the answer will be index 8(which is also true) and not index 1.
                start = mid+1;
            }
            else {
                end = mid;
            }

        }

        return start;
    }

}
