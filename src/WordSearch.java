public class WordSearch {

    public static void main(String args[])
    {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCCED";

        boolean ans = new WordSearch().exist(board,word);

        System.out.print(ans);
    }
    public boolean exist(char[][] board, String word) {

        boolean flag[][] = new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
            {
                if(helperExist(board,word,i,j,flag,0))
                    return true;
            }

        return false;

    }

    private boolean helperExist(char board[][],String word,int i, int j,boolean flag[][],int wordCount)
    {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || flag[i][j]==true || board[i][j]!= word.charAt(wordCount))
            return false;

        if(wordCount == word.length()-1)
            return true;

        flag[i][j] = true;

        if( helperExist(board,word,i+1,j,flag,wordCount+1) || helperExist(board,word,i,j-1,flag,wordCount+1)
                || helperExist(board,word,i-1,j,flag,wordCount+1)|| helperExist(board,word,i,j+1,flag,wordCount+1) )

            return true;

        flag[i][j] = false;
        return false;
    }
}
