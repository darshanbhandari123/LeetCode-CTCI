import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String args[]){
        int nums[] = {5,7,1,3};
        int target = 6;

        int ans[] = twoSum(nums,target);

        for (int x:ans){
            System.out.print(x+"    ");
        }
    }

    private static int[] twoSum(int nums[],int target){
        int ans[] = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                ans[0] = map.get(target-nums[i]);
                ans[1] = i;
                return ans;
            }
            else {
                map.put(nums[i],i);
            }
        }
        return ans;
    }

}
