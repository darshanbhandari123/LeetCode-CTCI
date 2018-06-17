public class SortList {

    static ListNode head;

    public static void main(String args[]){
        head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);

        ListNode ans = sortList(head);
        while (ans!=null){

            System.out.print(ans.val + "    ");
            ans = ans.next;

        }
    }

    private static ListNode sortList(ListNode head){

        if(head==null || head.next==null)
            return head;

        ListNode prev=null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null)
        {
            prev=slow;
            fast=fast.next.next;
            slow=slow.next;
        }
        prev.next=null;
        fast=head;

        ListNode left = sortList(fast);
        ListNode right = sortList(slow);

        return mergeSort(left,right);

    }

    private static ListNode mergeSort(ListNode left,ListNode right){

        ListNode ans = new ListNode(0);
        ListNode prev = ans;

        while (left!=null && right!=null){
            ListNode cur;
            if(left.val < right.val){
                cur = new ListNode(left.val);
                left = left.next;
            }
            else {
                cur = new ListNode(right.val);
                right = right.next;
            }

            ans.next = cur;
            ans = ans.next;

        }
        if (left!=null)
            ans.next = left;

        if (right!=null)
            ans.next = right;

        return prev.next;
    }
}
