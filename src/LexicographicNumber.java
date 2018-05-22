import java.util.ArrayList;
import java.util.List;

public class LexicographicNumber {
    public static void main(String args[])
    {
        int n = 25;
        List<Integer> list = helper(n);

        for (int a:list)
            System.out.print(a +" ");
    }
    private static List<Integer> helper(int n)
    {
        List<Integer> result = new ArrayList<>(n);
        int cur = 1;
        for(int i=1;i<=n;i++)
        {
            result.add(cur);
            if(cur*10<=n)
                cur = cur*10;
            else if((cur%10) != 9 && (cur + 1)<=n)
                cur++;
            else
            {
                while((cur/10)%10 == 9)
                    cur = cur/10;

                cur = cur/10 + 1;
            }
        }

        return result;
    }
}
