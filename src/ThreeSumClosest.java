import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String args[]){

        int nums[] = {1,1,0,1};
        int target = 100;

        int ans = threeSumClosest(nums,target);
        System.out.println(ans);

    }

    private static int threeSumClosest(int[] nums,int target){

        Arrays.sort(nums);
        int closeSum = nums[0]+nums[1]+nums[nums.length-1];

        for (int i=0;i<nums.length-2;i++){

            int start = i+1;
            int end = nums.length-1;

            while (start<end){

                int sum = nums[i]+ nums[start] + nums[end];

                if(Math.abs(target-sum)<Math.abs(target-closeSum)){
                    closeSum = sum;
                }

                if (sum<target){
                    start++;
                }
                else {
                    end--;
                }

            }

        }

        return closeSum;
    }

}