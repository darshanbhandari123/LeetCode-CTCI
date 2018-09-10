import java.util.Stack;

public class BasicCalculator {

    public static void main(String a[]){

        String s = "  3+  2     *2";

        int ans = calculate(s);
        System.out.println(ans);

    }

    private static int calculate(String s){

        s = s.replaceAll("\\s+","");
        Stack<Integer> stack = new Stack<>();

        int total = 0;
        char sign = '+';
        for (int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                total = total*10 + (s.charAt(i)-'0');
            }
            if(!Character.isDigit(s.charAt(i)) || i==s.length()-1){
                if (sign == '+'){
                    stack.push(total);
                }
                if (sign == '-'){
                   stack.push(-1*total);
                }
                if (sign == '*'){
                    stack.push(stack.pop()*total);
                }
                if (sign == '/'){
                    stack.push(stack.pop()/total);
                }

                sign = s.charAt(i);
                total = 0;
            }
        }



        int ans = 0;
        for (int x:stack){
            ans += x;
        }

        return ans;

    }

}
