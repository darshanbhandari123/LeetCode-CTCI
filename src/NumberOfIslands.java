public class NumberOfIslands {

    public static void main(String args[]){
        char grid[][] = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','1'}};

        int ans = numIslands(grid);
        System.out.println(ans);
    }

    /*private static int numIslands(char[][] grid){

        int count = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];

        for (int i=0;i<grid.length;i++){

            for (int j=0;j<grid[0].length;j++){

                if(grid[i][j] == '1' && !visited[i][j]){

                    dfs(i,j,grid,visited);
                    count++;

                }

            }

        }

        return count;
    }

    private static void dfs(int row,int col,char[][] c,boolean[][] visited){

        int rowNum[] = {-1,0,0,1};
        int colNum[] = {0,-1,1,0};

        visited[row][col] = true;
        for (int k=0;k<4;k++){
            if(isSafe(row+rowNum[k],col+colNum[k],c,visited)){
                dfs(row+rowNum[k],col+colNum[k],c,visited);
            }
        }
    }

    private static boolean isSafe(int r,int c,char[][] grid,boolean[][] visited){

        return (r>-1 && r<grid.length && c>-1 && c<grid[0].length && grid[r][c] == '1' && !visited[r][c]);

    }*/

    public static int numIslands(char[][] grid) {

        if(grid.length==0)
            return 0;
        int count = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];

        for(int i=0;i<visited.length;i++)
        {
            for(int j=0;j<visited[i].length;j++)
            {
                if(grid[i][j]=='1' && !visited[i][j])
                {
                    DFS(grid,visited,i,j);
                    count++;
                }
            }
        }


        return count;
    }

    private static void DFS(char c[][], boolean visited[][], int row, int col)
    {
        int rowNum[]={-1,0,0,1};
        int colNum[]={0,-1,1,0};

        visited[row][col] = true;
        for(int k=0;k<4;k++)
        {
            if(isSafe(row+rowNum[k],col+colNum[k],c,visited))
                DFS(c,visited,row+rowNum[k],col+colNum[k]);
        }
    }

    private static boolean isSafe(int row,int col, char c[][], boolean visited[][])
    {
        return (row>=0 && row<visited.length && col>=0 && col<visited[0].length && c[row][col]=='1' && !visited[row][col]);
    }

}
