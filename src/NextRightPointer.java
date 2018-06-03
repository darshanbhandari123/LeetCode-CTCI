class Node
{
    int data;
    Node left, right,next;

    Node(int item)
    {
        data = item;
        left = right = next = null;
    }
}

public class NextRightPointer {

    Node root;

    private static Node nextRight(Node head)
    {
        Node pre = head;
        Node cur = null;

        if(head == null)
            return null;

        while (pre.left!=null)
        {
            cur = pre;

            while (cur!=null)
            {
                cur.left.next = cur.right;
                if(cur.next!=null)
                    cur.right.next = cur.next.left;

                cur = cur.next;
            }

            pre = pre.left;
        }

        return head;

    }

    private static void printTree(Node head)
    {
        Node pre = head;
        Node cur = null;

        while (pre.left!=null)
        {
            cur = pre;

            while (cur.next!=null)
            {
                System.out.println( cur.next.data);

                cur = cur.next;
            }

            pre = pre.left;
        }

    }

    public static void main(String args[])
    {
        NextRightPointer tree = new NextRightPointer();

        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(5);

        printTree(tree.root);
    }


}


