import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    static TreeNode root;

    public static void main(String args[]){

        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode ans = invertTree(root);



    }

    private static TreeNode invertTree(TreeNode root){

        if(root == null)
            return null;

        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;

        return root;

    }

}
