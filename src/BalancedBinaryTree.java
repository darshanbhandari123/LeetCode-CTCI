public class BalancedBinaryTree {

    static TreeNode root;

    public static void main(String a[]){

        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(20);
        root.left.left.left = new TreeNode(20);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(6);

        boolean ans = isBalanced(root);
        System.out.println(ans);
    }

    private static boolean isBalanced(TreeNode root){

        if(root == null){
            return true;
        }

        if(height(root)!=-1)
            return true;
        else
            return false;

    }

    private static int height(TreeNode root){

        if(root == null){
            return 0;
        }

        int lh = height(root.left);
        if(lh == -1)            //very important condition as we need to check for balance in each node of the tree.
            return -1;

        int rh = height(root.right);
        if(rh == -1)            //very important condition for the same reason as mentioned above.
            return -1;

        if((lh - rh)>1 || (lh-rh)<-1)
            return -1;

        return Math.max(lh,rh)+1;

    }

}
