public class RemoveKDigits {

    public static void main(String args[]){

        String num = "112";
        int k = 1;

        String ans = removeKDigits(num,k);
        System.out.println(ans);
    }

    private static String removeKDigits(String num,int k){

        int top = 0;
        char[] c = new char[num.length()];
        char temp;

        for (int i=0;i<num.length();i++){

            temp = num.charAt(i);
            if(k==0){
                break;
            }
            while (top>0 && c[top-1]>temp && k>0){
                top--;
                k--;
            }
            c[top] = temp;
            top++;

        }

        int totalDigits = num.length()-k;

        int index = 0;
        while (c[index]=='0'){
            index++;
        }

        if(index == totalDigits){
            return "0";
        }

        return new String(c,index,totalDigits);

    }

}
