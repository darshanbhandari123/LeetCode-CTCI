public class GameOfLife {

    public static void main(String args[])
    {
        int board[][] = new int[4][4];
        new GameOfLife().gameOfLife(board);
    }
    public void gameOfLife(int[][] board) {

        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
            {
                int n = getNeighbours(board,i,j);
                if(board[i][j]==1)
                {
                    if(n == 2 || n == 3)
                        board[i][j] = 3;
                }
                else
                {
                    if(n == 3)
                        board[i][j] = 2;
                }
            }

        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                board[i][j]>>=1;
    }

    private int getNeighbours(int board[][],int row,int col)
    {
        int count=0;
        for(int i=row-1;i<=row+1;i++)
            for(int j=col-1;j<=col+1;j++)
            {
                if(i>-1 && i<board.length && j>-1 && j<board[0].length)
                    count += board[i][j]&1;
            }

        count -=board[row][col]&1;
        return count;
    }
}
