public class IsAdditiveNumber {

    public static void main(String args[])
    {
        String str1 = "1123581321345589144";
        String str2 = "111111";

        boolean flag1 = isAdditive(str1);
        boolean flag2 = isAdditive(str2);

        System.out.println(flag1);
        System.out.println(flag2);
    }

    private static boolean isAdditive(String str)
    {
        char c[] = str.toCharArray();
        for(int i=0;i<c.length;i++)
            if(c[i]<'0' || c[i]>'9')
                return false;



        for(int i=2;i<c.length;i++)
        {a
            int sum = (c[i-2]-'0')+(c[i-1]-'0');

            if(sum!=c[i]-'0')
                return false;
        }

        return true;
    }
}
