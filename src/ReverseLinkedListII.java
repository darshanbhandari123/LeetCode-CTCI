public class ReverseLinkedListII {

    static ListNode head;

    public static void main(String a[]){

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);


        ListNode ans = reverseBetween(head,1,2);

        ListNode cur = ans;
        while (cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    private static ListNode reverseBetween(ListNode head,int m,int n){

        int count = 0;
        int start = 1;

        if (head == null){
            return head;
        }

        if(n == m){
            return head;
        }

        ListNode cur = head;
        ListNode previous = null;
        while (start!=m){
            previous = cur;
            cur = cur.next;
            start++;
        }

        ListNode prev = null;

        while (count!=n-m+1){

            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;

            count++;

        }

        if(previous == null || previous.next == null){
            head.next = cur;
            return prev;
        }

        previous.next.next = cur;
        previous.next = prev;

        return head;

    }

}
