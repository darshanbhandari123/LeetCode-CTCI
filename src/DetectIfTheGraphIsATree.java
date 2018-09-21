import java.util.ArrayList;
import java.util.List;

public class DetectIfTheGraphIsATree {

    public static void main(String args[]){

        List<Integer> adj[] = new List[2];
        for (int i=0;i<adj.length;i++){
            adj[i] = new ArrayList<>();
        }

        addEdge(adj,0,1);

        boolean ans = isTree(adj);
        System.out.println(ans);

    }

    private static void addEdge(List<Integer> adj[],int v,int w){

        adj[v].add(w);
        adj[w].add(v);

    }

    private static boolean isTree(List<Integer> adj[]){

        return(!hasCycleAndConnected(adj));

    }

    private static boolean hasCycleAndConnected(List<Integer> adj[]){

        boolean visited[] = new boolean[adj.length];
        for (int u=0;u<adj.length;u++){

            if(!visited[u]){

                if(hasCycleUntil(adj,visited,u,-1)){
                    return true;
                }

            }

        }

        for (int i=0;i<visited.length;i++){
            if(!visited[i]){
                return true;
            }
        }

        return false;

    }

    private static boolean hasCycleUntil(List<Integer> adj[],boolean[] visited,int i,int parent){

        visited[i] = true;
        List<Integer> list = adj[i];

        for (int x: list) {

            if(!visited[x]){
                if(hasCycleUntil(adj,visited,x,i)){
                    return true;
                }
            }
            else if(x!=parent) {
                return true;
            }

        }

        return false;

    }


}
