import java.util.Stack;

public class DecodeString {

    public static void main(String args[]){

        String s = "3[a]2[bc]";

        String ans = decodeString(s);
        System.out.println(ans);
    }

    private static String decodeString(String s){

        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String res = "";
        int i=0;
        while (i<s.length()){

            if(Character.isDigit(s.charAt(i))){

                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = 10 * count + (s.charAt(i) - '0');
                    i++;
                }
                countStack.push(count);

            }
            else if(s.charAt(i)=='['){
                stringStack.push(res);
                res = "";
                i++;
            }
            else if(s.charAt(i)==']'){
                StringBuffer sb = new StringBuffer(stringStack.pop());
                int times = countStack.pop();
                for (int j=0;j<times;j++){
                    sb.append(res);
                }

                res=sb.toString();
                i++;

            }
            else {
                res += s.charAt(i++);
            }
        }

        return res;
    }

}
