import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BullsAndCows {

    public static void main(String a[]){

        String secret = "011";
        String guess = "110";

        String ans = getHint(secret,guess);
        System.out.println(ans);

    }

    private static String getHint(String secret, String guess){

       int bull=0;
       int cow=0;
       int numbers[] = new int[10];
       for (int i=0;i<secret.length();i++){
           if(secret.charAt(i) == guess.charAt(i)){
               bull++;
           }
           else {
               if (numbers[secret.charAt(i)-'0'] < 0)
                   cow++;
               if (numbers[secret.charAt(i)-'0'] > 0)
                   cow++;

               numbers[secret.charAt(i)-'0']++;
               numbers[secret.charAt(i)-'0']--;
           }
       }

       return bull+"A"+cow+"B";

    }

}
