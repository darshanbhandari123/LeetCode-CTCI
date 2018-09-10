import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    public static void main(String a[]){

        int nums[] = {1,1,1,3,3,2,2,2};

        List<Integer> list = majorityElement(nums);
        for (int x:
             list) {
            System.out.print(x+"    ");
        }

    }

    private static List<Integer> majorityElement(int[] nums){

        List<Integer> result = new ArrayList<>();
        int count1=0;
        int count2=0;
        int num1 = 0;
        int num2 = 0;

        for(int i=0;i<nums.length;i++){

            if(nums[i] == num1){
                count1++;
            }
            else if(nums[i] == num2){
                count2++;
            }
            else if(count1 == 0){
                count1 = 1;
                num1 = nums[i];
            }
            else if (count2 == 0){
                count2 = 1;
                num2 = nums[i];
            }
            else{
                count1--;
                count2--;
            }
        }

        System.out.println(num1+"   "+num2);

        count1=0;count2=0;

        for(int i=0;i<nums.length;i++){

            if(nums[i] == num1)
                count1++;
            if (nums[i] == num2)
                count2++;
        }

        if(count1>nums.length/3)
            result.add(num1);
        if(count2>nums.length/3)
            result.add(num2);

        return result;

    }

}
