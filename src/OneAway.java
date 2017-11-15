public class OneAway {
    public static void main(String args[])
    {
        String s1 = new String("pale");
        String s2 = new String("bake");

        int hash[] = new int[256];
        int count=0;
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();

        for(char ch:c1)
            hash[ch]++;

        for(char ch: c2)
            hash[ch]--;

        for(int i=0;i<256;i++)
        {
            if(hash[i]!=0)
                count++;
        }

        if(count<=2)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
