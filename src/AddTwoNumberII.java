public class AddTwoNumberII {

    private static ListNode head1;
    private static ListNode head2;

    public static void main(String a[]){

        head1 = new ListNode(7);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);
        head1.next.next.next = new ListNode(3);

        head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);

        head1 = reverse(head1);
        head2 = reverse(head2);

        ListNode ans = add(head1,head2);
        ListNode c = ans;

        while (c!=null){
            System.out.print(c.val+"    ");
            c = c.next;
        }

    }

    private static ListNode reverse(ListNode head){

        ListNode prev = null;
        ListNode cur = head;

        while (cur!=null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    private static ListNode add(ListNode head1,ListNode head2){

        ListNode current = new ListNode(0);
        int carry = 0;
        int sum = 0;
        ListNode ans = current;
        ListNode c1 = head1;
        ListNode c2 = head2;
        while (c1!=null || c2!=null || carry != 0){

            int x = 0;
            int y = 0;
            if(c1!=null){
                x = c1.val;
            }
            if(c2 != null){
                y = c2.val;
            }

            sum = (x+y+carry)%10;
            carry = (x+y)/10;

            current.next = new ListNode(sum);
            current = current.next;

            if(c1!=null){
                c1 = c1.next;
            }
            if(c2!=null){
                c2 = c2.next;
            }

        }

        if(carry!=0){
            current.next = new ListNode(carry);
        }

        return ans.next;

    }

}
