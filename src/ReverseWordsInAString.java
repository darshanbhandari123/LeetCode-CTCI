public class ReverseWordsInAString {

    public static void main(String args[]){

        String s = "the     sky    is blue";

        String ans = reverseWords(s);
        System.out.println(ans);
    }

    private static String reverseWords(String s){
        s.trim();
        StringBuffer sb = new StringBuffer();

        String[] strs = s.split("\\s+");
        for (int i=strs.length-1;i>-1;i--){
            sb.append(strs[i]+" ");
        }
        return sb.toString();
    }

}
