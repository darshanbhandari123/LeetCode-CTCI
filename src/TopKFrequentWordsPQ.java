import java.util.*;

public class TopKFrequentWordsPQ {

    public static void main(String args[]){

        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 3;

        List<String> ans = topKFrequent(words,k);
        for (String x:
                ans) {
            System.out.print(x+"    ");
        }

    }

    private static List<String> topKFrequent(String[] words,int k){

        Map<String,Integer> map = new HashMap<>();

        for (String x:words){
            map.put(x,map.getOrDefault(x,0)+1);
        }

        PriorityQueue<Map.Entry<String,Integer>> priorityQueue = new PriorityQueue<>(
                (a,b) -> a.getValue()!=b.getValue() ? a.getValue().compareTo(b.getValue()) :  b.getKey().compareTo(a.getKey())
        );

        for (Map.Entry<String,Integer> entry:map.entrySet()) {

            priorityQueue.offer(entry);
            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }

        }

        List<String> ans = new ArrayList<>();
        while (!priorityQueue.isEmpty()){
            ans.add(0,priorityQueue.poll().getKey());
        }

        return ans;
    }

}
