import java.util.ArrayList;
import java.util.List;

public class ArjunTestI {

    public static void main(String aa[]){

        List<Integer> a = new ArrayList<>();
        a.add(7);
        a.add(2);
        a.add(3);
        a.add(10);
        a.add(1);
        a.add(4);
        a.add(8);
        a.add(1);

        int ans = maxDiff(a);
        System.out.println(ans);
    }

    private static int maxDiff(List<Integer> a){

        int max = Integer.MIN_VALUE;
        int smallestOddYet = Integer.MAX_VALUE;

        if (a.get(0)%2 == 1 || a.get(0)%2 == -1){
            smallestOddYet = a.get(0);
        }

        for (int i=1;i<a.size();i++){

            if(a.get(i)%2 == 0){

                if(smallestOddYet!=Integer.MAX_VALUE){

                    if(max < (a.get(i)-smallestOddYet)){
                        max = a.get(i)-smallestOddYet;
                    }

                }

            }
            else {

                if(a.get(i) < smallestOddYet ){

                    smallestOddYet = a.get(i);

                }

            }

        }

        if(max == Integer.MIN_VALUE){
            return -1;
        }
        else
            return max;

    }

}
