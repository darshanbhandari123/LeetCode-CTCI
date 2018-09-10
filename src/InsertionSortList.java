public class InsertionSortList {

    static ListNode head;

    public static void main(String args[]){

        head = new ListNode(4);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(2);

        insertionSort(head);
        ListNode ans = head;
        while (ans!=null){

            System.out.print(ans.val+"  ");
            ans = ans.next;

        }
    }

    private static ListNode insertionSort(ListNode head){

        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        pre.next = head;
        ListNode cur = head;

        while (cur!=null){

            pre = helper;
            while (pre.next!=null && pre.next.val<=cur.val){
                pre = pre.next;
            }



        }

        return helper.next;
    }

}
