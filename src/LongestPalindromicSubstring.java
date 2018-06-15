public class LongestPalindromicSubstring {

    public static void main(String args[]){

        String s = "babad";
        String ans = longestPalindrome(s);
        String ans1 = longestPalindromeusingconstantspace(s);
        System.out.print(ans1);

    }

    private static String longestPalindrome(String s){              //using dp O(n2) space complexity.

        boolean isPalindrome[][] = new boolean[s.length()][s.length()];
        int max = 1;
        int start = 0;
        for (int i=0;i<s.length();i++){
            isPalindrome[i][i] = true;
        }

        for (int i=0;i<s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                isPalindrome[i][i+1] = true;
                start = i;
                max = 2;
            }
        }

        for (int k = 3;k<=s.length();k++){

            for (int i = 0;i<s.length()-k-1;i++){

                int j = i + k - 1;

                if(isPalindrome[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    isPalindrome[i][j] = true;

                    if(k>max)
                    {
                        start = i;
                        max = k;
                    }
                }

            }

        }
        //System.out.print(max);
        return s.substring(start,start+max);

    }

    private static String longestPalindromeusingconstantspace(String s){
        int max = 1;
        int start = 0;

        for (int i = 1;i<s.length();i++){

            int low = i-1;
            int high = i;

            while (low>-1 && high<s.length() && s.charAt(low) == s.charAt(high)){
                if(high - low +1 > max){

                    start = low;
                    max = high - low + 1;

                }

                low--;
                high++;
            }

            low = i-1;
            high = i+1;

            while (low>-1 && high<s.length() && s.charAt(low) == s.charAt(high)){
                if(high - low + 1>max){

                    start=low;
                    max = high - low + 1;

                }

                low--;
                high++;
            }

        }

        return s.substring(start,start+max);
    }

}
