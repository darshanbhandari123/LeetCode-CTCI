import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String a[]){

        int n = 4;
        int k = 3;

        List<List<Integer>> result = combine(n,k);
        for (List<Integer> x:
             result) {
            for (Integer y: x){
                System.out.print(y);
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> combine(int n,int k){

        List<List<Integer>> result = new ArrayList<>();
        if(n <= 0)
            return result;

        List<Integer> temp = new ArrayList<>();

        helper(result,temp,n,k,1);
        return result;

    }

    private static void helper(List<List<Integer>> result, List<Integer> temp,int n,int k,int start){

        if(temp.size() == k){
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start;i<=n;i++){

            temp.add(i);
            helper(result,temp,n,k,i+1);
            temp.remove(temp.size()-1);

        }

    }

}
