import java.nio.channels.InterruptedByTimeoutException;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    public static void main(String args[]){     //solved using BFS.

        int numCourses = 5;
        int[][] prerequisites = {{0,1},{0,3},{2,1},{2,3},{4,3}};

        boolean ans = canFinish(numCourses,prerequisites);
        System.out.println(ans);

    }

    private static boolean canFinish(int numCourses,int[][] prerequisites){

        int inDegree[] = new int[numCourses];
        for (int i=0;i<prerequisites.length;i++){
            inDegree[prerequisites[i][0]]++;
        }

        int canFinishCount = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                canFinishCount++;
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){

            int prereq = queue.poll();
            for (int i=0;i<prerequisites.length;i++){
                if(prerequisites[i][1] == prereq){
                    inDegree[prerequisites[i][0]]--;
                    if(inDegree[prerequisites[i][0]] == 0){
                        canFinishCount++;
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }

        }

        return (canFinishCount == numCourses);

    }

}
