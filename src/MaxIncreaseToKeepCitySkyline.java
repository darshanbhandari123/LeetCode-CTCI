public class MaxIncreaseToKeepCitySkyline {

    public static void main(String args[]){
        int grid[][] = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};

        int ans = maxIncreaseKeepingSkyline(grid);
        System.out.print(ans);
    }

    private static int maxIncreaseKeepingSkyline(int[][] grid){
        int max = 0;

        int topBottom[] = new int[grid.length];
        int leftRight[] = new int[grid[0].length];

        calculateTBArray(topBottom,grid);
        calculateLRArray(leftRight,grid);

        for(int i=0;i<grid.length;i++){

            for (int j=0;j<grid.length;j++){

                int min = Math.min(topBottom[j],leftRight[i]);
                if(grid[i][j]<min){
                    max += min - grid[i][j];
                }

            }

        }

        return max;
    }

    private static void calculateTBArray(int[] topBottom, int[][] grid){

        for(int i=0;i<topBottom.length;i++){

            topBottom[i] = grid[0][i];
            for (int j=1;j<grid.length;j++){

                if(grid[j][i]>topBottom[i]) {
                    topBottom[i] = grid[j][i];
                }

            }

        }

    }

    private static void calculateLRArray(int[] leftRight,int[][] grid){

        for (int i=0;i<leftRight.length;i++){

            leftRight[i] = grid[i][0];
            for (int j=1;j<grid.length;j++){

                if (grid[i][j]>leftRight[i]){
                    leftRight[i] = grid[i][j];
                }

            }

        }

    }




}
