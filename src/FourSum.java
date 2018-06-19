import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String args[]){

        int nums[] = {-1,-5,-5,-3,2,5,0,4};
        int target = -7;

        List<List<Integer>> result = fourSum(nums,target);
        for (List<Integer> x:result) {
            for (int a: x) {
                System.out.print(a);
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> fourSum(int[] nums,int target){

        List<List<Integer>> result = new ArrayList<>();
        if (nums.length<4)
            return result;
        Arrays.sort(nums);

        for (int i=0;i<nums.length-3;i++){
            if(i!=0 && nums[i-1]==nums[i])
                continue;
            threeSum(result,nums,i+1,target-nums[i]);
        }
        return result;
    }

    private static void threeSum(List<List<Integer>> result,int[] nums,int start,int target){

        if(start>nums.length-3){
            return;
        }

        for(int i=start;i<nums.length-2;i++){
            if(i!=start && nums[i-1]==nums[i]){
                continue;
            }

            int startIndex = i+1;
            int endIndex = nums.length-1;
            int threeSumTarget = target - nums[i];

            while(startIndex<nums.length && endIndex>-1 && startIndex<endIndex){

                if(nums[startIndex] + nums[endIndex] == threeSumTarget){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[start-1]);
                    temp.add(nums[startIndex]);
                    temp.add(nums[endIndex]);
                    temp.add(nums[i]);

                    result.add(temp);

                    startIndex++;
                    endIndex--;

                    while (startIndex<endIndex && nums[startIndex-1] == nums[startIndex])
                        startIndex++;

                    while (endIndex>startIndex && nums[endIndex+1] == nums[endIndex])
                        endIndex--;
                }
                else if(nums[startIndex] + nums[endIndex] < threeSumTarget){
                    startIndex++;
                }
                else {
                    endIndex--;
                }
            }
        }

    }

}
