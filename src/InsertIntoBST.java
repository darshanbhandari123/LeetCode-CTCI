public class InsertIntoBST {

    public static void main(String args[]){

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode ans = insert(root,5);
        System.out.println(ans.right.left.data);

    }

    private static TreeNode insert(TreeNode root,int val){

        if(root == null){
            return new TreeNode(val);
        }

        if(root.data>val){
            root.left = insert(root.left, val);
        }
        else{
            root.right = insert(root.right,val);
        }

        return root;

    }

}
