import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class TreeNode1{
    int x;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1(int val){
        this.x = val;
        this.left = null;
        this.right = null;
    }
}

public class MaximumDepthOfBinaryTree {
    static TreeNode1 root;

    public static void main(String args[]){

        root = new TreeNode1(3);
        root.left = new TreeNode1(9);
        root.right = new TreeNode1(20);
        root.right.left = new TreeNode1(15);
        root.right.right = new TreeNode1(7);
        root.right.right.right = new TreeNode1(6);

        int ans = findMaxDepth(root);
        int ans1 = findMaxDepth1(root);
        System.out.println(ans);
        System.out.print(ans1);
    }

    private static int findMaxDepth(TreeNode1 root){            //BFS implementation
        int max = 0;
        int size;

        Queue<TreeNode1> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){

            size = queue.size();
            while (size>0){

                TreeNode1 cur = queue.poll();
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }

                size--;

            }
            max++;

        }

        return max;
    }

    private static int findMaxDepth1(TreeNode1 root){           //recursive implementation
        if (root == null){
            return 0;
        }

        return 1 + Math.max(findMaxDepth1(root.left),findMaxDepth1(root.right));
    }

}
