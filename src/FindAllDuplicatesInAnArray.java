import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public static void main(String a[]){

        int nums[] = {4,3,2,7,8,2,3,1};

        List<Integer> result = findDuplicates(nums);
        for (int x:
             result) {
            System.out.print(x+"    ");
        }

    }

    private static List<Integer> findDuplicates(int[] nums){

        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length<2)
            return result;

        for (int i=0;i<nums.length;i++){

            int x = Math.abs(nums[i]);
            if(nums[x-1]>0)
                nums[x-1] = -1 * nums[x-1];
            else
                result.add(x);

        }

        return result;

    }

}
