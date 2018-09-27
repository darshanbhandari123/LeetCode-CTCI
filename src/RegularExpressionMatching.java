public class RegularExpressionMatching {

    public static void main(String args[]){

        String s = "aab";
        String p = "c*a*b";

        boolean ans = isMatch(s,p);
        System.out.println(ans);

    }

    private static boolean isMatch(String s,String p){

        p = modify(p);

        boolean dp[][] = new boolean[s.length()+1][p.length()+1];

        dp[0][0] = true;
        for(int i=1;i<=p.length();i++){

            if(p.charAt(i-1)=='*'){
                dp[0][i] = dp[0][i-2];
            }
            else {
                dp[0][i] = false;
            }

        }

        for (int i=1;i<=s.length();i++){

            if(s.charAt(i-1) == ' '){
                dp[i][0] = dp[i-1][0];
            }
            else {
                dp[i][0] = true;
            }

        }

        for (int i=1;i<=s.length();i++){

            for (int j=1;j<=p.length();j++) {

                if((s.charAt(i-1) == p.charAt(j-1)) || p.charAt(j-1)=='.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-2];

                    if(p.charAt(j-2)=='.' || p.charAt(j-2)==s.charAt(i-1)){
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }

                }
                else {
                    dp[i][j] = false;
                }

            }
        }

        return dp[s.length()][p.length()];

    }

    private static String modify(String p){

        StringBuffer sb = new StringBuffer();
        boolean first = false;

        for (int i=0;i<p.length();i++){

            if(p.charAt(i)=='*'){
                if(!first){
                    first = true;
                    sb.append(p.charAt(i));
                }
            }
            else {
                sb.append(p.charAt(i));
                first = false;
            }

        }

        return sb.toString();

    }

}
