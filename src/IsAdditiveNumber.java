import java.math.BigInteger;

public class IsAdditiveNumber {

    public static void main(String args[])
    {
        String str1 = "1123581321345589144";
        String str2 = "0121224";

        boolean flag1 = isAdditive(str1);
        boolean flag2 = isAdditive(str2);

        System.out.println(flag1);
        System.out.println(flag2);
    }

    private static boolean isAdditive(String str)
    {
        int n = str.length();
        for (int i=1;i<=n/2;i++)
        {
            for (int j =1; Math.max(i,j)<=n-i-j;j++)
            {
                if(isValid(i,j,str))
                    return true;
            }
        }

        return false;
    }

    private static boolean isValid(int i,int j, String str)
    {

        if(str.charAt(0) == '0' && i>1)
            return false;
        if(str.charAt(i) == '0' && j>1)
            return false;

        String sum = "";
        BigInteger a = new BigInteger(str.substring(0,i));
        BigInteger b = new BigInteger(str.substring(i,i+j));

        for (int start = i+j;start<str.length();start+=sum.length())
        {
            b = b.add(a);
            a = b.subtract(a);

            sum = b.toString();
            if(!str.startsWith(sum,start))
                return false;
        }

        return true;
    }
}
