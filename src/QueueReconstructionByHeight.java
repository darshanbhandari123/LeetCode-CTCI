import java.util.*;

public class QueueReconstructionByHeight {

    static class PairComp implements Comparator<int[]> {
        public int compare(int[] p1, int[] p2) {
            int comp_h = Integer.compare(p2[0], p1[0]);
            return comp_h == 0 ? Integer.compare(p1[1], p2[1]) : comp_h;
        }
    }
    public static void main(String args[])
    {
        int people[][] = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int ans[][] = new int[people.length][people[0].length];

        LinkedList<int[]> list = new LinkedList();
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(1, new PairComp() );
        for (int[] ppl: people){
            queue.offer( ppl );
        }


        while ( ! queue.isEmpty() ) {
            int[] pair = queue.poll();
            list.add(pair[1], pair);
        }

        int count = 0;
        for(int x[]:list)
        {
            for(int i=0;i<x.length;i++)
            {
                ans[count][i] = x[i];
            }

            count++;
        }

        for(int i=0;i<ans.length;i++)
        {
            for(int j=0;j<ans[0].length;j++)
            {
                System.out.print(ans[i][j]+" ");
            }

            System.out.println();
        }
    }
}
