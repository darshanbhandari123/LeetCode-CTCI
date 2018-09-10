public class OddEvenLinkedList {
    static ListNode head;

    public static void main(String args[]){

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        evenOdd(head);
        ListNode ans = head;
        while (ans!=null){
            System.out.println(ans.val);

            ans=ans.next;
        }
    }

    private static void evenOdd(ListNode head){

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while (even!=null && even.next!=null){

            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;

        }

        odd.next = evenHead;
    }

}
