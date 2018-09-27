public class IntegerToEnglishWords {

    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"Billion","Million","Thousand",""};
    private static final int[] RADIX = {1000000000,1000000,1000,1};

    public static void main(String args[]){

        int num = 123;
        String ans = numberToWords(num);

        System.out.print(ans);
    }

    private static String numberToWords(int num){

        if(num == 0){
            return "Zero";
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<RADIX.length;i++){

            if(num/RADIX[i] == 0){
                continue;
            }

            sb.append(trans(num/RADIX[i])).append(' ').append(THOUSANDS[i]).append(' ');
            num = num % RADIX[i];

        }
        return sb.toString().trim();

    }

    private static String trans(int num){

        if(num==0){
            return "";
        }
        if(num<20){
            return LESS_THAN_20[num]+" ";
        }
        if(num<100){
            return TENS[num/10] +" "+trans(num%10);
        }

        return LESS_THAN_20[num/100] + " Hundred " + trans(num%100);

    }

}
