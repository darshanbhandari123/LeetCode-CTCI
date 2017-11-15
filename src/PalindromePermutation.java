public class PalindromePermutation {
    public static void main(String args[])
    {
        String s = new String("ababababa");

        s=s.replace(" ","");
        char c[] = s.toCharArray();
        int hash[] = new int[256];
        int flag1=0;
        int flag2=0;
        int count=0;

        for(char ch: c)
            hash[ch]++;

        if(c.length % 2==0)
        {
            for(int i=0;i<255;i++)
            {
                if(hash[i]%2!=0)
                    flag1=1;
            }
            if(flag1==0)
                System.out.println("true");
            else
                System.out.println("false");
        }
        else
        {
            for(int i=0;i<255;i++)
            {
                if(hash[i]%2==1)
                    count++;
                else if(hash[i]%2!=0)
                    flag2=1;
            }

            if(flag2==0 && count==1)
                System.out.println("true");
            else
                System.out.println("false");
        }

    }
}
