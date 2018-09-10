import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String args[]){
        List<Interval> intervals = new ArrayList<>();

        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));


        List<Interval> result = merge(intervals);
        for (Interval i:
             result) {
            System.out.println(i.start+"    "+i.end);
        }
    }

    private static List<Interval> merge(List<Interval> intervals){

        List<Interval> result = new ArrayList<>();
        int start[] = new int[intervals.size()];
        int end[] = new int[intervals.size()];

        for (int i = 0;i<intervals.size();i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int j=0;
        //int count = 0;
        for (int i=1;i<start.length;i++){

            if(end[j]>start[i]){
                end[j] = end[i];
            }
            else {
                Interval a = new Interval(start[j],end[j]);
                result.add(a);
                j=i;
            }
        }

        if(start[start.length-1]>end[end.length-2]){
            result.add(new Interval(start[start.length-1],end[end.length-1]));
        }
        else {
            Interval x = result.get(result.size()-1);
            result.remove(result.size()-1);
            x.end = end[end.length-1];
            result.add(x);
        }

        return result;
    }

}
