public class LCAInBST {

    static TreeNode root;

    public static void main(String a[]){

        root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode ans = lowestCommonAncestor(root,root.left,root.right);
        System.out.println(ans.data);
    }

    private static TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){

        if (root == null)
            return null;

        while (root!=null){
            if(p.data<root.data && q.data<root.data)
                root = root.left;
            else if(p.data>root.data && q.data>root.data)
                root = root.right;
            else
                break;
        }

        return root;
    }

}
