import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {

    public static void main(String[] a){

        String time = "09:04";

        String ans = nextClosestTime(time);
        System.out.println(ans);

    }

    private static String nextClosestTime(String time){

        String val[] = time.split(":");
        Set<Integer> set = new HashSet<>();

        add(set,val[0]);
        add(set,val[1]);

        int hour = Integer.parseInt(val[0]);
        int min = Integer.parseInt(val[1]);

        int times[] = {hour,min};
        next(times);

        while (!contains(set,times)){
            next(times);
        }

        return valid(times[0])+":"+valid(times[1]);

    }

    private static void add(Set<Integer> set,String value){

        int time = Integer.parseInt(value);
        set.add(time/10);
        set.add(time%10);

    }

    private static void next(int[] times){

        times[1]++;
        if(times[1] == 60){
            times[0]++;
            times[1] = 0;
            if(times[0] == 24){
                times[0] = 0;
            }
        }

    }

    private static boolean contains(Set<Integer> set,int[] times){

        int hour = times[0];
        int min = times[1];

        return set.contains(hour/10) && set.contains(hour%10) && set.contains(min/10) && set.contains(min%10);

    }

    private static String valid(int t){

        if(t>=0 && t<=9){
            return "0"+t;
        }

        return ""+t;
    }

}
