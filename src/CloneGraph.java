import java.util.*;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}

public class CloneGraph {

    public static void main(String a[]){

        UndirectedGraphNode zero = new UndirectedGraphNode(0);
        UndirectedGraphNode one = new UndirectedGraphNode(1);
        UndirectedGraphNode two = new UndirectedGraphNode(2);

        zero.neighbors.add(one);
        zero.neighbors.add(two);

        one.neighbors.add(zero);
        one.neighbors.add(two);

        two.neighbors.add(zero);
        two.neighbors.add(one);
        two.neighbors.add(two);

        UndirectedGraphNode x = cloneGraph(one);

    }

    private static UndirectedGraphNode cloneGraph(UndirectedGraphNode node){

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        if(node == null)
            return null;

        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();

        queue.offer(node);
        map.put(node,new UndirectedGraphNode(node.label));

        while (!queue.isEmpty()){

            UndirectedGraphNode u = queue.poll();

            UndirectedGraphNode clonedU = map.get(u);
            if(u.neighbors!=null){

                List<UndirectedGraphNode> v = u.neighbors;
                for (UndirectedGraphNode graphNode: v) {

                    UndirectedGraphNode clonedG = map.get(graphNode);
                    if(clonedG == null){

                        queue.offer(graphNode);

                        clonedG = new UndirectedGraphNode(graphNode.label);
                        map.put(graphNode,clonedG);

                    }

                    clonedU.neighbors.add(clonedG);
                }


            }

        }

        return map.get(node);
    }



}
