import java.util.LinkedList;
import java.util.Queue;

public class EvenSubarray {

    public static void main(String a[]){

        int nums[] = {1,2,3,4};
        int k = 1;

        int count = 0;
        int odd_count = 0;
        int j = 0;

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0;i < nums.length;i++){

            if(nums[i]%2 == 1){
                odd_count++;
                queue.offer(i);
            }

            if(odd_count<=k){
                count += i-j+1;
            }
            else {
                j = queue.poll() + 1;
                odd_count--;
                count += i-j+1;
            }

        }

        System.out.println(count);

    }

}
