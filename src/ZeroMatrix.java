import java.util.ArrayList;

public class ZeroMatrix {
    public static void main(String args[])
    {
        int a[][] = {{1,2,3,0,4},{5,0,8,0,2},{12,6,14,10,11}};

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int i=0;i<a.length;i++)
            for(int j=0;j<a[i].length;j++)
            {
                if(a[i][j]==0)
                {
                    if(!list1.contains(i))
                        list1.add(i);

                    if(!list2.contains(j))
                        list2.add(j);
                }
            }



        for(int i=0;i<a.length;i++)
        {
            if(list1.contains(i))
            {
                for(int j=0;j<a[0].length;j++)
                    a[i][j]=0;
            }
        }
        for(int j=0;j<a[0].length;j++)
        {
            if(list2.contains(j))
            {
                for(int i=0;i<a.length;i++)
                    a[i][j]=0;
            }
        }


        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[i].length;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

    }
}
