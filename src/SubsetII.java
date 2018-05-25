import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {

    public static void main(String args[])
    {
        int nums[] = {1,2,2};
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        helperSubset(result,subset,nums,0);

        for (List<Integer> list:result) {
            for (Integer x:list) {
                System.out.print(x+" ");
            }

            System.out.println();
        }
    }

    private static void helperSubset(List<List<Integer>> result,List<Integer> subset,int nums[],int start)
    {
        result.add(new ArrayList<>(subset));
        for(int i=start;i<nums.length;i++)
        {
            if(i!=start && nums[i]==nums[i-1])
                continue;

            subset.add(nums[i]);
            helperSubset(result,subset,nums,i+1);
            subset.remove(subset.size()-1);
        }
    }

}
