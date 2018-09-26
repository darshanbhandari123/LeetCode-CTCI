import java.util.*;

class MyComparator<K extends Comparable<? super K>,V extends Comparable<? super V>> implements Comparator<Map.Entry<K,V>>{

    @Override
    public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {

        int comp = o2.getValue().compareTo(o1.getValue());
        if(comp!=0){
            return comp;
        }
        else {
            return o1.getKey().compareTo(o2.getKey());
        }

    }

}

public class TopKFrequentWords {

    public static void main(String args[]){

        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;

        List<String> ans = topKFrequent(words,k);
        for (String x:
             ans) {
            System.out.print(x+"    ");
        }

    }

    private static List<String> topKFrequent(String word[],int k){

        Map<String,Integer> map = new HashMap<>();
        for (String x:
             word) {
            map.put(x,map.getOrDefault(x,0)+1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,new MyComparator<>());

        List<String> ans = new ArrayList<>();

        for (Map.Entry<String,Integer> x:list){

            String key = x.getKey();
            ans.add(key);
            k--;

            if(k==0){
                break;
            }

        }


        return ans;

    }

}
