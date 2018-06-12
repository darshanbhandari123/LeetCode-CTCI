public class RomanToInt {

    public static void main(String args[]){

        String s = "MMMDCCCLXXXVIII";

        int ans = convertToInt(s);
        System.out.print(ans);
    }

    private static int convertToInt(String s){
        int ans = 0;
        int prev = 1001;

        for (char c : s.toCharArray()) {
            int cur = 0;
            switch (c) {
                case 'I':
                    cur = 1;
                    break;

                case 'V':
                    cur = 5;
                    break;

                case 'X':
                    cur = 10;
                    break;

                case 'L':
                    cur = 50;
                    break;

                case 'C':
                    cur = 100;
                    break;

                case 'D':
                    cur = 500;
                    break;

                case 'M':
                    cur = 1000;
                    break;

            }

            if(prev<cur){
                    ans = ans - (2*prev);       // this is used to rectify the previous step eg(XIV  is 14 but after 2 iterations of for loop we have 11 and then 'V' yet to be parsed)
            }

            ans += cur;
            prev = cur;

        }

        return ans;

    }
}


