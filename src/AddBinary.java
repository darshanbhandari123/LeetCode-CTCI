public class AddBinary {

    public static void main(String args[]){

        String a = "11";
        String b = "1";
        StringBuffer sb = new StringBuffer();

        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        int sum=0;
        while (i>=0 || j>=0){
            sum = carry;
            if (i>=0){
                sum += a.charAt(i)-'0';
                i--;
            }
            if (j>=0){
                sum += b.charAt(j)-'0';
                j--;
            }
            carry = sum/2;
            sb.append(sum%2);
        }
        if (carry!=0)
            sb.append(1);

        System.out.println(sb.reverse().toString());
    }

}
