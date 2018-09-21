import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AsteroidCollision {

    public static void main(String args[]){

        int[] asteroids = {5,-5,10};

        int[] ans = asteroidCollision(asteroids);
        for (int x:
             ans) {
            System.out.print(x+"    ");
        }

    }

    private static int[] asteroidCollision(int[] asteroids){

        LinkedList<Integer> result = new LinkedList<>();

        for(int n:asteroids){

            if(n>=0){
                result.add(n);
            }
            else {
                while (!result.isEmpty() && result.getLast()>0 && result.getLast() < -n){
                    result.pollLast();
                }
                if(!result.isEmpty() && result.getLast() == -n){
                    result.pollLast();
                }
                else if(result.isEmpty() || result.getLast()<0){
                    result.add(n);
                }
            }

        }

        return result.stream().mapToInt(i -> i).toArray();

    }

}