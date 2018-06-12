import java.util.Map;

public class ContainerWithMostWater {

    public static void main(String args[]){

        int[]  height = {5,7,8};

        int ans = maxArea(height);
        System.out.print(ans);
    }

    private static int maxArea(int[] height){

        int max = 0;
        int low = 0;
        int high = height.length-1;

        while (low<high){
            max = Math.max(max,(high-low)*Math.min(height[low],height[high]));      // the height of the container is affected by the minimum height.
            if(height[low]<height[high])                        // the lesser valued boundary acts as a limiter and hence needs to be incremented or decremented accordingly, because we need to find maximum area we need to give chance to all combinations.
                low++;
            else
                high--;
        }

        return max;
    }
}
