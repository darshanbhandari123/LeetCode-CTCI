public class SingleNumber {

    public static void main(String args[])
    {
        int nums[] = {1,2,5,3,2,1};
        int diff=0;
        for (int x:nums) {
            diff ^=x;
        }

        int ans[] =new int[2];
        diff &= -diff;
        for(int n:nums){
            if((n&diff) ==0)
            {
                ans[0] ^=n;
            }
            else
            {
                ans[1] ^=n;
            }
        }

        for(int a:ans)
            System.out.print(a +" ");
    }

}
