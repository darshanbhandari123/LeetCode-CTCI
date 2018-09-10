import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String a[]){

        int nums[] = {0,1,2,4,5,7};

        List<String> list = summaryRanges(nums);
        for (String s:
             list) {
            System.out.print(s+"    ");
        }

    }

    private static List<String> summaryRanges(int[] nums){

        if(nums == null || nums.length == 0)
            return new ArrayList<>();

        List<String> result = new ArrayList<>();
        for (int i=0;i<nums.length;i++){

            int x = nums[i];

            while (i<nums.length-1){
                if(nums[i] == nums[i+1] - 1){
                    i++;
                }
                else{
                    break;
                }
            }

            if(x!=nums[i]){
                result.add(String.valueOf(x)+"->"+String.valueOf(nums[i]));
            }
            else {
                result.add(String.valueOf(x));
            }

        }

        return result;

    }


}
