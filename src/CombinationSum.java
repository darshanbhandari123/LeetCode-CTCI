import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String args[])
    {
        int nums[] = {2,3,6,7};
        int target=7;

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        helper(result,combination,nums,target,0);
        for (List<Integer> x:result) {
            for (Integer a: x) {

                System.out.print(a+" ");

            }

            System.out.println();
        }
    }

    private static void helper(List<List<Integer>> result, List<Integer> combinaiton,int nums[],int remain,int start)
    {
        if(remain == 0)
        {
            result.add(new ArrayList<>(combinaiton));
        }
        else
        {
            for(int i=start;i<nums.length;i++)
            {
                if(nums[i]>remain)
                    break;

                combinaiton.add(nums[i]);
                helper(result,combinaiton,nums,remain-nums[i],i);
                combinaiton.remove(combinaiton.size()-1);
            }
        }
    }
}
