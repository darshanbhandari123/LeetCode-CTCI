public class WildCardMatching {

    public static void main(String a[]){

        String s = "xayz";
        String p = "x?yrz";

        boolean ans = isMatch(s,p);
        System.out.println(ans);

    }

    private static boolean isMatch(String s,String p){

        StringBuffer sb = new StringBuffer();
        boolean flag = false;

        for (int i=0;i<p.length();i++){

            if(p.charAt(i) == '*'){

                if(!flag){

                    sb.append(p.charAt(i));
                    flag = true;

                }

            }
            else {
                flag = false;
                sb.append(p.charAt(i));
            }

        }

        p = sb.toString();

        boolean dp[][] = new boolean[s.length()+1][p.length()+1];

        dp[0][0] = true;
        if(p.charAt(0) == '*'){
            dp[0][1] = true;
        }

        for (int i=1;i<dp.length;i++){

            for (int j=1;j<dp[0].length;j++){

                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){

                    dp[i][j] = dp[i-1][j-1];

                }
                else if(p.charAt(j-1) == '*'){

                    dp[i][j] = dp[i-1][j] || dp[i][j-1];

                }

            }

        }

        return dp[s.length()][p.length()];

    }

}
