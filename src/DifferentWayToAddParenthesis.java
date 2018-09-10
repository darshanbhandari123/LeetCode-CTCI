import java.util.ArrayList;
import java.util.List;

public class DifferentWayToAddParenthesis {

    public static void main(String a[]){

        String s = "2-1";
        List<Integer> ans = new DifferentWayToAddParenthesis().diffWaysToCompute(s);

        for (Integer x:
             ans) {
            System.out.print(x+" ");
        }

    }

    private List<Integer> diffWaysToCompute(String input){

        List<Integer> result = new ArrayList<>();
        if(input == null || input.length() == 0){
            return result;
        }

        for (int i=0;i<input.length();i++){
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){

                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1, input.length()));

                for (Integer x: left) {

                    for (Integer y: right){

                        int c = 0;

                        switch (input.charAt(i)){

                            case '+':
                                c = x + y;
                                break;

                            case '-':
                                c = x - y;
                                break;

                            case '*':
                                c = x * y;
                                break;

                        }

                        result.add(c);

                    }

                }

            }
        }

        if(result.size() == 0){
            result.add(Integer.parseInt(input));
            return result;
        }

        return result;
    }

}
