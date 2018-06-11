import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public static void main(String args[]){

        String j = "z";
        String s = "ZZ";

        int ans = numJewelsInStones(j,s);
        System.out.print(ans);
    }

    private static int numJewelsInStones(String J, String S){

        if(J.length() == 0 || S.length()==0)
            return 0;

        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i=0;i<J.length();i++){
            set.add(J.charAt(i));
        }

        for (int i=0;i<S.length();i++){
            if(set.contains(S.charAt(i)))
                count++;
        }

        return count;
    }

}
