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
            result.add(new ArrayList<>(temp));
        }
        else {
            for (int i=0;i<nums.length;i++){
                if(temp.contains(nums[i]))
                    continue;
                temp.add(nums[i]);
                helper(result,temp,nums);
                temp.remove(temp.size()-1);
            }
        }

    }

}


