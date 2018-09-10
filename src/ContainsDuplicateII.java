import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {

    public static void main(String args[]){

        int nums[] = {1,0,1,1};
        int k = 1;

        boolean ans = containsNearbyDuplicate(nums,k);
        System.out.println(ans);

    }

    private static boolean containsNearbyDuplicate(int[] nums, int k){

        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){

            if(i>k){
                set.remove(nums[i-k-1]);
            }

            if(set.contains(nums[i]))
                return true;

            set.add(nums[i]);
        }

        return false;
    }

}
