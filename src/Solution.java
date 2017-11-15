public class Solution {
    public static void main(String args[])
    {
        String s = new String("fbdhs");


        char x[]=s.toCharArray();
        char y[]=new char[s.length()];
        y[0]=x[0];
        int k=1;
        for(int i=1;i<x.length;i++) {
            int flag=0;
            int j=0;
            while ( j < i) {
                if (x[i] == y[j])
                    flag=1;

                j++;
            }
            if(flag==0)
            {
                y[k]=x[i];
                k++;
            }
        }
        String ans = String.valueOf(y);
        ans=ans.trim();

        System.out.println(s.equals(ans));
    }
}
