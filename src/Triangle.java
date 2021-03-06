import java.util.ArrayList;
import java.util.List;

public class Triangle {

    public static void main(String args[])
    {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(2);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);

        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);

        List<Integer> list4 = new ArrayList<>();
        list4.add(1);
        list4.add(8);
        list4.add(4);
        list4.add(3);

        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);

        int ans = new Triangle().getMinimumSum(list);

        System.out.print("Minimum sum is: "+ans);
    }

    private int getMinimumSum(List<List<Integer>> triangle) {

        if(triangle == null)
            return 0;       //return 0 if triangle does not exist.

        int len = triangle.size();
        int dp[] = new int[len];

        for (int i=0;i<len;i++){
            dp[i] = triangle.get(len-1).get(i);
        }

        for (int i=len-2;i>-1;i--){
            List<Integer> row = triangle.get(i);

            for (int j=0;j<row.size();j++){

                dp[j] = row.get(j) + Math.min(dp[j],dp[j+1]);

            }
        }

        return dp[0];
    }

}
