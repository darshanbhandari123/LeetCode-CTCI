import java.util.Stack;

public class ValidateBinarySearchTree {

    public static void main(String a[]){

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        boolean ans = isValidBST(root);
        System.out.print(ans);

    }

    private static boolean isValidBST(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        while (root!=null || !stack.isEmpty()){

            while (root!=null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(pre!=null && root.data<=pre.data){
                return false;
            }
            pre = root;
            root = root.right;

        }

        return true;

    }

}
