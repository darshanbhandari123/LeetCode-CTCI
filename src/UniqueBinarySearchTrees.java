public class UniqueBinarySearchTrees {

    public static void main(String args[]){

        int n=5;
        int ans = numTrees(n);
        System.out.println(ans);

    }

    private static int numTrees(int n){

        int N[] = new int[n+1];
        N[0] = N[1] = 1;

        for (int i=2;i<N.length;i++){

            for (int j=1;j<=i;j++){
                N[i] += (N[j-1] * N[i-j]);      //when j is the root of the tree with i nodes;
            }

        }

        return N[n];
    }

}
