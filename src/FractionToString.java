import org.omg.CORBA.MARSHAL;

import java.util.HashMap;
import java.util.Map;

public class FractionToString {

    public static void main(String args[]){
        int numerator = 7;
        int denominator = 6;
        String s;

        s = convertToRecursiveString(numerator,denominator);
        System.out.print(s);
    }

    private static String convertToRecursiveString(int n,int d){
        StringBuffer result = new StringBuffer();

        if(n==0)
            return "0";

        if((n>0) ^ (d>0) == true)
            result.append("-");

        long num = Math.abs((long)n);
        long den = Math.abs((long)d);

        result.append(num/den);
        num %= den;
        if(num==0)
            return result.toString();

        result.append(".");
        Map<Long,Integer> map = new HashMap<>();
        map.put(num,result.length());
        while (num!=0)
        {
            num *= 10;
            result.append(num/den);
            num %= den;

            if(map.containsKey(num)){
                int index = map.get(num);
                result.insert(index,"(");
                result.append(")");
                break;
            }
            else {
                map.put(num,result.length());
            }
        }

        return result.toString();
    }

}
