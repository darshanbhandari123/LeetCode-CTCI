import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public static void main(String args[]){

        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        boolean ans = wordBreak(s,wordDict);
        System.out.println(ans);
    }

    private static boolean wordBreak(String s, List<String> wordDict){

        boolean canSegment[] = new boolean[s.length()+1];
        canSegment[0] = true;

        for (int i=1;i<canSegment.length;i++)
        {
            for (int j=0;j<i;j++){

                if(canSegment[j] && wordDict.contains(s.substring(j,i))){
                    canSegment[i] = true;
                    break;
                }

            }
        }

        return canSegment[canSegment.length-1];
    }

}
