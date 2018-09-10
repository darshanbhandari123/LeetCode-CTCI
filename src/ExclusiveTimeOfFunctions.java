import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {

    public static void main(String a[]){

        int n=2;
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");

        int ans[] = exclusiveTime(n,logs);

        for (int x:
             ans) {
            System.out.print(x+"    ");
        }

    }

    private static int[] exclusiveTime(int n,List<String> logs){

        int[] ans = new int[n];
        String t[] = logs.get(0).split(":");
        int runningFunctionId = Integer.parseInt(t[0]);
        int previousFunctionTime = Integer.parseInt(t[2]);

        Stack<Integer> stack = new Stack<>();

        for (String s:logs){
            t = s.split(":");
            int id = Integer.parseInt(t[0]);
            boolean isStart = t[1].equals("start");
            int time = Integer.parseInt(t[2]);

            if(!isStart){
                time++;
            }

            ans[runningFunctionId]+=(time - previousFunctionTime);

            if (isStart){
                stack.push(runningFunctionId);
                runningFunctionId = id;
            }
            else {
                runningFunctionId = stack.pop();
            }

            previousFunctionTime = time;

        }

        return ans;

    }

}
