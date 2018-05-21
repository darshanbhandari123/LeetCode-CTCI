public class ReorderList {
        static Node head;

        static class Node {

            int data;
            Node next;

            Node(int d) {
                data = d;
                next = null;
            }
        }

        Node reorder(Node head)
        {

            Node slow = head;
            Node fast = head;

            while(fast.next!=null && fast.next.next!=null)
            {
                slow = slow.next;
                fast = fast.next.next;
            }

            Node mid = slow;
            Node prev = null;

            Node cur = mid.next;
            while(cur!=null)
            {
                Node next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

            mid.next = prev;

            Node n1 = head;
            Node n2 = prev;

            while (n1!=mid)
            {
                Node n1next = n1.next;
                Node n2next = n2.next;

                n1.next = n2;
                n2.next = n1next;
                n1 = n1next;
                n2 = n2next;
            }

            mid.next = n2;

            return head;
        }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }


    public static void main(String args[]){

        ReorderList list = new ReorderList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);


        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reorder(head);
        System.out.println("");
        System.out.println("Reordered linked list ");
        list.printList(head);


    }

}
