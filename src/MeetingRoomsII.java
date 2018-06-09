import java.util.Arrays;

class Interval
{
    int start;
    int end;
    Interval(){

    }
    Interval(int s,int e) {

        start = s;
        end = e;

    }
}

public class MeetingRoomsII {

    public static void main(String args[]){
        Interval[] intervals = new Interval[3];

        intervals[0] = new Interval(0,30);
        intervals[1] = new Interval(5,10);
        intervals[2] = new Interval(15,20);

        int ans = minMeeringRooms(intervals);
        System.out.print(ans);

    }

    private static int minMeeringRooms(Interval[] intervals) {

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
        return rooms;
    }

}
