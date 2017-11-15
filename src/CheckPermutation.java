public class CheckPermutation {
    public static void main(String args[])
    {
        String s1 = new String("ABCD");
        String s2 = new String("bAccd");

        boolean ans = checkPermutation(s1,s2);
        System.out.println(ans);
    }

    private static boolean checkPermutation(String s1,String s2)
    {
        int hash[] = new int[256];
        char c1[]=s1.toLowerCase().toCharArray();
        char c2[]=s2.toLowerCase().toCharArray();

        for(char c: c1)
            hash[c]++;

        for(char c: c2)
            hash[c]--;

        for(int i=0;i<255;i++)
        {
            if(hash[i]!=0)
                return false;
        }
        return  true;
    }
}
