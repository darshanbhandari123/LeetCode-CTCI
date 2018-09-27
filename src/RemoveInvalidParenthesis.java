import sun.security.x509.AttributeNameEnumeration;

import java.util.*;

public class RemoveInvalidParenthesis {

    public static void main(String args[]){

        String s = "(()(()";

        List<String> ans = removeInvalidParentheses(s);
        for (String x:ans){
            System.out.println(x);
        }
    }

    //Using DFS(faster method)
    private static List<String> removeInvalidParentheses(String s){

        List<String> result = new ArrayList<>();
        if (s==null){
            return result;
        }

        remove(s,result,0,0,new char[]{'(',')'});
        return result;

    }

    private static void remove(String s,List<String> result,int last_i,int last_j,char[] par){

        int stack = 0;
        for (int i=last_i;i<s.length();i++){

            if(s.charAt(i)==par[0]){
                stack++;
            }
            else if(s.charAt(i)==par[1]){
                stack--;
            }
            if(stack>=0){
                continue;
            }

            for (int j=last_j;j<=i;j++){

                if(s.charAt(j)==par[1] && (j==last_j || s.charAt(j-1)!=par[1])){

                    String t = s.substring(0,j)+s.substring(j+1);
                    remove(t,result,i,j,par);

                }

            }

            return;

        }

        String reversed = new StringBuffer(s).reverse().toString();
        if(par[0]=='('){
            remove(reversed,result,0,0,new char[]{')','('});
        }
        else {
            result.add(reversed);
        }

    }

    //Using BFS
    /*
    private static List<String> removeInvalidParentheses(String s){

        List<String> result = new ArrayList<>();

        if(s==null || s.length()<2){
            return result;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        boolean found = false;

        queue.add(s);

        while (!queue.isEmpty()){
            s = queue.poll();

            if(isValid(s)){
                result.add(s);
                found = true;
            }

            if(found){
                continue;
            }

            found = false;

            for (int i=0;i<s.length();i++){

                if(s.charAt(i)!='(' && s.charAt(i)!=')'){
                    continue;
                }

                String t = s.substring(0,i)+s.substring(i+1);

                if(!visited.contains(t)){
                    visited.add(t);
                    queue.add(t);
                }

            }

        }

        return result;

    }

    private static boolean isValid(String s){

        int count = 0;

        for (int i=0;i<s.length();i++){

            if(s.charAt(i)=='('){
                count++;
            }
            else if(s.charAt(i)==')' && count--==0){
                return false;
            }

        }

        return count==0;

    }*/

}