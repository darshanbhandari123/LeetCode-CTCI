import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String args[]){

        int nums[] = {-1, 0, 1, 2, -1, -4};

        List<ArrayList<Integer>> result = threeSum(nums);
        for (ArrayList<Integer> x: result) {
            for (int a:x) {
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }

    private static List<ArrayList<Integer>> threeSum(int[] nums){

        List<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length<3)
            return result;

        Arrays.sort(nums);

        for (int i=0;i<nums.length-2;i++){

            if(i!=0 && nums[i]==nums[i-1])      //to avoid duplicates
                continue;

            int negate = 0 - nums[i];
            int start = i+1;
            int end = nums.length-1;

            while (start<end){

                if(nums[start] + nums[end] == negate){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    result.add(temp);

                    start++;
                    end--;

                    while (start<end && nums[start] == nums[start-1])       //to avoid duplication again after initial check
                        start++;

                    while (start<end && nums[end] == nums[end+1])           //to avoid duplication from behind as well
                        end--;
                }
                else if(nums[start] + nums[end] < negate)
                    start++;
                else
                    end--;
            }


        }


        return result;
    }

}
