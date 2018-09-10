import java.util.ArrayList;
import java.util.List;

public class RemoveComments {

    public static void main(String[] args){
        String[] source = {"a/*comment", "line", "more_comment*/b"};
        List<String> ans;

        ans = removeComments(source);

        for (String s:
             ans) {
            System.out.println(s+"    ");
        }

    }

    private static List<String> removeComments(String[] source){

        List<String> ans = new ArrayList<>();

        boolean isCommentStart = false;
        for (String s: source) {

            StringBuffer sb = new StringBuffer();
            for (int i=0;i<s.length();i++){

                if(isCommentStart){
                    if(i<s.length()-1 && s.charAt(i)=='*' && s.charAt(i+1)=='/'){
                        isCommentStart = false;
                        i++;
                    }
                }
                else {
                        if(i<s.length()-1 && s.charAt(i)=='/' && s.charAt(i+1)=='/'){
                            break;
                        }
                        else if(i<s.length()-1 && s.charAt(i)=='/' && s.charAt(i+1)=='*'){
                            isCommentStart = true;
                            i++;
                        }
                        else {
                            sb.append(s.charAt(i));
                        }
                }
            }

            if (sb.length() != 0){
                if(isCommentStart){
                    if(ans.size()!=0){
                        ans.add(ans.get(ans.size()-1)+sb.toString());
                    }
                    else {
                        ans.add(sb.toString());
                    }
                }
                else {
                    ans.add(sb.toString());
                }
            }

        }

        return ans;

    }

}


