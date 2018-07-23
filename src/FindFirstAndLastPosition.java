import javax.print.attribute.standard.NumberUp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindFirstAndLastPosition {

    public static void main(String a[]){

        int nums[] = {5,7,7,8,8,10};
        int target = 8;

        int ans[] = searchRange(nums,target);
        for (int x:ans){
            System.out.print(x+"    ");
        }
    }

    private static int[] searchRange(int[] nums,int target){

        int res[] = new int[2];
        res[0] = res[1] = -1;

        int start = 0;
        int end = nums.length-1;

        while (start<=end){

            int mid = (start+end)/2;

            if(nums[mid] == target){

                if(mid == 0){
                    res[0] = mid;
                    break;
                }
                else if(nums[mid-1]!=nums[mid]){
                    res[0] = mid;
                    break;
                }
                else {
                    end = mid-1;
                }

            }
            else if(nums[mid] < target){
                start = mid+1;
            }
            else {
                end = mid-1;
            }

        }

        start = 0;
        end = nums.length-1;

        while (start<=end){

            int mid = (start+end)/2;

            if(nums[mid] == target){

                if(mid == nums.length-1){
                    res[1] = mid;
                    break;
                }
                else if(nums[mid+1]!=nums[mid]){
                    res[1] = mid;
                    break;
                }
                else {
                    start = mid+1;
                }

            }
            else if(nums[mid] < target){
                start = mid+1;
            }
            else {
                end = mid-1;
            }

        }

        return res;

    }

}
