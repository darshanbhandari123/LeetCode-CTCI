import java.util.ArrayList;
import java.util.List;

class TreeNode {

    int data;
    TreeNode left,right;

    TreeNode(int x)
    {
        this.data = x;
        left = right = null;
    }

}

public class BinaryTreeLevelOrderTraversal {

    TreeNode root;

    private static List<List<Integer>> printLevelOrder(TreeNode root)
    {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;

        compute(list,root,0);
        return list;
    }

    private static void compute(List<List<Integer>> list, TreeNode root, int level)
    {
        if(root == null)
            return;

        if(list.size() == level)
        {
            list.add(new ArrayList<>());
        }

        list.get(level).add(root.data);

        compute(list,root.left,level+1);
        compute(list,root.right,level+1);

    }

    public static void main(String args[])
    {
        BinaryTreeLevelOrderTraversal tree =  new BinaryTreeLevelOrderTraversal();

        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(5);
        tree.root.left.left = new TreeNode(16);
        tree.root.left.right = new TreeNode(17);
        tree.root.right.left = new TreeNode(15);
        tree.root.right.right = new TreeNode(20);

        List<List<Integer>> list = printLevelOrder(tree.root);

        for (List<Integer> x: list)
        {
            for (Integer y : x)
            {
                System.out.print(y+" ");
            }

            System.out.println();
        }
    }



}
