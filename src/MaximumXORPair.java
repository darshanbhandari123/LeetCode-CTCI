public class MaximumXORPair {
    
    static class Node
    {
        Node left;
        Node right;
    }

    public static void main(String args[])
    {
        int a[] = {3,10,5};
        Node head = new Node();
        for(int i=0;i<a.length;i++)
        {
            insert(head,a[i]);
        }

        System.out.println(findMaxXOR(a,head));
    }

    private static void insert(Node head,int n)
    {
        Node cur = head;
        for(int i=31;i>=0;i--)
        {
            int bit = (n>>i) & 1;
            if(bit == 0)
            {
                if(cur.left==null)
                {
                    cur.left = new Node();
                }
                cur = cur.left;
            }
            else
            {
                if(cur.right==null)
                {
                    cur.right=new Node();
                }
                cur=cur.right;
            }
        }
    }

    private static int findMaxXOR(int a[],Node head)
    {
        int max_xor = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++)
        {
            Node cur = head;
            int value = a[i];
            int current_xor = 0;
            for(int j=31;j>=0;j--)
            {
                int bit = (value>>j)&1;
                if(bit == 0)
                {
                    if(cur.right != null)
                    {
                        current_xor += Math.pow(2,j);
                        cur=cur.right;
                    }
                    else
                    {
                        cur=cur.left;
                    }
                }
                else
                {
                    if(cur.left!=null)
                    {
                        current_xor += Math.pow(2,j);
                        cur = cur.left;
                    }
                    else
                    {
                        cur = cur.right;
                    }
                }
            }

            if(current_xor>max_xor)
                max_xor = current_xor;
        }

        return max_xor;
    }
}
