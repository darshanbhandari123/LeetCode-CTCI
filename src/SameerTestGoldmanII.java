import com.sun.org.apache.bcel.internal.generic.LUSHR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameerTestGoldmanII {

    public static void main(String a[]){

        List<Integer> seats = new ArrayList<>();
        seats.add(1);
        seats.add(3);
        seats.add(1);
        seats.add(2);

        List<Integer> score = new ArrayList<>();
        score.add(990);
        score.add(780);
        score.add(830);
        score.add(860);
        score.add(920);

        List<List<Integer>> pref = new ArrayList<>();
        pref.add(Arrays.asList(3,2,1));
        pref.add(Arrays.asList(3,0,0));
        pref.add(Arrays.asList(2,0,1));
        pref.add(Arrays.asList(0,1,3));
        pref.add(Arrays.asList(0,2,3));

        List<Integer> ans = allocate(seats,score,pref);

        for (int x:
             ans) {

            System.out.println(x);

        }


    }

    private static List<Integer> allocate(List<Integer> seats, List<Integer> score,List<List<Integer>> pref){

        List<Integer> ans = new ArrayList<>();

        for (int i=0;i<=score.size();i++){

            int index = getMax(score);
            List<Integer> list = pref.get(index);

            boolean ass = assign(list,seats,index);

            if(ass){
                pref.remove(index);
            }


            score.remove(index);

            i=0;

        }


        int total = 0;
        for (int x:
             seats) {
            total += x;
        }

        ans.add(total);
        ans.add(pref.size());

        return ans;


    }

    private static int getMax(List<Integer> score){

        int max = score.get(0);
        int index = 0;

        for (int i=1;i<score.size();i++){

            if(score.get(i) > max){
                max = score.get(i);
                index = i;
            }

        }

        return index;

    }

    private static boolean assign(List<Integer> parPref,List<Integer> seats,int index){

        boolean ans = false;

        for (int i=0;i<parPref.size();i++){

            int ch = parPref.get(i);

            if(seats.get(ch)>0){
                int x = seats.get(ch);
                x--;
                seats.set(ch,x);
                ans = true;
                break;
            }

        }

        return ans;

    }

}
