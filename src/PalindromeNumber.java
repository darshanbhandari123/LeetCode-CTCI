public class PalindromeNumber {

    public static void main(String args[]){

        int x = 121;

        boolean ans = isPalindrome(x);
        System.out.print(ans);
    }

    private static boolean isPalindrome(int x){

        int ch = x;
        int reversedNumber = 0;
        while (ch!=0){
            int lastDigit = ch%10;
            ch=ch/10;
            reversedNumber = (reversedNumber*10) + lastDigit;
        }

        if(reversedNumber!=x)
            return false;

        return true;
    }

}
