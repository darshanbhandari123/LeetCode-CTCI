class ListNode {
    int val;
    ListNode next = null;
    ListNode(int x){
        val = x;
    }
}

public class AddTwoNumbers {

    public static void main(String args[]){
        ListNode l1 = new ListNode(1);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);

        ListNode result = add(l1,l2);

        while (result!=null){
            System.out.print(result.val+"   ");
            result = result.next;
        }
    }

    private static ListNode add(ListNode l1,ListNode l2){

        ListNode head = new ListNode(0);
        ListNode mainHead = head;

        int carry = 0;
        while (l1!=null || l2!=null || carry!=0)        //we need to continue finding the sum even if any one of these quantities is not null or 0. (Most Important condition)
        {
            ListNode current = new ListNode(0);     //just a dummy value which will be changed accordingly.
            int sum=0;
            if(l1==null && l2==null)                    // these if else statements are very logical and needs to be glanced at before any interview.
                sum = 0+0+carry;
            else if(l1==null)
                sum = 0+l2.val+carry;
            else if(l2==null)
                sum = l1.val+0+carry;
            else
                sum=l1.val+l2.val+carry;

            current.val = sum%10;
            carry = sum/10;
            head.next = current;
            head = head.next;

            if (l1!=null)
                l1 = l1.next;
            if (l2!=null)
                l2 = l2.next;
        }

        return mainHead.next;
    }

}
