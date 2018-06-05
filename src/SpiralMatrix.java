public class SpiralMatrix {

    public static void main(String args[])
    {
        int n = 4;
        int ans[][] = new int[n][n];

        ans = constructMartrix(n);

        for (int i=0;i<4;i++)
        {
            for (int j=0;j<4;j++)
            {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }


    }

    private static int[][] constructMartrix(int n)
    {
        int res[][] = new int[n][n];
        int count = 1;
        int rs = 0;
        int cs = 0;
        int re = n;
        int ce = n;

        while (rs<re && cs<ce)
        {
            for(int i=cs;i<ce;i++)
            {
                res[rs][i] = count++;
            }
            rs++;

            for (int i=rs;i<re;i++)
            {
                res[i][ce-1] = count++;
            }
            ce--;

            for (int i=ce-1;i>=cs;i--)
            {
                res[re-1][i] = count++;
            }
            re--;

            for (int i=re-1;i>=rs;i--)
            {
                res[i][cs] = count++;
            }
            cs++;
        }

        return res;
    }

    private static void helper(int i,int j,int ans[][],int c)
    {

    }
}
