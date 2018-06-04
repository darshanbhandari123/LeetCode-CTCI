public class PalindromicSubstring {
    static int count = 0;

    public static void main(String args[])
    {
        String s = "aabbcc";

        int ans = countSubstring(s);
        System.out.println(ans);

    }

    private static int countSubstring(String s)
    {
        for (int i=0;i<s.length();i++)
        {
            helper(s,i,i);
            helper(s,i,i+1);
        }

        return count;
    }

    private static void helper(String s,int left,int right)
    {
        while(left>-1 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            count++;
            left--;
            right++;
        }
    }
}

