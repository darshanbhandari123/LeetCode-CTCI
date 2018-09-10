import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

    public static void main(String a[]){

        int n = 3;

        List<TreeNode> result = generateTree(n);
        for (TreeNode x:
             result) {
            System.out.println(x.data);
        }

    }

    private static List<TreeNode> generateTree(int n){

        return helper(1,n);

    }

    private static List<TreeNode> helper(int start,int end){

        List<TreeNode> result =  new ArrayList<>();

        if(start>end){
            result.add(null);
            return result;
        }
        if(start == end){
            result.add(new TreeNode(start));
            return result;
        }

        for (int i=start;i<=end;i++){

            List<TreeNode> left,right;

            left = helper(start,i-1);
            right = helper(i+1,end);

            for (TreeNode lnode:
                 left) {

                for (TreeNode rnode:
                     right) {

                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    result.add(root);

                }

            }

        }

        return result;

    }

}
