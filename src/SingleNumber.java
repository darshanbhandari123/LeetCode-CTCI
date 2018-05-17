public class SingleNumber {

    public static void main(String args[])
    {
        int a[] = {1,2,1,6,2,9};
        int diff = 0;
        for (int num : a) {
            diff ^= num;
        }

        diff &= -diff;

        System.out.println(diff);

        int ans[] = new int[2];
        for (int num: a)
        {
            if((num & diff) == 0)
                ans[0] ^= num;
            else
                ans[1] ^= num;
        }
        for(int i=0;i<ans.length;i++)
            System.out.print(ans[i] + " ");
    }

}
