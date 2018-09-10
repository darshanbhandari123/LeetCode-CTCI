public class SwapNodesInPairs {

    static ListNode head;

    public static void main(String a[]){

        head = new ListNode(1);
        head.next = new ListNode(2);



        ListNode ans = swapPairs(head);
        while (ans!=null){

            System.out.print(ans.val +" ");
            ans = ans.next;
        }

    }

    private static ListNode swapPairs(ListNode head){

        if(head==null || head.next==null)
            return head;

        ListNode newHead = head.next;
        ListNode current = head;

        while (current.next!=null){

            ListNode prev = current;
            ListNode next = current.next;
            current.next = next.next;
            next.next = current;

            if(current.next!=null){
                current = current.next;
                if(current.next!=null){
                    prev.next = current.next;
                }
            }
        }

        return newHead;
    }
}
