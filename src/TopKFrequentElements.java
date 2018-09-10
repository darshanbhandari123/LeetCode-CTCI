import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public static void main(String args[]){

        int nums[] = {1,2,1,2,1,3,4,4,3,5,6,6,5};
        int k = 2;

        List<Integer> result = topKFrequent(nums,k);

        for (Integer x: result){
            System.out.print(x+"    ");
        }
    }

    private static List<Integer> topKFrequent(int nums[],int k){

        Map<Integer,Integer> map = new HashMap<>();
        for (int n:nums){
            if(map.containsKey(n)){
                int x = map.get(n);
                map.put(n,x+1);
            }
            else {
                map.put(n,1);
            }
        }

        List<Integer> bucket[] = new List[nums.length+1];
        for (int key:map.keySet()){

            int frequency = map.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }

            bucket[frequency].add(key);

        }

        List<Integer> result = new ArrayList<>();
        for (int i=bucket.length-1;i>=0 && k>0;i--){

            if (bucket[i]!=null){

                result.addAll(bucket[i]);
                k = k-bucket[i].size();

            }

        }

        return result;

    }

}
