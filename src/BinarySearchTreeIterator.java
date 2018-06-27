import java.util.Stack;

public class BinarySearchTreeIterator {

    static Stack<TreeNode> stack = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root){
        pushAllnodes(root);
    }

    private static int next(){
        TreeNode result = stack.pop();
        pushAllnodes(result.right);
        return result.data;
    }

    private static boolean hasNext(){
        return !stack.isEmpty();
    }

    static TreeNode root;

    public static void main(String args[]){

        root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(25);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(12);
        root.right.right = new TreeNode(30);

        BinarySearchTreeIterator i = new BinarySearchTreeIterator(root);
        while (i.hasNext())
            System.out.println(i.next());

    }

    private static void pushAllnodes(TreeNode node){

        while(node!=null){
            stack.push(node);
            node = node.left;
        }

    }
}
