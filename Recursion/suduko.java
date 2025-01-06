
public class suduko {

    public static boolean isValid(char[][] arr , char c , int row , int col){

        for(int i = 0 ; i < 9 ; i++){

            if(arr[row][i] == c){
                return false;
            }

            if(arr[i][col] == c){
                return false;
            }

            if( arr[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c){
                return false;
            }
        }

        return true;
        
    }

    public static boolean solveSuduko(char[][] arr){

        for(int i = 0 ; i < arr.length ; i++){

            for(int j = 0 ; j < arr[i].length ; j++){

                if(arr[i][j] == '.'){

                    for(char c = '1' ; c <= '9' ; c++){
                        if(isValid(arr ,c ,i , j)){
                            arr[i][j] = c;

                            if(solveSuduko(arr)) {

                                return true;

                            } else {

                                arr[i][j] = '.';

                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        char[][] board= {
            {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
            {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
            {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
            {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
            {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
            {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
            {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
            {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
            {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
            };

        solveSuduko(board);

        for(char[] i : board){
            System.out.println(i);
        }
    }

}
