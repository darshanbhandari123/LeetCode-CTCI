import java.util.ArrayList;

public class DXDY {

    public static void main(String args[]){

        int magicNumber = 0;

        ArrayList<Integer> numbers = new ArrayList();
        numbers.add(1);


        boolean ans = arithmeticBoggle(magicNumber,numbers);
        System.out.print(ans);
    }

    private static boolean arithmeticBoggle(int magicNumber,ArrayList<Integer> number){

        int size = number.size();
        if(size == 0){
            if(magicNumber==0){
                return true;
            }
            else {
                return false;
            }

        }

        if(test(0,number.get(0),size,magicNumber,number) || test(0,-number.get(0),size,magicNumber,number)){
            return true;
        }
        return false;
    }

    private static boolean test(int index,int sum,int size,int magicNumber,ArrayList<Integer> number){

        if(index==size-1){
            if(sum == magicNumber){
                return true;
            }
            else {
                return false;
            }
        }

        return (test(index+1,sum+number.get(index+1),size,magicNumber,number) || test(index+1,sum-number.get(index+1),size,magicNumber,number) );


    }




}
