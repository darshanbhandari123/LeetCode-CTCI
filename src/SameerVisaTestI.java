import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public class SameerVisaTestI {

    public static void main(String args[]){

        List<Integer> andrea = new ArrayList<>();
        andrea.add(1);
        andrea.add(2);
        andrea.add(3);

        List<Integer> maria = new ArrayList<>();
        maria.add(2);
        maria.add(1);
        maria.add(3);

        String s = "Even";

        String ans = winner(andrea,maria,s);
        System.out.print(ans);
    }

    private static String winner(List<Integer> andrea,List<Integer> maria,String s){

        String winner = "";
        int i;
        if(s.equals("Even")){
            i=0;
        }else {
            i=1;
        }

        int scoreA=0;
        int scoreM=0;

        for (;i<andrea.size();i+=2){

            scoreA += andrea.get(i)-maria.get(i);
            scoreM += maria.get(i)-andrea.get(i);

        }

        if(scoreA>scoreM){
            winner = "Andrea";
        }
        else if(scoreA<scoreM){
            winner = "Maria";
        }
        else {
            winner = "Tie";
        }

        return winner;

    }

}
