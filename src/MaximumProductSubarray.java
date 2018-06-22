public class MaximumProductSubarray {

    public static void main(String args[]){

        int nums[] = {2,3,-2,4,-6};
        int max = nums[0];
        int max_ending_here = nums[0];
        int min_ending_here = nums[0];

        for (int i=1;i<nums.length;i++){

            if(nums[i]<0){
                int temp = max_ending_here;
                max_ending_here = min_ending_here;
                min_ending_here = temp;
            }

            max_ending_here = Math.max(nums[i],max_ending_here*nums[i]);
            min_ending_here = Math.min(nums[i],min_ending_here*nums[i]);

            if(max_ending_here>max)
                max = max_ending_here;

        }

        System.out.println(max);
    }

}
