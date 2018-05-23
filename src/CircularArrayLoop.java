public class CircularArrayLoop {

    public static void main(String args[])
    {
        int a[] = {2, -1, 1, 2, 2};
        getIndex(a);

        boolean ans = isLooped(a);

        for (int x:a) {
            System.out.print(x +" ");
        }
        System.out.println("\n"+ans);
    }

    private static void getIndex(int a[])
    {
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>=0)
            {
                a[i] = (a[i]+i)%a.length;
            }
            else
            {
                if((a[i]+i)<0)
                {
                    a[i] = (a.length + (a[i]+i)%a.length)%a.length;
                }
                else
                {
                    a[i] = i + a[i];
                }
            }
        }
    }

    private static boolean isLooped(int a[])
    {
        for(int i=0;i<a.length;i++)
        {
            if(a[i] == i)
                continue;

            int s;
            int f;
            int count = 0;
            int j=i;
            while(count!=a.length && j<a.length)
            {
                s = a[j];
                f = a[s];

                if(s==f && count>0)
                    return true;

                j++;
                count++;
            }
        }
        return false;
    }
}
