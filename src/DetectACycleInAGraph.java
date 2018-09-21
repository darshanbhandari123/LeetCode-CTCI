import java.util.ArrayList;
import java.util.List;

public class DetectACycleInAGraph {

    public static void main(String args[]){

        List<Integer> adj[] = new List[5];
        for(int i=0;i<5;i++){
            adj[i] = new ArrayList<>();
        }

        addEdge(adj,1, 0);
        addEdge(adj,0, 2);
        addEdge(adj,2, 0);
        addEdge(adj,0, 3);
        addEdge(adj,3, 4);

        boolean ans = isCyclic(adj);
        System.out.println(ans);

    }

    private static void addEdge(List<Integer> adj[],int v,int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    private static boolean isCyclic(List<Integer> adj[]){

        boolean[] visited = new boolean[adj.length];
        for(int u=0;u<adj.length;u++){

                if(!visited[u]) {

                    if (isCyclicUntil(visited, u, adj, -1)) {
                        return true;
                    }

                }
        }

        return false;

    }

    private static boolean isCyclicUntil(boolean visited[],int i,List<Integer> adj[],int parent){

        visited[i] = true;
        List<Integer> list = adj[i];

        for (int x:list){

            if(!visited[x]){
                if(isCyclicUntil(visited,x,adj,i)){
                    return true;
                }
            }
            else if(x!=parent){
                return true;
            }

        }
        return false;

    }

}
