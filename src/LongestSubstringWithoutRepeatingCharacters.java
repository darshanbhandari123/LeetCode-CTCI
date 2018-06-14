import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String args[]){

        String s1 = "abcadcabc";
        String s2 = "bbbbb";

        int ans1 = lengthOfLongestSubstring(s1);
        int ans2 = lengthOfLongestSubstring(s2);

        System.out.println(ans1);
        System.out.println(ans2);

    }

    private static int lengthOfLongestSubstring(String s){

        int max_len = 0;            //to store the maximum length of non repeating sequence of characters(nrsc).
        int cur_len = 0;            //to store the current length of nrsc (after the current substring).
        Map<Character,Integer> map = new HashMap<>();       //to store the last occurrence of all characters in the string.

        for (int i=0;i<s.length();i++)
        {
            if(!map.containsKey(s.charAt(i)))               //if the current character is occurring for the first time then we simply increase the current length
                cur_len++;
            else {                                          //if the character is already present then we need to perform a check
                if((i - map.get(s.charAt(i))) > cur_len)    //if the character is a part of the current nrsc, if not then simply increment current length.
                    cur_len++;
                else                                        //change the value of current length accordingly.
                    cur_len = i - map.get(s.charAt(i));
            }

            map.put(s.charAt(i),i);                         //update the map after every iteration in the for loop.

            if(cur_len > max_len)                           //update the value of maximum length whenever required.
                max_len = cur_len;
        }

        return max_len;
    }

}
