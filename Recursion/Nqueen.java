
import java.util.ArrayList;
import java.util.List;


public class Nqueen {

    public static List<String> charToList(char[][] arr){

        List<String> temp = new ArrayList<>();

        for(int i = 0 ; i < arr.length ; i++){

            String s = new String(arr[i]);
            temp.add(s);

        }
        return temp;
    }

    public static List<List<String>> queenSolve(int n){

        char[][] board = new char[n][n];

        for(int i = 0 ; i < n ; i++){

            for(int j = 0 ; j < n ; j++){

                board[i][j] = '_';
            }
        }

        List<List<String>> ans = new ArrayList<>();
        int len = 2 * n - 1;

        int left[] = new int[n];

        int lowerDiogonal[] = new int[len];
        int upperDiagonal[] = new int[len];

        nqueens(0,board,left,lowerDiogonal,upperDiagonal,ans);

        return ans;
    }

    public static void nqueens(int col ,char[][] board , int[] left , int[] ld , int[] ud , List<List<String>> ans){

        if(col == board.length){
            ans.add(charToList(board));
            return;
        }

        for(int row = 0 ; row < board.length ; row++){

            if(left[row] == 0 && ld[row + col] == 0 && ud[board.length - 1 + col - row] == 0){

                board[row][col] = 'Q';
                left[row] = 1;

                ld[row + col] = 1; // Check for lower diagonal
                ud[board.length - 1 + col - row] = 1; // Check for upper Diagonal

                nqueens(col + 1 , board , left , ld , ud , ans);

                board[row][col] = '_';
                left[row] = 0; // Mark the unplaced queen as empty

                ld[row + col] = 0;
                ud[board.length - 1 + col - row] = 0;
            }

        }

    }

    public static void main(String[] args) {
        
        int n = 4;

        List<List<String>> ans = queenSolve(n);

        for(List<String> i : ans){
            
            for(String j : i){
                System.out.println(j );
            }
            System.out.println();
        }

    }
}
