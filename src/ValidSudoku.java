import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String args[]){

        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}};

        boolean ans = isValid(board);
        System.out.println(ans);

    }

    private static boolean isValid(char[][] board){

        for (int i=0;i<9;i++){

            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> square = new HashSet<>();


            for (int j=0;j<9;j++){

                if(board[i][j]!='.' && row.contains(board[i][j]))
                    return false;

                if(board[j][i]!='.' && col.contains(board[j][i]))
                    return false;

                //int rowIndex = j/3;
                int colIndex = j%3;

                if(board[(3*(i/3))][(3*(j/3))+colIndex]!='.' && square.contains(board[(3*(i/3))][(3*(j/3))+colIndex]))
                    return false;

                row.add(board[i][j]);
                col.add(board[j][i]);
                square.add(board[(3*(i/3))][(3*(j/3))+colIndex]);

            }
        }


        return true;
    }

}
