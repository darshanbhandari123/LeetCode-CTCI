public class DailyTemperatures {

    public static void main(String args[])
    {
        int temperatures[] = {73, 74, 75, 71, 69, 72, 76, 73};

        int ans[] = computeArray(temperatures);
        for (int x:ans) {
            System.out.print(x+" ");
        }
    }

    private static int[] computeArray(int[] temperatures) {

        int ans[] = new int[temperatures.length];
        int stack[] = new int[temperatures.length];
        int top = -1;

        for (int i=0;i<temperatures.length;i++)
        {
            while(top > -1 && temperatures[i]> temperatures[stack[top]])
            {
                int index = stack[top];
                top--;
                ans[index] = i-index;
            }

            top++;
            stack[top] = i;
            
        }

        return ans;
    }
}
