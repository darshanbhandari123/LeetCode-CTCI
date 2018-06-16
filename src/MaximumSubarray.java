public class MaximumSubarray {

    public static void main(String args[]){

        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        int ans =  maxSubarray(nums);

        System.out.print(ans);

    }

    private static int maxSubarray(int nums[]){
        int max = Integer.MIN_VALUE;
        int maxCur = 0;

        for (int i=0;i<nums.length;i++){

            maxCur += nums[i];

            if (maxCur>max){
                max = maxCur;
            }


            if(maxCur < 0){
                maxCur = 0;
            }
        }

        return max;
    }

}
