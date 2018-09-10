public class SearchInRotatedSortedArray {

    public static void main(String args[]){

        int nums[] = {5,6,7,0,1,2,4};
        int target = 4;

        int ans = search(nums,target);
        System.out.println(ans);
    }

    private static int search(int[] nums,int target){

        int start = 0;
        int end = nums.length-1;

        while (start+1<end)
        {

            int mid = (end-start)/2 + start;
            if(nums[mid] == target)
                return mid;

            if(nums[mid]>nums[end]){

                if (target>=nums[mid] && target<=nums[end]){
                    start = mid;
                }
                else {
                    end = mid;
                }

            }
            else {

                if(target<=nums[mid] && target>=nums[start]){
                    end = mid;
                }
                else {
                    start = mid;
                }

            }

        }

        if (nums[start] == target)
            return start;
        if (nums[end] == target)
            return end;

        return -1;

    }

}
