import java.util.Arrays;

public class MeetingRoomsI {

    public static void main(String args[]){
        Interval[] intervals = new Interval[3];

        intervals[0] = new Interval(0,30);
        intervals[1] = new Interval(35,40);
        intervals[2] = new Interval(45,50);

        boolean ans = minMeeringRooms(intervals);
        System.out.print(ans);

    }

    private static boolean minMeeringRooms(Interval[] intervals) {

        int[] startTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];

        for (int i=0;i<intervals.length;i++){
            startTime[i] = intervals[i].start;
            endTime[i] = intervals[i].end;
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int rooms = 0;
        int endIterator = 0;
        for (int i=0;i<startTime.length;i++)
        {
            if(startTime[i]<endTime[endIterator]){
                rooms++;
            }
            else {
                endIterator++;
            }
        }
        if (rooms==1)
            return true;
        else
            return false;
    }

}
