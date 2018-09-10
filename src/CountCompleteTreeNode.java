import com.sun.xml.internal.bind.v2.model.core.MaybeElement;

public class CountCompleteTreeNode {

    static TreeNode root;

    public static void main(String a[]){

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);


        int ans = countNodes(root);
        System.out.println(ans);

    }

    private static int countNodes(TreeNode root){

        int nodes = 0;
        int height = height(root);

        while (root!=null){

            if(height(root.right) == height-1){
                nodes += (int)Math.pow(2,height);
                root = root.right;

                System.out.println("if");
            }
            else {
                nodes += (int)Math.pow(2,height-1);
                root = root.left;

                System.out.println("else");
            }

            height--;
        }

        return nodes;
    }

    private static int height(TreeNode root){

        if(root == null){
            return -1;
        }
        else {
            return 1 + height(root.left);
        }

    }

}
