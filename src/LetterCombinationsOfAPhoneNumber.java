import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String args[]){

        String digits = "237";
        List<String> result = letterCombinations(digits);

        for (String s:result) {
            System.out.println(s);
        }
    }

    private static List<String> letterCombinations(String digits){

        List<String> result = new LinkedList<>();
        String[] map = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if (digits == null || digits.length()==0)
            return result;

        result.add("");
        for (int i = 0;i < digits.length();i++){

            while (result.get(0).length() == i){

                String t = result.remove(0);
                int x = Character.getNumericValue(digits.charAt(i));
                for (char c: map[x].toCharArray()) {
                    result.add(t+c);
                }
            }

        }

        return result;

    }

}
