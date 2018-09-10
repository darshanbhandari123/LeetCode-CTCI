public class StringToInteger {

    public static void main(String args[]){

        //String s1 = "3435";
        String s2 = "-846500";

        String s=s2;
        int index = 0;
        int sign = 1;
        int total = 0;

        while (index< s.length() && s.charAt(index)==' '){
            index++;
        }

        while (index<s.length() && (s.charAt(index)=='+' || s.charAt(index)=='-' )){
            if (s.charAt(index)=='-')
                sign=-1;

            index++;
        }

        while (index<s.length()){

            int digit = s.charAt(index)-'0';

            if(total>(Integer.MAX_VALUE/10)){
                if (sign == 1)
                    total = Integer.MAX_VALUE;
                else
                    total = Integer.MIN_VALUE;
            }

            total = total*10 + digit;
            index++;

        }

        total = sign*total;
        System.out.println(total);

    }

}
