import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsTok {

    public static void main(String a[]){

        int nums[] = {1,1,1};
        int k = 2;
        int count = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        for (int i=0;i<nums.length;i++){

            sum += nums[i];
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }

            map.put(sum,map.getOrDefault(sum,0)+1);

        }

        System.out.println(count);
    }

}
