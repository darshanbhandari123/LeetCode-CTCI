import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String args[]){

        int n=3;
        List<String> result = generateParenthesis(n);

        for (String s:result) {
            System.out.println(s);
        }
    }

    private static List<String> generateParenthesis(int n){

        String s = "";
        List<String> list = new ArrayList<>();
        helper(s,list,n,0,0);

        return list;
    }

    private static void helper(String s,List<String> list,int n,int open,int close){
        if(close == n){                                         //when close is equal to n we add the string to the list.
            list.add(s);
            return;
        }
        if (open<n){
            helper(s+"(",list,n,open+1,close);          //the biggest phase in logic here is that note:- there is no if else , only if and if with recursion.
        }
        if (open>close){
            helper(s+")",list,n,open,close+1);
        }
    }
}
