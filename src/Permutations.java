import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String args[]){

        int nums[] = {1,2,3};
        List<List<Integer>> result;

        result = permute(nums);

        /*for (List<Integer> x: result) {

            for (int a:x)
                System.out.print(a);

            System.out.println();
        }*/
    }

    private static List<List<Integer>> permute(int[] nums){

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length==0)
            return result;

        List<Integer> temp = new ArrayList<>();
        helper(result,temp,nums);
        return result;


    }

    private static void helper(List<List<Integer>> result,List<Integer> temp,int[] nums){

        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));          // when the temporary list has 3 elements, we will add it to the result and basically return
        }
        else {
            for (int i=0;i<nums.length;i++){
                if(temp.contains(nums[i]))              //to avoid duplication we check for this
                    continue;
                temp.add(nums[i]);
                helper(result,temp,nums);               //this is to implement dfs.
                temp.remove(temp.size()-1);         // this is the basic backtracking the calls will be like a dfs.(1   1,2     1,2,3      1,3      1,3,2   2   etc etc)
            }
        }

    }

}


