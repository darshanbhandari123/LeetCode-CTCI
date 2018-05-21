import java.util.*;

public class QueueReconstructionByHeight {

   static class Comp implements Comparator<int []>
   {
       public int compare(int[] p1,int[] p2)
       {
           int comp = Integer.compare(p2[0],p1[0]);
           return comp == 0? Integer.compare(p1[1],p2[1]): comp;
       }
   }

   public static void main(String args[])
   {
       int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
       PriorityQueue<int[]> queue = new PriorityQueue(1,new Comp());

       for (int[] x:people)
       {
           queue.offer(x);
       }

       List<int[]> result = new ArrayList<>();
       while(!queue.isEmpty())
       {
           int a[] = queue.poll();
           result.add(a[1],a);
       }

       for (int[] x:result) {

           for (int ans:x){
               System.out.print(ans + " ");
           }

           System.out.println();
       }
   }
}
