public class GameOfLife {

    public static void main(String args[])
    {
        int board[][] = {{1,1,1,0},{1,0,1,1},{0,1,0,0},{0,1,1,1}};
        new GameOfLife().gameOfLife(board);

        for (int i=0;i<board.length;i++)
        {
            for (int j=0;j<board[0].length;j++)
            {
                System.out.print(board[i][j] +" ");
            }

            System.out.println();
        }
    }
    public void gameOfLife(int[][] board) {

        for(int i=0;i<board.length;i++)
        {
            for (int j=0;j<board[0].length;j++)
            {
                int n = getNeighbours(board,i,j);
                if(board[i][j]==1)
                {
                    if(n==2 || n==3)
                    {
                        board[i][j]=3;
                    }
                }
                else
                {
                    if(n==3)
                    {
                        board[i][j]=2;
                    }
                }
            }
        }

        for (int i=0;i<board.length;i++) {
            for (int j = 0; j < board[0].length; j++) {

                board[i][j] /=2;
            }
        }
    }

    private int getNeighbours(int board[][],int row,int col)
    {
        int count=0;
        for(int x = row-1;x<=row+1;x++)
        {
            for(int y=col-1;y<=col+1;y++)
            {
                if(x<0 || x>=board.length || y<0 || y>=board[0].length)
                    continue;

                count +=board[x][y]&1;
            }
        }

        count -=board[row][col]&1;
        return count;
    }
}
