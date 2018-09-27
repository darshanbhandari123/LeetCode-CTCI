import java.util.Stack;

public class BSTToDoublyLinkedList {

    static TreeNode root;
    static TreeNode head;

    public static void main(String args[]){

        root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        head = makeList(root);
        TreeNode start = head;
        int count = 0;

        while (count==0 || start!=head){
            System.out.print(start.data+" ");
            start = start.right;
            count++;
        }
    }

    private static TreeNode makeList(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        TreeNode start = root;
        while (start.left!=null){
            start = start.left;
        }

        TreeNode prev = null;

        while (!stack.isEmpty() || cur!=null){

            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();

            if(prev != null){
                prev.right = cur;
                cur.left = prev;
            }

            prev = cur;
            cur = cur.right;

        }

        start.left = prev;
        prev.right = start;

        return start;

    }

}
