public class KthSmallestElementInBST {

    public static void main(String a[]){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int k=3;
        int ans = kthSmallest(root,k);

        System.out.println(ans);

    }

    private static int kthSmallest(TreeNode root,int k){

        int c = count(root.left);

        if(k <= c){
            return kthSmallest(root.left,k);
        }
        else if (k > c+1){
            return kthSmallest(root.right,k-1-c);
        }

        return root.data;

    }

    private static int count(TreeNode node){

        if(node == null){
            return 0;
        }

        return 1 + count(node.left) + count(node.right);

    }

}
