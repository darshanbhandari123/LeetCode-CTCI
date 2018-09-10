public class IntersectionOfTwoLinkedLists {

    public static void main(String args[]){

        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        ListNode headB = new ListNode(3);
        headB.next = new ListNode(4);
        headB.next.next = new ListNode(5);
        headA.next.next = new ListNode(6);
        headA.next.next.next = new ListNode(7);
        headA.next.next.next.next = new ListNode(8);

        headB.next.next.next = headA.next.next;

        ListNode ans = getIntersectionPoint(headA,headB);
        System.out.println(ans.val);
    }

    private static ListNode getIntersectionPoint(ListNode headA,ListNode headB){

        if(headA == null || headB == null){
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while (a!=b){

            if(a==null)
                a=headB;
            else
                a = a.next;

            if (b == null)
                b = headA;
            else
                b = b.next;
        }

        return a;
    }

}
