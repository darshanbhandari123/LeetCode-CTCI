public class ZigZagConversion {

    public static void main(String args[]){
        String s = "PAYPALISHIRING";
        int numRows = 3;

        String ans =  convert(s,numRows);
        System.out.print(ans);
    }

    private static String convert(String s,int numRows){
            if (numRows==1)
                return s;

            StringBuffer sb[] = new StringBuffer[numRows];
            for (int i=0;i<numRows;i++)
                sb[i] = new StringBuffer();

            boolean upward = false;
            StringBuffer result = new StringBuffer();

            int index = 0;
            for (int i=0;i<s.length();i++) {

                if(upward){
                    sb[index].append(String.valueOf(s.charAt(i)));
                    index--;
                    if(index==-1){
                        upward=false;
                        index=1;
                    }
                }
                else {
                    sb[index].append(String.valueOf(s.charAt(i)));
                    index++;
                    if(index == numRows){
                        upward = true;
                        index = numRows-2;
                    }
                }
            }

            for (int i=0;i<sb.length;i++)
                result.append(sb[i]);

            return result.toString();
    }

}
