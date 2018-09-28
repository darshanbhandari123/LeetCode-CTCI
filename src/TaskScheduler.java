import java.lang.reflect.Array;
import java.util.*;

public class TaskScheduler {

    public static void main(String args[]){

        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;

        int ans = leastInterval(tasks,n);
        System.out.println(ans);

    }

    private static int leastInterval(char[] tasks,int n){

        int c[] = new int[26];
        for (char x:
             tasks) {
            c[x-'A']++;
        }

        Arrays.sort(c);

        int i=25;
        while (i>-1 && c[i]==c[25]){
            i--;
        }

        return Math.max(tasks.length,((c[25]-1)*(n+1)) + 25-i);

    }

}
