public class SingleElementInASortedArray {

    public static void main(String a[]){

        int nums[] = {1,2,2,3,3,4,4,8,8};

        int ans = singleNonDupicate(nums);
        System.out.println(ans);

    }

    private static int singleNonDupicate(int[] nums){

        int low = 0;
        int high = nums.length-1;

        while (low<high){

            int mid = (low+high)/2;

            if(mid%2==0){
                if(nums[mid] == nums[mid-1]){
                    high = mid-1;
                }
                else if(nums[mid] == nums[mid+1]){
                    low = mid+1;
                }
                else
                    return nums[mid];
            }
            else {
                if(nums[mid] == nums[mid-1]){
                    low = mid+1;
                }
                else if(nums[mid] == nums[mid+1]){
                    high = mid-1;
                }
                else {
                    return nums[mid];
                }
            }
        }

        return nums[low];
    }

}
