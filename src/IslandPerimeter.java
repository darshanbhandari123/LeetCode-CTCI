public class IslandPerimeter {

    public static void main(String args[]){

        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};

        int ans = calculatePerimeter(grid);
        System.out.println(ans);
    }

    private static int calculatePerimeter(int[][] grid){
        int ans = 0;
        int count = 0;
        int neighbours = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid.length;j++){

                if (grid[i][j]==1){
                    count++;

                    if (i-1>=0){
                        if(grid[i-1][j]==1)
                            neighbours++;
                    }

                    if (i+1<grid.length){
                        if (grid[i+1][j]==1)
                            neighbours++;
                    }

                    if (j-1>=0){
                        if (grid[i][j-1]==1){
                            neighbours++;
                        }
                    }

                    if (j+1<grid.length){
                        if (grid[i][j+1]==1)
                            neighbours++;
                    }
                }

            }
            System.out.println(i+" "+neighbours);
        }

        System.out.println(count+"  "+neighbours);
        ans = (count*4) - neighbours;
        return ans;
    }

}


