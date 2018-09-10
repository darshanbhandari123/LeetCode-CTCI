public class PartionList {

    public static void main(String a[]){

        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        int x = 3;

        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);

        ListNode h1 = l1;
        ListNode h2 = l2;

        while(head!=null){

            if(head.val <= x){
                l1.next = head;
                l1 = l1.next;
            }
            else {
                l2.next = head;
                l2 = l2.next;
            }

            head = head.next;

        }

        l2.next = null;
        l1.next = h2.next;

        while(h1.next!=null){

            System.out.println(h1.next.val);

            h1 = h1.next;

        }



    }

}
