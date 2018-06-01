public class EliminationGame {

    public static void main(String args[])
    {
        int n = 10;

        int ans = findRemaining(n);

        System.out.println(ans);
    }

    private static int findRemaining(int n)
    {
        int remaining = n;
        int step = 1;
        int head = 1;
        boolean left = true;

        while (remaining>1)
        {
            if(left || remaining%2 == 1)
                head = head+step;

            step = step*2;
            remaining = remaining/2;
            left = !left;
        }

        return head;
    }
}
