class ListNode1{

    int x;
    ListNode1 next;
    ListNode1(int val){
        this.x = val;
        this.next = null;
    }

}

public class ReverseLinkedList {

    static ListNode1 head;

    public static void main(String args[]){

        head = new ListNode1(1);
        head.next = new ListNode1(2);
        head.next.next = new ListNode1(3);
        head.next.next.next = new ListNode1(4);
        head.next.next.next.next = new ListNode1(5);

        ListNode1 ans1 = reverse(head);
        while (ans1!=null){
            System.out.print(ans1.x+"   ");
            ans1 = ans1.next;
        }
    }

    private static ListNode1 reverse(ListNode1 head){

        ListNode1 prev = null;
        ListNode1 cur = head;

        while (cur!=null){
            ListNode1 next = cur.next;

            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }


}
