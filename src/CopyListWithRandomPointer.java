class RandomListNode {

    int label;
    RandomListNode next,random;
    RandomListNode(int x){
        this.label = x;
    }

}

public class CopyListWithRandomPointer {
    static RandomListNode head;

    public static void main(String args[]){

        head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.next.next = new RandomListNode(4);
        head.next.next.next.next = new RandomListNode(5);

        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;
        head.next.next.next.next.random = head.next.next;

        RandomListNode ans = copyRandomList(head);

        while (ans!=null){
            if(ans.random!=null)
                System.out.print(ans.label+"    "+ans.random.label);
            else
                System.out.print(ans.label);

            System.out.println();
            ans = ans.next;
        }

    }

    private static RandomListNode copyRandomList(RandomListNode head){
        if(head == null)
            return null;

        RandomListNode ans = new RandomListNode(head.label);
        RandomListNode newHead = ans;
        RandomListNode cur = head;

        while (cur!=null && cur.next!=null){                            //cloning the linked list provided with same data and next fields

            ans.next = new RandomListNode(cur.next.label);
            ans = ans.next;
            cur = cur.next;

        }
        if(cur.next!=null){                                             //replicating the last node.
            ans.next = new RandomListNode(cur.next.label);
        }

        cur = head;
        ans = newHead;

        while (ans!=null){                                              //assigning the random pointer of each node of new linked list with corresponding previous data node eg:-  random of new 1 is pointing to old 1.

            ans.random = cur;
            ans = ans.next;
            cur = cur.next;

        }

        cur = head;
        ans = newHead;

        while (cur!=null){                                              //assigning the next of each node in original linked list with corresponding value node in new linked list.

            RandomListNode next = cur.next;
            cur.next = ans;
            ans = ans.next;
            cur = next;

        }

        ans = newHead;

        while (ans!=null){                                              //finally assigning random pointer values to new nodes as follows
            ans.random = ans.random.random.next;                        //for better understanding draw diagrams at each stage.
            ans = ans.next;
        }

        return newHead;
    }

}
