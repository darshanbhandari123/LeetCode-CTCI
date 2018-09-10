import java.util.Map;

public class UglyNumberII {

    public static void main(String a[]){

        int n = 12;

        int ans = findNthUglyNo(n);
        System.out.println(ans);
    }

    private static int findNthUglyNo(int n){

        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;

        for(int i=1;i<n;i++){

            int next = Math.min(factor2,Math.min(factor3,factor5));

            ugly[i] = next;
            if(next == factor2){

                index2++;
                factor2 = ugly[index2]*2;

            }
            if(next == factor3){

                index3++;
                factor3 = ugly[index3]*3;

            }
            if(next == factor5){

                index5++;
                factor5 = ugly[index5]*5;

            }
        }

        return ugly[n-1];
    }

}
